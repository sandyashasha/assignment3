package descddl;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Executionstep {

	static String db;
  
static int size=0;
public ArrayList<String> get_db() throws Exception
{
 ArrayList<String> db_names=new ArrayList<>();
 Class.forName("com.mysql.cj.jdbc.Driver");  
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false","root","root");  
 //Connection conn= getMySqlConnection();
 Statement stmt=con.createStatement();
 ResultSet rs=stmt.executeQuery("show databases");  
        while(rs.next()) 
        {
         db_names.add(rs.getString(1));
        }
 return db_names;
}

public ArrayList<String> get_tables(String db_name) throws ClassNotFoundException, SQLException
{
 ArrayList<String> table_names=new ArrayList<>(); 
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db_name+"?useSSL=false","root","root");  
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("show tables");  
        while(rs.next()) 
        {
         table_names.add(rs.getString(1));
        }
        
       return table_names;  
}


public ArrayList<String> get_dblite() throws ClassNotFoundException, SQLException
{
 ArrayList<String> db_names=new ArrayList<>(); 
       String db1name= "book";
       String db2name="db2";
       db_names.add(db1name);
       db_names.add(db2name);      
 return db_names;
}



public ArrayList<String> get_tableslite(String db_name) throws ClassNotFoundException, SQLException
{
 ArrayList<String> table_names=new ArrayList<>();
 Class.forName("org.sqlite.JDBC");
 String url ="jdbc:sqlite:C:/Users/sandya.nandakumar/"+db_name+".db";

 Connection con = DriverManager.getConnection(url);
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT name FROM sqlite_master WHERE type ='table'");  
        while(rs.next()) 
        {
         table_names.add(rs.getString(1));
        }
        
       return table_names;  
}

public ArrayList<String> get_dboracle() throws Exception
{
 ArrayList<String> db_names=new ArrayList<>();
 Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:caspian","root1","root1");
 Statement stmt=conn.createStatement();
 ResultSet rs=stmt.executeQuery("show databases");  
        while(rs.next()) 
        {
         db_names.add(rs.getString(1));
        }
 return db_names;
}

public ArrayList<String> get_tablesoracle(String db_name) throws ClassNotFoundException, SQLException
{
 ArrayList<String> table_names=new ArrayList<>(); 
  
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:caspian","root1","root1");
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("show tables");  
        while(rs.next()) 
        {
         table_names.add(rs.getString(1));
        }
        
       return table_names;  
}



public ArrayList execution1(String db_name,String table_name) throws Exception
{
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name + "?useSSL=false", "root",
		"root");
Statement stmt=conn.createStatement();  
ResultSet rs=stmt.executeQuery("DESC " +table_name);  
ArrayList x=new ArrayList<> ();
while(rs.next()) {
ArrayList exe =new ArrayList<> ();	
exe.add(rs.getString(1));
exe.add(rs.getString(2));
exe.add(rs.getString(3));
if(rs.getString(4).equals("MUL"))
{
exe.add("foreignkey");
}
else if(rs.getString(4).equals("PRI"))
{
exe.add("primarykey");
}
else
{
exe.add("default");
}
if(rs.getString(5)== null)
{
exe.add("-"); 
}
else
{
	exe.add(rs.getString(5));
}
if(rs.getString(6)== null)
{
	exe.add("-");  
}
else
{
	exe.add(rs.getString(6));  
}
x.add(exe);
}
return x;  
}


public ArrayList execution2(String db_name,String table_name) throws Exception, SQLException
{
	 Class.forName("org.sqlite.JDBC");
	 String url = "jdbc:sqlite:C:/Users/sandya.nandakumar/"+db_name+".db";

	 Connection con = DriverManager.getConnection(url);
	  Statement stmt  = con.createStatement();
      
 String sql="pragma table_info" +(table_name);
 String sql1="select * from Authors";
     ResultSet rs    = stmt.executeQuery(sql);  
     ArrayList x = new ArrayList<>();

        
         while (rs.next()) {
        	 ArrayList exe = new ArrayList<>();
             exe.add(rs.getString(1));
             exe.add(rs.getString(2));
          
             x.add(exe);
         }


	return x;
	
}


public ArrayList execution3(String db_name,String table_name) throws Exception
{
Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:caspian","root1","root1");
	Statement stmt=conn.createStatement();  
ResultSet rs=stmt.executeQuery("DESC " +table_name);  
ArrayList x=new ArrayList<> ();
while(rs.next()) {
ArrayList exe =new ArrayList<> ();	
exe.add(rs.getString(1));
exe.add(rs.getString(2));
exe.add(rs.getString(3));
if(rs.getString(4).equals("MUL"))
{
exe.add("foreignkey");
}
else if(rs.getString(4).equals("PRI"))
{
exe.add("primarykey");
}
else
{
exe.add("default");
}
if(rs.getString(5)== null)
{
exe.add("-"); 
}
else
{
	exe.add(rs.getString(5));
}
if(rs.getString(6)== null)
{
	exe.add("-");  
}
else
{
	exe.add(rs.getString(6));  
}
x.add(exe);
}
return x;  
}




         
  



public static Connection getMySqlConnection() throws Exception {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url ="jdbc:mysql://localhost:3306/jdbc?useSSL=false";
	String username = "root";
	String password = "root";
	Class.forName(driver);
	Connection conn = DriverManager.getConnection(url, username, password);
	return conn;
}







private static Connection getSqliteConnection() throws Exception {

	System.out.println("enter the db name from below :");
	ArrayList<String> db_names = new ArrayList<>();
	db_names.add("emp");
	db_names.add("book");
	for (String i : db_names) {
		System.out.println(i);
	}
	Scanner input = new Scanner(System.in);
	 db = input.next();
	String url = "jdbc:sqlite:C:/Users/sandya.nandakumar/"+db+".db";	
	Connection conn = DriverManager.getConnection(url);

	return conn;
}


public static Connection getOracleConnection() throws Exception {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:caspian";
	String username = "mp";
	String password = "mp2";
	Class.forName(driver); // load Oracle driver
	Connection conn = DriverManager.getConnection(url, username, password);
	return conn;
}

}





