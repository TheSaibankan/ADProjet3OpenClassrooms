package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class GameModes {

    static int pI;
    static int pIDef;
    static int indiceDef;

    static int combinationLengthDef;
    static String combinationChallenger = "";
    static String combinationDefender = "";
    static String combinationDefender2 = "";
    static String resultatIACombinaison = "";
    static String tempValue = "";

    static void challengerMode() throws IOException {
        Scanner sc = new Scanner(System.in);

        PropertiesReader.setBasicParam();
        PropertiesReader.getParamConfig();

        User.settingsChallenger();

        String combinationChallenger = IA.createCombinationChallenger();

        if (Main.devMode) {
            System.out.println("La combinaison est la suivante : " + combinationChallenger);
        }

        for (pI = 0; pI < Main.nbTries; pI++) {
            StringBuilder resultUserCombinaison = new StringBuilder();
            System.out.println("Veuillez rentrer " + Main.combinationLength + " chiffres :" );

            String userCombination = sc.nextLine();

            if (userCombination.length() != Main.combinationLength) {
                System.out.println("Attention ! Vous avez saisi "+userCombination.length()+" chiffre(s) "+
                        "au lieu de "+Main.combinationLength+".");
                if (pI == 0) continue;
                else pI--;
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
                EndMenu.askEndMenuChallenger();
            }
            else if (pI+1 == Main.nbTries) {
                System.out.println("Perdu ! Vous n'avez pas trouvé la combinaison.\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                EndMenu.askEndMenuChallenger();
            }
        }
    }

    static void defenderMode() throws IOException {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        User.settingsDefender();

        System.out.println("Veuillez rentrer une combinaison de 3, 4 ou 5 chiffes :");

        String userCombinationDefender = sc.nextLine();

        if (userCombinationDefender.length() == 3) combinationLengthDef = 3;
        else if (userCombinationDefender.length() == 4) combinationLengthDef = 4;
        else if (userCombinationDefender.length() == 5) combinationLengthDef = 5;
        else {
            System.out.println("Une erreur est survenue. Votre combinaison est de " +
                    userCombinationDefender.length()+" chiffre(s). Redémarrage du module Défenseur...");
            return;
        }

        combinationDefender2 = IA.createTryDefender(userCombinationDefender);

        if (combinationDefender2.equals(userCombinationDefender)) {
            System.out.println("L'ordinateur a trouvé la solution !\n" +
                    "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
            if (Main.infiniteTries) {
                System.out.println("L'ordinateur a pris "+(pIDef+1)+" tours pour trouver la combinaison.");
            }
            EndMenu.askEndMenuDefender();
        }
        else if (pIDef+1 == Main.nbTries){
            System.out.println("L'ordinateur n'a pas trouvé la combinaison.\n" +
                    "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
            EndMenu.askEndMenuDefender();
        }
    }

    static void duelMode() throws IOException {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int combinaisonLengthDef;
        Main.nbTries = 1500;

        String combinationDefender = "";
        String combinationDefender2 = "";
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
                Main.combinationLength = PropertiesReader.getParamConfigCombinationLength();
                Main.nbTries = PropertiesReader.getParamConfigNbTries();
            }
            else if (choixDiff == 2) {
                System.out.println("Vous avez choisi le mode normal. (4 chiffres)");
                PropertiesReader.setMediumDuel();
                Main.combinationLength = PropertiesReader.getParamConfigCombinationLength();
                Main.nbTries = PropertiesReader.getParamConfigNbTries();
            }
            else if (choixDiff == 3) {
                System.out.println("Vous avez choisi le mode difficile. (5 chiffres)");
                PropertiesReader.setHardDuel();
                Main.combinationLength = PropertiesReader.getParamConfigCombinationLength();
                Main.nbTries = PropertiesReader.getParamConfigNbTries();
            }
            else {
                System.out.println("Une erreur est survenue. Redémarrage du module Duel...");
                return;
            }

        }
        else if (reponseDiff == 2) {
            PropertiesReader.setMediumDuel();
            Main.combinationLength = PropertiesReader.getParamConfigCombinationLength();
            Main.nbTries = PropertiesReader.getParamConfigNbTries();
        }
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Duel...");
            return;
        }

        System.out.println("Voulez-vous activer le mode développeur ? 1 - Oui  2 - Non");
        int answerDev = sc.nextInt();
        if (answerDev == 1) Main.devMode = true;
        else if (answerDev == 2) Main.devMode = false;
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

        if (Main.combinationLength == 3) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 + digitCombi3;
        }
        else if (Main.combinationLength == 4) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 +
                    digitCombi3 + digitCombi4;
        }
        else if (Main.combinationLength == 5) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 +
                    digitCombi3 + digitCombi4 + digitCombi5;
        }


        //affichage de la solution en mode dev
        if (Main.devMode) {
            System.out.println("La combinaison est la suivante : " + combinationChallenger);
        }

        for (pI = 0; pI < Main.nbTries; pI++) {
            String resultUserCombinaison = "";
            System.out.println("Veuillez rentrer " + Main.combinationLength + " chiffres :" );

            String userCombination = sc.nextLine();
            if (userCombination.length() != Main.combinationLength) {
                System.out.println("Attention ! Vous avez saisi "+userCombination.length()+" chiffre(s) "+
                        "au lieu de "+Main.combinationLength+".");
                pI--;
                continue;
            }

            for(int indice = 0; indice < Main.combinationLength; indice++) {

                if (userCombination.charAt(indice) == combinationChallenger.charAt(indice)) {
                    resultUserCombinaison += "=";
                }
                else if (userCombination.charAt(indice) < combinationChallenger.charAt(indice)) {
                    resultUserCombinaison += "+";
                }
                else if (userCombination.charAt(indice) > combinationChallenger.charAt(indice)) {
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
                    combinationDefender = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3;
                }
                else if (combinaisonLengthDef == 4) {
                    combinationDefender = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3 + chiffreCombiDef4;
                }
                else if (combinaisonLengthDef == 5) {
                    combinationDefender = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                            chiffreCombiDef3 + chiffreCombiDef4 + chiffreCombiDef5;
                }
                System.out.println(combinationDefender);
            }

            else if (pI > 0) {

                combinationDefender2 = "";
                resultatIACombinaison = "";

                for (int indiceDef = 0; indiceDef < combinaisonLengthDef; indiceDef++) {

                    if (pI == 1) {

                        if (userCombinationDefender.charAt(indiceDef) == combinationDefender.charAt
                                (indiceDef)) {

                            combinationDefender2 += combinationDefender.charAt(indiceDef);
                            resultatIACombinaison += "=";
                        }

                        else if (userCombinationDefender.charAt(indiceDef) > combinationDefender.charAt
                                (indiceDef)) {

                            int min = Character.getNumericValue(combinationDefender.charAt(indiceDef));
                            combinationDefender2 += Character.forDigit
                                    ((random.nextInt(9-min+1)+min),10);
                            resultatIACombinaison += "+";
                        }

                        else if (userCombinationDefender.charAt(indiceDef) < combinationDefender.charAt
                                (indiceDef)) {

                            int max = Character.getNumericValue(combinationDefender.charAt(indiceDef));

                            combinationDefender2 += Character.forDigit(random.nextInt(max),10);

                            resultatIACombinaison += "-";

                        }
                    }
                    else if (pI > 1) {
                        if (userCombinationDefender.charAt(indiceDef) == tempValue.charAt
                                (indiceDef)) {

                            combinationDefender2 += tempValue.charAt(indiceDef);
                            resultatIACombinaison += "=";

                        }

                        else if (userCombinationDefender.charAt(indiceDef) > tempValue.charAt
                                (indiceDef)) {

                            int min = Character.getNumericValue(tempValue.charAt(indiceDef));

                            combinationDefender2 += Character.forDigit
                                    ((random.nextInt(10-min+1)+min),10);

                            resultatIACombinaison += "+";
                        }

                        else if (userCombinationDefender.charAt(indiceDef) < tempValue.charAt
                                (indiceDef)) {

                            int max = Character.getNumericValue(tempValue.charAt(indiceDef));

                            combinationDefender2 += Character.forDigit(random.nextInt(max),10);

                            resultatIACombinaison += "-";

                        }
                    }
                }

                tempValue = combinationDefender2;
                System.out.println("Proposition de l'IA : " + combinationDefender2);

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

                if (combinationDefender2.equals(userCombinationDefender)) {
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
                else if (pI+1 == Main.nbTries){
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
