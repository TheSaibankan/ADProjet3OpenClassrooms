package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class DuelMode {
    static void duelModeLaunch() throws IOException {
        GameModes.pIDef = 0;
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Paramétrage du système Challenger...");
        User.settingsChallenger();

        System.out.println("Paramétrage du système Défenseur...");
        System.out.println("Veuillez rentrer une combinaison de " + Main.combinationLength + " chiffres :");
        String userCombinationDefender = sc.nextLine();

        if (userCombinationDefender.length() > Main.combinationLength) {
            System.out.println("Votre combinaison dépasse la longueur prévue, l'IA ne retiendra que les "
            + Main.combinationLength + " premiers chiffres.");
        }

        GameModes.combinationChallenger = "";
        GameModes.combinationChallenger = IA.createCombinationChallenger();

        if (Main.devMode) {
            System.out.println("La combinaison est la suivante : " + GameModes.combinationChallenger);
        }

        for (GameModes.pI = 0; GameModes.pI < Main.nbTries; GameModes.pI++) {
            StringBuilder resultUserCombinaison = new StringBuilder();
            System.out.println("Veuillez rentrer " + Main.combinationLength + " chiffres :" );

            GameModes.userCombination = sc.nextLine();
            if (GameModes.userCombination.length() != Main.combinationLength) {
                System.out.println("Attention ! Vous avez saisi "+GameModes.userCombination.length()+" chiffre(s) "+
                        "au lieu de "+Main.combinationLength+".");
                Logger.errorUserInput();
                GameModes.pI--;
            }
            else if (GameModes.userCombination.equals(GameModes.combinationChallenger)) {
                System.out.println("Félicitation ! Vous avez trouvé la combinaison !\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                EndMenu.askEndMenuDuel();
            }
            else {
                for(int indice = 0; indice < Main.combinationLength; indice++) {
                    if (GameModes.userCombination.charAt(indice) == GameModes.combinationChallenger.charAt(indice)) {
                        resultUserCombinaison.append("=");
                    }
                    else if (GameModes.userCombination.charAt(indice) < GameModes.combinationChallenger.charAt(indice)) {
                        resultUserCombinaison.append("+");
                    }
                    else if (GameModes.userCombination.charAt(indice) > GameModes.combinationChallenger.charAt(indice)) {
                        resultUserCombinaison.append("-");
                    }
                }
                System.out.println(resultUserCombinaison);
                GameModes.combinationDefenderSecondTurn = IA.createTryDefender(userCombinationDefender);

                if (GameModes.combinationDefenderSecondTurn.equals(userCombinationDefender)) {
                    System.out.println("Perdu ! L'IA a trouvé la combinaison avant vous !\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                    EndMenu.askEndMenuDuel();
                }
            }
        }
    }
}
