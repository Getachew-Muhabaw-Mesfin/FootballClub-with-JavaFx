package player;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.DatePicker;

public class PlayerDataBase {
	public static void insertData(int jersyNum, String fName, String lName, String sex, DatePicker dateP, String bloodType, String playingPosition, String playingFoot, String contractYrs, String userName, String password)
    {
		String Insert = "INSERT INTO Player (JerseyNumber, FirstName, LastName, Gender, Dob, BloodType, Position, Foot, Contract, UserName, Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	Connection conn = null;
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
            PreparedStatement preparedStatement = conn.prepareStatement(Insert);
          
            java.sql.Date date = Date.valueOf(dateP.getValue());
            
            preparedStatement.setInt(1, jersyNum);
            preparedStatement.setString(2, fName);
            preparedStatement.setString(3, lName);
            preparedStatement.setString(4, sex);
            preparedStatement.setDate(5, date);
            preparedStatement.setString(6, bloodType);
            preparedStatement.setString(7, playingPosition);
            preparedStatement.setString(8, playingFoot);
            preparedStatement.setString(9, contractYrs);
            preparedStatement.setString(10, userName);
            preparedStatement.setString(11, password);
            
            preparedStatement.executeUpdate();
        	
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
        	if(conn!=null)
        		conn.close();
        }
        catch(SQLException se) {
        	se.printStackTrace();
        }
}
	
	public static void updateData(int jersyNum, String fName, String lName, String sex, String bloodType, String playingPosition, String playingFoot, String contractYrs, String userName, String password)
    {
		int a = jersyNum;
		String update = "UPDATE player SET JerseyNumber = ?, FirstName = ?, LastName =? , Gender =? , BloodType = ?, Position = ?, Foot = ?, Contract = ?, UserName = ?, Password = ?  WHERE JerseyNumber = ? ";
    	
		Connection conn = null;
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
            PreparedStatement preparedStatement = conn.prepareStatement(update);
           
            preparedStatement.setInt(1, jersyNum);
            preparedStatement.setString(2, fName);
            preparedStatement.setString(3, lName);
            preparedStatement.setString(4, sex);
            preparedStatement.setString(5, bloodType);
            preparedStatement.setString(6, playingPosition);
            preparedStatement.setString(7, playingFoot);
            preparedStatement.setString(8, contractYrs);
            preparedStatement.setString(9, userName);
            preparedStatement.setString(10, password);
            preparedStatement.setInt(11, jersyNum);
           
            preparedStatement.executeUpdate();
            
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
        	if(conn!=null)
        		conn.close();
        }
        catch(SQLException se) {
        	se.printStackTrace();
        }
}
}