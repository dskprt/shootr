package shootr.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    public static void info(Object o, String text) {
        System.out.println(String.format("%s [%s/INFO] %s",
                getCurrentTime(), o.getClass().getName(), text));
    }

    public static void warn(Object o, String text) {
        System.out.println(String.format("%s [%s/WARN] %s",
                getCurrentTime(), o.getClass().getName(), text));
    }

    public static void error(Object o, String text) {
        System.err.println(String.format("%s [%s/ERROR] %s",
                getCurrentTime(), o.getClass().getName(), text));
    }

    public static void fatal(Object o, String text, Throwable t) {
        System.err.println(String.format("%s [%s/FATAL] %s",
                getCurrentTime(), o.getClass().getName(), text));

        t.printStackTrace();
    }

    public static void info(Class<?> o, String text) {
        System.out.println(String.format("%s [%s/INFO] %s",
                getCurrentTime(), o.getName(), text));
    }

    public static void warn(Class<?> o, String text) {
        System.out.println(String.format("%s [%s/WARN] %s",
                getCurrentTime(), o.getName(), text));
    }

    public static void error(Class<?> o, String text) {
        System.err.println(String.format("%s [%s/ERROR] %s",
                getCurrentTime(), o.getName(), text));
    }

    public static void fatal(Class<?> o, String text, Throwable t) {
        System.err.println(String.format("%s [%s/FATAL] %s",
                getCurrentTime(), o.getName(), text));

        t.printStackTrace();
    }

    private static String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        return formatter.format(new Date());
    }
}
