package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;
import java.util.Scanner;

class ChallengerMode {
    static void challengerModeLaunch() throws IOException {
        Scanner sc = new Scanner(System.in);

        PropertiesReader.getParamConfig();
        User.settingsChallenger();

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
                if (GameModes.pI == 0) continue;
                else GameModes.pI--;
            }

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

            if (GameModes.userCombination.equals(GameModes.combinationChallenger)) {
                System.out.println("Félicitation ! Vous avez trouvé la combinaison !\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                EndMenu.askEndMenuChallenger();
            }
            else if (GameModes.pI+1 == Main.nbTries) {
                System.out.println("Perdu ! Vous n'avez pas trouvé la combinaison.\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                EndMenu.askEndMenuChallenger();
            }
        }
    }
}
