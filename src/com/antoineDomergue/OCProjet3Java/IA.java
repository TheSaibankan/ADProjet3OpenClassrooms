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
                        GameModes.combinationDefender += String.valueOf(digitCombiI);
                    }
                    System.out.println(combinationDefender);
                }

                else if (pIDef > 0) {

                    GameModes.combinationDefender2 = "";
                    GameModes.resultatIACombinaison = "";

                    for (indiceDef = 0; indiceDef < Main.combinationLength; indiceDef++) {

                        if (pIDef == 1) {

                            if (userCombinationDefender.charAt(indiceDef) == combinationDefender.charAt
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
                    tempValue = GameModes.combinationDefender2;
                    System.out.println(GameModes.combinationDefender2);
                    if (userCombinationDefender.equals(combinationDefender2)) {
                        System.out.println(combinationDefender2);
                        System.out.println("L'ordinateur a trouvé la solution !\n" +
                                "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                        System.out.println("L'ordinateur a pris "+(pIDef+1)+" tours pour trouver la combinaison.");
                        EndMenu.askEndMenuDefender();
                    }
                    else if (pIDef+1 == Main.nbTries){
                        System.out.println("L'ordinateur n'a pas trouvé la combinaison.\n" +
                                "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                        EndMenu.askEndMenuDefender();
                    }
                    }
                } return combinationDefender2;
            }

    }