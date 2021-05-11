package com.example.diceroller;

public class DiceResult {


    int[] diceType;
    int[][] diceResults;
    int modifier;
    int invalid=0;

    public DiceResult(){
        this.diceType= new int[]{4};
        this.diceResults= new int[][]{{1}};
        this.modifier=1;
    }

    public DiceResult(int[] diceType, int[][] diceResults, int modifier){
        this.diceType=diceType;
        this.diceResults=diceResults;
        this.modifier=modifier;
    }

    public DiceResult(int invalid){
        this.invalid=invalid;
    }

    //SETTER
    public void setDiceType(int[] diceType){
        this.diceType=diceType;
    }
    public void setDiceResults(int[][] diceResults){
        this.diceResults=diceResults;
    }
    public void setModifier(int Modifier){
        this.modifier=Modifier;
    }

    //GETTER
    public int[] getDiceType() {
        return diceType;
    }

    public int[][] getDiceResults() {
        return diceResults;
    }

    public int getModifier() {
        return modifier;
    }

    public int calculateTotalResult(int[][] diceResults, int modifier){
        int totalResult = 0;
        for (int[] arr : diceResults)
            for(int i: arr)
                totalResult+=i;

        return totalResult+modifier;
    }

    public int calculateTotalResult(){
        int totalResult = 0;
        for (int[] arr : this.diceResults)
            try {
                for(int i: arr)
                    totalResult+=i;
            } catch (Exception e) {
                //e.printStackTrace();
            }

        return totalResult+this.modifier;
    }

    public static DiceResult diceRoll(String diceRollString) {

        diceRollString = DiceStringReader.formatString(diceRollString); //format

        String[] diceRollStringArray = DiceStringReader.diceRollStringToArray(diceRollString); //separate

        // preliminary variable for diceResult object used for result display and sum
        int[][] resultArray= new int[diceRollStringArray.length][]; //diceType
        int[] diceRollFaces = new int[diceRollStringArray.length];  //diceResults
        int modifier=0;                                             //total modifier

        //roll the dices one hand at the time
        for(int i=0;i<diceRollStringArray.length;i++){
            if(DiceStringReader.isDice(diceRollStringArray[i])){ //confirm if it is dice. If not, it is a modifier
                int[] diceAttributes = DiceStringReader.diceIndividualScan(diceRollStringArray[i]); //determines type of dice (diceFace) and amount to roll (diceAmount)
                Dice dice1 = new Dice(diceAttributes[0],diceAttributes[1]);

                diceRollFaces[i]=diceAttributes[1]; //set the type of dice for print

                resultArray[i]=dice1.rollMultiple(dice1); //set roll result for proper dice
            }
            else if(DiceStringReader.isModifier(diceRollStringArray[i])){
                modifier=modifier+Integer.parseInt(diceRollStringArray[i]); //total modifier
            }
            else{
                return new DiceResult(1);
            }
        }

        DiceResult totalResult=new DiceResult(diceRollFaces,resultArray,modifier);
        return totalResult;
    }

    public String fullResultString(){
        //Generate error message
        if (this.invalid==1)
            return "Invalid input, please Try again.";
        //generate full result String
        else{
            String fullResultString="";
            fullResultString=printFullResultString(fullResultString);
                    return fullResultString;
            }

        }


    private String printFullResultString(String fullAddString) {
            for(int i=0;i<diceResults.length;i++){

                if(diceType[i]!=0){
                    fullAddString = fullAddString + "( ";
                    for(int j=0;j<diceResults[i].length;j++){
                        if(j<diceResults[i].length-1)
                            fullAddString=fullAddString + diceResults[i][j] + " + ";
                        else
                            fullAddString=fullAddString + diceResults[i][j] + " ";
                    }
                    //Add a plus sign
                    if(i==diceResults.length-1)
                        fullAddString=fullAddString + ") ";
                    else
                    fullAddString=fullAddString + ") + ";
                }
            }
             //print modifier
             if(modifier!=0)
                fullAddString=fullAddString + "" + modifier + " ";

            fullAddString = fullAddString + "= "+ this.calculateTotalResult();
            return fullAddString;
        }



    public void consolePrint(){
        //simple console print to show results

        System.out.println("Results...");
        for(int i=0;i<diceResults.length;i++){
            if(diceType[i]!=0){
                System.out.print("      d"+ diceType[i] + " : ");
                for(int j=0;j<diceResults[i].length;j++)
                    System.out.print(" " + diceResults[i][j] + " ");
                System.out.println();
            }
            else
                System.out.println("modifier : " + modifier);
        }
        System.out.println();
        System.out.println("TOTAL RESULT : " + this.calculateTotalResult());
    }

}
