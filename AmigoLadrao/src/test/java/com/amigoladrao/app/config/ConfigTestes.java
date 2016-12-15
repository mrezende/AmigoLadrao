package com.amigoladrao.app.config;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.amigoladrao.app.config.SorteioConfig;



public class ConfigTestes {
	
	@Test
	public void leProperty_umNome_retornaTrue() {
		
		SorteioConfig config;
		try {
			config = new SorteioConfig();
			String[] nomes = config.recuperaNomes();
			
			Assert.assertEquals("Gdao", nomes[17]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
