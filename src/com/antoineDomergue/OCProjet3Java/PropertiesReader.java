package com.antoineDomergue.OCProjet3Java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

class PropertiesReader {

    static void getParamConfig() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Param");
        boolean devMode = Boolean.parseBoolean(resourceBundle.getString("paramDevMode"));
        int combinationLength = Integer.parseInt(resourceBundle.getString("paramCombinationLength"));
        int nbTries = Integer.parseInt(resourceBundle.getString("paramNbTries"));
        Main.devMode = devMode;
        Main.combinationLength = combinationLength;
        Main.nbTries = nbTries;
    }

    static int getParamConfigNbTries() throws IOException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Param");
        Main.nbTries = Integer.parseInt(resourceBundle.getString("paramNbTries"));
        return Main.nbTries;
    }

    static int getParamConfigCombinationLength() throws IOException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Param");
        Main.combinationLength = Integer.parseInt(resourceBundle.getString("paramCombinationLength"));
        return Main.combinationLength;
    }

    static boolean getParamConfigDevMode() throws IOException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Param");
        Main.devMode = Boolean.parseBoolean(resourceBundle.getString("paramDevMode"));
        return Main.devMode;
    }


    /*static void setBasicParam() throws  IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "7");
        properties.setProperty("paramCombinationLength", "4");
        properties.setProperty("paramDevMode", "false");
        properties.setProperty("paramInfiniteTries", "false");
        properties.store(outputStream, null);
    }*/

    static void setEasyChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "10");
        properties.setProperty("paramCombinationLength", "3");
        properties.setProperty("paramDevMode", String.valueOf(Main.devMode));
        properties.store(outputStream, null);
    }
    static void setEasyDuel() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "1500");
        properties.setProperty("paramCombinationLength", "3");
        properties.setProperty("paramDevMode", String.valueOf(Main.devMode));
        properties.store(outputStream, null);
    }
    static void setMediumChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "7");
        properties.setProperty("paramCombinationLength", "4");
        properties.setProperty("paramDevMode", String.valueOf(Main.devMode));
        properties.store(outputStream, null);
    }
    static void setMediumDuel() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "1500");
        properties.setProperty("paramCombinationLength", "4");
        properties.setProperty("paramDevMode", String.valueOf(Main.devMode));
        properties.store(outputStream, null);
    }
    static void setHardChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "5");
        properties.setProperty("paramCombinationLength", "5");
        properties.setProperty("paramDevMode", String.valueOf(Main.devMode));
        properties.store(outputStream, null);
    }
    static void setHardDuel() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "1500");
        properties.setProperty("paramCombinationLength", "5");
        properties.setProperty("paramDevMode", String.valueOf(Main.devMode));
        properties.store(outputStream, null);
    }
    static void setDevModeChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", String.valueOf(Main.nbTries));
        properties.setProperty("paramCombinationLength", String.valueOf(Main.combinationLength));
        properties.setProperty("paramDevMode", "true");
        properties.store(outputStream, null);
    }
}