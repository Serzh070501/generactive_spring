package am.aca.generactive.util;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class DatabaseConfigurationUtil {

    public static final String DATABASE_PROPERTIES_FILE = "hibernate.properties";


    public static Properties getConnectionProperties() {
        return readProperties(DATABASE_PROPERTIES_FILE);
    }

    public static Properties readProperties(String file) {

        Properties props = new Properties();

        try {

            props.load(Objects.requireNonNull(DatabaseConfigurationUtil.class
                    .getClassLoader()
                    .getResource(file)).openStream());

            return props;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to load db properties from: "
                    + file);
        }
    }
}
