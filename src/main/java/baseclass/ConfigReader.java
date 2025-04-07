package baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static String getproperty(String key) throws IOException {
		Properties prop= new Properties();
		String path="C:\\Users\\sanjay royal\\eclipse-workspace\\Automationchallange\\src\\test\\java\\TestData\\com.properties";
		try {
			FileInputStream file= new FileInputStream(path);
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		return prop.getProperty(key);
		
		
	}

}
