package com.antoineDomergue.OCProjet3Java;

/***
 * Manages Log4J and input errors from the user.
 */
class Logger {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);

    /***
     * Returns an error message in the terminal when the user does not enter the expected value.
     */
    static void errorUserInput() {
        logger.error("La saisie de l'utilisateur ne correspond pas aux instructions données.");
    }
}
