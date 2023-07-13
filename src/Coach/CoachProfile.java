package Coach;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import Training.Trainings_Table;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import player.PlayerDataBase;

public class CoachProfile {
	static VBox proVb = new VBox();
		//Get the coach profile information from the database
		public static HBox coach_Form_Database()
		{
			Connection conn = null;
	    	Statement stmt = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
	            stmt = conn.createStatement();
	            
	            String sql = "SELECT FirstName, LastName, Gender, Dob, BloodType, Contract, Nationality, MaritualStatus FROM coach";
	            ResultSet rs = stmt.executeQuery(sql);
	            String fNameDB = null, lNameDB = null, genderDB = null, bloodTypeDB = null, contractDB = null, nationality = null, maritualStatus = null;
				Date dobDB = null;
	            int jerseyDB = 0;
	            
	            while(rs.next()){
	            	fNameDB = rs.getString("FirstName");
	            	lNameDB = rs.getString("LastName");
	            	genderDB = rs.getString("Gender");
	            	dobDB = rs.getDate("Dob");
	            	bloodTypeDB = rs.getString("BloodType");
	            	contractDB = rs.getString("Contract");
	            	nationality = rs.getString("Nationality");
	            	maritualStatus = rs.getString("MaritualStatus");
	                      	
	            }
	        
	           HBox root = coach_Information_List(fNameDB, lNameDB , genderDB, dobDB, bloodTypeDB, contractDB, nationality, maritualStatus);
	            
	            rs.close();
	            stmt.close();
	            conn.close();
	        } 
	        
	        catch(SQLException se) {
	        	se.printStackTrace();
	        }
	        catch(Exception e1) {
	        	e1.printStackTrace();
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
	        
	        return root;
		}
		
		static VBox labelV = new VBox();
		static VBox textField = new VBox();
		static HBox root = new HBox();
		
		static Label fName = new Label("First Name: ");
		static Label lName = new Label("Last Name: ");
		static Label gender = new Label("Gender: ");
		static Label dob = new Label("Date of Birth: ");
		static Label bloodType = new Label("Blood Type: ");
		static Label contract = new Label("Contract Years: ");
		static Label nationalityL = new Label("Nationality: ");
		static Label maritualL = new Label("Maritual Status: ");
		
		//Display coach profile informations
		public static HBox coach_Information_List(String fNameDB, String lNameDB , String genderDB, Date dobDB, String bloodTypeDB, String contractDB, String nationality, String maritualStatus)
		{
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");
			String dateString = dateformat.format(dobDB);
			
			TextField fNameF = new TextField(fNameDB);
			TextField lNameF = new TextField(lNameDB);
			TextField genderF = new TextField(genderDB);
			TextField dobF = new TextField(dateString);
			TextField bloodTypeF = new TextField(bloodTypeDB);
			TextField contractF = new TextField(contractDB);
			TextField nationalityF = new TextField(nationality);
			TextField maritualF = new TextField(maritualStatus);
			
			fNameF.setEditable(false);
			lNameF.setEditable(false);
			genderF.setEditable(false);
			dobF.setEditable(false);
			bloodTypeF.setEditable(false);
			contractF.setEditable(false);
			nationalityF.setEditable(false);
			maritualF.setEditable(false);
			
			Button edit = new Button("Edit");
			
			labelV.getChildren().clear();
			textField.getChildren().clear();
			root.getChildren().clear();
			
			//
			labelV.getChildren().addAll(fName, lName, gender, dob, bloodType, contract, nationalityL, maritualL);
			textField.getChildren().addAll(fNameF, lNameF, genderF, dobF, bloodTypeF, contractF, nationalityF, maritualF);
			root.getChildren().addAll(labelV, textField);

			edit.setMinSize(150, 40);
			
			labelV.setSpacing(15);
			textField.setSpacing(13);
			root.setSpacing(10);
			proVb.getChildren().add(root);
			
			return root;
		}
		
		
}
