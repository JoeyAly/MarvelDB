package database;


import java.sql.Statement;

public class InsertRows {
	
	//Gets table name from main
public String tableName;
	
	public InsertRows(String tableName)
	{
		this.tableName = tableName;
		
	}
	
	public void insertData (String movieTitle, String topBilled, double grossing, int score, int runtime, int chronology){
		try {


		Statement stmt = MarvelDbMain.conn.createStatement();
				


		// Insert row
		String sqlStatement = "INSERT INTO " + tableName 
				+ "(MovieTitle,TopBilled, Grossing, RottenTomatoesScore, RunTime, Chronology) VALUES ( "
				+ "\"" + movieTitle	+ "\", " 
				+ "\"" + topBilled	+ "\", " 
				+ grossing			+ ", " 
				+ score 			+ ", " 
				+ runtime			+ ", " 		
				+ chronology 	
				+ ");" ;
		


		stmt.executeUpdate(sqlStatement);

		} catch(Exception e) {System.out.println(e);}
//		finally {
		//	System.out.println("Rows added");
//		}
	}
	

//	public static void insertRows() {
//		try {
//			Connection con = ConnTest.getConnection();
//			Statement stmt= con.createStatement();
////			String sqlStatement;
//			
//			// Insert first row
//			String sqlStatement = "INSERT INTO MarvelMovies"+
//					"(MovieTitle,TopBilled, Grossing, RottenTomatoesScore, RunTime, Chronology)" +
//					"VALUES (\"Iron Man\", \"Robert Downey Jr\", \"$585.2 Million\", 93, 126, 1)";			
//			stmt.executeUpdate(sqlStatement);
//			
//			System.out.println("Insert second movie");
//
//
//			// Insert second row
//			sqlStatement = "INSERT INTO MarvelMovies"+
//					"(MovieTitle,TopBilled, Grossing, RottenTomatoesScore, RunTime, Chronology)" +
//					"VALUES (\"The Incredible Hulk\", \"Edward Norton\", \"$263.4 Million\", 67, 112, 2)";			
//			stmt.executeUpdate(sqlStatement);
//			
//			// Insert third row
//			sqlStatement = "INSERT INTO MarvelMovies"+
//					"(MovieTitle,TopBilled, Grossing, RottenTomatoesScore, RunTime, Chronology)" +
//					"VALUES (\"Iron Man 2\", \"Robert Downey Jr\", \"$623.9 Million\", 73, 125, 3)";			
//			stmt.executeUpdate(sqlStatement);
//			
//			// Insert fourth row
//			sqlStatement = "INSERT INTO MarvelMovies"+
//					"(MovieTitle,TopBilled, Grossing, RottenTomatoesScore, RunTime, Chronology)" +
//					"VALUES (\"Thor\", \"Chris Hemsworth\", \"$449.3 Million\", 77, 114, 4)";			
//			stmt.executeUpdate(sqlStatement);
//
//			// Insert fifth row
//			sqlStatement = "INSERT INTO MarvelMovies"+
//					"(MovieTitle,TopBilled, Grossing, RottenTomatoesScore, RunTime, Chronology)" +
//					"VALUES (\"Captain America: The First Avenger\", \"Chris Evans\", \"$370.6 Million\", 80, 124, 5)";			
//			stmt.executeUpdate(sqlStatement);
//			
//			// Insert sixth row
//			sqlStatement = "INSERT INTO MarvelMovies"+
//					"(MovieTitle,TopBilled, Grossing, RottenTomatoesScore, RunTime, Chronology)" +
//					"VALUES (\"The Avengers\", \"Robert Downey Jr.\", \"$1.519 Billion\", 92, 143, 6)";			
//			stmt.executeUpdate(sqlStatement);
//					
//			
////			// Prepared statement
////			sqlStatement = "INSERT INTO MarvelMovies"+
////			"(MovieTitle,TopBilled, Grossing, RottenTomatoesScore, RunTime, Chronology)" +
////			"VALUES (?, ? , ? , ?, ? , ? )";		
//			
//
//				
//			
//		}catch(Exception e) {System.out.println(e);}
//		finally {
//			System.out.println("Rows added");
//		}
//	}

}
