package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHandler {

    protected static Properties prop = new Properties();

    static {
        try {
            PropertyHandler.loadPropertyFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadPropertyFile() throws IOException {
        InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/configuration.properties");
        prop.load(input);
    }

    public static String getProperty(String key){
        return prop.getProperty(key)
;    }

}
