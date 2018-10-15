/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rems;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Anandhu Anil
 */
public class dbclaz {
    Connection con=null;
	public static java.sql.Connection dbConnector()
	{
	try
	{Class.forName("com.mysql.jdbc.Driver");  
        java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reminder2","root","");  
	 System.out.println( "Connection is Successfull");
	return con;
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
	}
}
