package logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class JDKLoggerTest {

    public static void sysErrLog (String logFileName) {

        try {
            System.setErr(new PrintStream(new File(logFileName)));
            System.err.println("Message");

        } catch (FileNotFoundException e) {
            //туда же
            e.printStackTrace();
        }
    }

    public static void jul (String[] args) {

        Logger log = Logger.getLogger(JDKLoggerTest.class.getName());

        // Строковое сообщение
        String stringMessage = "Сообщение";

        // Строковое сообщение с параметрами
        String stringMessageFormat ="Сообщение {0}";

        // Исключение
        Throwable throwable = new Throwable();

        // ResourceBundle хранящий сообщения
        ResourceBundle resourceBundle = ResourceBundle.getBundle("logging.jul.bundle");

        // Поставщик сообщений
        Supplier<String> stringMessageSupplier = ()->"Сообщение";


        log.info(stringMessage);
        log.info(stringMessageSupplier);


        // Вывести сообщение с указанием уровня логгирования
        log.log(new LogRecord(Level.INFO, stringMessage));
        log.log(Level.INFO, stringMessage);
        log.log(Level.INFO, stringMessageSupplier);
        log.log(Level.INFO, stringMessageFormat, args);
        log.log(Level.INFO, stringMessage, throwable );
        log.log(Level.INFO, throwable, stringMessageSupplier);

        // Вывести сообщение с указанием уровня логгирования, класса и метода
        log.logp(Level.INFO, "ClassName", "MethodName", stringMessage);
        log.logp(Level.INFO, "ClassName", "MethodName", stringMessageSupplier);
        log.logp(Level.INFO, "ClassName", "MethodName", stringMessageFormat, args);
        log.logp(Level.INFO, "ClassName", "MethodName", stringMessage, throwable);
        log.logp(Level.INFO, "ClassName", "MethodName", throwable, stringMessageSupplier);

        // Вывести сообщение с указанием уровня логгирования, класса,
        // метода и resourceBundle, хранящего сообщения
        log.logrb(Level.INFO, "ClassName", "MethodName", resourceBundle, "messageId");
        log.logrb(Level.INFO, "ClassName", "MethodName", resourceBundle, "messageId", throwable);

        // Вывести сообщение об ошибке
        log.throwing("ClassName","MethodName", throwable);


    }

}
