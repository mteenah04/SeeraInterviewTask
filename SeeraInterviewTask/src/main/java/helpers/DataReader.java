package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class DataReader {

    // This method helps in reading values from
    // .properties files
    public static String dataReader(String parsedValue) {
        FileReader reader = null;
        try {
            reader = new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                    + File.separator + "resources" + File.separator + "TestData.properties");

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Properties p = new Properties();
        try {
            p.load(reader);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String value = p.getProperty(parsedValue);
        return value;
    }

}
