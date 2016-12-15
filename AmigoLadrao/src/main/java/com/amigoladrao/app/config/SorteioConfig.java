package com.amigoladrao.app.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class SorteioConfig {
	
	public final static String SORTEIO_PROPERTY = "SORTEIO_PROPERTY";
	
	private String propertyName;
	
	
	@Inject
	public SorteioConfig(@Named(SorteioConfig.SORTEIO_PROPERTY) String propertyName) throws IOException {
		this.propertyName = propertyName;
	}

	public String[] recuperaNomes() {
		
		return "".split(",");
	}

}
