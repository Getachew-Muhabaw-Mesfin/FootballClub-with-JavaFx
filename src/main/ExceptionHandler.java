package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import player.PlayerModel;

public class ExceptionHandler {//In this class all methods needed for validation and exception handling are found we only need to call them.
	int choice;
	
	final static Tooltip tooltip = new Tooltip();
	
	public static void expSt(TextField textField, Stage primaryStage)//checks if the inserted data is valid alphabetic character or not. No space is needed.
	{
		textField.setTooltip(tooltip);
		tooltip.setStyle("-fx-background-color: yellow; -fx-text-fill: red; -fx-font-size: 15px; -fx-font-family: 'Arial Black';");

		textField.setOnKeyTyped(e ->{
			 char arr[]=new char[textField.getText().length()];
				for(int j=0; j<textField.getText().length(); j++)
					{
					arr[j]=textField.getText().charAt(j);
				    int a=(int)arr[j];
				      if(a==32)
				      {
				    	  tooltip.setText("No is space needed");
				    show_Tooltip(textField, tooltip, primaryStage);
				      }
				      else if((a<65 || a>90)&&(a<97 || a>122))
				      {
				    	  tooltip.setText("invalid input");
					      show_Tooltip(textField, tooltip, primaryStage);
				      }
				      else
				    	  tooltip.hide();
					}	

		});
	}
 
	public static void intCheck(TextField textField, Stage primaryStage)//checks if the inserted data is an integer or not
	    {
		textField.setTooltip(tooltip);
		tooltip.setStyle("-fx-background-color: yellow; -fx-text-fill: red; -fx-font-size: 15px; -fx-font-family: 'Arial Black';");

		textField.setOnKeyTyped(e ->{
		char arr[]=new char[textField.getText().length()];
		for(int j=0; j<textField.getText().length(); j++)
			{
			arr[j]=textField.getText().charAt(j);
		    int a=(int)arr[j];
		      if(a==32)
		      {
		    	  tooltip.setText("No is space needed");
		    show_Tooltip(textField, tooltip, primaryStage);
		      }
		      else if(a<48 || a>57)
		      {
		    	  tooltip.setText("enter a number");
			      show_Tooltip(textField, tooltip, primaryStage);
		      }
		      else
		    	  tooltip.hide();
			}	
			
	});
		
	    }
	
	public static boolean jerseyCheck(int jersey)//checks if the inserted jersey number is unique or not 
	{
		Boolean bool = false;
		int count = 0;
		Connection conn = null;
    	Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
            stmt = conn.createStatement();
            
            String sql = "SELECT JerseyNumber FROM Player";
            ResultSet rs = stmt.executeQuery(sql);
 
            while(rs.next()){
    				if(jersey==rs.getInt("JerseyNumber"))		
    					count++;
            }
            if(count == 0)
            	bool = true;
            
            rs.close();
            stmt.close();
            conn.close();
        } 
        
        catch(SQLException se) {
        	se.printStackTrace();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally
        {
    }
        try {
        	if(stmt!= null)
        		stmt.close();
        }
        catch(SQLException se2) {
        	
        }
        try {
        	if(conn!=null)
        		conn.close();
        }
        catch(SQLException se) {
        	se.printStackTrace();
        }
	
		return bool;
	}
	
	public static boolean userNameCheck(String userName)//checks if username is duplicate
	{
		Boolean bool = false;
		int count = 0;
		Connection conn = null;
    	Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
            stmt = conn.createStatement();
            
            String sql = "SELECT UserName FROM Player";
            ResultSet rs = stmt.executeQuery(sql);
 
            while(rs.next()){
    				if(userName.compareToIgnoreCase(rs.getString("UserName")) == 0)		
    					count++;
            }
            if(count == 0)
            	bool = true;
            
            rs.close();
            stmt.close();
            conn.close();
        } 
        
        catch(SQLException se) {
        	se.printStackTrace();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally
        {
    }
        try {
        	if(stmt!= null)
        		stmt.close();
        }
        catch(SQLException se2) {
        	
        }
        try {
        	if(conn!=null)
        		conn.close();
        }
        catch(SQLException se) {
        	se.printStackTrace();
        }
	
		return bool;
	}
	
	public static void duplicate(TextField textField, Stage primaryStage) // when jersey number or user name is duplicate
	{
		textField.setTooltip(tooltip);
		tooltip.setStyle("-fx-background-color: yellow; -fx-text-fill: red; -fx-font-size: 15px; -fx-font-family: 'Arial Black';");
		tooltip.setText("duplicate entry");
	    show_Tooltip(textField, tooltip, primaryStage);
	    textField.setOnKeyTyped(e ->{
	    	tooltip.hide();
	    });
	}
	
	public static Boolean passwordCheck(String password)//check if the password if valid length
	{
		Boolean bool = true;
		if(password.length()<4)
			bool = false;
		
			return bool;
	}
	
	public static void invalidLength(TextField textField, Stage primaryStage)// when the user inserts invalid length of password
	{
		textField.setTooltip(tooltip);
		tooltip.setStyle("-fx-background-color: yellow; -fx-text-fill: red; -fx-font-size: 15px; -fx-font-family: 'Arial Black';");
		tooltip.setText("password length mustn't be less than 4");
	    show_Tooltip(textField, tooltip, primaryStage);
	    textField.setOnKeyTyped(e ->{
	    	tooltip.hide();
	    });
	}
	public static boolean loginCheck(String userName, String password)//checks if the inserted user name and password is correct or not 
	{
		Boolean bool = false;
		int count = 0;
		Connection conn = null;
    	Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
            stmt = conn.createStatement();
            
            String sql = "SELECT UserName, Password FROM Player";
            ResultSet rs = stmt.executeQuery(sql);
 
            while(rs.next()){
    				if(userName.compareToIgnoreCase(rs.getString("UserName")) == 0)		
    					if(password.compareTo(rs.getString("Password"))==0)
    						bool = true;
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } 
        
        catch(SQLException se) {
        	se.printStackTrace();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally
        {
    }
        try {
        	if(stmt!= null)
        		stmt.close();
        }
        catch(SQLException se2) {
        	
        }
        try {
        	if(conn!=null)
        		conn.close();
        }
        catch(SQLException se) {
        	se.printStackTrace();
        }
	
		return bool;
	}
	
	public static void incorrect(TextField textField, Stage primaryStage)// when the user inserts incorrect user name or password
	{
		textField.setTooltip(tooltip);
		tooltip.setStyle("-fx-background-color: yellow; -fx-text-fill: red; -fx-font-size: 15px; -fx-font-family: 'Arial Black';");
		tooltip.setText("incorrect user name or password");
	    show_Tooltip(textField, tooltip, primaryStage);
	    textField.setOnKeyTyped(e ->{
	    	tooltip.hide();
	    });
	}

    public static void show_Tooltip(TextField txt, Tooltip t, Stage primaryStage)
	{
		javafx.geometry.Point2D pt = txt.localToScene(txt.getBoundsInLocal().getMaxX(), txt.getBoundsInLocal().getMaxY());
		t.show(txt, pt.getX()+primaryStage.getScene().getX()+primaryStage.getScene().getX()+1,pt.getY());
	}

}
