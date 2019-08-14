package com.antoineDomergue.OCProjet3Java;

public class Logger {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);

    public static void debug(String message) {logger.debug(message);}
    public static void info(String message) {logger.info(message);}
    public static void warn(String message) {logger.warn(message);}
    public static void error(String message) {logger.error(message);}
    public static void fatal(String message) {logger.fatal(message);}
}
