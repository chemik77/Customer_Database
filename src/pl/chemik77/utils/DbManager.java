package pl.chemik77.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {

	private static Connection connection;
	private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/databaseName?autoReconnect=true&useSSL=false";
	private static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	private static String pathToCredentials = "/credentials.txt";
	private static String databaseName;
	private static String user;
	private static String password;

	private static void readCredentials() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(pathToCredentials));
			databaseName = br.readLine().replaceAll("database=", "");
			user = br.readLine().replaceAll("user=", "");
			password = br.readLine().replaceAll("password=", "");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER_MYSQL).newInstance();
			readCredentials();
			String url = URL_MYSQL.replaceAll("databaseName", databaseName);
			connection = DriverManager.getConnection(url, user, password);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public static void main(String[] args) {
		readCredentials();
		System.out.println(databaseName);
		getConnection();
		if(connection != null) {
			System.out.println("You are connected!");
		}
	}
	
}
