package fr.fms.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateConfigFile {

	public static void main(String[] args) {
		try(FileOutputStream config = new FileOutputStream(new File("files/config.properties"))) {
			Properties props = new Properties();
			props.setProperty("db.driver", "org.mariadb.jdbc.Driver");
			props.setProperty("db.url", "jdbc:mariadb://localhost:3306/elearningshop");
			props.setProperty("db.login", "root");
			props.setProperty("db.password", "fms2024");
			props.store(config, "Configuration de la base de données");
			System.out.println("Fichier de configuration créé .....");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
