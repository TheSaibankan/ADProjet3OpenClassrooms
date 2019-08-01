package com.antoineDomergue.OCProjet3Java;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class PropertiesReader {


    /*private ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
    private boolean developer = Boolean.parseBoolean(resourceBundle.getString("devMode"));
    private int combinationSize = Integer.parseInt(resourceBundle.getString("plusOrMinus.combinationSize"));
    private int maxAttempts = Integer.parseInt(resourceBundle.getString("plusOrMinus.maxAttempts"));*/


    static void getParamConfig() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        String paramNbTries = properties.getProperty("paramNbTries");
        String paramCombinationLength = properties.getProperty("paramCombinationLength");
        String paramDevMode = properties.getProperty("paramDevMode");

        Main.nbTries = Integer.parseInt(paramNbTries);
        Main.combinationLength = Integer.parseInt(paramCombinationLength);
        Main.devMode = Boolean.parseBoolean(paramDevMode);
    }

    static int getParamConfigNbTries() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        return Integer.parseInt(properties.getProperty("paramNbTries"));
    }

    static int getParamConfigCombinationLength() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        return Integer.parseInt(properties.getProperty("paramCombinationLength"));
    }

    static boolean getParamConfigDevMode() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        return Boolean.parseBoolean(properties.getProperty("paramDevMode"));
    }

    static  boolean getParamInfiniteTries() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        return Boolean.parseBoolean(properties.getProperty("paramInfiniteTries"));
    }

    static void setBasicParam() throws  IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "7");
        properties.setProperty("paramCombinationLength", "4");
        properties.setProperty("paramDevMode", "false");
        properties.setProperty("paramInfiniteTries", "false");
        properties.store(outputStream, null);
    }

    static void setEasyChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "10");
        properties.setProperty("paramCombinationLength", "3");
        properties.setProperty("paramDevMode", String.valueOf(Main.devMode));
        properties.setProperty("paramInfiniteTries", "false");
        properties.store(outputStream, null);
    }
    static void setEasyDuel() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "1500");
        properties.setProperty("paramCombinationLength", "3");
        properties.setProperty("paramDevMode", String.valueOf(Main.devMode));
        properties.setProperty("paramInfiniteTries", "false");
        properties.store(outputStream, null);
    }
    static void setMediumChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "7");
        properties.setProperty("paramCombinationLength", "4");
        properties.setProperty("paramDevMode", String.valueOf(Main.devMode));
        properties.setProperty("paramInfiniteTries", "false");
        properties.store(outputStream, null);
    }
    static void setMediumDuel() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "1500");
        properties.setProperty("paramCombinationLength", "4");
        properties.setProperty("paramDevMode", String.valueOf(Main.devMode));
        properties.setProperty("paramInfiniteTries", "false");
        properties.store(outputStream, null);
    }
    static void setHardChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "5");
        properties.setProperty("paramCombinationLength", "5");
        properties.setProperty("paramDevMode", String.valueOf(Main.devMode));
        properties.setProperty("paramInfiniteTries", "false");
        properties.store(outputStream, null);
    }
    static void setHardDuel() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "1500");
        properties.setProperty("paramCombinationLength", "5");
        properties.setProperty("paramDevMode", String.valueOf(Main.devMode));
        properties.setProperty("paramInfiniteTries", "false");
        properties.store(outputStream, null);
    }
    static void setDevModeChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", String.valueOf(Main.nbTries));
        properties.setProperty("paramCombinationLength", String.valueOf(Main.combinationLength));
        properties.setProperty("paramDevMode", "true");
        properties.setProperty("paramInfiniteTries", "false");
        properties.store(outputStream, null);
    }
    static void setInfiniteTriesDefender() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "1500");
        properties.setProperty("paramCombinationLength", String.valueOf(Main.combinationLength));
        properties.setProperty("paramDevMode", "false");
        properties.setProperty("paramInfiniteTries", "true");
        properties.store(outputStream, null);
    }
    static void setInfiniteTriesDefenderFalse() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "10");
        properties.setProperty("paramCombinationLength", String.valueOf(Main.combinationLength));
        properties.setProperty("paramDevMode", "false");
        properties.setProperty("paramInfiniteTries", "false");
        properties.store(outputStream, null);
    }
}