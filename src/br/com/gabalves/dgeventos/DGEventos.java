package br.com.gabalves.dgeventos;

import org.bukkit.plugin.java.JavaPlugin;

public class DGEventos extends JavaPlugin {
	
	public static DGEventos instance;
	
	public void onEnable() {
		instance = this;
		configure();
	}
	
	public void onDisable() {
		
	}
	
	private void configure() {
		if(this.getDataFolder().exists()) {
			this.getDataFolder().mkdir();
		}
		
		saveDefaultConfig();
	}

}
