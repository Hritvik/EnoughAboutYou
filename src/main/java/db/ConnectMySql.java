package db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.json.simple.JSONObject;

import config.LoadConfig;
import util.Constants;

public class ConnectMySql {
	public ConnectMySql() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection connection;

	private void createConnection(String host, String dbName, String userName, String password) {
		try {
			setConnection(DriverManager.getConnection(host + "/" + dbName, userName, password));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void createConnection(String dbName) {
		JSONObject dbConfig = (JSONObject) LoadConfig.getInstance().getConfig().get(Constants.DB_CONFIG);
		String host = (String) dbConfig.get(Constants.MYSQL_URL);
		String userName = (String) dbConfig.get(Constants.MYSQL_USERNAME);
		String password = (String) dbConfig.get(Constants.MYSQL_PASSWORD);
		createConnection(host, dbName, userName, password);
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
