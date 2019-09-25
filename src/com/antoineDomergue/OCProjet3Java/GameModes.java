package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.PropertyResourceBundle;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

/***
 * Mother class of all game modes.
 * Contains variables common to all modes as well as essential methods.
 */
class GameModes {
    Random random = new Random();
    Scanner sc    = new Scanner(System.in);
    /***
     * Corresponds to the length of the combination during the game
     */
    int combinationLength;
    /***
     * Corresponds to the number of trials allowed during the game.
     */
    int nbTries;
    /***
     * Corresponds to the Dev mode, which allows you to see the generated combination.
     */
    boolean devMode;

    /***
     * Retrieves data from the Param.properties file
     */
    void getParamConfig() throws IOException {
        //ResourceBundle resourceBundle = ResourceBundle.getBundle("Param");
        ResourceBundle resourceBundle = new PropertyResourceBundle(Files.newInputStream(Paths.get("Param.properties")));
        devMode = Boolean.parseBoolean(resourceBundle.getString("paramDevMode"));
        combinationLength = Integer.parseInt(resourceBundle.getString("paramCombinationLength"));
        nbTries = Integer.parseInt(resourceBundle.getString("paramNbTries"));
    }

    /***
     * Generate a combination of random numbers.
     * @return generated combination
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
