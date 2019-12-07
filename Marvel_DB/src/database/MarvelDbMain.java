package database;


import java.sql.Connection;
import java.sql.DriverManager;




public class MarvelDbMain {

	 static String tableName = "MarvelMovies";

	 // Insert data 
	 static String[] movies = {"Iron Man", "The Incredible Hulk", "Iron Man 2", "Thor", "Captain America", "The Avengers"};
	 static String[] topBilled = {"Robert Downey Jr", "Edward Norton", "Robert Downey Jr", "Chris Hemsworth", "Chris Evans", "Robert Downey Jr"};
	 static double[] grossingInMill = { 585.2, 263.4, 623.9, 449.3, 370.6, 1290.3};
	 static int[] rottenTomatoesScore = {93, 67, 73, 77, 80, 92};
	 static int[] runtime = {126, 112, 125, 114, 124, 143};
	 static int[] chronology = {1, 2, 3, 4, 5, 6};

	 static Connection conn;


	public static void main(String[] args) throws Exception
	{
		
		conn = getConnection();

		
		
		
		
		// 1) Create Table
		CreateTable tableCreater = new CreateTable(tableName);
		tableCreater.createTable();

		
		// 2) Insert Rows
	
		InsertRows rowInserter = new InsertRows(tableName);

		
		for (int i = 0; i < movies.length; i++) {
			rowInserter.insertData(
						movies[i],
						topBilled[i], 
						grossingInMill[i], 
						rottenTomatoesScore[i], 
						runtime[i], 
						chronology[i]);
		}
			

		// Call four create views
		
		viewAllMovies();
		viewRobertMovies();
		viewMoviesGrossOver500Mil();
		viewMoviesScore80Plus();
		

		
		DropTable tableDropper = new DropTable(tableName);
		tableDropper.drop();
		
	}
	
	
	
	// View all movies
	
	public static void viewAllMovies() {

		String viewName = "all_movies";

		String sqlStatement = "CREATE OR REPLACE VIEW " 
		+ viewName
		+ " AS SELECT MovieTitle, TopBilled, RottenTomatoesScore, Grossing, Runtime, Chronology " 
		+ "FROM MarvelMovies;";
		
		
		MakeViews viewMaker = new MakeViews(viewName, sqlStatement);

		viewMaker.createView();
		viewMaker.printView();
	}
	

	// View Robert Downey Jr. Movies
	
	public static void viewRobertMovies() {

		System.out.println("viewRobertMovies");

		String viewName = "robert_movies";

		String sqlStatement = "CREATE OR REPLACE VIEW "
		+ viewName
		+ " AS SELECT MovieTitle, RottenTomatoesScore, Runtime, Chronology " 
		+ "FROM MarvelMovies "
		+ "WHERE TopBilled = \"Robert Downey Jr\";";


		MakeViews viewMaker = new MakeViews(viewName, sqlStatement);

		viewMaker.createView();
		viewMaker.printView();
	}
	
	
	//View movies that made over 500 million
	
	public static void viewMoviesGrossOver500Mil() {

		String viewName = "gross_movies";

		String sqlStatement = "CREATE OR REPLACE VIEW "
		+ viewName
		+ " AS SELECT MovieTitle, Grossing " 
		+ "FROM MarvelMovies "
		+ "WHERE Grossing > 500;";

		MakeViews viewMaker = new MakeViews(viewName, sqlStatement);

		viewMaker.createView();
		viewMaker.printView();
	}


	// Made movies that got an 80 or better score
	
	public static void viewMoviesScore80Plus() {

		String viewName = "score_movies";

		String sqlStatement = "CREATE OR REPLACE VIEW "
		+ viewName
		+ " AS SELECT MovieTitle, RottenTomatoesScore " 
		+ "FROM MarvelMovies "
		+ "WHERE RottenTomatoesScore >= 80 ;";

		MakeViews viewMaker = new MakeViews(viewName, sqlStatement);
		
		viewMaker.createView();
		viewMaker.printView();
	}

	
	
	
	public static Connection getConnection() throws Exception{
		
			try
			{
				String driver = "com.mysql.cj.jdbc.Driver";
				String db_URL = "jdbc:mysql://localhost:3306/Marvel_DB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=EST";
				
				
				String username= "root";
				String password= "cspassword";
				Class.forName(driver);
				
				Connection conn = DriverManager.getConnection(db_URL,username,password);
				System.out.println("Connection created");
				
				return conn;
				
				
				
			} catch(Exception e) {System.out.println(e);}		
			conn.close();
		return null;
	}
		
}
