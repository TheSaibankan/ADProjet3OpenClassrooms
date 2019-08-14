package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;
import java.util.Scanner;

class User {
    static Scanner sc = new Scanner(System.in);

    static void settingsChallenger() throws IOException {

        System.out.println("Vous avez sélectionné le mode Challenger !");
        System.out.println("Voulez-vous choisir un mode de difficulté ?\n 1 - Oui  2 - Non"
        +"\nNote : Choisissez 'non' pour utiliser le fichier de configuration. Les modes de difficultés ne modifient " +
                "pas les données du fichier.");

        int answerDiff = sc.nextInt();

        if (answerDiff == 1) {
            System.out.println("Choisissez la difficulté : 1 - Facile  2 - Normal  " +
                    "3 - Difficile");

            int choixDiff = sc.nextInt();

            if (choixDiff == 1){
                System.out.println("Vous avez choisi le mode facile. (3 chiffres, 10 essaies)");
                Main.combinationLength = 3;
                Main.nbTries = 10;
            }
            else if (choixDiff == 2) {
                System.out.println("Vous avez choisi le mode normal. (4 chiffres, 7 essaies)");
                Main.combinationLength = 4;
                Main.nbTries = 7;
            }
            else if (choixDiff == 3) {
                System.out.println("Vous avez choisi le mode difficile. (5 chiffres, 5 essaies)");
                Main.combinationLength = 5;
                Main.nbTries = 5;
            }
            else {
                System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
                return;
            }
        }

        else if (answerDiff == 2) {
            PropertiesReader.getParamConfig();
            System.out.println("Voici les paramètres sauvegardés :" + "\nNombre d'essaie(s) : " + Main.nbTries +
                    "\nLongueur de la combinaison : " + Main.combinationLength + "\nMode Dev : " + Main.devMode);
        }
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
        }
    }
}
