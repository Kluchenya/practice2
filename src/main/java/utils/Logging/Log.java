package utils.Logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

    private static Logger Log = LoggerFactory.getLogger(Log.class);

    public static void info(String message){
        Log.debug(message);
    }

    public static void debug(String message){
        Log.debug(message);
    }

    public static void error(String message){
        Log.error(message);
    }

    public static void warn (String message){
        Log.warn(message);
    }
}
