package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;
import java.util.Scanner;

class User {
    static Scanner sc = new Scanner(System.in);

    static void settingsChallenger() throws IOException {
        boolean settingsLoop = true;

        while (settingsLoop) {
            if (Main.challengerLoop) {System.out.println("Vous avez sélectionné le mode Challenger !");}
            System.out.println("Voulez-vous choisir un mode de difficulté ?\n 1 - Oui  2 - Non"
                    +"\nNote : Choisissez 'non' pour utiliser le fichier de configuration. Les modes de difficultés ne modifient " +
                    "pas les données du fichier.");

            int answerDiff = sc.nextInt();

            if (answerDiff == 1) {
                System.out.println("Choisissez la difficulté : 1 - Facile  2 - Normal  " +
                        "3 - Difficile");
                int choixDiff = sc.nextInt();

                if (choixDiff == 1) {
                    if (Main.duelLoop) {
                        System.out.println("Vous avez choisi le mode facile. (3 chiffres)");
                        Main.nbTries = 1500;
                    } else {
                        System.out.println("Vous avez choisi le mode facile. (3 chiffres, 10 essaies)");
                        Main.nbTries = 10;
                    }
                    Main.combinationLength = 3;
                    settingsLoop = false;
                }
                else if (choixDiff == 2) {
                    if (Main.duelLoop) {
                        System.out.println("Vous avez choisi le mode normal. (4 chiffres)");
                        Main.nbTries = 1500;
                    } else {
                        System.out.println("Vous avez choisi le mode normal. (4 chiffres, 7 essaies)");
                        Main.nbTries = 7;
                    }
                    Main.combinationLength = 4;
                    settingsLoop = false;
                }
                else if (choixDiff == 3) {
                    if (Main.duelLoop) {
                        System.out.println("Vous avez choisi le mode difficile. (5 chiffres)");
                        Main.nbTries = 1500;
                    } else {
                        System.out.println("Vous avez choisi le mode difficile. (5 chiffres, 5 essaies)");
                        Main.nbTries = 5;
                    }
                    Main.combinationLength = 5;
                    settingsLoop = false;
                }
                else {
                    System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
                    Logger.errorUserInput();
                }
            }

            else if (answerDiff == 2) {
                PropertiesReader.getParamConfig();
                if (Main.duelLoop) {
                    System.out.println("Voici les paramètres sauvegardés :" + "\nNombre d'essaie(s) : " + Main.nbTries +
                            "\nLongueur de la combinaison : " + Main.combinationLength + "\nMode Dev : " + Main.devMode);
                    System.out.println("Mode Duel détecté, nombre d'essaies automatiquement monté à 1500.");
                    Main.nbTries = 1500;
                    settingsLoop = false;
                } else {
                    System.out.println("Voici les paramètres sauvegardés :" + "\nNombre d'essaie(s) : " + Main.nbTries +
                            "\nLongueur de la combinaison : " + Main.combinationLength + "\nMode Dev : " + Main.devMode);
                    settingsLoop = false;
                }
            }
            else {
                System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
                Logger.errorUserInput();
            }
        }
    }
}

