/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author oXCToo
 */
public class PlayerTable {
	
	
	private static TableView<PlayerModel> table;

	public static TableView<PlayerModel> table()
	{
		table = new TableView<>();
		TableColumn<PlayerModel, Number> player_jersy = new TableColumn<>("Jersy"); 
		player_jersy.setPrefWidth(150);
		player_jersy.setCellValueFactory(cellData -> cellData.getValue().getJersyNumber());
		table.getColumns().add(player_jersy);
		
		TableColumn<PlayerModel, String> player_Name = new TableColumn<>("Full Name"); 
		player_Name.setPrefWidth(150);
		player_Name.setCellValueFactory(cellData -> cellData.getValue().getFullName());
		table.getColumns().add(player_Name);
		
		TableColumn<PlayerModel, String> gender = new TableColumn<>("Gender"); 
		gender.setPrefWidth(150);
		gender.setCellValueFactory(cellData -> cellData.getValue().getGender());
		table.getColumns().add(gender);
		
		TableColumn<PlayerModel, String> dob = new TableColumn<>("Date of Birth"); 
		dob.setPrefWidth(150);
		dob.setCellValueFactory(cellData -> cellData.getValue().getDob());
		table.getColumns().add(dob);
		
		TableColumn<PlayerModel, String> bloodType = new TableColumn<>("Blood Type"); 
		bloodType.setPrefWidth(150);
		bloodType.setCellValueFactory(cellData -> cellData.getValue().getBloodType());
		table.getColumns().add(bloodType);
		
		TableColumn<PlayerModel, String> position = new TableColumn<>("Position"); 
		position.setPrefWidth(150);
		position.setCellValueFactory(cellData -> cellData.getValue().getPosition());
		table.getColumns().add(position);
		
		TableColumn<PlayerModel, String> foot = new TableColumn<>("Playing Foot"); 
		foot.setPrefWidth(150);
		foot.setCellValueFactory(cellData -> cellData.getValue().getFoot());
	    table.getColumns().add(foot);
	    
	    TableColumn<PlayerModel, String> contract = new TableColumn<>("Contract years"); 
		contract.setPrefWidth(150);
		contract.setCellValueFactory(cellData -> cellData.getValue().getContract());
	    table.getColumns().add(contract);
	    
	    table.setItems(getInfo());
	    table.setPrefHeight(Integer.min(1000, 650));
	    
	    return table;
	}
    public static ObservableList<PlayerModel> db(ObservableList<PlayerModel> playerInfo)
    {
    	Connection conn = null;
    	Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
            stmt = conn.createStatement();
            
            String sql = "SELECT JerseyNumber, FirstName, LastName, Gender, Dob, BloodType, Position, Foot, Contract FROM Player";
            ResultSet rs = stmt.executeQuery(sql);
 
            while(rs.next()){
            	String  name, gender, dob, bloodType, position, foot, contract;
            	int jersey;
            	jersey = rs.getInt("JerseyNumber");
            	name = rs.getString("FirstName") + " " + rs.getString("LastName");
            	gender = rs.getString("Gender");
            	dob = rs.getString("Dob");
            	bloodType = rs.getString("BloodType");
            	position = rs.getString("Position");
            	foot = rs.getString("Foot");
            	contract = rs.getString("Contract");
            	
            	playerInfo.add(new PlayerModel(jersey, name , gender, dob, bloodType, position, foot, contract));
                      	
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
    return playerInfo;
}
    public static ObservableList<PlayerModel> getInfo()
    {
    	ObservableList<PlayerModel> playerInfo = FXCollections.observableArrayList();
    	playerInfo = db(playerInfo);
    	return playerInfo;
    }

}