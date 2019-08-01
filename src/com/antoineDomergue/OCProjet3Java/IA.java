package com.antoineDomergue.OCProjet3Java;

import java.util.Random;

import static com.antoineDomergue.OCProjet3Java.GameModes.*;

class IA {

    //new Random().ints(Main.combinationLength, 0, 9).forEach(secret::append);


    private static Random random = new Random();

    static String createCombinationChallenger() {

        for(int iCombination = 1; iCombination <= Main.combinationLength; iCombination++) {
            int digitCombiI = random.nextInt(10);
            GameModes.combinationChallenger += String.valueOf(digitCombiI);
        }
        return GameModes.combinationChallenger;
    }

    static String createTryDefender(String userCombinationDefender) {
        for (pIDef = 0; pIDef <= Main.nbTries; pIDef++) {
            if (pIDef == 0) {
                for(int iCombination = 1; iCombination <= Main.combinationLength; iCombination++) {
                    int digitCombiI = random.nextInt(10);
                    GameModes.combinationChallenger += String.valueOf(digitCombiI);
                }
                System.out.println(GameModes.combinationChallenger);
            }

            else if (pIDef > 0) {

                GameModes.combinationDefender2 = "";
                GameModes.resultatIACombinaison = "";

                for (indiceDef = 0; indiceDef < combinationLengthDef; indiceDef++) {

                    if (pIDef == 1) {

                        if (userCombinationDefender.charAt(indiceDef) == GameModes.combinationChallenger.charAt
                                (indiceDef)) {
                            GameModes.combinationDefender2 += GameModes.combinationChallenger.charAt(indiceDef);
                            GameModes.resultatIACombinaison += "=";
                        }
                        else if (userCombinationDefender.charAt(indiceDef) > GameModes.combinationChallenger.charAt
                                (indiceDef)) {
                            int min = Character.getNumericValue(GameModes.combinationChallenger.charAt(indiceDef));
                            GameModes.combinationDefender2 += Character.forDigit
                                    ((random.nextInt(9-min+1)+min),10);
                            GameModes.resultatIACombinaison += "+";
                        }
                        else if (userCombinationDefender.charAt(indiceDef) < GameModes.combinationChallenger.charAt
                                (indiceDef)) {
                            int max = Character.getNumericValue(GameModes.combinationChallenger.charAt(indiceDef));
                            GameModes.combinationDefender2 += Character.forDigit(random.nextInt(max),10);
                            GameModes.resultatIACombinaison += "-";
                        }
                    }

                    else if (pIDef > 1) {
                        if (userCombinationDefender.charAt(indiceDef) == tempValue.charAt
                                (indiceDef)) {
                            GameModes.combinationDefender2 += tempValue.charAt(indiceDef);
                            GameModes.resultatIACombinaison += "=";
                        }
                        else if (userCombinationDefender.charAt(indiceDef) > tempValue.charAt
                                (indiceDef)) {
                            int min = Character.getNumericValue(tempValue.charAt(indiceDef));
                            GameModes.combinationDefender2 += Character.forDigit
                                    ((random.nextInt(10-min+1)+min),10);
                            GameModes.resultatIACombinaison += "+";
                        }
                        else if (userCombinationDefender.charAt(indiceDef) < tempValue.charAt
                                (indiceDef)) {
                            int max = Character.getNumericValue(tempValue.charAt(indiceDef));
                            GameModes.combinationDefender2 += Character.forDigit(random.nextInt(max),10);
                            GameModes.resultatIACombinaison += "-";
                        }
                    }
                }
                if (resultatIACombinaison.equals("===") || resultatIACombinaison.equals("====")
                        || resultatIACombinaison.equals("=====") ) {
                    return combinationDefender2;
                } else {
                    tempValue = GameModes.combinationDefender2;
                    System.out.println(GameModes.combinationDefender2);
                }
            }
        }
        return combinationDefender2;
    }
}