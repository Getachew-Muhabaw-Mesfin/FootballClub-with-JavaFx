package main;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import player.Player;

public class Personal_Information{
	static ExceptionHandler handler= new ExceptionHandler();
	
	public static void personal_info(Stage primaryStage)
	{

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
			
			Boolean bool;
			bool = ExceptionHandler.jerseyCheck(jersyInt);
			if(bool == true)
					Player.player_info(primaryStage, fNameS, lNameS, sex, dateOfB, bloodTypeSt, jersyInt , playingPositionSt, footSt, contractYrs);
			else
				ExceptionHandler.duplicate(jersy, primaryStage);
					});
		
		
		Text text = new Text("Registration form");
		text.setFont(Font.font("Courier New", 40));
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(text);
		
		VBox vBox = new VBox();
		
		vBox.getChildren().addAll(fName, fNameF, lName, lNameF, gender, hbox, birthday, dateOfB, bloodType, comboBox, hBoxCombo, position, comboBoxP, jersyNumber, jersy, playingFoot, comboBoxPl, contractYears, contract);
		
		VBox root = new VBox();
		root.setSpacing(30);
		root.setPadding(new Insets(50,800,50,650));
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(hb, vBox, hBox);

		//Set id for personal infromation page---//_+
		root.setId("personal-information-page");
		
		Scene scene = new Scene(root, 1600,900);
		scene.getStylesheets().add("player.css");
		primaryStage.setScene(scene);

	}
	
	
}
