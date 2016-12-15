package com.amigoladrao.app.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class SorteioConfig {
	
	public final static String SORTEIO_PROPERTY = "SORTEIO_PROPERTY";

	private String propertyName;
	
	
	@Inject
	public SorteioConfig(@Named(SorteioConfig.SORTEIO_PROPERTY) String propertyName) throws IOException {
		this.propertyName = propertyName;
	}

	private Configuration getConfiguration() {
		Parameters params = new Parameters();
		FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
				new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
						.configure(params.properties()
								.setFileName(this.propertyName)
								.setListDelimiterHandler(new DefaultListDelimiterHandler(',')));
		Configuration config = null;
		try {
			config = builder.getConfiguration();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		return config;
	}

	public String[] recuperaNomes() {
		Configuration configuration = getConfiguration();
		return configuration.getStringArray("participantes");
	}

}
