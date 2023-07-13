package Training;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TrainingDataBase {
	
	public static int trainingId() {
		
		int trainingId = 0;
		Connection conn = null;
    	Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
            stmt = conn.createStatement();
            
            String db = "SELECT Training_ID FROM training";
            
            ResultSet rs = stmt.executeQuery(db);
 
            while(rs.next()){
             
            	trainingId = rs.getInt("Training_ID");
                      	
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
		
		return trainingId;
	}
	
	public static void insertData(String type, String date, String time, float duration, String address)
    {
		String Insert = "INSERT INTO training (Training_ID, Type, Date, Time, Duration, Address) VALUES (?, ?, ?, ?, ?, ?)";
    	Connection conn = null;
    	//LocalDate date = dateOfB.getValue();
    	//Date date = Date.valueOf(dateOfB.getValue());//Change and cast the type of date
    	
    	int trainingId = 1 + trainingId();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
            PreparedStatement preparedStatement = conn.prepareStatement(Insert);
            
            preparedStatement.setInt(1, trainingId);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, time);
            preparedStatement.setFloat(5, duration);
            preparedStatement.setString(6, address);
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
	
//update
}