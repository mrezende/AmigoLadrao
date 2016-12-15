package com.amigoladrao.app.config.module;

import com.amigoladrao.app.config.SorteioConfig;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class SorteioConfigModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(String.class).annotatedWith(Names.named(SorteioConfig.SORTEIO_PROPERTY)).toInstance("sorteio.properties");
	}
	
	

}
