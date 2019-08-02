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
    static String userCombination = "";

    static void challengerMode() throws IOException {
        Scanner sc = new Scanner(System.in);

        PropertiesReader.getParamConfig();
        User.settingsChallenger();

        GameModes.combinationChallenger = "";
        GameModes.combinationChallenger = IA.createCombinationChallenger();

        if (Main.devMode) {
            System.out.println("La combinaison est la suivante : " + GameModes.combinationChallenger);
        }

        for (pI = 0; pI < Main.nbTries; pI++) {
            StringBuilder resultUserCombinaison = new StringBuilder();
            System.out.println("Veuillez rentrer " + Main.combinationLength + " chiffres :" );

            userCombination = sc.nextLine();

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

            if (userCombination.equals(combinationChallenger)) {
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

        System.out.println("Veuillez rentrer une combinaison de x chiffres :");

        String userCombinationDefender = sc.nextLine();
        Main.combinationLength = userCombinationDefender.length();

        combinationDefender2 = IA.createTryDefender(userCombinationDefender);

        if (combinationDefender2.equals(userCombinationDefender)) {
            System.out.println(combinationDefender2);
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

        System.out.println("Paramétrage du système Challenger...");
        User.settingsChallenger();

        System.out.println("Paramétrage du système Défenseur...");
        System.out.println("Veuillez rentrer une combinaison de x chiffres :");
        String userCombinationDefender = sc.nextLine();

        GameModes.combinationChallenger = "";
        GameModes.combinationChallenger = IA.createCombinationChallenger();

        if (Main.devMode) {
            System.out.println("La combinaison est la suivante : " + GameModes.combinationChallenger);
        }

        for (pI = 0; pI < Main.nbTries; pI++) {
            StringBuilder resultUserCombinaison = new StringBuilder();
            System.out.println("Veuillez rentrer " + Main.combinationLength + " chiffres :" );

            GameModes.userCombination = sc.nextLine();
            if (GameModes.userCombination.length() != Main.combinationLength) {
                System.out.println("Attention ! Vous avez saisi "+GameModes.userCombination.length()+" chiffre(s) "+
                        "au lieu de "+Main.combinationLength+".");
                pI--;
                continue;
            }
            else if (GameModes.userCombination.equals(GameModes.combinationChallenger)) {
                System.out.println("Félicitation ! Vous avez trouvé la combinaison !\n" +
                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                EndMenu.askEndMenuDuel();
            }
            else {
                for(int indice = 0; indice < Main.combinationLength; indice++) {
                    if (GameModes.userCombination.charAt(indice) == combinationChallenger.charAt(indice)) {
                        resultUserCombinaison.append("=");
                    }
                    else if (GameModes.userCombination.charAt(indice) < combinationChallenger.charAt(indice)) {
                        resultUserCombinaison.append("+");
                    }
                    else if (GameModes.userCombination.charAt(indice) > combinationChallenger.charAt(indice)) {
                        resultUserCombinaison.append("-");
                    }
                }
                System.out.println(resultUserCombinaison);
                combinationDefender2 = IA.createTryDefender(userCombinationDefender);

                if (combinationDefender2.equals(userCombinationDefender)) {
                    System.out.println("Perdu ! L'IA a trouvé la combinaison avant vous !\n" +
                            "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
                    EndMenu.askEndMenuDuel();
                }

            }

        }


    }
}