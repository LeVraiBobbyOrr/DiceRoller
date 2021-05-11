package com.example.diceroller;

public class DiceButton {
    String diceButtonString;
    String oldDiceButtonString;

    int counter;
    int d4counter = 1;
    int d6counter = 1;
    int d8counter = 1;
    int d10counter = 1;
    int d12counter = 1;
    int d20counter = 1;
    int d100counter = 1;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getD4counter() {
        return d4counter;
    }

    public void setD4counter(int d4counter) {
        this.d4counter = d4counter;
    }

    public int getD6counter() {
        return d6counter;
    }

    public void setD6counter(int d6counter) {
        this.d6counter = d6counter;
    }

    public int getD8counter() {
        return d8counter;
    }

    public void setD8counter(int d8counter) {
        this.d8counter = d8counter;
    }

    public int getD10counter() {
        return d10counter;
    }

    public void setD10counter(int d10counter) {
        this.d10counter = d10counter;
    }

    public int getD12counter() {
        return d12counter;
    }

    public void setD12counter(int d12counter) {
        this.d12counter = d12counter;
    }

    public int getD20counter() {
        return d20counter;
    }

    public void setD20counter(int d20counter) {
        this.d20counter = d20counter;
    }

    public int getD100counter() {
        return d100counter;
    }

    public void setD100counter(int d100counter) {
        this.d100counter = d100counter;
    }

    public String getDiceButtonString() {
        return diceButtonString;
    }

//    private boolean detectDX(int d, ){
//
//
//
//    }

    public DiceButton(String diceButtonString) {
        this.diceButtonString = diceButtonString;
    }

    public void resetCounters() {
        setCounter(0);
        setD4counter(0);
        setD6counter(0);
        setD8counter(0);
        setD10counter(0);
        setD12counter(0);
        setD20counter(0);
        setD100counter(0);
    }

    public void addD4() {
        //plusSign();
        if (d6counter < 2) {
            oldDiceButtonString = diceButtonString;
            diceButtonString = diceButtonString + "1d4";
        } else if (d4counter >= 2)
            diceButtonString = oldDiceButtonString + d4counter + "d4";

        d4counter++;
    }

//    private void plusSign() {
//        if (d4counter+d6counter+d8counter+d10counter+d12counter+d20counter+d100counter!=0)
//
//    }

    public void addD6() {

        if (d6counter < 2) {
            oldDiceButtonString = diceButtonString;
            diceButtonString = diceButtonString + "1d6";
        } else if (d6counter >= 2)
            diceButtonString = oldDiceButtonString + d6counter + "d6";

        d6counter++;
    }

    public void addD8() {

        if (d8counter < 2) {
            oldDiceButtonString = diceButtonString;
            diceButtonString = diceButtonString + "1d8";
        } else if (d8counter >= 2)
            diceButtonString = oldDiceButtonString + d8counter + "d8";

        d8counter++;
    }

    public void addD10() {

        if (d10counter < 2) {
            oldDiceButtonString = diceButtonString;
            diceButtonString = diceButtonString + "1d10";
        } else if (d10counter >= 2)
            diceButtonString = oldDiceButtonString + d8counter + "d10";

        d10counter++;
    }

    public void addD12() {

        if (d12counter < 2) {
            oldDiceButtonString = diceButtonString;
            diceButtonString = diceButtonString + "1d12";
        } else if (d12counter >= 2)
            diceButtonString = oldDiceButtonString + d8counter + "d12";

        d12counter++;
    }

    public void addD20() {

        if (d20counter < 2) {
            oldDiceButtonString = diceButtonString;
            diceButtonString = diceButtonString + "1d20";
        } else if (d20counter >= 2)
            diceButtonString = oldDiceButtonString + d20counter + "d20";

        d20counter++;
    }

    public void addD100() {

        if (d100counter < 2) {
            oldDiceButtonString = diceButtonString;
            diceButtonString = diceButtonString + "1d100";
        } else if (d100counter >= 2)
            diceButtonString = oldDiceButtonString + d100counter + "d100";

        d100counter++;
    }


//        this.oldDiceButtonString=this.diceButtonString;
//        this.counter = 0;
//        if (d6counter < 0){
//            this.d6counter= this.d6counter + 1;
//            return diceButtonString = diceButtonString + "1d6 ";
//        }
//        if (d6counter > 0){
//            return oldDiceButtonString + this.d6counter + "d6 ";
//        }
//        else
//            return oldDiceButtonString;

    //        String[] diceRollArray = DiceStringReader.diceRollStringToArray(DiceStringReader.formatString(diceButtonString));
//        for(int i=0;i<diceRollArray.length;i++){
//
//        }
//
//
//        return diceButtonString+"1d6 ";
//    }


}