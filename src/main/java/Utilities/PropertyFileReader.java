package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
     Properties properties=new Properties();

    public PropertyFileReader() throws FileNotFoundException {
        FileInputStream fileInputStream=new FileInputStream("/Users/prajwal/Desktop/testvagrant /assignment projects/Buildtoolpractice/src/main/java/resources/environment.properties");
        System.out.println("Reading all properties from the file");
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  String getProperty(String key){
        return properties.getProperty(key);
    }
}
