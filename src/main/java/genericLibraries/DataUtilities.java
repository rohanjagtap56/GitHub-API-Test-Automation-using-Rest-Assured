package genericLibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataUtilities {
	
	public String readData(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(AutoConstant.propertyFilePath);
		properties.load(fis);
		return properties.getProperty(key);
	}

}
