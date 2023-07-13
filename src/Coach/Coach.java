package Coach;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.Menu;
import main.Personal_Information;
import player.Player;
import player.PlayerProfile;
import player.PlayerTable;
import team.TeamInformation;

public class Coach {
	public static void signUpF(Stage primaryStage)// sign up and login method
	{
		GridPane signUpPane = new GridPane();// VBox for sign up Scene
		
		Label userName = new Label("User Name");
		TextField name = new TextField();
		Label password = new Label("Password");
		PasswordField pass = new PasswordField();
		Button login = new Button("Log In");
		Button back = new Button("Back");
		
		signUpPane.setAlignment(Pos.CENTER);
		signUpPane.add(userName, 0, 1);
		signUpPane.add(name, 0, 2);
		signUpPane.add(password, 0, 3);
		signUpPane.add(pass, 0, 4);
		signUpPane.add(login, 0, 5);
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
		signUpPane.setId("login-page");
		
		
		///////////////////////////////////////////////
		
		Scene signScene = new Scene(bp,1600,900);
		signScene.getStylesheets().add("player.css");
		primaryStage.setScene(signScene);
		
		login.setOnAction(e -> {
			coach_Page(primaryStage);
		});
		
		back.setOnAction(e-> {
			Menu.menuMethod(primaryStage);
		});
		
	}
	
	
	public static void coach_Page(Stage primaryStage)
	{
		Text welcome = new Text("Welcome to the Coach's page");
		welcome.setFont(Font.font("Algerian",30));
		Pane pane = new Pane();
		pane.getChildren().add(welcome);
		
		Button profile = new Button("Profile");
		Button trainings = new Button("Trainings");
		Button statistics = new Button("Statistics");
		Button playersInfo = new Button("Players Information");
		Button teamInfo = new Button("Team Information");
		Button logout = new Button("Logout");
		
		//Create pathtransition
		PathTransition pt = new PathTransition(Duration.millis(10000),new Line(0, 50, 1550, 50), welcome);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play(); //Start animation
		
		//set button size
		profile.setMinSize(200, 50);
		trainings.setMinSize(200, 50);
		statistics.setMinSize(200, 50);
		playersInfo.setMinSize(200, 50);
		teamInfo.setMinSize(200, 50);
		
		//vbox for player table
				HBox hBox = new HBox();
		
		//actions for the buttons
		profile.setOnAction(e ->{
			hBox.getChildren().clear();
			hBox.getChildren().add(CoachProfile.coach_Form_Database());
		});
		trainings.setOnAction(e ->{
			hBox.getChildren().clear();
			hBox.getChildren().add(Coach_Task.trainings());
		});
		statistics.setOnAction(e ->{
			hBox.getChildren().clear();
			statistics(hBox);
			
		});
		playersInfo.setOnAction(e ->{
			hBox.getChildren().clear();
			hBox.getChildren().add(PlayerTable.table());
			hBox.setPadding(new Insets(0,0,0,50));
		});
		teamInfo.setOnAction(e ->{
			hBox.getChildren().clear();
			hBox.getChildren().add(TeamInformation.team());
		});
		logout.setOnAction(e -> {
			hBox.getChildren().clear();
			signUpF(primaryStage);
		});
		
		//set button font
		profile.setFont(Font.font("Bell MT",20));
		trainings.setFont(Font.font("Bell MT",20));
		statistics.setFont(Font.font("Bell MT",19));
		playersInfo.setFont(Font.font("Bell MT",20));
		teamInfo.setFont(Font.font("Bell MT",20));
		
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setPadding(new Insets(0,5,0,5));
		hb.getChildren().addAll(profile, trainings, statistics, playersInfo, teamInfo, logout);
		hb.setAlignment(Pos.CENTER);
		BorderPane bp = new BorderPane();
		
		VBox vb = new VBox();
		vb.setSpacing(50);
		vb.getChildren().addAll(pane,hb,hBox);
		bp.setTop(vb);
		
		// set id for bp in coach page
		bp.setId("coach-page");
			
		Scene scene = new Scene(bp,1600,900);
		scene.getStylesheets().add("player.css");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void statistics(HBox hBox)
	{
		Label userNameLabel = new Label("Player's User Name: ");
		TextField userNameInput = new TextField();
		Button search = new Button("Search");
		search.setMinSize(200, 40);
		
		HBox hb = new HBox();
		hb.getChildren().addAll(userNameLabel, userNameInput, search);
		hb.setSpacing(10);
		hBox.setSpacing(100);
		hBox.getChildren().add(hb);
		
		search.setOnAction(e ->{
			String currentUser = "Coach";
			
			String userName = userNameInput.getText();
			hBox.getChildren().add(PlayerProfile.statistics_From_Database(userName, currentUser)); 
		});

	}
}
