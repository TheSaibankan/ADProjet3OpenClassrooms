package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static boolean challengerLoop   = false;
    static boolean defenderLoop     = false;
    static boolean duelLoop         = false;
    static boolean menuLoop         = true;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenue dans le module de recherche d'une combinaison à X chiffres.");

        while (menuLoop) {

            System.out.println("Veuillez sélectionner un mode de jeu :\n1 - Challenger  2 - Défenseur  3 - Duel");

            int answerMode = sc.nextInt();

            if (answerMode == 1) challengerLoop = true;
            else if (answerMode == 2) defenderLoop = true;
            else if (answerMode == 3) duelLoop = true;
            else {
                Logger.errorUserInput();
                continue;
            }

            while (challengerLoop) {
                ChallengerMode challengerMode = new ChallengerMode();
                challengerMode.getParamConfig();
                challengerMode.challengerModeLaunch (
                        challengerMode.getCombinationLength(),
                        challengerMode.getNbTries(),
                        challengerMode.isDevMode() );

            }
            while (defenderLoop) {
                DefenderMode defenderMode = new DefenderMode();
                defenderMode.getParamConfig();
                defenderMode.defenderModeLaunch (
                        defenderMode.getCombinationLength(),
                        defenderMode.getNbTries(),
                        defenderMode.isDevMode() );
            }

            while (duelLoop) {
                DuelMode duelMode = new DuelMode();
                duelMode.getParamConfig();
                duelMode.duelModeLaunch(
                        duelMode.getCombinationLength(),
                        duelMode.getNbTries(),
                        duelMode.isDevMode()
                );
            }
        }
    }
}
