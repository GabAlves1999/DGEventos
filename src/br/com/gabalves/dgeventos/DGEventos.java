package br.com.gabalves.dgeventos;

import org.bukkit.plugin.java.JavaPlugin;

public class DGEventos extends JavaPlugin {
	
	public void onEnable() {
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
