package db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Properties {
	
	private String dbUrl = "";
	private String dbDriver = "";
	private String dbUser = "";
	private String dbPassword = "";
	private String dbTable = "";
	private String dbType = "";
	
	public Properties() {
	}

	
	public void readFromFile(String path) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = "";
			
			while((line = br.readLine()) != null) {
				if(line.contains("dbUrl"))
					dbUrl = line.split("=")[1];
				if(line.contains("dbDriver"))
					dbDriver = line.split("=")[1];
				if(line.contains("dbUser"))
					dbUser = line.split("=")[1];
				if(line.contains("dbPassword"))
					dbPassword = line.split("=")[1];
				if(line.contains("dbTable"))
					dbTable = line.split("=")[1];
				if(line.contains("dbType"))
					dbType = line.split("=")[1];
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String getDbUrl() {
		return dbUrl;
	}


	public String getDbDriver() {
		return dbDriver;
	}


	public String getDbUser() {
		return dbUser;
	}


	public String getPassword() {
		return dbPassword;
	}


	public String getDbTable() {
		return dbTable;
	}
	
	public String getDbType() {
		return dbType;
	}
}
