package logging;

import org.apache.log4j.Logger;

public class Logger4jTest {

    public static void log4j () {

        // add dependencies log4j before all else

        Logger log = Logger.getLogger(Logger4jTest.class.getName());

        log.info("Info message");
        log.error("Error message", new Exception());

    }

}
