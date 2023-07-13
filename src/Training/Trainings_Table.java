package Training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Trainings_Table {
	private static TableView<Training_Model> table;

	public static TableView<Training_Model> table()
	{
		table = new TableView<>();
		
		TableColumn<Training_Model, Number> training_id = new TableColumn<>("Training Id"); 
		training_id.setPrefWidth(150);
		training_id.setCellValueFactory(cellData -> cellData.getValue().getTrainingId());
		table.getColumns().add(training_id);
		
		TableColumn<Training_Model, String> training_type = new TableColumn<>("Training Type"); 
		training_type.setPrefWidth(150);
		training_type.setCellValueFactory(cellData -> cellData.getValue().getTrainingType());
		table.getColumns().add(training_type);
		
		TableColumn<Training_Model, String> training_date = new TableColumn<>("Training Date"); 
		training_date.setPrefWidth(150);
		training_date.setCellValueFactory(cellData -> cellData.getValue().getTrainingDate());
		table.getColumns().add(training_date);
		
		TableColumn<Training_Model, String> time = new TableColumn<>("Time"); 
		time.setPrefWidth(150);
		time.setCellValueFactory(cellData -> cellData.getValue().getTime());
		table.getColumns().add(time);
		
		TableColumn<Training_Model, Number> duration = new TableColumn<>("Duration(hrs)"); 
		duration.setPrefWidth(150);
		duration.setCellValueFactory(cellData -> cellData.getValue().getDuration());
		table.getColumns().add(duration);
		
		TableColumn<Training_Model, String> address = new TableColumn<>("Address"); 
		address.setPrefWidth(150);
		address.setCellValueFactory(cellData -> cellData.getValue().getAddress());
		table.getColumns().add(address);
	    
	    table.setItems(getInfo());
	    
	    return table;
	}
    public static ObservableList<Training_Model> db(ObservableList<Training_Model> training_Info)
    {
    	Connection conn = null;
    	Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clubfc?useSSL=true", "root", "root");
            stmt = conn.createStatement();
            
            String db = "SELECT Training_ID, Type, Date, Time,Duration , Address FROM training";
            
            ResultSet rs = stmt.executeQuery(db);
 
            while(rs.next()){
            	String  type, date, time, address;
            	float duration;
            	int training_id;

            	training_id = rs.getInt("Training_ID");
            	type = rs.getString("Type");
            	date = rs.getString("Date");
            	time = rs.getString("Time");
                duration = rs.getFloat("Duration");
            	address = rs.getString("Address");
            	
            	training_Info.add(new Training_Model(training_id,type, date, time, duration, address));
                      	
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
    return training_Info;
}
    public static ObservableList<Training_Model> getInfo()
    {
    	ObservableList<Training_Model> training_Info = FXCollections.observableArrayList();
    	training_Info = db(training_Info);
    	return training_Info;
    }
}
