package com.opus.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Properties;

public class PropReader {
	String result = "";
	InputStream inputStream;

	public String getLocalValue(String textToFind) throws IOException {

		try {
			Properties prop = new Properties();
			String propFileName = "utilities.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			Date time = new Date(System.currentTimeMillis());

			// get the property value and print it out
			String pathToDisk = prop.getProperty(textToFind);
			result = pathToDisk;
			System.out.println("\nProgram Ran on " + time + " and the resolution was =" + pathToDisk);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}

	public String getExternalValue(String textToFind, String path) throws IOException {
		try {
			Properties prop = new Properties();
			inputStream = new FileInputStream(path);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + path + "' not found in the classpath");
			}

			Date time = new Date(System.currentTimeMillis());

			// get the property value and print it out
			String pathToDisk = prop.getProperty(textToFind);
			result = pathToDisk;
			System.out.println("\nProgram Ran on " + time + " and the resolution was =" + pathToDisk);
			inputStream.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropReader pr = new PropReader();
		try {
			pr.getLocalValue("miTaller");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
