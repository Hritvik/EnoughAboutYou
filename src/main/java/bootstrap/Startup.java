package bootstrap;

import java.sql.ResultSet;
import java.sql.Statement;

import config.LoadConfig;
import db.ConnectMySql;

public class Startup {
	public static void main(String[] args) {
		try {
			LoadConfig.getInstance().loadConfig();
			testConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void initJetty() {
		
	}

	private static void testConnection() {
		try {
			ConnectMySql connectMySql = new ConnectMySql();
			connectMySql.createConnection("world");
			Statement statement = connectMySql.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("show tables");
			while (resultSet.next()) {
				System.out.println(resultSet.getString("Tables_in_world"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
