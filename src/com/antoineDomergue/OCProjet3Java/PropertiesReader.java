package com.antoineDomergue.OCProjet3Java;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class PropertiesReader {
    static void getParamConfig() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        String paramNbTries = properties.getProperty("paramNbTries");
        String paramCombinaisonLength = properties.getProperty("paramCombinaisonLength");
        String paramDevMode = properties.getProperty("paramModeDev");

        Main.nbTries = Integer.parseInt(paramNbTries);
        Main.combinationLength = Integer.parseInt(paramCombinaisonLength);
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

        return Integer.parseInt(properties.getProperty("paramCombinaisonLength"));
    }

    static boolean getParamConfigDevMode() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        return Boolean.parseBoolean(properties.getProperty("paramModeDev"));
    }

    static  boolean getParamInfiniteTries() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        return Boolean.parseBoolean(properties.getProperty("paramEssaiesInfinie"));
    }

    static void setBasicParam() throws  IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "7");
        properties.setProperty("paramCombinaisonLength", "4");
        properties.setProperty("paramModeDev", "false");
        properties.setProperty("paramEssaiesInfinie", "false");
        properties.store(outputStream, null);
    }

    static void setEasyChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "10");
        properties.setProperty("paramCombinaisonLength", "3");
        properties.setProperty("paramModeDev", String.valueOf(Main.devMode));
        properties.setProperty("paramEssaiesInfinie", "false");
        properties.store(outputStream, null);
    }
    static void setEasyDuel() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "1500");
        properties.setProperty("paramCombinaisonLength", "3");
        properties.setProperty("paramModeDev", String.valueOf(Main.devMode));
        properties.setProperty("paramEssaiesInfinie", "false");
        properties.store(outputStream, null);
    }
    static void setMediumChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "7");
        properties.setProperty("paramCombinaisonLength", "4");
        properties.setProperty("paramModeDev", String.valueOf(Main.devMode));
        properties.setProperty("paramEssaiesInfinie", "false");
        properties.store(outputStream, null);
    }
    static void setMediumDuel() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "1500");
        properties.setProperty("paramCombinaisonLength", "4");
        properties.setProperty("paramModeDev", String.valueOf(Main.devMode));
        properties.setProperty("paramEssaiesInfinie", "false");
        properties.store(outputStream, null);
    }
    static void setHardChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "5");
        properties.setProperty("paramCombinaisonLength", "5");
        properties.setProperty("paramModeDev", String.valueOf(Main.devMode));
        properties.setProperty("paramEssaiesInfinie", "false");
        properties.store(outputStream, null);
    }
    static void setHardDuel() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "1500");
        properties.setProperty("paramCombinaisonLength", "5");
        properties.setProperty("paramModeDev", String.valueOf(Main.devMode));
        properties.setProperty("paramEssaiesInfinie", "false");
        properties.store(outputStream, null);
    }
    static void setDevModeChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", String.valueOf(Main.nbTries));
        properties.setProperty("paramCombinaisonLength", String.valueOf(Main.combinationLength));
        properties.setProperty("paramModeDev", "true");
        properties.setProperty("paramEssaiesInfinie", "false");
        properties.store(outputStream, null);
    }
    static void setInfiniteTriesDefender() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "1500");
        properties.setProperty("paramCombinaisonLength", String.valueOf(Main.combinationLength));
        properties.setProperty("paramModeDev", "false");
        properties.setProperty("paramEssaiesInfinie", "true");
        properties.store(outputStream, null);
    }
    static void setInfiniteTriesDefenderFalse() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbTries", "10");
        properties.setProperty("paramCombinaisonLength", String.valueOf(Main.combinationLength));
        properties.setProperty("paramModeDev", "false");
        properties.setProperty("paramEssaiesInfinie", "false");
        properties.store(outputStream, null);
    }
}