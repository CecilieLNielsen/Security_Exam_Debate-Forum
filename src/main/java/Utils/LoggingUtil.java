package Utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingUtil {

    /**
     * Log message with desired level to a file
     *
     * @param level level of the log message
     * @param msg   the message to log
     */
    public static void log(Level level, String msg) {
        Logger logger = Logger.getLogger(LoggingUtil.class.getName());
        FileHandler fileHandler;
        try {
            // server.log is found at apache-tomcat-x.x.xx/bin/server.log
            fileHandler = new FileHandler("server.log", true);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.log(level, msg);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

}
