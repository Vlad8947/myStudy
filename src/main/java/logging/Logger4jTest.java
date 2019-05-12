package logging;

import org.apache.log4j.Logger;

public class Logger4jTest {

    public static void log4j () {

        // Add dependencies log4j before all else
        //  and create log4j.properties in resources

        Logger log = Logger.getLogger(Logger4jTest.class.getName());

        log.info("Info message");
        log.error("Error message", new Exception());

    }

}
