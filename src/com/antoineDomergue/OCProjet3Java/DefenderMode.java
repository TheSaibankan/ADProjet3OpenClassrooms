package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;
import java.util.Scanner;

class DefenderMode {
    static void defenderModeLaunch() throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez rentrer une combinaison de x chiffres :");
        String userCombinationDefender = sc.nextLine();
        Main.combinationLength = userCombinationDefender.length();

        PropertiesReader.getParamConfigNbTries();

        GameModes.combinationDefender2 = IA.createTryDefender(userCombinationDefender);
    }
}
