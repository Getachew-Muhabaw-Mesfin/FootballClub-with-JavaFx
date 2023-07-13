package main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ListsOfClubs {
	
	public static void clubs(Stage primaryStage)
	{

		Button fasil = new Button("Fasil Kenema");
		Button buna = new Button("Ethiopia Buna");
		Button giyorgis = new Button("Kidus giyorgis");
		Button bd = new Button("Bahir Dar Kenema");
		Button hadiya = new Button("Hadiya Kenema");
		Button welayta = new Button("Welayita Dich");
		Button welkite = new Button("Welkite Kenema");
		Button sebeta = new Button("Sebeta City");
		Button awasa = new Button("Awasa Kenema");
		Button diredawa = new Button("Diredawa Kenema");
		Button sidama = new Button("Sidama Buna");
		Button jima = new Button("Jima Kenema");
		
		fasil.setMinSize(300, 150);
		buna.setMinSize(300, 150);
		giyorgis.setMinSize(300, 150);
		bd.setMinSize(300, 150);
		hadiya.setMinSize(300, 150);
		welayta.setMinSize(300, 150);
		welkite.setMinSize(300, 150);
		sebeta.setMinSize(300, 150);
		awasa.setMinSize(300, 150);
		diredawa.setMinSize(300, 150);
		sidama.setMinSize(300, 150);
		jima.setMinSize(300, 150);
		
		fasil.setFont(Font.font("Times new roman",35));
		buna.setFont(Font.font("Times new roman",35));
		giyorgis.setFont(Font.font("Times new roman",35));
		bd.setFont(Font.font("Times new roman",33));
		hadiya.setFont(Font.font("Times new roman",35));
		welayta.setFont(Font.font("Times new roman",35));
		welkite.setFont(Font.font("Times new roman",35));
		awasa.setFont(Font.font("Times new roman",35));
		sebeta.setFont(Font.font("Times new roman",35));
		sidama.setFont(Font.font("Times new roman",35));
		jima.setFont(Font.font("Times new roman",35));
		diredawa.setFont(Font.font("Times new roman",32));
		
		HBox hBox1 = new HBox();
		hBox1.getChildren().addAll(fasil, buna, giyorgis);
		
		HBox hBox2 = new HBox();
		hBox2.getChildren().addAll(bd, hadiya, welayta);
		
		HBox hBox3 = new HBox();
		hBox3.getChildren().addAll(welkite, sebeta, awasa);
		
		HBox hBox4 = new HBox();
		hBox4.getChildren().addAll(diredawa, sidama, jima);
		
		hBox1.setSpacing(50);
		hBox2.setSpacing(50);
		hBox3.setSpacing(50);
		hBox4.setSpacing(50);
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4);
		//vBox.setAlignment
		vBox.setPadding(new Insets(50,0,0,250));
		//vBox.setStyle("-fx-background-color: green;");
		vBox.setId("clubs");
		

		hBox1.setSpacing(50);
		hBox2.setSpacing(50);
		hBox3.setSpacing(50);
		hBox4.setSpacing(50);
		vBox.setSpacing(50);
		
		//
		
		giyorgis.setOnAction(e->{
			Menu.menuMethod(primaryStage);
		});
		
		Scene scene = new Scene(vBox, 1600,900);
		scene.getStylesheets().add("club.css");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Clubs");
	}


}
