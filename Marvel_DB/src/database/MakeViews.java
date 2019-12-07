package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MakeViews {
	
	public String viewName;
	public String sqlStatement;
	
	public ResultSet rs;
	public Statement stmt;
	
    public MakeViews(String viewName, String sqlStatement) {
    	
    	this.viewName 	  = viewName;
    	this.sqlStatement = sqlStatement;
    }   

	public void createView()
	{
		try {
			System.out.println("Creating view");

			Connection con = MarvelDbMain.conn;
			stmt = con.createStatement();
			
			// Get data of the sql statement
			stmt.executeUpdate(sqlStatement);
			
			System.out.println("Creating view done");
						
		}
		catch(Exception e) {
			System.out.println(e);
			}
		finally {
			System.out.println("Completed view");
		
		}
	}
	
	/*
	 * Print all rows that fit the selection query
	 * 
	 * */
	
	public void printView() { 
		
		try {
			
			rs = stmt.executeQuery("SELECT * FROM " + viewName + ";"); 

			System.out.println("==============		View: " + this.viewName + "      ==========================");

			while(rs.next()) {

				try { 
					System.out.print("	Movie Title: " 			 + rs.getString("MovieTitle"));
				}catch(Exception e) { /*System.out.println( "No Title");*/}


				try {
					System.out.print(", Top Billed: " 			 + rs.getString("TopBilled"));
				}catch(Exception e) { /*System.out.println( "No Billed");*/}

			
				try {
					System.out.print(", Rotten Tomatoes Score: " 				+ rs.getInt("RottenTomatoesScore"));
				}catch(Exception e) { /*System.out.println( "No Score");*/}

				try {
					System.out.print(", Grossing: " 			+ rs.getBigDecimal("Grossing") + " million");
				}catch(Exception e) { /*System.out.println( "No Grossing");*/}

				try {
					System.out.print(", Runtime: " 				+ rs.getInt("Runtime"));
				}catch(Exception e) { /*System.out.println( "No Runtime");*/}

				try {
					System.out.print(", Chronology: "			 + rs.getInt("Chronology"));
				} catch(Exception e) { /*System.out.println( "No Chronology");*/}
				finally {
					System.out.println("\n");

				}			
				
			} 
		}catch(Exception e) {
			System.out.println(e);
			}
		finally {
			System.out.println("Completed view");
//			System.out.println("\n\n");

		}		
	}
	
	
}
