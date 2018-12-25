package core.utils.Logging;

import org.slf4j.MDC;

public class TestLogHelper {
    public static final String TEST_NAME = "testname";

    /**
     * Adds the test name to MDC so that sift appender can use it and log the new
     * log events to a different file
     * @param name name of the new log file
     * @throws Exception
     */
    public static void startTestLogging(String name) {
        MDC.put(TEST_NAME, name);
    }
    /**
     * Removes the key (log file name) from MDC
     * @return name of the log file, if one existed in MDC
     */
    public static String stopTestLogging() {
        String name = MDC.get(TEST_NAME);
        MDC.remove(TEST_NAME);
        return name;
    }
}
