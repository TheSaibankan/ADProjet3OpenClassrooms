import java.util.Random;
import java.util.Scanner;

public class modesDeJeu {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    static boolean challengerBoucle;
    static boolean defenseurBoucle;
    static boolean duelBoucle;

    int longueurCombinaison;
    int nbEssaies;
    boolean modeDev;
    boolean menuBoucle;

    public void modeChallenger() {
        System.out.println("Vous avez sélectionné le mode Challenger !");
        System.out.println("Par défaut, la combinaison contient 4 chiffres. " +
                "Voulez-vous modifier la difficulté ?\n 1 - Oui  2 - Non");

        int reponseDiff = sc.nextInt();


        if (reponseDiff == 1) {
            System.out.println("Choisissez la difficulté : 1 - Facile  2 - Normal  " +
                    "3 - Difficile");

            int choixDiff = sc.nextInt();

            if (choixDiff == 1){
                System.out.println("Vous avez choisi le mode facile. (3 chiffres, 10 essaies)");
                longueurCombinaison = 3;
                nbEssaies = 10;
            }
            else if (choixDiff == 2) {
                System.out.println("Vous avez choisi le mode normal. (4 chiffres, 7 essaies)");
                longueurCombinaison = 4;
                nbEssaies = 7;
            }
            else if (choixDiff == 3) {
                System.out.println("Vous avez choisi le mode difficile. (5 chiffres, 5 essaies)");
                longueurCombinaison = 5;
                nbEssaies = 5;
            }
            else {
                System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
            }

        }
        else if (reponseDiff == 2) {
            longueurCombinaison = 4;
            nbEssaies = 7;
        }
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
        }

        System.out.println("Voulez-vous activer le mode développeur ? 1 - Oui  2 - Non");
        int reponseDev = sc.nextInt();
        if (reponseDev == 1) modeDev = true;
        else if (reponseDev == 2) modeDev = false;
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
        }

        String combinaisonChallenger = "";

        //ajout des valeurs dans le string
        int chiffreCombi1 = random.nextInt(10);
        int chiffreCombi2 = random.nextInt(10);
        int chiffreCombi3 = random.nextInt(10);
        int chiffreCombi4 = random.nextInt(10);
        int chiffreCombi5 = random.nextInt(10);

        if (longueurCombinaison == 3) {
            combinaisonChallenger = String.valueOf(chiffreCombi1) + chiffreCombi2 + chiffreCombi3;
        }
        else if (longueurCombinaison == 4) {
            combinaisonChallenger = String.valueOf(chiffreCombi1) + chiffreCombi2 +
                    chiffreCombi3 + chiffreCombi4;
        }
        else if (longueurCombinaison == 5) {
            combinaisonChallenger = String.valueOf(chiffreCombi1) + chiffreCombi2 +
                    chiffreCombi3 + chiffreCombi4 + chiffreCombi5;
        }


        //affichage de la solution en mode dev
        if (modeDev) {
            System.out.println("La combinaison est la suivante : " + combinaisonChallenger);
        }

        for (int pI = 0; pI < nbEssaies; pI++) {
            String resultatUserCombinaison = "";
            System.out.println("Veuillez rentrer " + longueurCombinaison + " chiffres :" );

            if (pI == 0) {
                sc.nextLine(); // pourquoi première lecture est sautée ?
            }

            String userCombinaison = sc.nextLine();
            if (userCombinaison.length() != longueurCombinaison) {
                System.out.println("Attention ! Vous avez saisi "+userCombinaison.length()+" chiffre(s) "+
                        "au lieu de "+longueurCombinaison+".");
                pI--;
                continue;
            }

            for(int indice = 0; indice < longueurCombinaison; indice++) {

                if (userCombinaison.charAt(indice) == combinaisonChallenger.charAt(indice)) {
                    resultatUserCombinaison += "=";
                }
                else if (userCombinaison.charAt(indice) < combinaisonChallenger.charAt(indice)) {
                    resultatUserCombinaison += "+";
                }
                else if (userCombinaison.charAt(indice) > combinaisonChallenger.charAt(indice)) {
                    resultatUserCombinaison += "-";
                }
            }
            System.out.println(resultatUserCombinaison);

            if (resultatUserCombinaison.equals("===") || resultatUserCombinaison.equals("====") ||
                    resultatUserCombinaison.equals("=====")) {
                System.out.println("Félicitation ! Vous avez trouvé la combinaison !\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");

                int userInputEndGame = sc.nextInt();

                if (userInputEndGame == 1) {
                    pI = 99;
                    challengerBoucle = true;
                }
                else if (userInputEndGame == 2) {
                    pI = 99;
                    challengerBoucle = false;
                    menuBoucle = true;
                }
                else if (userInputEndGame == 3) {
                    System.exit(0);
                }
                else {
                    System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                    challengerBoucle = false;
                    menuBoucle = true;
                }
            }
            else if (pI+1 == nbEssaies) {
                System.out.println("Perdu ! Vous n'avez pas trouvé la combinaison.\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");

                int userInputEndGame = sc.nextInt();

                if (userInputEndGame == 1) {
                    pI = 99;
                    challengerBoucle = true;
                }
                else if (userInputEndGame == 2) {
                    pI = 99;
                    challengerBoucle = false;
                    menuBoucle = true;
                }
                else if (userInputEndGame == 3) {
                    System.exit(0);
                }
                else {
                    System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                    challengerBoucle = false;
                    menuBoucle = true;
                }
            }
        }
    }
}
