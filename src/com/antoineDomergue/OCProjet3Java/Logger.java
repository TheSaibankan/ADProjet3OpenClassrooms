package com.antoineDomergue.OCProjet3Java;

public class Logger {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);

    static void error(String message) {logger.error(message);}
    static void errorUserInput() {
        logger.error("La saisie de l'utilisateur ne correspond pas aux instructions données.");
    }
}
