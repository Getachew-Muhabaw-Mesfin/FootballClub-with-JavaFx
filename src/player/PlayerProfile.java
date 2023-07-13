package player;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import Training.Trainings_Table;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayerProfile {
	
	static VBox proVb = new VBox();
	static TextField userNameF;
	static PasswordField pass;
	
	//Player profile page
	public static HBox profile(String userName)
	{
		Button display = new Button("Display Profile");
		Button statistics = new Button("Statistical Information");
		Button cardInfo = new Button("Card Information");
		Button training = new Button("Training");
		
		display.setMinSize(200,50);
		statistics.setMinSize(200,50);
		cardInfo.setMinSize(200,50);
		training.setMinSize(200,50);
		
		display.setOnAction(e ->{
			proVb.getChildren().clear();
			player_Form_Database(userName); 	
			
		});
		
		statistics.setOnAction(e ->{
			String currentUser = "Player";
			proVb.getChildren().clear();
			statistics_From_Database(userName, currentUser);
		});
		
		cardInfo.setOnAction(e ->{
			proVb.getChildren().clear();
			cardInfo_From_Database(userName);
		});
		
		training.setOnAction(e ->{
			proVb.getChildren().clear();
			proVb.getChildren().add(Trainings_Table.table());
		});
		
		VBox playerVb = new VBox();
		playerVb.getChildren().addAll(display, statistics, cardInfo, training);
		
		//Set id for vertical box in the player page 
		playerVb.setId("player-profile-vbox");
		
		HBox playerHb = new HBox();
		playerHb.setSpacing(100);
		playerHb.getChildren().addAll(playerVb, proVb);
		
		return playerHb;
	}
	
	//Get the player profile information from the database
	public static HBox player_Form_Database(String userName)
	{
		Connection conn = null;
    	Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
            stmt = conn.createStatement();
            
            String sql = "SELECT JerseyNumber, FirstName, LastName, Gender, Dob, BloodType, Position, Foot, Contract, UserName, Password FROM Player";
            ResultSet rs = stmt.executeQuery(sql);
            String fNameDB = null, lNameDB = null, genderDB = null, bloodTypeDB = null, positionDB = null, footDB = null, contractDB = null, name = null, password = null;
			Date dobDB = null;
            int jerseyDB = 0;
            
            while(rs.next()){
            	if(rs.getString("UserName").compareToIgnoreCase(userName)==0)
            	{
            	jerseyDB = rs.getInt("JerseyNumber");
            	fNameDB = rs.getString("FirstName");
            	lNameDB = rs.getString("LastName");
            	genderDB = rs.getString("Gender");
            	dobDB = rs.getDate("Dob");
            	bloodTypeDB = rs.getString("BloodType");
            	positionDB = rs.getString("Position");
            	footDB = rs.getString("Foot");
            	contractDB = rs.getString("Contract");
            	
            	name = rs.getString("UserName");
            	password = rs.getString("Password");
            	}
                      	
            }
        
           HBox root = players_Information_List(jerseyDB, fNameDB, lNameDB , genderDB, dobDB, bloodTypeDB, positionDB, footDB, contractDB, name, password);
            
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
	static Label jersey = new Label("Jersy Number: ");
	static Label position = new Label("Playing Position: ");
	static Label foot = new Label("Playing Foot: ");
	static Label contract = new Label("Contract Years: ");
	
	//Display player profile informations
	public static HBox players_Information_List(int jerseyDB, String fNameDB, String lNameDB , String genderDB, Date dobDB, String bloodTypeDB, String positionDB, String footDB, String contractDB, String userName, String password)
	{
		//cast jersey to string to insert it in to textfield
		String jerseyString = Integer.toString(jerseyDB);
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");
		String dateString = dateformat.format(dobDB);
		
		TextField fNameF = new TextField(fNameDB);
		TextField lNameF = new TextField(lNameDB);
		TextField genderF = new TextField(genderDB);
		TextField dobF = new TextField(dateString);
		TextField bloodTypeF = new TextField(bloodTypeDB);
		TextField jerseyF = new TextField(jerseyString);
		TextField positionF = new TextField(positionDB);
		TextField footF = new TextField(footDB);
		TextField contractF = new TextField(contractDB);
		
		fNameF.setEditable(false);
		lNameF.setEditable(false);
		genderF.setEditable(false);
		dobF.setEditable(false);
		bloodTypeF.setEditable(false);
		jerseyF.setEditable(false);
		positionF.setEditable(false);
		footF.setEditable(false);
		contractF.setEditable(false);
		
		Button edit = new Button("Edit");
		
		labelV.getChildren().clear();
		textField.getChildren().clear();
		root.getChildren().clear();
		
		//
		labelV.getChildren().addAll(fName, lName, gender, dob, bloodType, jersey, position, foot, contract);
		textField.getChildren().addAll(fNameF, lNameF, genderF, dobF, bloodTypeF, jerseyF, positionF, footF, contractF, edit);
		root.getChildren().addAll(labelV, textField);

		edit.setMinSize(150, 40);
		
		
		//Edit player Information
		edit.setOnAction(e ->{
			Edit_Player_Information(fNameF, lNameF, genderF, bloodTypeF, jerseyF, positionF, footF,contractF, userName, password);
		});
		
		labelV.setSpacing(15);
		textField.setSpacing(13);
		root.setSpacing(10);
		proVb.getChildren().add(root);
		
		return root;
	}
	
	public static void Edit_Player_Information(TextField fNameF, TextField lNameF, TextField genderF, TextField bloodTypeF, TextField jerseyF, TextField positionF, TextField footF, TextField contractF, String userName, String password)
	{
		proVb.getChildren().clear();
		fNameF.setEditable(true);
		lNameF.setEditable(true);
		genderF.setEditable(true);
		bloodTypeF.setEditable(true);
		jerseyF.setEditable(true);
		positionF.setEditable(true);
		footF.setEditable(true);
		contractF.setEditable(true);
		
		Button save = new Button("Save");
		save.setMinSize(150, 40);
		
		labelV.getChildren().clear();
		textField.getChildren().clear();
		root.getChildren().clear();
		
		labelV.getChildren().addAll(fName, lName, gender, bloodType, jersey, position, foot, contract);
		textField.getChildren().addAll(fNameF, lNameF, genderF, bloodTypeF, jerseyF, positionF, footF, contractF, save);
		root.getChildren().addAll(labelV, textField);
		
		labelV.setSpacing(22);
		textField.setSpacing(13);
		root.setSpacing(10);
		proVb.getChildren().add(root);
		
		save.setOnAction(e ->{
			String jerseyS = jerseyF.getText();
			String fNameS = fNameF.getText();
			String lNameS = lNameF.getText();
			String sex = genderF.getText();
            String bloodType = bloodTypeF.getText();
            String playingPositionSt = positionF.getText();
            String footSt = footF.getText();
			String contractYrs = contractF.getText();
			int jerseyInt = Integer.parseInt(jerseyS);
			PlayerDataBase.updateData(jerseyInt, fNameS, lNameS, sex, bloodType , playingPositionSt, footSt, contractYrs, userName, password);
			
			player_Form_Database(userName);
			
	
		});

	}
	
	//Get players statical and performance information from the database
	public static VBox statistics_From_Database(String userName, String currentUser)
	{
		VBox vb = new VBox();
		
		Connection conn = null;
    	Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
            stmt = conn.createStatement();
            
            String sql = "SELECT Physical, Mental, Attacking, Speed, Defending, Technical, Weight, Height, UserName FROM Player";
            ResultSet rs = stmt.executeQuery(sql);
 
            int physical = 0, mental = 0, attacking = 0, speed = 0, defending = 0, technical = 0;
            float weight = 0, height = 0;
     
            while(rs.next()){
            	if(rs.getString("UserName").compareToIgnoreCase(userName)==0)
            	{
            		
            	physical = rs.getInt("Physical");
            	mental = rs.getInt("Mental");
            	attacking = rs.getInt("Attacking");
            	speed = rs.getInt("Speed");
            	defending = rs.getInt("Defending");
            	technical = rs.getInt("Technical");
            	weight = rs.getFloat("Weight");
            	height = rs.getFloat("Height");
            	

            	}
                      	
            }
           vb = statistics(physical, mental, attacking, speed, defending, technical, weight, height, currentUser, userName);
            
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
        
        return vb;
	}
	
	//Display player's statical and perfomance informations
	public static VBox statistics(int physical, int mental, int attacking, int speed, int defending, int technical, float weight, float height, String currentUser, String userName)
	{
		String physicalSt, mentalSt, attackingSt, speedSt, defendingSt, technicalSt, weightSt, heightSt;
		
		Text stat = new Text("Player Statistical Information");
		stat.setFont(Font.font("Bell MT",30));
		Pane pane = new Pane();
		pane.getChildren().add(stat);
		
		Label physicalLabel = new Label("Physical: ");
		Label mentalLabel = new Label("Mental: ");
		Label attackingLabel = new Label("Attacking: ");
		Label speedLabel = new Label("Speed: ");
		Label defendingLabel = new Label("Defending: ");
		Label technicalLabel = new Label("Technical: ");
		Label weightLabel = new Label("Weight: ");
		Label heightLabel = new Label("Height: ");
		
		physicalSt = Integer.toString(physical);
		mentalSt = Integer.toString(mental);
		attackingSt = Integer.toString(attacking);
		speedSt = Integer.toString(speed);
		defendingSt = Integer.toString(defending);
		technicalSt = Integer.toString(technical);
		weightSt = Float.toString(weight);
		heightSt = Float.toString(height);
		
		TextField physicalField = new TextField(physicalSt);
		TextField mentalField = new TextField(mentalSt);
		TextField attackingField = new TextField(attackingSt);
		TextField speedField = new TextField(speedSt);
		TextField defendingField = new TextField(defendingSt);
		TextField technicalField = new TextField(technicalSt);
		TextField weightField = new TextField(weightSt);
		TextField heightField = new TextField(heightSt);

        if(currentUser.compareToIgnoreCase("Coach")==0) {
        	physicalField.setEditable(true);
    		mentalField.setEditable(true);
    		attackingField.setEditable(true);
    		speedField.setEditable(true);
    		defendingField.setEditable(true);
    		technicalField.setEditable(true);
    		weightField.setEditable(true);
    		heightField.setEditable(true);
    		
        }
        else
        {
		physicalField.setEditable(false);
		mentalField.setEditable(false);
		attackingField.setEditable(false);
		speedField.setEditable(false);
		defendingField.setEditable(false);
		technicalField.setEditable(false);
		weightField.setEditable(false);
		heightField.setEditable(false);
        }
		
		//
		VBox labelV = new VBox();
		VBox textField = new VBox();
		HBox hb = new HBox();
		VBox root = new VBox();
		
		labelV.getChildren().addAll(physicalLabel, mentalLabel, attackingLabel, speedLabel, defendingLabel, technicalLabel, weightLabel, heightLabel);
		textField.getChildren().addAll(physicalField, mentalField, attackingField, speedField, defendingField, technicalField, weightField, heightField);
		hb.getChildren().addAll(labelV, textField);
		root.getChildren().addAll(pane,hb);
		
		 if(currentUser.compareToIgnoreCase("Coach")==0) {
			 
			 Button save = new Button("Save");
			 save.setMinSize(150, 40);
			 root.getChildren().add(save);
			 
			 save.setOnAction(e ->{
				// String ph = 
				 int physicalInt = Integer.parseInt(physicalField.getText()) ;
				 int mentalInt = Integer.parseInt(mentalField.getText()) ;
				 int attackingInt = Integer.parseInt(attackingField.getText()) ;
				 int speedInt = Integer.parseInt(speedField.getText()) ;
				 int defendingInt = Integer.parseInt(defendingField.getText()) ;
				 int technicalInt = Integer.parseInt(technicalField.getText()) ;
				 float weightFloat = Float.parseFloat(weightField.getText()) ;
				 float heightFloat = Float.parseFloat(heightField.getText()) ;
				 
				 updateStatistics(physicalInt, mentalInt, attackingInt, speedInt, defendingInt, technicalInt, weightFloat, heightFloat, userName);
			 });
		 }
		
		labelV.setSpacing(15);
		textField.setSpacing(13);
		hb.setSpacing(10);

		hb.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		proVb.getChildren().add(root);
		
		return root;
	}
	
	public static void updateStatistics(int physical, int mental, int attacking, int speed, int defending, int technical, float weight, float height, String userName)
	{

		String update = "UPDATE player SET Physical = ?, Mental = ?, Attacking =? , Speed =? , Defending = ?, Technical = ?, Weight = ?, Height = ?  WHERE userName = ? ";
    	
		Connection conn = null;
 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
            PreparedStatement preparedStatement = conn.prepareStatement(update);
           
            preparedStatement.setInt(1, physical);
            preparedStatement.setInt(2, mental);
            preparedStatement.setInt(3, attacking);
            preparedStatement.setInt(4, speed);
            preparedStatement.setInt(5, defending);
            preparedStatement.setInt(6, technical);
            preparedStatement.setFloat(7, weight);
            preparedStatement.setFloat(8, height);
            preparedStatement.setString(9, userName);
           
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
	
	//Get players card(yellow or re) information from the database
		public static void cardInfo_From_Database(String userName)
		{
			Connection conn = null;
	    	Statement stmt = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
	            stmt = conn.createStatement();
	            
	            String sql = "SELECT Yellow, Red, UserName FROM Player";
	            ResultSet rs = stmt.executeQuery(sql);
	 
	            int yellow = 0, red = 0;
	     
	            while(rs.next()){
	            	if(rs.getString("UserName").compareToIgnoreCase(userName)==0)
	            	{
	            		
	            	yellow = rs.getInt("Yellow");
	            	red = rs.getInt("Red");
	            	}
	                      	
	            }
	            card_Info(yellow, red);
	            
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
		}
		
		//Display player's card informations
		public static void card_Info(int yellow, int red)
		{
			Text stat = new Text("Player Card Information");
			stat.setFont(Font.font("Bell MT",30));
			Pane pane = new Pane();
			pane.getChildren().add(stat);
			
			String yellowCard, redCard;
			
			Label yellowLabel = new Label("Yellow: ");
			Label redLabel = new Label("Red: ");
			
			yellowCard = Integer.toString(yellow);
			redCard = Integer.toString(red);
			
			TextField yellowField = new TextField(yellowCard);
			TextField redField = new TextField(redCard);
			
			yellowField.setEditable(false);
			redField.setEditable(false);
			
			//
			VBox labelV = new VBox();
			VBox textField = new VBox();
			HBox root = new HBox();
			
			labelV.getChildren().addAll(yellowLabel, redLabel);
			textField.getChildren().addAll(yellowField, redField);
			root.getChildren().addAll(labelV, textField);
			
			labelV.setSpacing(22);
			textField.setSpacing(13);
			root.setSpacing(10);
			proVb.getChildren().addAll(pane, root);
		}
	
}
