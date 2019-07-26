import java.util.Scanner;

public class GameEngine {
    Scanner sc = new Scanner(System.in);


    void launchChallenger(String combinationChallenger) {


        if (Main.devMode) {
            System.out.println("La combinaison est la suivante : " + combinationChallenger);
        }

        for (int pI = 0; pI < Main.nbTries; pI++) {
            StringBuilder resultUserCombinaison = new StringBuilder();
            System.out.println("Veuillez rentrer " + Main.combinationLength + " chiffres :" );

            if (pI == 0) {
                sc.nextLine(); // pourquoi première lecture est sautée ?
            }

            String userCombination = sc.nextLine();
            if (userCombination.length() != Main.combinationLength) {
                System.out.println("Attention ! Vous avez saisi "+userCombination.length()+" chiffre(s) "+
                        "au lieu de "+Main.combinationLength+".");

                if (pI == 0) {
                    continue;
                }
                else {
                    pI--;
                }
            }

            for(int indice = 0; indice < Main.combinationLength; indice++) {

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

            if (resultUserCombinaison.toString().equals("===") || resultUserCombinaison.toString().equals("====") ||
                    resultUserCombinaison.toString().equals("=====")) {
                System.out.println("Félicitation ! Vous avez trouvé la combinaison !\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");

                int userInputEndGame = sc.nextInt();

                if (userInputEndGame == 1) {
                    pI = 99;
                    Main.challengerLoop = true;
                }
                else if (userInputEndGame == 2) {
                    pI = 99;
                    Main.challengerLoop = false;
                    Main.menuLoop = true;
                    return;
                }
                else if (userInputEndGame == 3) {
                    System.exit(0);
                }
                else {
                    System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                    Main.challengerLoop = false;
                    Main.menuLoop = true;
                    return;
                }
            }
            else if (pI+1 == Main.nbTries) {
                System.out.println("Perdu ! Vous n'avez pas trouvé la combinaison.\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");

                int userInputEndGame = sc.nextInt();

                if (userInputEndGame == 1) {
                    pI = 99;
                    Main.challengerLoop = true;
                }
                else if (userInputEndGame == 2) {
                    pI = 99;
                    Main.challengerLoop = false;
                    Main.menuLoop = true;
                    return;
                }
                else if (userInputEndGame == 3) {
                    System.exit(0);
                }
                else {
                    System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                    Main.challengerLoop = false;
                    Main.menuLoop = true;
                    return;
                }
            }
        }
    }
}
