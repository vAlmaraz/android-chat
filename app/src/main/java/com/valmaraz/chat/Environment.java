package com.valmaraz.chat;

/**
 * Created by vAlmaraz on 09/07/2017.
 * https://www.valmaraz.com
 */

public class Environment {

    public static String CURRENT_USER = "contact_1";

    // Default values (PRODUCTION)
    public static boolean showLog = false;
    public static String socketAddress = "ws://chat.valmaraz.com";

    private static Type type = Type.PRODUCTION;

    public static void configure() {
        switch (type) {
            case DEVELOP:
                showLog = true;
                socketAddress = "http://192.168.2.5";
                break;
            case PREPRODUCTION:
                showLog = true;
                socketAddress = "ws://chat.valmaraz.com";
                break;
            case PRODUCTION:
                showLog = false;
                socketAddress = "ws://chat.valmaraz.com";
                break;
        }
    }

    public enum Type {
        DEVELOP,
        PREPRODUCTION,
        PRODUCTION
    }
}
