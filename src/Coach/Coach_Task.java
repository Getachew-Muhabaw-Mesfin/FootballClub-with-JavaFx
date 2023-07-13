package Coach;

import Training.TrainingDataBase;
import Training.Trainings_Table;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Coach_Task {
	public static HBox trainings()
	{
		Button display = new Button("Display Trainings");
		Button add = new Button("Add new Training");
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(display, add);
		
		//set id for trainging vbox
		vbox.setId("trainings-vbox");

		HBox hb = new HBox();
		
		display.setOnAction(e -> {
			hb.getChildren().clear();
			hb.getChildren().add(Trainings_Table.table());
		});
		add.setOnAction(e ->{
			hb.getChildren().clear();
			hb.getChildren().add(add_trainings());
		});
		HBox hbox = new HBox();
		hbox.getChildren().addAll(vbox, hb);
		
		return hbox;
	}
	
	public static VBox add_trainings()
	{
		Label type = new Label("Training Type");
		TextField typeF = new TextField();
		
		Label date = new Label("Training Date");
		TextField dateF = new TextField();
		
		Label time = new Label("Training Time");
		TextField timeF = new TextField();
		
		Label duration = new Label("Training Duration");
		TextField durationF = new TextField();
		
		Label address = new Label("Address");
		TextField addressF = new TextField();
		
		Button save = new Button("Save");
		
		save.setOnAction(e->{
			String typeS = typeF.getText();
			String timeS = timeF.getText();
			String durationS = durationF.getText();
			String addressS = addressF.getText();
			
			Float durationFloat = Float.parseFloat(durationS);
			
			TrainingDataBase.insertData(typeS, "Date", timeS, durationFloat, addressS);
		});
		
VBox vBox = new VBox();
		
		vBox.setSpacing(5);
		vBox.setPadding(new Insets(50,800,50,650));
		vBox.setAlignment(Pos.CENTER_LEFT);
		vBox.getChildren().addAll(type, typeF, date, dateF, time, timeF, duration, durationF, address, addressF,save);
		
		vBox.setId("add-trianing");
		return vBox;
	}
	
}
