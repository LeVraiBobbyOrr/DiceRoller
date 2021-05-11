package com.example.diceroller;

public class DiceStringReader {
    int[] diceGroupArray;
    int modifier=0;


    public static String formatString(String notFormated){
        return notFormated.replaceAll("\\s+","").toLowerCase();
    }

    public static int diceSeparation(String diceRoll){
        int separateDice=0;

        return separateDice;
    }

    public static String[] diceRollStringToArray(String diceRoll){
        String[] dicRollArray = diceRoll.split("\\+");
        return dicRollArray;
    }

    public static boolean isDice(String diceString){

        char[] dice = diceString.toCharArray();

        for(int i=0;i<dice.length;i++){
            if (dice[i] == 'd') {
                return true;
            }
        }
        return false;
    }

    public static boolean isModifier(String diceString){

        try {
            int test = Integer.parseInt(diceString);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static int[] diceIndividualScan(String diceString){
        int diceAmount = 1;
        String diceAmountString = "";
        int diceFace = 1;
        String diceFaceString = "";
        int positionD = 0;

        char[] dice = diceString.toCharArray();

        for(int i=0;i<dice.length;i++){
            if (dice[i] == 'd') {
                positionD = i;
            }
        }

        if (positionD == 0)
            diceAmount=1;
        else {
            for (int j = 0; j < positionD; j++) {
                diceAmountString = diceAmountString + dice[j];
            }
            diceAmount = Integer.parseInt(diceAmountString);
        }
        for(int k=positionD+1;k<dice.length;k++){
            diceFaceString =diceFaceString + dice[k];
        }
        diceFace = Integer.parseInt(diceFaceString);

        int[] diceAttributes = {diceAmount,diceFace};

        return diceAttributes;
    }

    public Dice[] diceReader(String diceRoll){


        Dice[] fullRoll = new Dice[2];
        return fullRoll;
    }
}
