package com.example.diceroller;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FinalResultStringUnitTest {
    /**
     * You can verify that all words in the returned the string exist in the global vocabulary
     * You can verify that there are, or are no repeats of words in that returned string
     * You can verify that there is no extraneous white space at the beginning and end
     * You can verify that the number of words enforces positive numbers
     * You can verify that the a list of 0 words provides an empty string
     */

    @Test
    public void Format_IsCorrect(){
        String diceRoll = " 2d 6+ 1D8 +   4 ";
        String rollResult = DiceResult.diceRoll(diceRoll).fullResultString();
        assertTrue(checkSpaceEqualPlusMinusPara(rollResult));
    }

    @Test
    public void Format_NoDiceRoll_IsCorrect(){
        String diceRoll = " 2 +   4 ";
        String rollResult = DiceResult.diceRoll(diceRoll).fullResultString();
        assertFalse(checkNoParaPlusMinus(rollResult));
    }

    @Test
    public void Format_ModOnly_IsCorrect(){
        String diceRoll = " 2 +   4 ";
        String rollResult = DiceResult.diceRoll(diceRoll).fullResultString();
        //check for space
        assertEquals(2,check4Spaces(rollResult));
    }

    @Test
    public void WordNumber_isCorrect(){
        String diceRoll = " 2d 6+ 1D8 +   4 ";
        String rollResult = DiceResult.diceRoll(diceRoll).fullResultString();
        assertEquals(13,rollResult.split("\\s+").length);

        diceRoll = " 1d4+d6+2d8+10";
        rollResult = DiceResult.diceRoll(diceRoll).fullResultString();
        assertEquals(17,rollResult.split("\\s+").length);
    }

    private static boolean checkSpaceEqualPlusMinusPara(String input) {
        //String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
        String specialChars1 = "=";
        String specialChars2 = "+";
        String specialChars3 = "-";
        String specialChars4 = "(";
        String specialChars5 = ")";
        char currentCharacter;
        boolean upperCasePresent = false;
//        boolean numberPresent = false;
//        boolean lowerCasePresent = false;
//        boolean specialCharacterPresent1 = false;
        boolean specialCharacterPresent2 = false;
        boolean specialCharacterPresent3 = false;
        boolean specialCharacterPresent4 = false;
        boolean specialCharacterPresent5 = false;

        for (int i = 0; i < input.length(); i++) {
            currentCharacter = input.charAt(i);
        if (Character.isUpperCase(currentCharacter)) {
            upperCasePresent = true;
//            } elseif (Character.isDigit(currentCharacter)) {
//                numberPresent = true;
//            } else if (Character.isLowerCase(currentCharacter)) {
//                lowerCasePresent = true;
//            } else if (specialChars1.contains(String.valueOf(currentCharacter))) {
//                specialCharacterPresent1 = true;
            } else if (specialChars2.contains(String.valueOf(currentCharacter))) {
                specialCharacterPresent2 = true;
            } else if (specialChars3.contains(String.valueOf(currentCharacter))) {
                specialCharacterPresent3 = true;
            } else if (specialChars4.contains(String.valueOf(currentCharacter))) {
                specialCharacterPresent4 = true;
            } else if (specialChars5.contains(String.valueOf(currentCharacter))) {
                specialCharacterPresent5 = true;
            }
        }

        boolean specialCharacterPresent = (specialCharacterPresent2  || specialCharacterPresent3)&&(specialCharacterPresent4&&specialCharacterPresent5);
        return
                upperCasePresent!=specialCharacterPresent;//numberPresent && upperCasePresent && lowerCasePresent && specialCharacterPresent;
    }

    private static boolean checkNoParaPlusMinus(String input) {

        String specialChars2 = "+";
        String specialChars3 = "-";
        String specialChars4 = "(";
        String specialChars5 = ")";
        char currentCharacter;


        boolean specialCharacterPresent2 = false;
        boolean specialCharacterPresent3 = false;
        boolean specialCharacterPresent4 = false;
        boolean specialCharacterPresent5 = false;

        for (int i = 0; i < input.length(); i++) {
            currentCharacter = input.charAt(i);

            if (specialChars2.contains(String.valueOf(currentCharacter))) {
                specialCharacterPresent2 = true;
            } else if (specialChars3.contains(String.valueOf(currentCharacter))) {
                specialCharacterPresent3 = true;
            } else if (specialChars4.contains(String.valueOf(currentCharacter))) {
                specialCharacterPresent4 = true;
            } else if (specialChars5.contains(String.valueOf(currentCharacter))) {
                specialCharacterPresent5 = true;
            }
        }

        boolean specialCharacterPresent = specialCharacterPresent2  || specialCharacterPresent3
                    ||specialCharacterPresent4 || specialCharacterPresent5;
        return
                specialCharacterPresent;
    }

    private static int check4Spaces(String input) {

        String specialChars = " ";
        char currentCharacter;
        int spaceCounter=0;

        boolean specialCharacterPresent = false;

        for (int i = 0; i < input.length(); i++) {
            currentCharacter = input.charAt(i);

            if (specialChars.contains(String.valueOf(currentCharacter))) {
                spaceCounter++;
            }
        }
        return spaceCounter;
    }


}