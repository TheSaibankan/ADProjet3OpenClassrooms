package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class DuelMode extends DefenderMode {

    void duelModeLaunch(int combinationLength, int nbTries, boolean devMode) throws IOException {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int pI;
        int pIDef = 0;

        System.out.println("Paramétrage du système Challenger...");
        settingsChallenger();

        System.out.println("Paramétrage du système Défenseur...");
        System.out.println("Veuillez rentrer une combinaison de " + combinationLength + " chiffres :");
        String userCombinationDefender = sc.nextLine();

        if (userCombinationDefender.length() > combinationLength) {
            System.out.println("Votre combinaison dépasse la longueur prévue, l'IA ne retiendra que les "
            + combinationLength + " premiers chiffres.");
        }


        String combinationChallenger = createCombinationChallenger();

        if (devMode) {
            System.out.println("La combinaison est la suivante : " + combinationChallenger);
        }


        for (pI = 0; pI < nbTries; pI++) {
            StringBuilder resultUserCombinaison = new StringBuilder();
            System.out.println("Veuillez rentrer " + combinationLength + " chiffres :" );

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
                String combinationDefenderSecondTurn = defenderModeLaunch(combinationLength, nbTries, devMode);

                if (combinationDefenderSecondTurn.equals(userCombinationDefender)) {
                    System.out.println("Perdu ! L'IA a trouvé la combinaison avant vous !\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                    askEndMenuDuel();
                }
            }
        }
    }
}
