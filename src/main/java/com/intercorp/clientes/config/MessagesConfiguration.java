package com.intercorp.clientes.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MessagesConfiguration implements WebMvcConfigurer {

	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource  messageSource = new ResourceBundleMessageSource ();
		messageSource.setBasename("i18n/messages_es");
		return messageSource;
	}
}

