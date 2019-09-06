package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GameModes {
    private Random random = new Random();
    private Scanner sc    = new Scanner(System.in);

    private int       combinationLength;
    private int       nbTries;
    private boolean   devMode;

    void getParamConfig() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Param");
        //ResourceBundle resourceBundle = new PropertyResourceBundle(Files.newInputStream(Paths.get("Param.properties")));
        devMode = Boolean.parseBoolean(resourceBundle.getString("paramDevMode"));
        combinationLength = Integer.parseInt(resourceBundle.getString("paramCombinationLength"));
        nbTries = Integer.parseInt(resourceBundle.getString("paramNbTries"));
    }

    String createCombinationChallenger() {
        StringBuilder combinationChallenger = new StringBuilder();

        for(int iCombination = 1; iCombination <= combinationLength; iCombination++) {
            int digitCombinationI = random.nextInt(10);
            combinationChallenger.append(digitCombinationI);
        }
        return combinationChallenger.toString();
    }

    void settingsChallenger() throws IOException {
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
                        nbTries = 1500;
                    } else {
                        System.out.println("Vous avez choisi le mode facile. (3 chiffres, 10 essaies)");
                        nbTries = 10;
                    }
                    combinationLength = 3;
                    settingsLoop = false;
                }
                else if (choixDiff == 2) {
                    if (Main.duelLoop) {
                        System.out.println("Vous avez choisi le mode normal. (4 chiffres)");
                        nbTries = 1500;
                    } else {
                        System.out.println("Vous avez choisi le mode normal. (4 chiffres, 7 essaies)");
                        nbTries = 7;
                    }
                    combinationLength = 4;
                    settingsLoop = false;
                }
                else if (choixDiff == 3) {
                    if (Main.duelLoop) {
                        System.out.println("Vous avez choisi le mode difficile. (5 chiffres)");
                        nbTries = 1500;
                    } else {
                        System.out.println("Vous avez choisi le mode difficile. (5 chiffres, 5 essaies)");
                        nbTries = 5;
                    }
                    combinationLength = 5;
                    settingsLoop = false;
                }
                else {
                    System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
                    Logger.errorUserInput();
                }
            }
            else if (answerDiff == 2) {
                getParamConfig();
                if (Main.duelLoop) {
                    System.out.println("Voici les paramètres sauvegardés :" + "\nNombre d'essaie(s) : " + nbTries +
                            "\nLongueur de la combinaison : " + combinationLength + "\nMode Dev : " + devMode);
                    System.out.println("Mode Duel détecté, nombre d'essaies automatiquement monté à 1500.");
                    nbTries = 1500;
                    settingsLoop = false;
                } else {
                    System.out.println("Voici les paramètres sauvegardés :" + "\nNombre d'essaie(s) : " + nbTries +
                            "\nLongueur de la combinaison : " + combinationLength + "\nMode Dev : " + devMode);
                    settingsLoop = false;
                }
            }
            else {
                System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
                Logger.errorUserInput();
            }
        }
    }

    void askEndMenuChallenger() {

        int userInputEndGame = sc.nextInt();

        if (userInputEndGame == 1) {
            Main.challengerLoop = true;
        }
        else if (userInputEndGame == 2) {
            Main.challengerLoop = false;
        }
        else if (userInputEndGame == 3) {
            Main.challengerLoop = false;
            Main.menuLoop = false;
        }
        else {
            System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
            Logger.errorUserInput();
            Main.challengerLoop = false;
            Main.menuLoop = true;
        }
    }
    void askEndMenuDefender() {
        int userInputEndGame = sc.nextInt();

        if (userInputEndGame == 1) {
            Main.defenderLoop = true;
        }
        else if (userInputEndGame == 2) {
            Main.defenderLoop = false;
            Main.defenderLoop = true;
        }
        else if (userInputEndGame == 3) {
            Main.defenderLoop = false;
            Main.menuLoop = false;
        }
        else {
            System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
            Logger.errorUserInput();
            Main.defenderLoop = false;
            Main.menuLoop = true;
        }
    }
    void askEndMenuDuel() {
        int userInputEndGame = sc.nextInt();

        if (userInputEndGame == 1) {
            Main.duelLoop = true;
        }
        else if (userInputEndGame == 2) {
            Main.duelLoop = false;
            Main.menuLoop = true;
        }
        else if (userInputEndGame == 3) {
            Main.duelLoop = false;
            Main.menuLoop = false;
        }
        else {
            System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
            Logger.errorUserInput();
            Main.duelLoop = false;
            Main.menuLoop = true;
        }
    }

    //GETTER AND SETTER

    int getCombinationLength() {
        return combinationLength;
    }
    public void setCombinationLength(int combinationLength) {
        this.combinationLength = combinationLength;
    }

    int getNbTries() {
        return nbTries;
    }
    public void setNbTries(int nbTries) {
        this.nbTries = nbTries;
    }

    boolean isDevMode() {
        return devMode;
    }
    public void setDevMode(boolean devMode) {
        this.devMode = devMode;
    }

}