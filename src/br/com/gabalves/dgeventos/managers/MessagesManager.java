package br.com.gabalves.dgeventos.managers;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;

public class MessagesManager {
	
	private static final String BUNDLE_NAME = "messages";

	private static Locale LOCALE;
	private static ResourceBundle RESOURCE_BUNDLE;
	
	public MessagesManager() {
		
	}
	
	public void init(String locale) {
		try {
			String[] list = StringUtils.split(locale, "_");
	
			LOCALE = new Locale(list[0], list[1]);
			RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME, LOCALE);
		} catch (MissingResourceException e) {
			Bukkit.getLogger().info(" ");
			Bukkit.getLogger().warning("Unidentified '" + locale + "' language");
			Bukkit.getLogger().info(" ");
		}
	}
	
	public String getString(String key) {
		if(RESOURCE_BUNDLE.getString(key) == null) {
			throw new NullPointerException("String value cannot be null");
		}
		String str = RESOURCE_BUNDLE.getString(key);
		str = str.replaceAll("&", "§");
		return str;
	}
	
	public String getString(String key, Object... params) {
		if(RESOURCE_BUNDLE.getString(key) == null) {
			throw new NullPointerException("String value cannot be null");
		}
		String str = MessageFormat.format(RESOURCE_BUNDLE.getString(key), params);
		str = str.replaceAll("&", "§");
		return str;
	}
	
	public String getDefaultString(String key) {
		if(RESOURCE_BUNDLE.getString(key) == null) {
			throw new NullPointerException("String value cannot be null");
		}
		return RESOURCE_BUNDLE.getString(key);
	}
	
	public String getDefaultString(String key, Object... params) {
		if(RESOURCE_BUNDLE.getString(key) == null) {
			throw new NullPointerException("String value cannot be null");
		}
		return MessageFormat.format(RESOURCE_BUNDLE.getString(key), params);
	}

}
