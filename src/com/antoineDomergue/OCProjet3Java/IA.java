package com.antoineDomergue.OCProjet3Java;

import java.util.Random;

import static com.antoineDomergue.OCProjet3Java.GameModes.*;

class IA {
    private static Random random = new Random();

    static String createCombinationChallenger() {

        String combinationChallenger = "";

        //ajout des valeurs dans le string
        int digitCombi1 = random.nextInt(10);
        int digitCombi2 = random.nextInt(10);
        int digitCombi3 = random.nextInt(10);
        int digitCombi4 = random.nextInt(10);
        int digitCombi5 = random.nextInt(10);

        if (Main.combinationLength == 3) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 + digitCombi3;
        }
        else if (Main.combinationLength == 4) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 +
                    digitCombi3 + digitCombi4;
        }
        else if (Main.combinationLength == 5) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 +
                    digitCombi3 + digitCombi4 + digitCombi5;
        }
        return combinationChallenger;
    }

    static String createTryDefender(String userCombinationDefender) {
        for (pIDef = 0; pIDef <= Main.nbTries; pIDef++) {
            if (pIDef == 0) {
                int chiffreCombiDef1 = random.nextInt(10);
                int chiffreCombiDef2 = random.nextInt(10);
                int chiffreCombiDef3 = random.nextInt(10);
                int chiffreCombiDef4 = random.nextInt(10);
                int chiffreCombiDef5 = random.nextInt(10);

                if (combinationLengthDef == 3) {
                    GameModes.combinationDefender = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3;
                }
                else if (combinationLengthDef == 4) {
                    GameModes.combinationDefender = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3 + chiffreCombiDef4;
                }
                else if (combinationLengthDef == 5) {
                    GameModes.combinationDefender = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3 + chiffreCombiDef4 + chiffreCombiDef5;
                }
                System.out.println(GameModes.combinationDefender);
            }

            else if (pIDef > 0) {

                GameModes.combinationDefender2 = "";
                GameModes.resultatIACombinaison = "";

                for (indiceDef = 0; indiceDef < combinationLengthDef; indiceDef++) {

                    if (pIDef == 1) {

                        if (userCombinationDefender.charAt(indiceDef) == GameModes.combinationDefender.charAt
                                (indiceDef)) {
                            GameModes.combinationDefender2 += GameModes.combinationDefender.charAt(indiceDef);
                            GameModes.resultatIACombinaison += "=";
                        }
                        else if (userCombinationDefender.charAt(indiceDef) > GameModes.combinationDefender.charAt
                                (indiceDef)) {
                            int min = Character.getNumericValue(GameModes.combinationDefender.charAt(indiceDef));
                            GameModes.combinationDefender2 += Character.forDigit
                                    ((random.nextInt(9-min+1)+min),10);
                            GameModes.resultatIACombinaison += "+";
                        }
                        else if (userCombinationDefender.charAt(indiceDef) < GameModes.combinationDefender.charAt
                                (indiceDef)) {
                            int max = Character.getNumericValue(GameModes.combinationDefender.charAt(indiceDef));
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