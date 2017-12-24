package com.simonkay.javaframework.utility.localisation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.simonkay.javaframework.utility.enums.Language;

public class LocaleHelper implements LanguageImplementor {
	private static final Logger LOG = LogManager.getLogger(LocaleHelper.class);
	
	@Autowired
	private Environment environment;
	
	private Language language;

	
	public LocaleHelper() {
		language = getLanguage();
		LOG.debug("Retrieved application language as: " + this.language.toString());
	}
	
	@Override
	public String getResource(String value) {
		return "";		
	}

	@Override
	public Language getLanguage() {
		String language = environment.getProperty("env.language");
		
		switch(language.toLowerCase()) {
		case "english":
			return Language.ENGLISH;
		case "italian":
			return Language.ITALIAN;
		case "spanish":
			return Language.SPANISH;
		case "french":
			return Language.FRENCH;
		default: LOG.debug("Bad Language set in properties or by maven, defaulting to ENGLISH");
			return Language.ENGLISH;		
		}				
	}
	
}
