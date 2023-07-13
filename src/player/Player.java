package player;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import Coach.CoachProfile;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.ExceptionHandler;
import main.Menu;
import main.Personal_Information;
import president.PresidentProfile;
import team.TeamInformation;

public class Player {
	
	static TextField userNameF;
	static PasswordField pass;
	//static String userName;
	
	public static void signUpF(Stage primaryStage)// sign up and login method
	{
		
		GridPane signUpPane = new GridPane();// VBox for sign up Scene
		//signUp.setAlignment(Pos.TOP_RIGHT);
		
		Label userName = new Label("User Name");
		TextField name = new TextField();
		Label password = new Label("Password");
		PasswordField pass = new PasswordField();
		Button login = new Button("Log In");
		Label or = new Label("Or");
		Button account = new Button("Create account");
		Button back = new Button("Back");
		
		signUpPane.setAlignment(Pos.CENTER);
		signUpPane.add(userName, 0, 1);
		signUpPane.add(name, 0, 2);
		signUpPane.add(password, 0, 3);
		signUpPane.add(pass, 0, 4);
		signUpPane.add(login, 0, 5);
		signUpPane.add(or, 0, 6);
		signUpPane.add(account, 0, 7);
		signUpPane.add(back, 3, 8);
		
		//Reflection for gridPane
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		signUpPane.setEffect(r);
		
		//DropShadow effect
		DropShadow dropShadow= new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);
		
		//Adding text and DropShadow effect to it
		Text text = new Text("Login");
		text.setFont(Font.font("Courier New", 60));
		text.setEffect(dropShadow);
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(text);
		BorderPane bp = new BorderPane();
		bp.setTop(hb);
		bp.setCenter(signUpPane);
		

		//////////////////////////////////////////
		// set id for login page 
		
		back.setId("back");
		login.setId("btn-login");
		account.setId("btn-account");
		signUpPane.setId("login-page");
		
		
		///////////////////////////////////////////////
		
		
		Scene signScene = new Scene(bp,1600,900);
		signScene.getStylesheets().add("player.css");
		primaryStage.setScene(signScene);
		
		login.setOnAction(e -> {
			String nameSt = name.getText();
			String passSt = pass.getText();
			
			Boolean bool = ExceptionHandler.loginCheck(nameSt, passSt);
			if(bool == true)
			{
				Player.player_Page(primaryStage, nameSt);
			}
			else
				ExceptionHandler.incorrect(pass, primaryStage);
		});
		
		account.setOnAction(e->{
		
			Personal_Information.personal_info(primaryStage);
		});
		
		back.setOnAction(e-> {
			Menu.menuMethod(primaryStage);
		});
		
	}
	
	public static void player_info(Stage primaryStage, String fName, String lName, String sex, DatePicker date, String bloodType, int jersyInt, String playingPositionSt, String footSt, String contractYrs)
	{
		
		Text text = new Text("Sign in portal");
		text.setFont(Font.font("Courier New", 70));
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(text);
		
		VBox login = player_Login();
		Button submit = new Button("Submit");
		submit.setMinSize(80, 30);
		Button back = new Button("Back");
		back.setMinSize(80, 30);
		
		HBox hBox = new HBox();
		hBox.getChildren().addAll(back, submit);
		hBox.setSpacing(20);
		
		submit.setOnAction(e ->{
			String userName = userNameF.getText();
			String password = pass.getText();
			Boolean bool;
			bool = ExceptionHandler.userNameCheck(userName);
			if(bool == true)
			{
				Boolean bool2;
				bool2 = ExceptionHandler.passwordCheck(password);
				
				if(bool2 == true)
				{
					PlayerDataBase.insertData(jersyInt, fName, lName, sex, date , bloodType , playingPositionSt, footSt, contractYrs, userName, password);
					signUpF(primaryStage);
				}
				else
					ExceptionHandler.invalidLength(userNameF, primaryStage);
	    	}
			
			else
				ExceptionHandler.duplicate(userNameF, primaryStage);
		});
		
		back.setOnAction(e->{
			Personal_Information.personal_info(primaryStage);
		});
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(login);
		
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(50,800,50,650));
	    root.getChildren().addAll(hb, vBox, hBox);
	    root.setSpacing(30);
	    
		root.setId("logNew");
	    
		Scene scene = new Scene(root,1600, 900);
		scene.getStylesheets().add("player.css");
		primaryStage.setScene(scene);
	}
	
	public static VBox player_Login()
	{
		Label userName = new Label("User Name");
		userNameF = new TextField();
		
		Label password = new Label("Password");
		pass = new PasswordField();
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(userName, userNameF, password, pass);
		
		
		return vbox;
	}
	
	public static void player_Page(Stage primaryStage, String userName)
	{
		Text welcome = new Text("Welcome to the players page");
		welcome.setFont(Font.font("Algerian",30));
		Pane pane = new Pane();
		pane.getChildren().add(welcome);
		
		Button profile = new Button("Profile");
		Button playersInfo = new Button("Players Information");
		Button coachInfo = new Button("Coach's Information");
		Button presidentInfo = new Button("President Information");
		Button teamInfo = new Button("Team Information");
		Button logout = new Button("Logout");
		
		//Create pathtransition
		PathTransition pt = new PathTransition(Duration.millis(10000),new Line(0, 50, 1550, 50), welcome);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play(); //Start animation
		
		//set button size
		profile.setMinSize(200, 50);
		playersInfo.setMinSize(200, 50);
		coachInfo.setMinSize(200, 50);
		presidentInfo.setMinSize(200, 50);
		teamInfo.setMinSize(200, 50);
		
		//vbox for player table
		VBox vBox = new VBox();
		
		//actions for the buttons
		profile.setOnAction(e ->{
			vBox.getChildren().clear();
			vBox.getChildren().add(PlayerProfile.profile(userName));
		});
		playersInfo.setOnAction(e ->{
			vBox.getChildren().clear();
			vBox.getChildren().add(PlayerTable.table());
			vBox.setPadding(new Insets(0,0,0,50));
			
		});
		coachInfo.setOnAction(e ->{
			vBox.getChildren().clear();
			vBox.getChildren().add(CoachProfile.coach_Form_Database());
		});
		presidentInfo.setOnAction(e ->{
			vBox.getChildren().clear();
			vBox.getChildren().add(PresidentProfile.president_Form_Database());
		});
		teamInfo.setOnAction(e ->{
			vBox.getChildren().clear();
			vBox.getChildren().add(TeamInformation.team());
		});
		logout.setOnAction(e -> {
			signUpF(primaryStage);
		});
		
		//set button font
		profile.setFont(Font.font("Bell MT",20));
		playersInfo.setFont(Font.font("Bell MT",20));
		coachInfo.setFont(Font.font("Bell MT",20));
		presidentInfo.setFont(Font.font("Bell MT",19));
		teamInfo.setFont(Font.font("Bell MT",20));
		
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setPadding(new Insets(0,5,0,5));
		hb.getChildren().addAll(profile, playersInfo, coachInfo, presidentInfo, teamInfo, logout);
		hb.setAlignment(Pos.CENTER);
		BorderPane bp = new BorderPane();
		

		// set id for the whole player page
		bp.setId("player-page");
		
		VBox vb = new VBox();
		vb.setSpacing(50);
		vb.getChildren().addAll(pane,hb,vBox);
		bp.setTop(vb);
		
		Scene scene = new Scene(bp,1600,900);
		// add the css on the scene
		scene.getStylesheets().add("player.css");

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
}
