package com.antoineDomergue.OCProjet3Java;

import static com.antoineDomergue.OCProjet3Java.Main.defenderLoop;
import static com.antoineDomergue.OCProjet3Java.Main.menuLoop;

/***
 * Contient le code nécessaire au traitement du mode Defender et Duel.
 */
class DefenderMode extends GameModes {
    private int pIDef = 0;
    private int indiceDef = 0;

    private String combinationDefenderSecondTurn = "";
    private String combinationDefender = "";
    private String tempValue = "";

    /***
     * Génère une proposition quand le joueur fournis une combinaison.
     * La proposition est d'abord générée aléatoirement, puis l'IA se base sur les indices fournis.
     *
     * @param userCombinationDefender
     * @return La proposition de l'IA
     */
    String defenderModeLaunch(String userCombinationDefender) {

        getParamConfig();

        if (defenderLoop) {
            System.out.println("Veuillez rentrer une combinaison de x chiffres :");
            userCombinationDefender = sc.nextLine();
            combinationLength = userCombinationDefender.length();
        }

        if (Main.defenderLoop || (Main.duelLoop && pIDef == 0)) {
            combinationDefenderSecondTurn = "";
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
                }
                
                if(Main.duelLoop && indiceDef > 1) {combinationDefenderSecondTurn = "";}
                
                for (indiceDef = 0; indiceDef < combinationLength; indiceDef++) {
                    
                    if (pIDef == 1) {
                        if (userCombinationDefender.charAt(indiceDef) == combinationDefender.charAt
                                (indiceDef)) {
                            combinationDefenderSecondTurn += combinationDefender.charAt(indiceDef);
                        }
                        else if (userCombinationDefender.charAt(indiceDef) > combinationDefender.charAt
                                (indiceDef)) {
                            int min = Character.getNumericValue(combinationDefender.charAt(indiceDef));
                            combinationDefenderSecondTurn += Character.forDigit
                                    ((random.nextInt(9-min+1)+min),10);
                        }
                        else if (userCombinationDefender.charAt(indiceDef) < combinationDefender.charAt
                                (indiceDef)) {
                            int max = Character.getNumericValue(combinationDefender.charAt(indiceDef));
                            combinationDefenderSecondTurn += Character.forDigit(random.nextInt(max),10);
                        }
                    }

                    else if (pIDef > 1) {
                        if (userCombinationDefender.charAt(indiceDef) == tempValue.charAt
                                (indiceDef)) {
                            combinationDefenderSecondTurn += tempValue.charAt(indiceDef);
                        }
                        else if (userCombinationDefender.charAt(indiceDef) > tempValue.charAt
                                (indiceDef)) {
                            int min = Character.getNumericValue(tempValue.charAt(indiceDef));
                            combinationDefenderSecondTurn += Character.forDigit
                                    ((random.nextInt(10-min+1)+min),10);
                        }
                        else if (userCombinationDefender.charAt(indiceDef) < tempValue.charAt
                                (indiceDef)) {
                            int max = Character.getNumericValue(tempValue.charAt(indiceDef));
                            combinationDefenderSecondTurn += Character.forDigit(random.nextInt(max),10);
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
                    break;
                }
                else if (pIDef+1 == nbTries){
                    System.out.println("L'ordinateur n'a pas trouvé la combinaison.\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                    askEndMenuDefender();
                    break;
                }
                if (Main.duelLoop) {
                    pIDef++;
                    break;}
            }
        } return combinationDefenderSecondTurn;
    }
    private void askEndMenuDefender() {
        int userInputEndGame = sc.nextInt();

        if (userInputEndGame == 1) {
            defenderLoop = true;
        }
        else if (userInputEndGame == 2) {
            defenderLoop = false;
            menuLoop = true;
        }
        else if (userInputEndGame == 3) {
            defenderLoop = false;
            menuLoop = false;
        }
        else {
            System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
            Logger.errorUserInput();
            defenderLoop = false;
            menuLoop = true;
        }
    }
}
