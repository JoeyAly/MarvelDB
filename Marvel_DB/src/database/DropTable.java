package database;

import java.sql.*;


public class DropTable {
	
	public String tableName;
	
	public DropTable(String tableName)
	{
		this.tableName = tableName;
		
	}

	public void drop() {
		try {
			Statement stmt 		= MarvelDbMain.conn.createStatement();
			String sqlStatement = "DROP TABLE " + tableName;
			
			stmt.executeUpdate(sqlStatement);
			System.out.println("Dropped table " + tableName);

		} catch(Exception e) {System.out.println("Could not drop table: ");}
	}
}
