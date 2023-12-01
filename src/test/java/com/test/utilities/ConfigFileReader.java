package com.test.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private static Properties properties;
	private static ConfigFileReader configReader;

    public ConfigFileReader() {
		BufferedReader reader;
	    	String propertyFilePath = "configs/androidInfo.properties";
	        try {
	            reader = new BufferedReader(new FileReader(propertyFilePath));
	            properties = new Properties();
	            try {
	                properties.load(reader);
	                reader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            throw new RuntimeException("androidInfo.properties not found at " + propertyFilePath);
	        }		
	}

    public static ConfigFileReader getInstance( ) {
    	if(configReader == null) {
    		configReader = new ConfigFileReader();
    	}
        return configReader;
    }

    public  String getDeviceName() {
        String deviceName = properties.getProperty("deviceName");
        if(deviceName != null) return deviceName;
        else throw new RuntimeException("deviceName not specified in the androidInfo.properties file.");
    }

    public  String getPlatformVersion() {
        String platformVersion = properties.getProperty("platformVersion");
        if(platformVersion != null) return platformVersion;
        else throw new RuntimeException("platformVersion not specified in the androidInfo.properties file.");
    }
    
    public  String getPlatformName() {
        String platformName = properties.getProperty("platformName");
        if(platformName != null) return platformName;
        else throw new RuntimeException("platformName not specified in the androidInfo.properties file.");
    }
    
    public  String getAppPath() {
        String appPath = properties.getProperty("appPath");
        if(appPath != null) return appPath;
        else throw new RuntimeException("appPath not specified in the androidInfo.properties file.");
    }
    
    
}
