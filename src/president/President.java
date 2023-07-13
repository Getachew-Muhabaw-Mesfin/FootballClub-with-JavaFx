package president;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Coach.CoachProfile;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
import player.Player;
import player.PlayerProfile;
import player.PlayerTable;
import team.TeamInformation;

public class President {

	public static void signUpF(Stage primaryStage)// sign up and login method
	{
		GridPane signUpPane = new GridPane();// VBox for sign up Scene
		//signUp.setAlignment(Pos.TOP_RIGHT);
		
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
			president_Page(primaryStage);
		});
		
		back.setOnAction(e-> {
			Menu.menuMethod(primaryStage);
		});
		
	}
	
	public static void president_Page(Stage primaryStage)
	{
		Text welcome = new Text("Welcome to the president page");
		welcome.setFont(Font.font("Algerian",30));
		Pane pane = new Pane();
		pane.getChildren().add(welcome);
		
		Button profile = new Button("Profile");
		Button playersInfo = new Button("Players Information");
		Button coachInfo = new Button("Coach's Information");
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
		teamInfo.setMinSize(200, 50);
		
		//vbox for player table
				VBox vBox = new VBox();
		
		//actions for the buttons
		profile.setOnAction(e ->{
			vBox.getChildren().clear();
			vBox.getChildren().add(PresidentProfile.president_Form_Database());
		});
		playersInfo.setOnAction(e ->{
			vBox.getChildren().clear();
			vBox.getChildren().add(profile(primaryStage));
		});
		coachInfo.setOnAction(e ->{
			vBox.getChildren().clear();
			vBox.getChildren().add(CoachProfile.coach_Form_Database());
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
		teamInfo.setFont(Font.font("Bell MT",20));
		
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setPadding(new Insets(0,5,0,5));
		hb.getChildren().addAll(profile, playersInfo, coachInfo, teamInfo, logout);
		hb.setAlignment(Pos.CENTER);
		BorderPane bp = new BorderPane();
		
		VBox vb = new VBox();
		vb.setSpacing(50);
		vb.getChildren().addAll(pane,hb, vBox);
		bp.setTop(vb);
		//Set Id for President page
		bp.setId("president-page");
		
		Scene scene = new Scene(bp,1600,900);
		//add stylesheet
		scene.getStylesheets().add("player.css");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static HBox profile(Stage primaryStage)
	{
		Button display = new Button("Display Players");
		Button search = new Button("Search For Player");
		Button purchase = new Button("Purchase Player");
		Button add = new Button("Add player");
		Button remove = new Button("Remove player");
		
		display.setMinSize(200,50);
		search.setMinSize(200,50);
		purchase.setMinSize(200,50);
		add.setMinSize(200,50);
	    remove.setMinSize(200,50);
	    
	    VBox vb = new VBox();
	    vb.getChildren().addAll(display, search, purchase, add, remove);
	    
	 // set id for presedant page for player information button
	    vb.setId("presidant-vbox");
	    
	  VBox vBox = new VBox();
	    
	    display.setOnAction(e ->{
			vBox.getChildren().clear();
	    	vBox.getChildren().add(PlayerTable.table());
	    });
	    
        search.setOnAction(e ->{
			vBox.getChildren().clear();
			vBox.getChildren().add(search());
	    });

        purchase.setOnAction(e ->{
        	vBox.getChildren().clear();
	    });
        
        add.setOnAction(e ->{
        	vBox.getChildren().clear();
        	vBox.getChildren().add(addPlayer(primaryStage));
	    });
        
        remove.setOnAction(e ->{
        	vBox.getChildren().clear();
        	vBox.getChildren().add(delete());
	    });
        
        HBox hBox = new HBox();
        
        hBox.setSpacing(50);
		hBox.getChildren().addAll(vb, vBox);
		
		return hBox;
	}
	 
	public static HBox search()
	{
		Label userNameLabel = new Label("Player's User Name: ");
		TextField userNameInput = new TextField();
		Button search = new Button("Search");
		search.setMinSize(200, 40);
		
		HBox hb = new HBox();
		hb.getChildren().addAll(userNameLabel, userNameInput, search);
		hb.setSpacing(10);
		
		search.setOnAction(e ->{

			String userName = userNameInput.getText();
			hb.getChildren().add(PlayerProfile.player_Form_Database(userName));
		});
		
		return hb;
	}
	public static HBox delete()
	{
		Label userNameLabel = new Label("Player's User Name: ");
		TextField userNameInput = new TextField();
		Button search = new Button("Search");
		search.setMinSize(200, 40);
		
		HBox hb = new HBox();
		hb.getChildren().addAll(userNameLabel, userNameInput, search);
		hb.setSpacing(10);
		
		search.setOnAction(e ->{

			String userName = userNameInput.getText();
			delete_From_dataBase(userName);
		});
		
		return hb;
	}
	public static void delete_From_dataBase(String userName)
	{
		String delete = "DELETE from player WHERE UserName = ?";
		Connection conn = null;
	    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
            PreparedStatement preparedStatement = conn.prepareStatement(delete);
           
            preparedStatement.setString(1, userName);
            
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
	public static VBox addPlayer(Stage primaryStage) {
		//title
		Label fName = new Label("First Name");
		TextField fNameF = new TextField();
		ExceptionHandler.expSt(fNameF, primaryStage);
		
		Label lName = new Label("Last Name");
		TextField lNameF = new TextField();
		ExceptionHandler.expSt(lNameF, primaryStage);
		
		Label gender = new Label("Gender");
		RadioButton male = new RadioButton("Male");
		RadioButton female = new RadioButton("Female");
		ToggleGroup radioGroup = new ToggleGroup();
		male.setToggleGroup(radioGroup);
		female.setToggleGroup(radioGroup);
		male.setSelected(true);
		HBox hbox = new HBox(male,female);
		
		Label birthday = new Label("Birthday");
		DatePicker dateOfB = new DatePicker();
		
		Label bloodType = new Label("Blood type");
		ComboBox comboBox = new ComboBox();
	   
		comboBox.getItems().add("A+");
		comboBox.getItems().add("A-");
		comboBox.getItems().add("B+");
		comboBox.getItems().add("B-");
		comboBox.getItems().add("AB+");
		comboBox.getItems().add("AB-");
		comboBox.getItems().add("O+");
		comboBox.getItems().add("O-");
		
		comboBox.getSelectionModel().selectFirst();
		
		HBox hBoxCombo = new HBox(comboBox);
	
		//players explicit information
		Label position = new Label("Playing Position");
		ComboBox comboBoxP = new ComboBox();
		comboBoxP.getItems().add("Goal Keeper");
		comboBoxP.getItems().add("Defence");
		comboBoxP.getItems().add("Mid Filder");
		comboBoxP.getItems().add("Attacker");
		comboBoxP.getSelectionModel().selectFirst();
		HBox hBoxComboP = new HBox(comboBox);
		
		Label jersyNumber = new Label("Jersy Number");
		TextField jersy = new TextField();
		ExceptionHandler.intCheck(jersy, primaryStage);
		
		Label playingFoot = new Label("Playing foot");
		ComboBox comboBoxPl = new ComboBox();
		comboBoxPl.getItems().add("Right");
		comboBoxPl.getItems().add("Left");
		comboBoxPl.getSelectionModel().selectFirst();
		HBox hboxC = new HBox(comboBoxPl);
		
		Label contractYears = new Label("Contract Years");
		TextField contract = new TextField();
		ExceptionHandler.intCheck(contract, primaryStage);
		
		Button back = new Button("Back");
		back.setMinSize(80, 30);
		Button next = new Button("Next");
		next.setMinSize(80, 30);
		
		HBox hBox = new HBox();
		hBox.getChildren().addAll(back, next);
		hBox.setSpacing(25);
		back.setOnAction(e ->{
			Player.signUpF(primaryStage);
		});
		
		next.setOnAction(e ->{
			String bloodTypeSt = (String) comboBox.getValue();
		    String fNameS = fNameF.getText();
		    String jersyNum = jersy.getText();
			String lNameS = lNameF.getText();
			String sex;
			
			if(female.isSelected()) {
				sex = "female";
			}
			else
				sex = "male";
			
			String playingPositionSt = (String) comboBox.getValue();
			String footSt = (String) comboBoxPl.getValue();
			
			String contractYrs = contract.getText();
			int jersyInt = Integer.parseInt(jersyNum);
			
			/*Boolean bool;
			bool = ExceptionHandler.jerseyCheck(jersyInt);
			if(bool == true)
					//Player.player_info(primaryStage, fNameS, lNameS, sex, dateOfB, bloodTypeSt, jersyInt , playingPositionSt, footSt, contractYrs);
			else
				ExceptionHandler.duplicate(jersy, primaryStage);*/
					});
		
		VBox vBox = new VBox();
		VBox vBox2 = new VBox();
		
		vBox.getChildren().addAll(fName, fNameF, lName, lNameF, gender, hbox, birthday, dateOfB, bloodType, comboBox);
		vBox2.getChildren().addAll(hBoxCombo, position, comboBoxP, jersyNumber, jersy, playingFoot, comboBoxPl, contractYears, contract);
		
		HBox hBox1 = new HBox();
		hBox1.getChildren().addAll(vBox, vBox2);
		hBox1.setSpacing(60);
		
		VBox root = new VBox();
		root.setSpacing(30);
		root.setPadding(new Insets(0,500,50,250));
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(hBox1, hBox);

		//Set id for personal infromation page---//_+
		//root.setId("personal-information-page");
		
		return root;

	}
}
