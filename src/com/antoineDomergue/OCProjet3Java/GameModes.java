package com.antoineDomergue.OCProjet3Java;

import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

/***
 * Classe mère des différents modes de jeu.
 * Contient les variables communes à tous les modes ainsi que des méthodes indispensables.
 */
class GameModes {
    Random random = new Random();
    Scanner sc    = new Scanner(System.in);
    /***
     * Correspond à la longueur de la combinaison pendant le jeu.
     */
    int combinationLength;
    /***
     * Correspond au nombre d'essaies autorisés pendant le jeu.
     */
    int nbTries;
    /***
     * Correspond au mode Dev, qui permet de voir la combinaison générée.
     */
    boolean devMode;

    /***
     * Permet de récupérer les données du fichier Param.properties
     */
    void getParamConfig() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Param");
        //ResourceBundle resourceBundle = new PropertyResourceBundle(Files.newInputStream(Paths.get("Param.properties")));
        devMode = Boolean.parseBoolean(resourceBundle.getString("paramDevMode"));
        combinationLength = Integer.parseInt(resourceBundle.getString("paramCombinationLength"));
        nbTries = Integer.parseInt(resourceBundle.getString("paramNbTries"));
    }

    /***
     * Génère une combinaison de chiffres aléatoire.
     * @return La combinaison générée
     */
    String createCombinationChallenger() {
        StringBuilder combinationChallenger = new StringBuilder();

        for(int iCombination = 1; iCombination <= combinationLength; iCombination++) {
            int digitCombinationI = random.nextInt(10);
            combinationChallenger.append(digitCombinationI);
        }
        return combinationChallenger.toString();
    }
}
