package com.antoineDomergue.OCProjet3Java;

import java.util.Random;
import java.util.Scanner;

class DefenderMode extends GameModes {
    private Random random = new Random();

    String defenderModeLaunch(int combinationLength, int nbTries, boolean devMode) {
        Scanner sc = new Scanner(System.in);
        
        int pIDef = 0;
        int indiceDef = 0;
        String combinationDefenderSecondTurn = "";
        String resultIACombinaison = "";
        String combinationDefender = "";
        String tempValue = "";
        
        System.out.println("Veuillez rentrer une combinaison de x chiffres :");
        String userCombinationDefender = sc.nextLine();
        combinationLength = userCombinationDefender.length();
        
        if (Main.defenderLoop || (Main.duelLoop && pIDef == 0)) {
            combinationDefenderSecondTurn = "";
            resultIACombinaison = "";
            combinationDefender = "";
            pIDef = 0;
        }

        for (; pIDef <= nbTries; pIDef++) {
            if (pIDef == 0) {
                for(int iCombination = 0; iCombination < combinationLength; iCombination++) {
                    int digitCombinationI = random.nextInt(10);
                    combinationDefender += String.valueOf(digitCombinationI);
                }
                System.out.println(combinationDefender);
                if (Main.duelLoop) {
                    pIDef++;
                    break;}
            }

            else if (pIDef > 0) {

                if (Main.defenderLoop) {
                    combinationDefenderSecondTurn = "";
                    resultIACombinaison = "";
                }
                
                if(Main.duelLoop && indiceDef > 1) {combinationDefenderSecondTurn = "";}
                
                for (indiceDef = 0; indiceDef < combinationLength; indiceDef++) {
                    
                    if (pIDef == 1) {
                        if (userCombinationDefender.charAt(indiceDef) == combinationDefender.charAt
                                (indiceDef)) {
                            combinationDefenderSecondTurn += combinationDefender.charAt(indiceDef);
                            resultIACombinaison += "=";
                        }
                        else if (userCombinationDefender.charAt(indiceDef) > combinationDefender.charAt
                                (indiceDef)) {
                            int min = Character.getNumericValue(combinationDefender.charAt(indiceDef));
                            combinationDefenderSecondTurn += Character.forDigit
                                    ((random.nextInt(9-min+1)+min),10);
                            resultIACombinaison += "+";
                        }
                        else if (userCombinationDefender.charAt(indiceDef) < combinationDefender.charAt
                                (indiceDef)) {
                            int max = Character.getNumericValue(combinationDefender.charAt(indiceDef));
                            combinationDefenderSecondTurn += Character.forDigit(random.nextInt(max),10);
                            resultIACombinaison += "-";
                        }
                    }

                    else if (pIDef > 1) {
                        if (userCombinationDefender.charAt(indiceDef) == tempValue.charAt
                                (indiceDef)) {
                            combinationDefenderSecondTurn += tempValue.charAt(indiceDef);
                            resultIACombinaison += "=";
                        }
                        else if (userCombinationDefender.charAt(indiceDef) > tempValue.charAt
                                (indiceDef)) {
                            int min = Character.getNumericValue(tempValue.charAt(indiceDef));
                            combinationDefenderSecondTurn += Character.forDigit
                                    ((random.nextInt(10-min+1)+min),10);
                            resultIACombinaison += "+";
                        }
                        else if (userCombinationDefender.charAt(indiceDef) < tempValue.charAt
                                (indiceDef)) {
                            int max = Character.getNumericValue(tempValue.charAt(indiceDef));
                            combinationDefenderSecondTurn += Character.forDigit(random.nextInt(max),10);
                            resultIACombinaison += "-";
                        }
                    }
                }
                tempValue = combinationDefenderSecondTurn;
                System.out.println(combinationDefenderSecondTurn);

                if (userCombinationDefender.equals(combinationDefenderSecondTurn)) {
                    System.out.println(combinationDefenderSecondTurn);
                    System.out.println("L'ordinateur a trouvé la solution !\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                    System.out.println("L'ordinateur a pris "+(pIDef+1)+" tours pour trouver la combinaison.");
                    askEndMenuDefender();
                }
                else if (pIDef+1 == nbTries){
                    System.out.println("L'ordinateur n'a pas trouvé la combinaison.\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                    askEndMenuDefender();
                }
                if (Main.duelLoop) {
                    pIDef++;
                    break;}
            }
        } return combinationDefenderSecondTurn;
    }
}
