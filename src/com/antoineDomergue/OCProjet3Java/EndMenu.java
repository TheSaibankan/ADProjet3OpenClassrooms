package com.antoineDomergue.OCProjet3Java;

import static com.antoineDomergue.OCProjet3Java.User.sc;

class EndMenu {

    static void askEndMenuChallenger() {

        int userInputEndGame = sc.nextInt();

        if (userInputEndGame == 1) {
            GameModes.pI = Main.nbTries + 1;
            Main.challengerLoop = true;
        }
        else if (userInputEndGame == 2) {
            GameModes.pI = Main.nbTries + 1;
            Main.challengerLoop = false;
            Main.menuLoop = true;
        }
        else if (userInputEndGame == 3) {
            System.exit(0);
        }
        else {
            System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
            Logger.errorUserInput();
            Main.challengerLoop = false;
            Main.menuLoop = true;
        }
    }
    static void askEndMenuDefender() {
        int userInputEndGame = sc.nextInt();

        if (userInputEndGame == 1) {
            GameModes.pIDef = Main.nbTries + 1;
            Main.defenderLoop = true;
        }
        else if (userInputEndGame == 2) {
            GameModes.pIDef = Main.nbTries + 1;
            Main.defenderLoop = false;
            Main.menuLoop = true;
        }
        else if (userInputEndGame == 3) System.exit(0);
        else {
            System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
            Logger.errorUserInput();
            Main.defenderLoop = false;
            Main.menuLoop = true;
        }
    }
    static void askEndMenuDuel() {
        int userInputEndGame = sc.nextInt();

        if (userInputEndGame == 1) {
            GameModes.pIDef = Main.nbTries + 1;
            Main.duelLoop = true;
        }
        else if (userInputEndGame == 2) {
            GameModes.pIDef = Main.nbTries + 1;
            GameModes.pI = GameModes.pIDef + 1;
            Main.duelLoop = false;
            Main.menuLoop = true;
        }
        else if (userInputEndGame == 3) System.exit(0);
        else {
            System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
            Logger.errorUserInput();
            Main.duelLoop = false;
            Main.menuLoop = true;
        }
    }
}

