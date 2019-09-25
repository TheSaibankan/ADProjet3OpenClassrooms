package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;

import static com.antoineDomergue.OCProjet3Java.Main.duelLoop;
import static com.antoineDomergue.OCProjet3Java.Main.menuLoop;

/***
 * Contains the code needed to process Duel mode.
 */
class DuelMode extends DefenderMode {
    /***
     * Contains the code specific to the Duel mode.
     * The computer and the user offer a combination.
     * The first to find the combination of the other wins.
     */
    void duelModeLaunch() throws IOException {
        getParamConfig();
        nbTries = 1500;

        System.out.println("Veuillez rentrer une combinaison de " + combinationLength + " chiffres que l'IA devra deviner :");
        String userCombinationDefender = sc.nextLine();

        if (userCombinationDefender.length() > combinationLength) {
            System.out.println("Votre combinaison dépasse la longueur prévue, l'IA ne retiendra que les "
            + combinationLength + " premiers chiffres.");
        }

        String combinationChallenger = createCombinationChallenger();

        if (devMode) {
            System.out.println("La combinaison est la suivante : " + combinationChallenger);
        }


        for (int pI = 0; pI < nbTries; pI++) {
            StringBuilder resultUserCombinaison = new StringBuilder();
            System.out.println("Faites une proposition de " + combinationLength + " chiffres :" );

            String userCombination = sc.nextLine();
            if (userCombination.length() != combinationLength) {
                System.out.println("Attention ! Vous avez saisi "+userCombination.length()+" chiffre(s) "+
                        "au lieu de "+combinationLength+".");
                Logger.errorUserInput();
                pI--;
            }
            else if (userCombination.equals(combinationChallenger)) {
                System.out.println("Félicitation ! Vous avez trouvé la combinaison !\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                askEndMenuDuel();
                break;
            }
            else {
                for(int indice = 0; indice < combinationLength; indice++) {
                    if (userCombination.charAt(indice) == combinationChallenger.charAt(indice)) {
                        resultUserCombinaison.append("=");
                    }
                    else if (userCombination.charAt(indice) < combinationChallenger.charAt(indice)) {
                        resultUserCombinaison.append("+");
                    }
                    else if (userCombination.charAt(indice) > combinationChallenger.charAt(indice)) {
                        resultUserCombinaison.append("-");
                    }
                }
                System.out.println(resultUserCombinaison);
                String combinationDefenderSecondTurn = defenderModeLaunch(userCombinationDefender);

                if (combinationDefenderSecondTurn.equals(userCombinationDefender)) {
                    System.out.println("Perdu ! L'IA a trouvé la combinaison avant vous !\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                    askEndMenuDuel();
                    break;
                }
            }
        }
    }

    /***
     * Manages the end-of-game menu of the Duel mode.
     */
    private void askEndMenuDuel() {
        int userInputEndGame = sc.nextInt();

        if (userInputEndGame == 1) {
            duelLoop = true;
        }
        else if (userInputEndGame == 2) {
            duelLoop = false;
            menuLoop = true;
        }
        else if (userInputEndGame == 3) {
            duelLoop = false;
            menuLoop = false;
        }
        else {
            System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
            Logger.errorUserInput();
            duelLoop = false;
            menuLoop = true;
        }
    }
}
