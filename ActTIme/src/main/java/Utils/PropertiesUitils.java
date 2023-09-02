package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUitils {

	
	/**
	 * 
	 * This method will fetch the data from property file and return to calling method
	 * 
	 * @param key--> Provide the data we want to fetch from file
	 * @param path--> Path of the file
	 * @throws Throwable
	 */
	public String PropertyFetchData(String key,String path) throws Throwable {
		
		FileInputStream fis= new FileInputStream(path);
		Properties pobj= new Properties();
		pobj.load(fis);
		String data= pobj.getProperty(key);
		return data;
		
	}
}
