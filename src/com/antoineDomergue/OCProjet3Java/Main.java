package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;
import java.util.Scanner;

import static com.antoineDomergue.OCProjet3Java.Logger.*;

public class Main {
    static boolean challengerLoop   = false;
    static boolean defenderLoop     = false;
    static boolean duelLoop         = false;
    static boolean menuLoop         = true;

    static int combinationLength;
    static int nbTries;
    static boolean devMode;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenue dans le module de recherche d'une combinaison à X chiffres.");
        info("Lancement de l'application.");

        while (menuLoop) {

            System.out.println("Veuillez sélectionner un mode de jeu :\n1 - Challenger  2 - Défenseur  3 - Duel");

            int answerMode = sc.nextInt();

            if (answerMode == 1) challengerLoop = true;
            else if (answerMode == 2) defenderLoop = true;
            else if (answerMode == 3) duelLoop = true;

            while (challengerLoop) GameModes.challengerMode();
            while (defenderLoop) GameModes.defenderMode();
            while (duelLoop) GameModes.duelMode();
        }
    }
}