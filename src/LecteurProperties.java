import java.io.*;
import java.util.*;

public class LecteurProperties {
    public static void getParamConfig() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        int recupParamNbEssaies = Integer.getInteger(properties.getProperty("paramNbEssaies"));
        int recupParamLongueurCombinaison = Integer.getInteger(properties.getProperty("paramLongueurCombinaison"));
        boolean recupParamModeDev = Boolean.parseBoolean(properties.getProperty("paramModeDev"));
    }

    public static int getParamConfigNbEssaies() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        return Integer.getInteger(properties.getProperty("paramNbEssaies"));
    }

    public static int getParamConfigLongueurCombinaison() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        return Integer.getInteger(properties.getProperty("paramLongueurCombinaison"));
    }

    public static boolean getParamConfigModeDev() throws IOException {
        FileReader reader = new FileReader("Param.properties");
        Properties properties = new Properties();
        properties.load(reader);

        return Boolean.parseBoolean(properties.getProperty("paramModeDev"));

    }



    public static void setEasyChallenger() throws IOException {
        FileInputStream input = new FileInputStream("Param.properties");
        Properties properties = new Properties();
        properties.load(input);

        properties.setProperty("paramNbEssaies", "10");
        properties.setProperty("paramLongueurCombinaison", "3");
    }
    public static void setMediumChallenger() throws IOException {
        FileInputStream input = new FileInputStream("Param.properties");
        Properties properties = new Properties();
        properties.load(input);

        properties.setProperty("paramNbEssaies", "7");
        properties.setProperty("paramLongueurCombinaison", "4");

    }
    public static void setHardChallenger() throws IOException {
        FileInputStream input = new FileInputStream("Param.properties");
        Properties properties = new Properties();
        properties.load(input);

        properties.setProperty("paramNbEssaies", "5");
        properties.setProperty("paramLongueurCombinaison", "5");
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

