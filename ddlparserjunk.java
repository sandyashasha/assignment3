package trailing;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ddlparserjunk {
	static int size=0;
public ArrayList<String> get_db() throws ClassNotFoundException, SQLException
{
 ArrayList<String> db_names=new ArrayList<>();
 Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useSSL=false","root","root");  
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
  Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db_name+"?useSSL=false","root","root");  
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("show tables");  
        while(rs.next()) 
        {
         table_names.add(rs.getString(1));
        }
        
       return table_names;  
}


public ArrayList execution(String db_name,String table_name) throws Exception

{
Class.forName("com.mysql.cj.jdbc.Driver");  
ResultSet rsColumns = null;
//ResultSet rs = null;
Connection conn = getMySqlConnection();
//System.out.println("Got Connection.");
Statement st = conn.createStatement();
DatabaseMetaData meta = conn.getMetaData();
rsColumns = meta.getColumns(null, null, table_name, null);
//ResultSet rsPK = meta.getPrimaryKeys(null, null, table_name);
//ResultSet PK = meta.getPrimaryKeys(null,null, table_name);

//ResultSet FK = meta.getImportedKeys(null, null, table_name);
//while(FK.next())
//{
//    System.out.println(FK.getString("PKTABLE_NAME") + "---" + FK.getString("PKCOLUMN_NAME") + "===" + FK.getString("FKTABLE_NAME") + "---" + FK.getString("FKCOLUMN_NAME"));
//    //exe.add(FK.getString("PKTABLE_NAME") + "---" + FK.getString("PKCOLUMN_NAME") + "===" + FK.getString("FKTABLE_NAME") + "---" + FK.getString("FKCOLUMN_NAME"));
//    
//}
/*ArrayList x1=new ArrayList<>();
x1.add("field");
x1.add("Datatype");*/
ArrayList x=new ArrayList<>();
//x.add(x1);
while (rsColumns.next()) {
	ArrayList exe=new ArrayList<>();
	/*while(PK.next())
	{
	  //System.out.println(PK.getString("COLUMN_NAME") + "===" + PK.getString("PK_NAME"));
	  exe.add(PK.getString("PK_NAME"));
	}*/
	
	
	// exe.add(PK.getString("PK_NAME"));
	  //  exe.add(FK.getString("PKTABLE_NAME") + "---" + FK.getString("PKCOLUMN_NAME") + "===" + FK.getString("FKTABLE_NAME") + "---" + FK.getString("FKCOLUMN_NAME"));
	int position = rsColumns.getInt("ORDINAL_POSITION");
	 exe.add(position);
	String columnName = rsColumns.getString("COLUMN_NAME");
	exe.add(rsColumns.getString("COLUMN_NAME"));
	/*while(PK.next())
	{
	  //System.out.println(PK.getString("COLUMN_NAME") + "===" + PK.getString("PK_NAME"));
	  exe.add(PK.getString("PK_NAME"));
	}*/
	 // System.out.println("column name=" + columnName);
	  String columnType = rsColumns.getString("TYPE_NAME");
	  exe.add( rsColumns.getString("TYPE_NAME"));
	//  System.out.println("type:" + columnType);
	  size = rsColumns.getInt("COLUMN_SIZE");
	  exe.add(size);
	 // System.out.println("size:" + size);
    //String columnName = rsColumns.getString("COLUMN_NAME");
    //String columnType = rsColumns.getString("TYPE_NAME");
    //int columnSize = rsColumns.getInt("COLUMN_SIZE");
    
    //System.out.println(columnName+" - " + columnType + "(" + columnSize + ")");
    //String decimaldigits = rsColumns.getString("DECIMAL_DIGITS");
    //System.out.println("decimaldigits:" + decimaldigits); 
    String isNullable = rsColumns.getString("IS_NULLABLE");
    exe.add(isNullable);
  //  System.out.println("isNullable:" + isNullable); 
    //String is_autoIncrment = rsColumns.getString("IS_AUTOINCREMENT");
    //System.out.println("is_autoIncrment:" + is_autoIncrment); 
    
int nullable = rsColumns.getInt("NULLABLE");
  if (nullable == DatabaseMetaData.columnNullable) {
   // System.out.println("nullable true");
  } else {
    //System.out.println("nullable false");
  }
  
 // System.out.println("column order:" + position);  
 // System.out.println("fhfghfghf");
  //DatabaseMetaData meta = conn.getMetaData();

x.add(exe);

}



return x;  
}






public static Connection getMySqlConnection() throws Exception {
    String driver ="com.mysql.jdbc.Driver";
    //System.out.println("enter db");
    //Scanner in = new Scanner(System.in); 
    //String choicedb=in.next();
    String url =  "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
    String username = "root";
    String password = "root";

    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }




private static Connection getHSQLConnection() throws Exception {
    Class.forName("org.hsqldb.jdbcDriver");
   // System.out.println("Driver Loaded.");
    String url = "jdbc:hsqldb:data/tutorial";
    return DriverManager.getConnection(url, "sa", "");
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

           
         
  



