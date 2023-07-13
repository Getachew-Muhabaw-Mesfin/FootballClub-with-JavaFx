package main;

import Coach.Coach;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import player.Player;
import president.President;
import users.OtherUser;

public class Menu {
	public static void menuMethod(Stage primaryStage)//main menu
	{
		
		Button player = new Button("Player");
		Button coach = new Button("Coach");
		Button president = new Button("President");
		Button otherUser = new Button("Other user");
		Button back = new Button("Back");
		
		//Set Button size
		player.setMinSize(200, 60);
		coach.setMinSize(200, 60);
		president.setMinSize(200, 60);
	    otherUser.setMinSize(200, 60);
	    back.setMinSize(200, 60);

	    //Set Button font
	    player.setFont(Font.font("Times new roman",30));
	    coach.setFont(Font.font("Times new roman",30));
	    president.setFont(Font.font("Times new roman",30));
	    otherUser.setFont(Font.font("Times new roman",30));
	    back.setFont(Font.font("Times new roman",30));
	 
		VBox root = new VBox();// VBox for main menu
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);
		root.getChildren().addAll(player, coach, president, otherUser,back);
		Scene scene = new Scene(root,1600,900);
		
	    //set id for styling
	    player.setId("player1");
	    coach.setId("coach1");
	    president.setId("president1");
	    otherUser.setId("otherUser1");
	    root.setId("root1");
	    
		player.setOnAction(e -> {// Action when player button is selected
			Player.signUpF(primaryStage);
			});
		coach.setOnAction(e -> {// Action when player button is selected
			Coach.signUpF(primaryStage);		
			});
		president.setOnAction(e -> {// Action when player button is selected
			President.signUpF(primaryStage);		
			});
		otherUser.setOnAction(e -> {// Action when player button is selected
			OtherUser.otherUser_Method(primaryStage);		
			});
		back.setOnAction(e ->{
			ListsOfClubs.clubs(primaryStage);
		});
		 
		scene.getStylesheets().add("player.css");
		primaryStage.setTitle("User Type");
		primaryStage.setScene(scene);
	}
	
	
}
