package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;
import java.util.Scanner;

class ChallengerMode extends GameModes {

    void challengerModeLaunch(int combinationLength, int nbTries, boolean devMode) throws IOException {
        Scanner sc = new Scanner(System.in);

        getParamConfig();
        settingsChallenger();

        String combinationChallenger = "";
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
                askEndMenuChallenger();
            }
            else if (pI+1 == nbTries) {
                System.out.println("Perdu ! Vous n'avez pas trouvé la combinaison.\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                askEndMenuChallenger();
            }
        }
    }
}
