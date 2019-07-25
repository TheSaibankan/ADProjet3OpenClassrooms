import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class GameModes {

    static int combinaisonLength;
    static int nbTries;
    static boolean devMode;

    static void challengerMode() throws IOException {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        PropertiesReader.setBasicParam();
        PropertiesReader.getParamConfig();

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
                PropertiesReader.setEasyChallenger();
                combinaisonLength = PropertiesReader.getParamConfigCombinationLength();
                nbTries = PropertiesReader.getParamConfigNbTries();

            }
            else if (choixDiff == 2) {
                System.out.println("Vous avez choisi le mode normal. (4 chiffres, 7 essaies)");
                PropertiesReader.setMediumChallenger();
                combinaisonLength = PropertiesReader.getParamConfigCombinationLength();
                nbTries = PropertiesReader.getParamConfigNbTries();

            }
            else if (choixDiff == 3) {
                System.out.println("Vous avez choisi le mode difficile. (5 chiffres, 5 essaies)");
                PropertiesReader.setHardChallenger();
                combinaisonLength = PropertiesReader.getParamConfigCombinationLength();
                nbTries = PropertiesReader.getParamConfigNbTries();

            }
            else {
                System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
                return;
            }
        }

        else if (reponseDiff == 2) {
            PropertiesReader.setMediumChallenger();
            combinaisonLength = PropertiesReader.getParamConfigCombinationLength();
            nbTries = PropertiesReader.getParamConfigNbTries();
        }
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
            return;
        }

        System.out.println("Voulez-vous activer le mode développeur ? 1 - Oui  2 - Non");
        int reponseDev = sc.nextInt();
        if (reponseDev == 1) {
            PropertiesReader.setDevModeChallenger();
            devMode = PropertiesReader.getParamConfigDevMode();
        }
        else if (reponseDev == 2) devMode = false;
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
            return;
        }

        String combinationChallenger = "";

        //ajout des valeurs dans le string
        int digitCombi1 = random.nextInt(10);
        int digitCombi2 = random.nextInt(10);
        int digitCombi3 = random.nextInt(10);
        int digitCombi4 = random.nextInt(10);
        int digitCombi5 = random.nextInt(10);

        if (combinaisonLength == 3) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 + digitCombi3;
        }
        else if (combinaisonLength == 4) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 +
                    digitCombi3 + digitCombi4;
        }
        else if (combinaisonLength == 5) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 +
                    digitCombi3 + digitCombi4 + digitCombi5;
        }


        //affichage de la solution en mode dev
        if (devMode) {
            System.out.println("La combinaison est la suivante : " + combinationChallenger);
        }

        for (int pI = 0; pI < nbTries; pI++) {
            StringBuilder resultUserCombinaison = new StringBuilder();
            System.out.println("Veuillez rentrer " + combinaisonLength + " chiffres :" );

            if (pI == 0) {
                sc.nextLine(); // pourquoi première lecture est sautée ?
            }

            String userCombinaison = sc.nextLine();
            if (userCombinaison.length() != combinaisonLength) {
                System.out.println("Attention ! Vous avez saisi "+userCombinaison.length()+" chiffre(s) "+
                        "au lieu de "+combinaisonLength+".");

                if (pI == 0) {
                    continue;
                }
                else {
                    pI--;
                }
            }

            for(int indice = 0; indice < combinaisonLength; indice++) {

                if (userCombinaison.charAt(indice) == combinationChallenger.charAt(indice)) {
                    resultUserCombinaison.append("=");
                }
                else if (userCombinaison.charAt(indice) < combinationChallenger.charAt(indice)) {
                    resultUserCombinaison.append("+");
                }
                else if (userCombinaison.charAt(indice) > combinationChallenger.charAt(indice)) {
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
            else if (pI+1 == nbTries) {
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

    static void defenderMode() throws IOException {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int combinaisonLengthDef;

        String combinaisonDefenseur = "";
        String combinationDefenseur2 = "";
        String resultatIACombinaison = "";
        String tempValue = "";

        boolean infiniteTries = false;

        System.out.println("Vous avez sélectionné le mode Défenseur !");

        System.out.println("Voulez-vous activer le mode Essaies illimités ? 1 - Oui  2 - Non");
        int repEssaiesInfinie = sc.nextInt();

        if (repEssaiesInfinie == 1) {
            PropertiesReader.setInfiniteTriesDefender();
            nbTries = PropertiesReader.getParamConfigNbTries();
            infiniteTries = PropertiesReader.getParamInfiniteTries();
        }

        else if (repEssaiesInfinie == 2) {
            PropertiesReader.setInfiniteTriesDefenderFalse();
            nbTries = PropertiesReader.getParamConfigNbTries();
            infiniteTries = PropertiesReader.getParamInfiniteTries();
        }
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Défenseur...");
            return;
        }

        System.out.println("Veuillez rentrer une combinaison de 3, 4 ou 5 chiffes :");

        sc.nextLine();
        String userCombinationDefender = sc.nextLine();


        if (userCombinationDefender.length() == 3) {
            combinaisonLengthDef = 3;
        }
        else if (userCombinationDefender.length() == 4) {
            combinaisonLengthDef = 4;
        }
        else if (userCombinationDefender.length() == 5) {
            combinaisonLengthDef = 5;
        }
        else {
            System.out.println("Une erreur est survenue. Votre combinaison est de " +
                    userCombinationDefender.length()+" chiffre(s). Redémarrage du module Défenseur...");
            return;
        }

        for (int pIDef = 0; pIDef <= nbTries; pIDef++) {
            if (pIDef == 0) {
                int chiffreCombiDef1 = random.nextInt(10);
                int chiffreCombiDef2 = random.nextInt(10);
                int chiffreCombiDef3 = random.nextInt(10);
                int chiffreCombiDef4 = random.nextInt(10);
                int chiffreCombiDef5 = random.nextInt(10);

                if (combinaisonLengthDef == 3) {
                    combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3;
                }
                else if (combinaisonLengthDef == 4) {
                    combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3 + chiffreCombiDef4;
                }
                else if (combinaisonLengthDef == 5) {
                    combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3 + chiffreCombiDef4 + chiffreCombiDef5;
                }
                System.out.println(combinaisonDefenseur);
            }

            else if (pIDef > 0) {

                combinationDefenseur2 = "";
                resultatIACombinaison = "";

                for (int indiceDef = 0; indiceDef < combinaisonLengthDef; indiceDef++) {

                    if (pIDef == 1) {

                        if (userCombinationDefender.charAt(indiceDef) == combinaisonDefenseur.charAt
                                (indiceDef)) {

                            combinationDefenseur2 += combinaisonDefenseur.charAt(indiceDef);
                            resultatIACombinaison += "=";

                        }

                        else if (userCombinationDefender.charAt(indiceDef) > combinaisonDefenseur.charAt
                                (indiceDef)) {

                            int min = Character.getNumericValue(combinaisonDefenseur.charAt(indiceDef));

                            combinationDefenseur2 += Character.forDigit
                                    ((random.nextInt(9-min+1)+min),10);

                            resultatIACombinaison += "+";
                        }

                        else if (userCombinationDefender.charAt(indiceDef) < combinaisonDefenseur.charAt
                                (indiceDef)) {

                            int max = Character.getNumericValue(combinaisonDefenseur.charAt(indiceDef));

                            combinationDefenseur2 += Character.forDigit(random.nextInt(max),10);

                            resultatIACombinaison += "-";

                        }
                    }

                    else if (pIDef > 1) {
                        if (userCombinationDefender.charAt(indiceDef) == tempValue.charAt
                                (indiceDef)) {

                            combinationDefenseur2 += tempValue.charAt(indiceDef);
                            resultatIACombinaison += "=";

                        }

                        else if (userCombinationDefender.charAt(indiceDef) > tempValue.charAt
                                (indiceDef)) {

                            int min = Character.getNumericValue(tempValue.charAt(indiceDef));

                            combinationDefenseur2 += Character.forDigit
                                    ((random.nextInt(10-min+1)+min),10);

                            resultatIACombinaison += "+";
                        }

                        else if (userCombinationDefender.charAt(indiceDef) < tempValue.charAt
                                (indiceDef)) {

                            int max = Character.getNumericValue(tempValue.charAt(indiceDef));

                            combinationDefenseur2 += Character.forDigit(random.nextInt(max),10);

                            resultatIACombinaison += "-";

                        }
                    }
                }

                tempValue = combinationDefenseur2;
                System.out.println(combinationDefenseur2);

                if (combinationDefenseur2.equals(userCombinationDefender)) {
                    System.out.println("L'ordinateur a trouvé la solution !\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                    if (infiniteTries) {
                        System.out.println("L'ordinateur a pris "+(pIDef+1)+" tours pour trouver la combinaison.");
                    }

                    int userInputEndGame = sc.nextInt();

                    if (userInputEndGame == 1) {
                        pIDef = 1501;
                        Main.defenderLoop = true;
                    }
                    else if (userInputEndGame == 2) {
                        pIDef = 1501;
                        Main.defenderLoop = false;
                        Main.menuLoop = true;
                    }
                    else if (userInputEndGame == 3) {
                        System.exit(0);
                    }
                    else {
                        System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                        Main.defenderLoop = false;
                        Main.menuLoop = true;
                    }
                }
                else if (pIDef+1 == nbTries){
                    System.out.println("L'ordinateur n'a pas trouvé la combinaison.\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");

                    int userInputEndGame = sc.nextInt();

                    if (userInputEndGame == 1) {
                        Main.defenderLoop = true;
                    } else if (userInputEndGame == 2) {
                        Main.defenderLoop = false;
                        Main.menuLoop = true;
                    } else if (userInputEndGame == 3) {
                        System.exit(0);
                    } else {
                        System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                        Main.defenderLoop = false;
                        Main.menuLoop = true;
                    }
                }
            }
        }
    }

    public static void duelMode() throws IOException {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int combinaisonLengthDef;
        nbTries = 1500;

        String combinaisonDefenseur = "";
        String combinationDefenseur2 = "";
        String resultatIACombinaison = "";
        String tempValue = "";

        boolean infiniteTries = false;

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
                PropertiesReader.setEasyDuel();
                combinaisonLength = PropertiesReader.getParamConfigCombinationLength();
                nbTries = PropertiesReader.getParamConfigNbTries();
            }
            else if (choixDiff == 2) {
                System.out.println("Vous avez choisi le mode normal. (4 chiffres)");
                PropertiesReader.setMediumDuel();
                combinaisonLength = PropertiesReader.getParamConfigCombinationLength();
                nbTries = PropertiesReader.getParamConfigNbTries();
            }
            else if (choixDiff == 3) {
                System.out.println("Vous avez choisi le mode difficile. (5 chiffres)");
                PropertiesReader.setHardDuel();
                combinaisonLength = PropertiesReader.getParamConfigCombinationLength();
                nbTries = PropertiesReader.getParamConfigNbTries();
            }
            else {
                System.out.println("Une erreur est survenue. Redémarrage du module Duel...");
                return;
            }

        }
        else if (reponseDiff == 2) {
            PropertiesReader.setMediumDuel();
            combinaisonLength = PropertiesReader.getParamConfigCombinationLength();
            nbTries = PropertiesReader.getParamConfigNbTries();
        }
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Duel...");
            return;
        }

        System.out.println("Voulez-vous activer le mode développeur ? 1 - Oui  2 - Non");
        int reponseDev = sc.nextInt();
        if (reponseDev == 1) devMode = true;
        else if (reponseDev == 2) devMode = false;
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Duel...");
            return;
        }

        System.out.println("Paramétrage du système Défenseur...");
        System.out.println("Veuillez rentrer une combinaison de 3, 4 ou 5 chiffes :");

        sc.nextLine();
        String userCombinationDefender = sc.nextLine();


        if (userCombinationDefender.length() == 3) {
            combinaisonLengthDef = 3;
        }
        else if (userCombinationDefender.length() == 4) {
            combinaisonLengthDef = 4;
        }
        else if (userCombinationDefender.length() == 5) {
            combinaisonLengthDef = 5;
        }
        else {
            System.out.println("Une erreur est survenue. Votre combinaison est de " +
                    userCombinationDefender.length()+" chiffre(s). Redémarrage du module Duel...");
            return;
        }

        String combinationChallenger = "";

        //ajout des valeurs dans le string
        int digitCombi1 = random.nextInt(10);
        int digitCombi2 = random.nextInt(10);
        int digitCombi3 = random.nextInt(10);
        int digitCombi4 = random.nextInt(10);
        int digitCombi5 = random.nextInt(10);

        if (combinaisonLength == 3) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 + digitCombi3;
        }
        else if (combinaisonLength == 4) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 +
                    digitCombi3 + digitCombi4;
        }
        else if (combinaisonLength == 5) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 +
                    digitCombi3 + digitCombi4 + digitCombi5;
        }


        //affichage de la solution en mode dev
        if (devMode) {
            System.out.println("La combinaison est la suivante : " + combinationChallenger);
        }

        for (int pI = 0; pI < nbTries; pI++) {
            String resultUserCombinaison = "";
            System.out.println("Veuillez rentrer " + combinaisonLength + " chiffres :" );

            String userCombinaison = sc.nextLine();
            if (userCombinaison.length() != combinaisonLength) {
                System.out.println("Attention ! Vous avez saisi "+userCombinaison.length()+" chiffre(s) "+
                        "au lieu de "+combinaisonLength+".");
                pI--;
                continue;
            }

            for(int indice = 0; indice < combinaisonLength; indice++) {

                if (userCombinaison.charAt(indice) == combinationChallenger.charAt(indice)) {
                    resultUserCombinaison += "=";
                }
                else if (userCombinaison.charAt(indice) < combinationChallenger.charAt(indice)) {
                    resultUserCombinaison += "+";
                }
                else if (userCombinaison.charAt(indice) > combinationChallenger.charAt(indice)) {
                    resultUserCombinaison += "-";
                }
            }
            System.out.println(resultUserCombinaison);

            if (pI == 0) {
                int chiffreCombiDef1 = random.nextInt(10);
                int chiffreCombiDef2 = random.nextInt(10);
                int chiffreCombiDef3 = random.nextInt(10);
                int chiffreCombiDef4 = random.nextInt(10);
                int chiffreCombiDef5 = random.nextInt(10);

                if (combinaisonLengthDef == 3) {
                    combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3;
                }
                else if (combinaisonLengthDef == 4) {
                    combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3 + chiffreCombiDef4;
                }
                else if (combinaisonLengthDef == 5) {
                    combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3 + chiffreCombiDef4 + chiffreCombiDef5;
                }
                System.out.println(combinaisonDefenseur);
            }

            else if (pI > 0) {

                combinationDefenseur2 = "";
                resultatIACombinaison = "";

                for (int indiceDef = 0; indiceDef < combinaisonLengthDef; indiceDef++) {

                    if (pI == 1) {

                        if (userCombinationDefender.charAt(indiceDef) == combinaisonDefenseur.charAt
                                (indiceDef)) {

                            combinationDefenseur2 += combinaisonDefenseur.charAt(indiceDef);
                            resultatIACombinaison += "=";
                        }

                        else if (userCombinationDefender.charAt(indiceDef) > combinaisonDefenseur.charAt
                                (indiceDef)) {

                            int min = Character.getNumericValue(combinaisonDefenseur.charAt(indiceDef));
                            combinationDefenseur2 += Character.forDigit
                                    ((random.nextInt(9-min+1)+min),10);
                            resultatIACombinaison += "+";
                        }

                        else if (userCombinationDefender.charAt(indiceDef) < combinaisonDefenseur.charAt
                                (indiceDef)) {

                            int max = Character.getNumericValue(combinaisonDefenseur.charAt(indiceDef));

                            combinationDefenseur2 += Character.forDigit(random.nextInt(max),10);

                            resultatIACombinaison += "-";

                        }
                    }
                    else if (pI > 1) {
                        if (userCombinationDefender.charAt(indiceDef) == tempValue.charAt
                                (indiceDef)) {

                            combinationDefenseur2 += tempValue.charAt(indiceDef);
                            resultatIACombinaison += "=";

                        }

                        else if (userCombinationDefender.charAt(indiceDef) > tempValue.charAt
                                (indiceDef)) {

                            int min = Character.getNumericValue(tempValue.charAt(indiceDef));

                            combinationDefenseur2 += Character.forDigit
                                    ((random.nextInt(10-min+1)+min),10);

                            resultatIACombinaison += "+";
                        }

                        else if (userCombinationDefender.charAt(indiceDef) < tempValue.charAt
                                (indiceDef)) {

                            int max = Character.getNumericValue(tempValue.charAt(indiceDef));

                            combinationDefenseur2 += Character.forDigit(random.nextInt(max),10);

                            resultatIACombinaison += "-";

                        }
                    }
                }

                tempValue = combinationDefenseur2;
                System.out.println("Proposition de l'IA : " + combinationDefenseur2);

                if (resultUserCombinaison.equals("===") || resultUserCombinaison.equals("====") ||
                        resultUserCombinaison.equals("=====")) {
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
                    }
                    else if (userInputEndGame == 3) {
                        System.exit(0);
                    }
                    else {
                        System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                        Main.challengerLoop = false;
                        Main.menuLoop = true;
                    }
                }
                else if (pI+1 == nbTries) {
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
                    }
                    else if (userInputEndGame == 3) {
                        System.exit(0);
                    }
                    else {
                        System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                        Main.challengerLoop = false;
                        Main.menuLoop = true;
                    }
                }

                if (combinationDefenseur2.equals(userCombinationDefender)) {
                    System.out.println("L'ordinateur a trouvé la solution !\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                    if (infiniteTries) {
                        System.out.println("L'ordinateur a pris "+(pI+1)+" tours pour trouver la combinaison.");
                    }

                    int userInputEndGame = sc.nextInt();

                    if (userInputEndGame == 1) {
                        pI = 1501;
                        Main.defenderLoop = true;
                    }
                    else if (userInputEndGame == 2) {
                        pI = 1501;
                        Main.defenderLoop = false;
                        Main.menuLoop = true;
                    }
                    else if (userInputEndGame == 3) {
                        System.exit(0);
                    }
                    else {
                        System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                        Main.defenderLoop = false;
                        Main.menuLoop = true;
                    }
                }
                else if (pI+1 == nbTries){
                    System.out.println("L'ordinateur n'a pas trouvé la combinaison.\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");

                    int userInputEndGame = sc.nextInt();

                    if (userInputEndGame == 1) {
                        Main.defenderLoop = true;
                    } else if (userInputEndGame == 2) {
                        Main.defenderLoop = false;
                        Main.menuLoop = true;
                    } else if (userInputEndGame == 3) {
                        System.exit(0);
                    } else {
                        System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                        Main.defenderLoop = false;
                        Main.menuLoop = true;
                    }
                }
            }
        }
    }
}
