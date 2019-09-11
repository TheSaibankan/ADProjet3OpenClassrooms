package com.antoineDomergue.OCProjet3Java;

import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

class GameModes {
    private Random random = new Random();
    private Scanner sc    = new Scanner(System.in);
    int combinationLength;
    int nbTries;
    boolean devMode;

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
}
