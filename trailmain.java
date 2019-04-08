package trailing;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class trailmain{

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
ddlparserjunk obj1=new ddlparserjunk();
	System.out.println("Enter a db name from the below list:");
	try{
	ArrayList<String> db_names=obj1.get_db();
	for(String i:db_names)
	{
		System.out.println(i);
	}
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	 
    Scanner in = new Scanner(System.in); 
    String choicedb=in.next();
    	System.out.println("These are the tables in the database: "+choicedb);
		
    	try{
    		ArrayList<String> table_names=obj1.get_tables(choicedb);
    		for(String i:table_names)
    		{
    			System.out.println(i);
    		}
    	} catch (ClassNotFoundException | SQLException e)
    	{
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	System.out.println("select the table from the list to see the description");
    	 Scanner in1 = new Scanner(System.in); 
    	    String choicetable=in1.next();
    	   try {
    		   //System.out.println(obj1.get_tables(choicetable));
    		   System.out.println(obj1.execution(choicedb,choicetable));
 
				
    		   
    		  
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				try
				{
				new excel().write_to_excel(obj1.execution(choicedb,choicetable));
				//new junkexcel().writeExcel(obj1.execution(choicedb,choicetable));
				}
				catch(IOException e1)
				{
					System.out.println("");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			
    	  
    	   
    }




