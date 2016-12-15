package com.amigoladrao.app.config;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

import com.amigoladrao.app.config.SorteioConfig;

import mockit.Injectable;



public class ConfigTestes {
	
	@Test
	public void leProperty_umNome_retornaTrue() {
		
		Properties properties = new Properties();
		properties.setProperty("participantes", "Tio");
		
		
		SorteioConfig config;
		try {
			config = new SorteioConfig(properties);
			String[] nomes = config.recuperaNomes();
			
			Assert.assertEquals("Tio", nomes[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
