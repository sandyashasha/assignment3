package descddl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class Mainfunction extends Executionstep{



	public static void main(String args[]){ 	
		 Executionstep obj1=new Executionstep();
	System.out.println("There are following three databases");
	 System.out.println("1.MySql");
	 System.out.println("2.Sqlite");
	 System.out.println("3.Oracle");
	 System.out.println();
	 System.out.println("Please enter your Choices...");
	 Scanner in = new Scanner(System.in); 
	         int choice = in.nextInt();
	         switch(choice)
	         {
	         case 1:
	         System.out.println("You have Selected Database MySql");
	      
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
	     } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     	 
	         Scanner in1 = new Scanner(System.in); 
	         String choicedb=in1.next();
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
	         	 Scanner in2 = new Scanner(System.in); 
	         	    String choicetable=in2.next();
	         	   try {   
	         		   System.out.println(obj1.execution1(choicedb,choicetable));		  
	     			} catch (SQLException e) {
	     				// TODO Auto-generated catch block
	     				e.printStackTrace();
	     			} catch (Exception e) {
	     				// TODO Auto-generated catch block
	     				e.printStackTrace();
	     			}
	     				try
	     				{
	     				new Excel().write_to_excel(obj1.execution1(choicedb,choicetable));
	     				
	     				}
	     				catch(IOException e1)
	     				{
	     					System.out.println("");
	     				} catch (Exception e) {
	     					// TODO Auto-generated catch block
	     					e.printStackTrace();
	     				}
	     				break;
	     				         
	
case 2:
	 System.out.println("You have Selected Database Sqlite3");
 	System.out.println("Enter a db name from the below list:");
 	try{
 	ArrayList<String> db_names=obj1.get_dblite();
 	for(String i:db_names)
 	{
 		System.out.println(i);
 	}
 } catch (ClassNotFoundException | SQLException e) {
 	// TODO Auto-generated catch block
 	e.printStackTrace();
 }
 	 
     Scanner in3 = new Scanner(System.in); 
     String choicedblite=in3.next();
     	System.out.println("These are the tables in the database: "+choicedblite);
 		
     	try{
     		ArrayList<String> table_names=obj1.get_tableslite(choicedblite);
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
     	 Scanner in4 = new Scanner(System.in); 
     	    String choicetablelite=in4.next();
     	   try {   
     		   System.out.println(obj1.execution2(choicedblite,choicetablelite));		  
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 				try
 				{
 				new Excel().write_to_excel(obj1.execution2(choicedblite,choicetablelite));
 				
 				}
 				catch(IOException e1)
 				{
 					System.out.println("");
 				} catch (Exception e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 				break;
	         
 		
	         case 3:
	        	 System.out.println("You have Selected Database Oracle");
	 	     	System.out.println("Enter a db name from the below list:");
	 	     	try{
	 	     	ArrayList<String> db_names=obj1.get_dboracle();
	 	     	for(String i:db_names)
	 	     	{
	 	     		System.out.println(i);
	 	     	}
	 	     } catch (ClassNotFoundException | SQLException e) {
	 	     	// TODO Auto-generated catch block
	 	     	e.printStackTrace();
	 	     } catch (Exception e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}	 	     	 
	 	         Scanner in11 = new Scanner(System.in); 
	 	         String choicedb1=in11.next();
	 	         	System.out.println("These are the tables in the database: "+choicedb1);     		
	 	         	try{
	 	         		ArrayList<String> table_names=obj1.get_tablesoracle(choicedb1);
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
	 	         	 Scanner in21 = new Scanner(System.in); 
	 	         	    String choicetable1=in21.next();
	 	         	   try {   
	 	         		   System.out.println(obj1.execution3(choicedb1,choicetable1));		  
	 	     			} catch (SQLException e) {
	 	     				// TODO Auto-generated catch block
	 	     				e.printStackTrace();
	 	     			} catch (Exception e) {
	 	     				// TODO Auto-generated catch block
	 	     				e.printStackTrace();
	 	     			}
	 	     				try
	 	     				{
	 	     				new Excel().write_to_excel(obj1.execution3(choicedb1,choicetable1));
	 	     				
	 	     				}
	 	     				catch(IOException e1)
	 	     				{
	 	     					System.out.println("");
	 	     				} catch (Exception e) {
	 	     					// TODO Auto-generated catch block
	 	     					e.printStackTrace();
	 	     				}
	 	     				break;
	 	     				         
     
	
}
	}
}

	
	
	