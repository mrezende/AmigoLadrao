package com.amigoladrao.app.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SorteioConfig {
	
	Properties properties = new Properties();
	
	public SorteioConfig() throws IOException {
		InputStream propertyFile = new FileInputStream("sorteio.properties");
		this.properties.load(propertyFile);
	}

	public String[] recuperaNomes() {
		String value = this.properties.getProperty("participantes", "Tia");
		return value.split(",");
	}

}
