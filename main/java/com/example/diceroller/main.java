package com.example.diceroller;

import java.lang.*;

public class main {

    public static void main(String[] args) {

//        String diceRollString = "1d6+2d8+6d4+2d20+2";
//        System.out.println(diceRollString);
//        System.out.println(DiceResult.diceRoll(diceRollString).fullResultString());

        String diceRoll="";
        DiceButton diceButton = new DiceButton(diceRoll);


        diceButton.addD8();
        System.out.println(diceButton.diceButtonString);


    }
}
