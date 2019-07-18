import java.io.*;
import java.util.*;

public class LecteurProperties {
    static void getParamConfig() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        String recupParamNbEssaies = properties.getProperty("paramNbEssaies");
        String recupParamLongueurCombinaison = properties.getProperty("paramLongueurCombinaison");
        String recupParamModeDev = properties.getProperty("paramModeDev");

        ModesDeJeu.nbEssaies = Integer.parseInt(recupParamNbEssaies);
        ModesDeJeu.longueurCombinaison = Integer.parseInt(recupParamLongueurCombinaison);
        ModesDeJeu.modeDev = Boolean.parseBoolean(recupParamModeDev);
    }

    static int getParamConfigNbEssaies() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        int paramNbEssaies = Integer.parseInt(properties.getProperty("paramNbEssaies"));
        return paramNbEssaies;
    }

    static int getParamConfigLongueurCombinaison() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        int paramLongueurCombinaison = Integer.parseInt(properties.getProperty("paramLongueurCombinaison"));
        return paramLongueurCombinaison;
    }

    public static boolean getParamConfigModeDev() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        boolean paramModeDev = Boolean.parseBoolean(properties.getProperty("paramModeDev"));
        return paramModeDev;

    }

    static void setBasicParam() throws  IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbEssaies", "7");
        properties.setProperty("paramLongueurCombinaison", "4");
        properties.setProperty("paramModeDev", "false");
        properties.store(outputStream, null);
    }

    static void setEasyChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbEssaies", "10");
        properties.setProperty("paramLongueurCombinaison", "3");
        properties.setProperty("paramModeDev", String.valueOf(ModesDeJeu.modeDev));
        properties.store(outputStream, null);
    }
    static void setMediumChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbEssaies", "7");
        properties.setProperty("paramLongueurCombinaison", "4");
        properties.setProperty("paramModeDev", String.valueOf(ModesDeJeu.modeDev));
        properties.store(outputStream, null);
    }
    static void setHardChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbEssaies", "5");
        properties.setProperty("paramLongueurCombinaison", "5");
        properties.setProperty("paramModeDev", String.valueOf(ModesDeJeu.modeDev));
        properties.store(outputStream, null);
    }
    static void setDevModeChallenger() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Param.properties");
        Properties properties = new Properties();

        properties.setProperty("paramNbEssaies", String.valueOf(ModesDeJeu.nbEssaies));
        properties.setProperty("paramLongueurCombinaison", String.valueOf(ModesDeJeu.longueurCombinaison));
        properties.setProperty("paramModeDev", "true");
        properties.store(outputStream, null);
    }
}

















//    public static void setDataProperties() {
//
//        Properties prop = new Properties();
//
//        String recupNbEssaies;
//        String recupLongueurCombinaison;
//        String recupModeDev;
//
//        String configPath = "Param.properties";
//
//        try {
//            FileInputStream input = new FileInputStream(configPath);
//            prop.load(input);
//            input.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        recupNbEssaies = prop.getProperty("nbEssaies");
//        recupLongueurCombinaison = prop.getProperty("longueurCombinaison");
//        recupModeDev = prop.getProperty("modeDev");
//
//        int intRecupNbEssaies = Integer.getInteger(recupNbEssaies);
//        int intRecupLongueurCombinaison = Integer.getInteger(recupLongueurCombinaison);
//        Boolean boolRecupModeDev = Boolean.parseBoolean(recupModeDev);
//
//
//        ModesDeJeu.nbEssaies = intRecupNbEssaies;
//        ModesDeJeu.longueurCombinaison = intRecupLongueurCombinaison;
//        ModesDeJeu.modeDev = boolRecupModeDev;
//    }
//
//    static void SetDataNbEssaies() {
//        Properties prop = new Properties();
//
//        String recupNbEssaies;
//
//        String configPath = "Param.properties";
//
//        try {
//            FileInputStream input = new FileInputStream(configPath);
//            prop.load(input);
//            input.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        recupNbEssaies = prop.getProperty("nbEssaies");
//        ModesDeJeu.nbEssaies = Integer.getInteger(recupNbEssaies);
//    }
//
//    static void setDataLongueurCombinaison() {
//        Properties prop = new Properties();
//
//        String recupLongueurCombinaison;
//
//        String configPath = "Param.properties";
//
//        try {
//            FileInputStream input = new FileInputStream(configPath);
//            prop.load(input);
//            input.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        recupLongueurCombinaison = prop.getProperty("longueurCombinaison");
//        ModesDeJeu.longueurCombinaison = Integer.getInteger(recupLongueurCombinaison);
//    }
//
//    static void setDataModeDev() {
//        Properties prop = new Properties();
//
//        String recupModeDev;
//
//        String configPath = "Param.properties";
//
//        try {
//            FileInputStream input = new FileInputStream(configPath);
//            prop.load(input);
//            input.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        recupModeDev = prop.getProperty("longueurCombinaison");
//        ModesDeJeu.longueurCombinaison = Integer.getInteger(recupModeDev);
//    }
//
//    static void setEasyChallenger() {
//        Properties prop = new Properties();
//        prop.setProperty("nbEssaies", "10");
//        prop.setProperty("longueurCombinaison", "3");
//    }
//    static void setMediumChallenger() {
//        Properties prop = new Properties();
//        prop.setProperty("nbEssaies", "7");
//        prop.setProperty("longueurCombinaison", "4");
//    }
//    static void setHardChallenger() {
//        Properties prop = new Properties();
//        prop.setProperty("nbEssaies", "5");
//        prop.setProperty("longueurCombinaison", "5");
//    }

