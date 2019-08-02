package com.antoineDomergue.OCProjet3Java;

import static com.antoineDomergue.OCProjet3Java.GameModes.pI;
import static com.antoineDomergue.OCProjet3Java.GameModes.pIDef;
import static com.antoineDomergue.OCProjet3Java.User.sc;

class EndMenu {

    static void askEndMenuChallenger() {

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
    static void askEndMenuDefender() {
        int userInputEndGame = sc.nextInt();

        if (userInputEndGame == 1) {
            GameModes.pIDef = 1501;
            Main.defenderLoop = true;
        }
        else if (userInputEndGame == 2) {
            GameModes.pIDef = 1501;
            Main.defenderLoop = false;
            Main.menuLoop = true;
        }
        else if (userInputEndGame == 3) System.exit(0);
        else {
            System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
            Main.defenderLoop = false;
            Main.menuLoop = true;
        }
    }
    static void askEndMenuDuel() {
        int userInputEndGame = sc.nextInt();

        if (userInputEndGame == 1) {
            GameModes.pIDef = 1501;
            Main.duelLoop = true;
        }
        else if (userInputEndGame == 2) {
            GameModes.pIDef = 1501;
            pI = pIDef + 1;
            Main.duelLoop = false;
            Main.menuLoop = true;
        }
        else if (userInputEndGame == 3) System.exit(0);
        else {
            System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
            Main.duelLoop = false;
            Main.menuLoop = true;
        }
    }
}

