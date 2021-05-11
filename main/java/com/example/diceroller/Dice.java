package com.example.diceroller;

import java.util.Random;

public class Dice {
    private int diceFace = 1;
    private int diceAmount = 1;
    private int[] diceResult = {1};

    public Dice(int diceAmount, int diceFace){
        this.diceFace = diceFace;
        this.diceAmount = diceAmount;
        this.diceResult = new int[diceAmount];
    }

    //SETTER
    public void setDiceFace(int diceFace) {
        this.diceFace = diceFace;
    }

    public void setDiceAmount(int diceAmount) {
        this.diceAmount = diceAmount;
    }

    public void setDiceResult(int[] diceResult) {
        this.diceResult = diceResult;
    }

    //GETTER
    public int getDiceFace() {
        return diceFace;
    }

    public int getDiceAmount() {
        return diceAmount;
    }

    public int[] getDiceResult() {
        return diceResult;
    }


    //FUNCTIONS
    public static int roll(Dice dice){
        //roll once
        Random rand = new Random();
        return rand.nextInt(dice.diceFace)+1;

    }
    
    public int[] rollMultiple(Dice dice){
        //roll diceAmount of time
        this.diceResult = new int[dice.diceAmount];

        for(int i = 0; i<dice.diceAmount; i++)
            diceResult[i] = roll(dice);
        return diceResult;
    }

    public static int sum(int[] array){
        int sum=0;
        for(int i=0;i<array.length;i++){
            sum=sum+array[i];
        }
        return sum;
    }
}
