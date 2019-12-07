package database;


import java.sql.PreparedStatement;



public class CreateTable {
	
	//Gets table name from main
	
	public String tableName;
	
	public CreateTable(String tableName)
	{
		this.tableName = tableName;
		
	}

	
	public void createTable() throws Exception	 
	{
		try {
			System.out.println("Creating table");

			PreparedStatement create = MarvelDbMain.conn.prepareStatement("CREATE TABLE IF NOT EXISTS " +
					tableName + " " +
					"(MovieTitle varchar(255) PRIMARY KEY ,"+
					"TopBilled varchar(255)," +
					"Grossing DECIMAL(5,1)," +
					"RottenTomatoesScore int," +
					"RunTime int," +
					"Chronology int)");
			create.executeUpdate();
			
		}catch(Exception e) {System.out.println(e);}
		finally
		{
			System.out.println("Completed table");
		}
	}
	

}