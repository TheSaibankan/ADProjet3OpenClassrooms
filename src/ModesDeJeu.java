import java.util.Random;
import java.util.Scanner;

class ModesDeJeu {

    static int longueurCombinaison = 0;
    static int nbEssaies = 7;

    static boolean menuBoucle;

    static boolean challengerBoucle = main.challengerBoucle;
    static boolean defenseurBoucle = main.defenseurBoucle;
    static boolean duelBoucle = main.duelBoucle;

    static boolean modeDev = false;

    static void modeChallenger() {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

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
                return;
            }

        }
        else if (reponseDiff == 2) {
            longueurCombinaison = 4;
            nbEssaies = 7;
        }
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
            return;
        }

        System.out.println("Voulez-vous activer le mode développeur ? 1 - Oui  2 - Non");
        int reponseDev = sc.nextInt();
        if (reponseDev == 1) modeDev = true;
        else if (reponseDev == 2) modeDev = false;
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
            return;
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
            StringBuilder resultatUserCombinaison = new StringBuilder();
            System.out.println("Veuillez rentrer " + longueurCombinaison + " chiffres :" );

            if (pI == 0) {
                sc.nextLine(); // pourquoi première lecture est sautée ?
            }

            String userCombinaison = sc.nextLine();
            if (userCombinaison.length() != longueurCombinaison) {
                System.out.println("Attention ! Vous avez saisi "+userCombinaison.length()+" chiffre(s) "+
                        "au lieu de "+longueurCombinaison+".");

                if (pI == 0) {
                    continue;
                }
                else {
                    pI--;
                }
            }

            for(int indice = 0; indice < longueurCombinaison; indice++) {

                if (userCombinaison.charAt(indice) == combinaisonChallenger.charAt(indice)) {
                    resultatUserCombinaison.append("=");
                }
                else if (userCombinaison.charAt(indice) < combinaisonChallenger.charAt(indice)) {
                    resultatUserCombinaison.append("+");
                }
                else if (userCombinaison.charAt(indice) > combinaisonChallenger.charAt(indice)) {
                    resultatUserCombinaison.append("-");
                }
            }
            System.out.println(resultatUserCombinaison);

            if (resultatUserCombinaison.toString().equals("===") || resultatUserCombinaison.toString().equals("====") ||
                    resultatUserCombinaison.toString().equals("=====")) {
                System.out.println("Félicitation ! Vous avez trouvé la combinaison !\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");

                int userInputEndGame = sc.nextInt();

                if (userInputEndGame == 1) {
                    pI = 99;
                    main.challengerBoucle = true;
                }
                else if (userInputEndGame == 2) {
                    pI = 99;
                    main.challengerBoucle = false;
                    menuBoucle = true;
                    return;
                }
                else if (userInputEndGame == 3) {
                    System.exit(0);
                }
                else {
                    System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                    main.challengerBoucle = false;
                    menuBoucle = true;
                    return;
                }
            }
            else if (pI+1 == nbEssaies) {
                System.out.println("Perdu ! Vous n'avez pas trouvé la combinaison.\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");

                int userInputEndGame = sc.nextInt();

                if (userInputEndGame == 1) {
                    pI = 99;
                    main.challengerBoucle = true;
                }
                else if (userInputEndGame == 2) {
                    pI = 99;
                    main.challengerBoucle = false;
                    menuBoucle = true;
                    return;
                }
                else if (userInputEndGame == 3) {
                    System.exit(0);
                }
                else {
                    System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                    main.challengerBoucle = false;
                    menuBoucle = true;
                    return;
                }
            }
        }
    }

    public static void modeDefenseur() {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int longueurCombinaisonDef;

        String combinaisonDefenseur = "";
        String combinaisonDefenseur2 = "";
        String resultatIACombinaison = "";
        String valeurTemp = "";

        boolean essaiesInfinie = false;

        System.out.println("Vous avez sélectionné le mode Défenseur !");

        System.out.println("Voulez-vous activer le mode Essaies illimités ? 1 - Oui  2 - Non");
        int repEssaiesInfinie = sc.nextInt();

        if (repEssaiesInfinie == 1) {
            nbEssaies = 1500;
            essaiesInfinie = true;
        }

        else if (repEssaiesInfinie == 2) {
            nbEssaies = 10;
            essaiesInfinie = false;
        }
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Défenseur...");
            return;
        }

        System.out.println("Veuillez rentrer une combinaison de 3, 4 ou 5 chiffes :");

        sc.nextLine();
        String userCombinaisonDefenseur = sc.nextLine();


        if (userCombinaisonDefenseur.length() == 3) {
            longueurCombinaisonDef = 3;
        }
        else if (userCombinaisonDefenseur.length() == 4) {
            longueurCombinaisonDef = 4;
        }
        else if (userCombinaisonDefenseur.length() == 5) {
            longueurCombinaisonDef = 5;
        }
        else {
            System.out.println("Une erreur est survenue. Votre combinaison est de " +
                    userCombinaisonDefenseur.length()+" chiffre(s). Redémarrage du module Défenseur...");
            return;
        }

        for (int pIDef = 0; pIDef <= nbEssaies; pIDef++) {
            if (pIDef == 0) {
                int chiffreCombiDef1 = random.nextInt(10);
                int chiffreCombiDef2 = random.nextInt(10);
                int chiffreCombiDef3 = random.nextInt(10);
                int chiffreCombiDef4 = random.nextInt(10);
                int chiffreCombiDef5 = random.nextInt(10);

                if (longueurCombinaisonDef == 3) {
                    combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3;
                }
                else if (longueurCombinaisonDef == 4) {
                    combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3 + chiffreCombiDef4;
                }
                else if (longueurCombinaisonDef == 5) {
                    combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3 + chiffreCombiDef4 + chiffreCombiDef5;
                }
                System.out.println(combinaisonDefenseur);
            }

            else if (pIDef > 0) {

                combinaisonDefenseur2 = "";
                resultatIACombinaison = "";

                for (int indiceDef = 0; indiceDef < longueurCombinaisonDef; indiceDef++) {

                    if (pIDef == 1) {

                        if (userCombinaisonDefenseur.charAt(indiceDef) == combinaisonDefenseur.charAt
                                (indiceDef)) {

                            combinaisonDefenseur2 += combinaisonDefenseur.charAt(indiceDef);
                            resultatIACombinaison += "=";

                        }

                        else if (userCombinaisonDefenseur.charAt(indiceDef) > combinaisonDefenseur.charAt
                                (indiceDef)) {

                            int min = Character.getNumericValue(combinaisonDefenseur.charAt(indiceDef));

                            combinaisonDefenseur2 += Character.forDigit
                                    ((random.nextInt(9-min+1)+min),10);

                            resultatIACombinaison += "+";
                        }

                        else if (userCombinaisonDefenseur.charAt(indiceDef) < combinaisonDefenseur.charAt
                                (indiceDef)) {

                            int max = Character.getNumericValue(combinaisonDefenseur.charAt(indiceDef));

                            combinaisonDefenseur2 += Character.forDigit(random.nextInt(max),10);

                            resultatIACombinaison += "-";

                        }
                    }

                    else if (pIDef > 1) {
                        if (userCombinaisonDefenseur.charAt(indiceDef) == valeurTemp.charAt
                                (indiceDef)) {

                            combinaisonDefenseur2 += valeurTemp.charAt(indiceDef);
                            resultatIACombinaison += "=";

                        }

                        else if (userCombinaisonDefenseur.charAt(indiceDef) > valeurTemp.charAt
                                (indiceDef)) {

                            int min = Character.getNumericValue(valeurTemp.charAt(indiceDef));

                            combinaisonDefenseur2 += Character.forDigit
                                    ((random.nextInt(10-min+1)+min),10);

                            resultatIACombinaison += "+";
                        }

                        else if (userCombinaisonDefenseur.charAt(indiceDef) < valeurTemp.charAt
                                (indiceDef)) {

                            int max = Character.getNumericValue(valeurTemp.charAt(indiceDef));

                            combinaisonDefenseur2 += Character.forDigit(random.nextInt(max),10);

                            resultatIACombinaison += "-";

                        }
                    }
                }

                valeurTemp = combinaisonDefenseur2;
                System.out.println(combinaisonDefenseur2);

                if (combinaisonDefenseur2.equals(userCombinaisonDefenseur)) {
                    System.out.println("L'ordinateur a trouvé la solution !\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                    if (essaiesInfinie == true) {
                        System.out.println("L'ordinateur a pris "+(pIDef+1)+" tours pour trouver la combinaison.");
                    }

                    int userInputEndGame = sc.nextInt();

                    if (userInputEndGame == 1) {
                        pIDef = 1501;
                        main.defenseurBoucle = true;
                    }
                    else if (userInputEndGame == 2) {
                        pIDef = 1501;
                        main.defenseurBoucle = false;
                        menuBoucle = true;
                    }
                    else if (userInputEndGame == 3) {
                        System.exit(0);
                    }
                    else {
                        System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                        main.defenseurBoucle = false;
                        menuBoucle = true;
                    }
                }
                else if (pIDef+1 == nbEssaies){
                    System.out.println("L'ordinateur n'a pas trouvé la combinaison.\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");

                    int userInputEndGame = sc.nextInt();

                    if (userInputEndGame == 1) {
                        main.defenseurBoucle = true;
                    } else if (userInputEndGame == 2) {
                        main.defenseurBoucle = false;
                        menuBoucle = true;
                    } else if (userInputEndGame == 3) {
                        System.exit(0);
                    } else {
                        System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                        main.defenseurBoucle = false;
                        menuBoucle = true;
                    }
                }
            }
        }
    }

    public static void modeDuel() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int longueurCombinaisonDef;
        nbEssaies = 1500;

        String combinaisonDefenseur = "";
        String combinaisonDefenseur2 = "";
        String resultatIACombinaison = "";
        String valeurTemp = "";

        boolean essaiesInfinie = false;

        System.out.println("Paramétrage du système Challenger...");

        System.out.println("Par défaut, la combinaison de l'IA contient 4 chiffres. " +
                "Voulez-vous modifier la difficulté ?\n 1 - Oui  2 - Non");

        int reponseDiff = sc.nextInt();

        if (reponseDiff == 1) {
            System.out.println("Choisissez la difficulté : 1 - Facile  2 - Normal  " +
                    "3 - Difficile");

            int choixDiff = sc.nextInt();

            if (choixDiff == 1){
                System.out.println("Vous avez choisi le mode facile. (3 chiffres)");
                longueurCombinaison = 3;
                nbEssaies = 10;
            }
            else if (choixDiff == 2) {
                System.out.println("Vous avez choisi le mode normal. (4 chiffres)");
                longueurCombinaison = 4;
                nbEssaies = 7;
            }
            else if (choixDiff == 3) {
                System.out.println("Vous avez choisi le mode difficile. (5 chiffres)");
                longueurCombinaison = 5;
                nbEssaies = 5;
            }
            else {
                System.out.println("Une erreur est survenue. Redémarrage du module Duel...");
                return;
            }

        }
        else if (reponseDiff == 2) {
            longueurCombinaison = 4;
            nbEssaies = 7;
        }
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Duel...");
            return;
        }

        System.out.println("Voulez-vous activer le mode développeur ? 1 - Oui  2 - Non");
        int reponseDev = sc.nextInt();
        if (reponseDev == 1) modeDev = true;
        else if (reponseDev == 2) modeDev = false;
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Duel...");
            return;
        }

        System.out.println("Paramétrage du système Défenseur...");
        System.out.println("Veuillez rentrer une combinaison de 3, 4 ou 5 chiffes :");

        sc.nextLine();
        String userCombinaisonDefenseur = sc.nextLine();


        if (userCombinaisonDefenseur.length() == 3) {
            longueurCombinaisonDef = 3;
        }
        else if (userCombinaisonDefenseur.length() == 4) {
            longueurCombinaisonDef = 4;
        }
        else if (userCombinaisonDefenseur.length() == 5) {
            longueurCombinaisonDef = 5;
        }
        else {
            System.out.println("Une erreur est survenue. Votre combinaison est de " +
                    userCombinaisonDefenseur.length()+" chiffre(s). Redémarrage du module Duel...");
            return;
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

            if (pI == 0) {
                int chiffreCombiDef1 = random.nextInt(10);
                int chiffreCombiDef2 = random.nextInt(10);
                int chiffreCombiDef3 = random.nextInt(10);
                int chiffreCombiDef4 = random.nextInt(10);
                int chiffreCombiDef5 = random.nextInt(10);

                if (longueurCombinaisonDef == 3) {
                    combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3;
                }
                else if (longueurCombinaisonDef == 4) {
                    combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3 + chiffreCombiDef4;
                }
                else if (longueurCombinaisonDef == 5) {
                    combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3 + chiffreCombiDef4 + chiffreCombiDef5;
                }
                System.out.println(combinaisonDefenseur);
            }

            else if (pI > 0) {

                combinaisonDefenseur2 = "";
                resultatIACombinaison = "";

                for (int indiceDef = 0; indiceDef < longueurCombinaisonDef; indiceDef++) {

                    if (pI == 1) {

                        if (userCombinaisonDefenseur.charAt(indiceDef) == combinaisonDefenseur.charAt
                                (indiceDef)) {

                            combinaisonDefenseur2 += combinaisonDefenseur.charAt(indiceDef);
                            resultatIACombinaison += "=";
                        }

                        else if (userCombinaisonDefenseur.charAt(indiceDef) > combinaisonDefenseur.charAt
                                (indiceDef)) {

                            int min = Character.getNumericValue(combinaisonDefenseur.charAt(indiceDef));
                            combinaisonDefenseur2 += Character.forDigit
                                    ((random.nextInt(9-min+1)+min),10);
                            resultatIACombinaison += "+";
                        }

                        else if (userCombinaisonDefenseur.charAt(indiceDef) < combinaisonDefenseur.charAt
                                (indiceDef)) {

                            int max = Character.getNumericValue(combinaisonDefenseur.charAt(indiceDef));

                            combinaisonDefenseur2 += Character.forDigit(random.nextInt(max),10);

                            resultatIACombinaison += "-";

                        }
                    }
                    else if (pI > 1) {
                        if (userCombinaisonDefenseur.charAt(indiceDef) == valeurTemp.charAt
                                (indiceDef)) {

                            combinaisonDefenseur2 += valeurTemp.charAt(indiceDef);
                            resultatIACombinaison += "=";

                        }

                        else if (userCombinaisonDefenseur.charAt(indiceDef) > valeurTemp.charAt
                                (indiceDef)) {

                            int min = Character.getNumericValue(valeurTemp.charAt(indiceDef));

                            combinaisonDefenseur2 += Character.forDigit
                                    ((random.nextInt(10-min+1)+min),10);

                            resultatIACombinaison += "+";
                        }

                        else if (userCombinaisonDefenseur.charAt(indiceDef) < valeurTemp.charAt
                                (indiceDef)) {

                            int max = Character.getNumericValue(valeurTemp.charAt(indiceDef));

                            combinaisonDefenseur2 += Character.forDigit(random.nextInt(max),10);

                            resultatIACombinaison += "-";

                        }
                    }
                }

                valeurTemp = combinaisonDefenseur2;
                System.out.println(combinaisonDefenseur2);

                if (resultatUserCombinaison.equals("===") || resultatUserCombinaison.equals("====") ||
                        resultatUserCombinaison.equals("=====")) {
                    System.out.println("Félicitation ! Vous avez trouvé la combinaison !\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");

                    int userInputEndGame = sc.nextInt();

                    if (userInputEndGame == 1) {
                        pI = 99;
                        main.challengerBoucle = true;
                    }
                    else if (userInputEndGame == 2) {
                        pI = 99;
                        main.challengerBoucle = false;
                        menuBoucle = true;
                    }
                    else if (userInputEndGame == 3) {
                        System.exit(0);
                    }
                    else {
                        System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                        main.challengerBoucle = false;
                        menuBoucle = true;
                    }
                }
                else if (pI+1 == nbEssaies) {
                    System.out.println("Perdu ! Vous n'avez pas trouvé la combinaison.\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");

                    int userInputEndGame = sc.nextInt();

                    if (userInputEndGame == 1) {
                        pI = 99;
                        main.challengerBoucle = true;
                    }
                    else if (userInputEndGame == 2) {
                        pI = 99;
                        main.challengerBoucle = false;
                        menuBoucle = true;
                    }
                    else if (userInputEndGame == 3) {
                        System.exit(0);
                    }
                    else {
                        System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                        main.challengerBoucle = false;
                        menuBoucle = true;
                    }
                }

                if (combinaisonDefenseur2.equals(userCombinaisonDefenseur)) {
                    System.out.println("L'ordinateur a trouvé la solution !\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                    if (essaiesInfinie) {
                        System.out.println("L'ordinateur a pris "+(pI+1)+" tours pour trouver la combinaison.");
                    }

                    int userInputEndGame = sc.nextInt();

                    if (userInputEndGame == 1) {
                        pI = 1501;
                        main.defenseurBoucle = true;
                    }
                    else if (userInputEndGame == 2) {
                        pI = 1501;
                        main.defenseurBoucle = false;
                        menuBoucle = true;
                    }
                    else if (userInputEndGame == 3) {
                        System.exit(0);
                    }
                    else {
                        System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                        main.defenseurBoucle = false;
                        menuBoucle = true;
                    }
                }
                else if (pI+1 == nbEssaies){
                    System.out.println("L'ordinateur n'a pas trouvé la combinaison.\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");

                    int userInputEndGame = sc.nextInt();

                    if (userInputEndGame == 1) {
                        main.defenseurBoucle = true;
                    } else if (userInputEndGame == 2) {
                        main.defenseurBoucle = false;
                        menuBoucle = true;
                    } else if (userInputEndGame == 3) {
                        System.exit(0);
                    } else {
                        System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                        main.defenseurBoucle = false;
                        menuBoucle = true;
                    }
                }
            }
        }
    }
}
