package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

	public static String getValuesFromProperty(String key) throws Exception {
		
		String filePath = "./data/Environment.properties";
		FileInputStream file = new FileInputStream(filePath);
		Properties pro = new Properties();
		pro.load(file);
		String value = pro.getProperty(key);
		file.close();
		return value;
	}
}
