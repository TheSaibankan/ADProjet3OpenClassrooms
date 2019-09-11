package com.antoineDomergue.OCProjet3Java;

import java.util.Scanner;

import static com.antoineDomergue.OCProjet3Java.Main.*;

class ChallengerMode extends GameModes {

    private Scanner sc = new Scanner(System.in);

    private void askMenuEndChallenger() {
        int userInputEndGame = sc.nextInt();

        if (userInputEndGame == 1) {
            challengerLoop = true;
        } else if (userInputEndGame == 2) {
            challengerLoop = false;
        } else if (userInputEndGame == 3) {
            challengerLoop = false;
            menuLoop = false;
        } else {
            System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
            Logger.errorUserInput();
            challengerLoop = false;
            menuLoop = true;
        }
    }

    void challengerModeLaunch() {

        String combinationChallenger;
        combinationChallenger = createCombinationChallenger();

        if (devMode) {
            System.out.println("La combinaison est la suivante : " + combinationChallenger);
        }

        for (int pI = 0; pI < nbTries; pI++) {
            StringBuilder resultUserCombinaison = new StringBuilder();
            System.out.println("Veuillez rentrer " + combinationLength + " chiffres :" );

            String userCombination = sc.nextLine();

            if (userCombination.length() != combinationLength) {
                System.out.println("Attention ! Vous avez saisi "+userCombination.length()+" chiffre(s) "+
                        "au lieu de "+combinationLength+".");
                Logger.errorUserInput();
                if (pI == 0) continue;
                else pI--;
            }

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

            if (userCombination.equals(combinationChallenger)) {
                System.out.println("Félicitation ! Vous avez trouvé la combinaison !\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                askMenuEndChallenger();
                break;
            }
            else if (pI +1 == nbTries) {
                System.out.println("Perdu ! Vous n'avez pas trouvé la combinaison.\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                askMenuEndChallenger();
                break;
            }
        }
    }
}
