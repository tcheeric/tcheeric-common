package xyz.tcheeric.common.config;

import lombok.NonNull;
import lombok.extern.java.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;

@Log
class PropertiesWrapper {

    private final static Properties properties = new Properties();
    private final static String CONFIG_FILE_PATH = "app.properties";

    static {
        String configFilePath = System.getProperty(CONFIG_FILE_PATH);
        try (InputStream input = (configFilePath != null) ? new FileInputStream(configFilePath) : PropertiesWrapper.class.getClassLoader().getResourceAsStream(CONFIG_FILE_PATH)) {
            if (input == null) {
                throw new IOException("Unable to find " + CONFIG_FILE_PATH);
            }
            properties.load(input);
        } catch (IOException ex) {
            log.log(Level.SEVERE, "Unable to load configuration", ex);
        }
    }

    static String getProperty(@NonNull String key) {
        return properties.getProperty(key);
    }

    static String getProperty(@NonNull String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
