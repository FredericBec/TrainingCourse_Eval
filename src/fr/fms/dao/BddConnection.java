package fr.fms.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

public class BddConnection {

	private static String driver;
	private static String url;
	private static String login;
	private static String password;
	private static Connection connection = null;
	public static final Logger logger = Logger.getLogger(BddConnection.class.getName());
	
	private BddConnection() {
		try {
			readConfigFile();
			Class.forName(driver);
			connection = DriverManager.getConnection(url, login, password);
		} catch (ClassNotFoundException e) {
			logger.severe("Problème de connection : " + e.getMessage());
		}catch(FileNotFoundException e) {
			logger.severe("Problème de fichier :" + e.getMessage());
		}catch(IOException e) {
			logger.severe("Problème I/O : " + e.getMessage());
		}catch(Exception e) {
			logger.severe("Erreur : " + e.getMessage());
		}
	}
	
	public static synchronized Connection getConnection() {
		if(connection == null) new BddConnection();
		return connection;
	}
	
	private static void readConfigFile() throws FileNotFoundException, IOException {
		Properties props = new Properties();
		try(FileInputStream fis = new FileInputStream("files/config.properties")) {
			props.load(fis);
		} catch (FileNotFoundException e) {
			logger.severe("Fichier de config non trouvé" + e.getMessage());
		}catch(IOException e) {
			logger.severe("Erreur de lecture du fichier" + e.getMessage());
		}
		props.getProperty("db.driver");
		props.getProperty("db.url");
		props.getProperty("db.login");
		props.getProperty("db.password");
	}
}
