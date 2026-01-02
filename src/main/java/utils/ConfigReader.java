package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream(
                    "src/main/resources/config.properties"
            );
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    private ConfigReader() {
        // Prevent object creation
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    /* ================= Common Getters ================= */

    public static String getBaseUrl() {
        return getProperty("baseUrl");
    }

    public static String getBrowser() {
        return getProperty("browser");
    }

    public static String getValidUsername() {
        return getProperty("valid.username");
    }

    public static String getValidPassword() {
        return getProperty("valid.password");
    }

    public static String getInvalidUsername() {
        return getProperty("invalid.username");
    }

    public static String getInvalidPassword() {
        return getProperty("invalid.password");
    }

    public static int getTimeout() {
        return Integer.parseInt(getProperty("timeout"));
    }
}

