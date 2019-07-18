import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;

public class LecteurPropertiesLog {
    Logger logger = Logger.getLogger(Main.class);

    void TestLog() {
        ConsoleAppender appender = (ConsoleAppender)  logger.getAppender("console");
        logger.addAppender(appender);
        logger.debug("Hello world.");
        logger.info("What a beautiful day.");
        logger.warn("What a beautiful day.");
    }
}
