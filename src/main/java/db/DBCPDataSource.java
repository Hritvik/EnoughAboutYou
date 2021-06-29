package db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.json.simple.JSONObject;

import config.LoadConfig;
import util.Constants;

public class DBCPDataSource {
	private static BasicDataSource ds = null;

	private static void init() {
		JSONObject dbConfig = (JSONObject) LoadConfig.getInstance().getConfig().get(Constants.DB_CONFIG);
		String host = (String) dbConfig.get(Constants.MYSQL_URL);
		String userName = (String) dbConfig.get(Constants.MYSQL_USERNAME);
		String password = (String) dbConfig.get(Constants.MYSQL_PASSWORD);
		ds.setUrl(host);
		ds.setUsername(userName);
		ds.setPassword(password);
		ds.setMinIdle(5);
		ds.setMaxIdle(10);
		ds.setMaxOpenPreparedStatements(100);
	}

	public static Connection getConnection() throws SQLException {
		if (ds == null) {
			ds = new BasicDataSource();
			init();
		}
		return ds.getConnection();
	}

	private DBCPDataSource() {
	}
}
