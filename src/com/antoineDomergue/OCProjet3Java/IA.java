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

        
        if (Main.defenderLoop || (Main.duelLoop && GameModes.pIDef < 0)) {
            GameModes.combinationDefenderSecondTurn = "";
            GameModes.resultatIACombinaison = "";
            GameModes.combinationDefender = "";
            GameModes.pIDef = 0;
        }

            for (; GameModes.pIDef <= Main.nbTries; GameModes.pIDef++) {
                if (GameModes.pIDef == 0) {
                    for(int iCombination = 0; iCombination < Main.combinationLength; iCombination++) {
                        int digitCombiI = random.nextInt(10);
                        GameModes.combinationDefender += String.valueOf(digitCombiI);
                    }
                    System.out.println(combinationDefender);
                    if (Main.duelLoop) {
                        GameModes.pIDef++;
                        break;}
                }

                else if (GameModes.pIDef > 0) {

                    /*
                        if (Main.defenderLoop || (Main.duelLoop && GameModes.pIDef > 0)) {
                        GameModes.combinationDefenderSecondTurn = "";
                        GameModes.resultatIACombinaison = "";
                        }
                        */

                    if(Main.duelLoop && indiceDef > 1) {GameModes.combinationDefenderSecondTurn = "";}

                    for (indiceDef = 0; indiceDef < Main.combinationLength; indiceDef++) {


                        if (GameModes.pIDef == 1) {

                            if (userCombinationDefender.charAt(indiceDef) == combinationDefender.charAt
                                    (indiceDef)) {
                                GameModes.combinationDefenderSecondTurn += GameModes.combinationDefender.charAt(indiceDef);
                                GameModes.resultatIACombinaison += "=";
                            }
                            else if (userCombinationDefender.charAt(indiceDef) > GameModes.combinationDefender.charAt
                                    (indiceDef)) {
                                int min = Character.getNumericValue(GameModes.combinationDefender.charAt(indiceDef));
                                GameModes.combinationDefenderSecondTurn += Character.forDigit
                                        ((random.nextInt(9-min+1)+min),10);
                                GameModes.resultatIACombinaison += "+";
                            }
                            else if (userCombinationDefender.charAt(indiceDef) < GameModes.combinationDefender.charAt
                                    (indiceDef)) {
                                int max = Character.getNumericValue(GameModes.combinationDefender.charAt(indiceDef));
                                GameModes.combinationDefenderSecondTurn += Character.forDigit(random.nextInt(max),10);
                                GameModes.resultatIACombinaison += "-";
                            }
                        }

                        else if (GameModes.pIDef > 1) {



                            if (userCombinationDefender.charAt(indiceDef) == tempValue.charAt
                                    (indiceDef)) {
                                GameModes.combinationDefenderSecondTurn += tempValue.charAt(indiceDef);
                                GameModes.resultatIACombinaison += "=";
                            }
                            else if (userCombinationDefender.charAt(indiceDef) > tempValue.charAt
                                    (indiceDef)) {
                                int min = Character.getNumericValue(tempValue.charAt(indiceDef));
                                GameModes.combinationDefenderSecondTurn += Character.forDigit
                                        ((random.nextInt(10-min+1)+min),10);
                                GameModes.resultatIACombinaison += "+";
                            }
                            else if (userCombinationDefender.charAt(indiceDef) < tempValue.charAt
                                    (indiceDef)) {
                                int max = Character.getNumericValue(tempValue.charAt(indiceDef));
                                GameModes.combinationDefenderSecondTurn += Character.forDigit(random.nextInt(max),10);
                                GameModes.resultatIACombinaison += "-";
                            }
                        }
                    }
                    tempValue = GameModes.combinationDefenderSecondTurn;
                    System.out.println(GameModes.combinationDefenderSecondTurn);
                    if (userCombinationDefender.equals(combinationDefenderSecondTurn)) {
                        System.out.println(combinationDefenderSecondTurn);
                        System.out.println("L'ordinateur a trouvé la solution !\n" +
                                "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                        System.out.println("L'ordinateur a pris "+(GameModes.pIDef+1)+" tours pour trouver la combinaison.");
                        EndMenu.askEndMenuDefender();
                    }
                    else if (GameModes.pIDef+1 == Main.nbTries){
                        System.out.println("L'ordinateur n'a pas trouvé la combinaison.\n" +
                                "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                        EndMenu.askEndMenuDefender();
                    }
                    if (Main.duelLoop) {
                        GameModes.pIDef++;
                        break;}
                    }
                } return combinationDefenderSecondTurn;
            }
    }