import java.io.IOException;
import java.util.Scanner;

public class User {
    static Scanner sc = new Scanner(System.in);

    void settingsChallenger() throws IOException {

        System.out.println("Vous avez sélectionné le mode Challenger !");
        System.out.println("Par défaut, la combinaison contient 4 chiffres. " +
                "Voulez-vous modifier la difficulté ?\n 1 - Oui  2 - Non");

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
            PropertiesReader.setMediumChallenger();
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
        else {
            System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
        }

    }


}

