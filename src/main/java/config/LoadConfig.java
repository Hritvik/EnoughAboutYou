package config;


import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LoadConfig {
	private JSONObject config;
	private static LoadConfig loadConfig;

	private LoadConfig() {
	}

	public static LoadConfig getInstance() {
		if (loadConfig == null) {
			loadConfig = new LoadConfig();
		}
		return loadConfig;
	}

	public void loadConfig() {
		try {
			JSONParser parser = new JSONParser();
			setConfig((JSONObject) parser.parse(new FileReader(new File("config/config.json"))));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JSONObject getConfig() {
		return config;
	}

	public void setConfig(JSONObject config) {
		this.config = config;
	}
}
