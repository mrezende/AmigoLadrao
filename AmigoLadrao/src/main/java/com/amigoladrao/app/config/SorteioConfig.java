package com.amigoladrao.app.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.inject.Inject;

public class SorteioConfig {
	
	private Properties properties;
	
	@Inject
	public SorteioConfig(Properties properties) throws IOException {
		this.properties = properties;
	}

	public String[] recuperaNomes() {
		String value = this.properties.getProperty("participantes", "Tia");
		return value.split(",");
	}

}
