package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;
import java.util.Scanner;

class User {
    static Scanner sc = new Scanner(System.in);

    static void settingsChallenger() throws IOException {

        System.out.println("Vous avez sélectionné le mode Challenger !");
        System.out.println("Voulez-vous choisir un mode de difficulté ?\n 1 - Oui  2 - Non"
        +"\nNote : Choisissez 'non' pour ne pas réécrire le fichier de configuration.");

        int answerDiff = sc.nextInt();

        if (answerDiff == 1) {
            System.out.println("Choisissez la difficulté : 1 - Facile  2 - Normal  " +
                    "3 - Difficile");

            int choixDiff = sc.nextInt();

            if (choixDiff == 1){
                System.out.println("Vous avez choisi le mode facile. (3 chiffres, 10 essaies)");
                PropertiesReader.setEasyChallenger();
                Main.combinationLength = PropertiesReader.getParamConfigCombinationLength();
                Main.nbTries = PropertiesReader.getParamConfigNbTries();
            }
            else if (choixDiff == 2) {
                System.out.println("Vous avez choisi le mode normal. (4 chiffres, 7 essaies)");
                PropertiesReader.setMediumChallenger();
                Main.combinationLength = PropertiesReader.getParamConfigCombinationLength();
                Main.nbTries = PropertiesReader.getParamConfigNbTries();
            }
            else if (choixDiff == 3) {
                System.out.println("Vous avez choisi le mode difficile. (5 chiffres, 5 essaies)");
                PropertiesReader.setHardChallenger();
                Main.combinationLength = PropertiesReader.getParamConfigCombinationLength();
                Main.nbTries = PropertiesReader.getParamConfigNbTries();
            }
            else {
                System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
                return;
            }
        }

        else if (answerDiff == 2) {
            Main.combinationLength = PropertiesReader.getParamConfigCombinationLength();
            Main.nbTries = PropertiesReader.getParamConfigNbTries();
        }
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
            return;
        }

        System.out.println("Voulez-vous activer le mode développeur ? 1 - Oui  2 - Non");
        int answerDev = sc.nextInt();
        if (answerDev == 1) {
            PropertiesReader.setDevModeChallenger();
            Main.devMode = PropertiesReader.getParamConfigDevMode();
        }
        else if (answerDev == 2) Main.devMode = false;
        else System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
    }

    static void settingsDefender() throws IOException {
        System.out.println("Vous avez sélectionné le mode Défenseur !");

        System.out.println("Voulez-vous activer le mode Essaies illimités ? 1 - Oui  2 - Non");
        int repEssaiesInfinie = sc.nextInt();

        if (repEssaiesInfinie == 1) {
            PropertiesReader.setInfiniteTriesDefender();
            Main.nbTries = PropertiesReader.getParamConfigNbTries();
            Main.infiniteTries = PropertiesReader.getParamInfiniteTries();
        }

        else if (repEssaiesInfinie == 2) {
            PropertiesReader.setInfiniteTriesDefenderFalse();
            Main.nbTries = PropertiesReader.getParamConfigNbTries();
            Main.infiniteTries = PropertiesReader.getParamInfiniteTries();
        }
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Défenseur...");
        }
    }
}

