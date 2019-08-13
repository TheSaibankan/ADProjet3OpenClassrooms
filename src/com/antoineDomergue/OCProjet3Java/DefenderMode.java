package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class DefenderMode {
    static void defenderModeLaunch() throws IOException {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Vous avez sélectionné le mode Défenseur !");

        System.out.println("Veuillez rentrer une combinaison de x chiffres :");

        String userCombinationDefender = sc.nextLine();
        Main.combinationLength = userCombinationDefender.length();
        PropertiesReader.getParamConfigNbTries();

        GameModes.combinationDefender2 = IA.createTryDefender(userCombinationDefender);
    }
}
