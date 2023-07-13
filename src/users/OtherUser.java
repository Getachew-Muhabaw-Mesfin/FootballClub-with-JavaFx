package users;

import Coach.CoachProfile;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.Menu;
import player.PlayerTable;
import president.PresidentProfile;
import team.TeamInformation;

public class OtherUser {
	
	public static void otherUser_Method(Stage primaryStage)
	{
		Other_User_Page(primaryStage);
	}
	
	public static void Other_User_Page(Stage primaryStage)
	{
		Text welcome = new Text("Welcome to our page");
		welcome.setFont(Font.font("Algerian",30));
		Pane pane = new Pane();
		pane.getChildren().add(welcome);
		
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
		playersInfo.setMinSize(200, 50);
		coachInfo.setMinSize(200, 50);
		presidentInfo.setMinSize(200, 50);
		teamInfo.setMinSize(200, 50);
		
		//vbox for player table
				VBox vBox = new VBox();
		
		//actions for the buttons
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
			Menu.menuMethod(primaryStage);
		});
		//set button font
		playersInfo.setFont(Font.font("Bell MT",20));
		coachInfo.setFont(Font.font("Bell MT",20));
		presidentInfo.setFont(Font.font("Bell MT",19));
		teamInfo.setFont(Font.font("Bell MT",20));
		
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setPadding(new Insets(0,5,0,5));
		hb.getChildren().addAll(playersInfo, coachInfo, presidentInfo, teamInfo, logout);
		hb.setAlignment(Pos.CENTER);
		BorderPane bp = new BorderPane();
		
		VBox vb = new VBox();
		vb.setSpacing(50);
		vb.getChildren().addAll(pane,hb, vBox);
		bp.setTop(vb);

		// set id for Users page
		bp.setId("users-page");
		
		Scene scene = new Scene(bp,1600,900);
		//add stylesheet
	     scene.getStylesheets().add("player.css");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

}