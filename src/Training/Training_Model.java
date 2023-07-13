package Training;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Training_Model {
	    
	    private SimpleIntegerProperty training_id = new SimpleIntegerProperty();
	    private SimpleStringProperty type = new SimpleStringProperty();
	    private SimpleStringProperty date = new SimpleStringProperty();
	    private SimpleStringProperty time = new SimpleStringProperty();
		private SimpleFloatProperty duration = new SimpleFloatProperty();
		private SimpleStringProperty address = new SimpleStringProperty();
		
		
		//constractor method
		public Training_Model (int training_id, String type, String date, String time, float duration, String address) {
			this.training_id.set(training_id);
			this.type.set(type);
			this.date.set(date);
			this.time.set(time);
			this.duration.set(duration);
			this.address.set(address);
		}
		
		// get information
		public IntegerProperty getTrainingId() { 
			return training_id;
		}
		public StringProperty getTrainingType() { 
			return type;
		}
		public StringProperty getTrainingDate() { 
			return date;
		}
		public StringProperty getTime() { 
			return time;
		}
		public FloatProperty getDuration() { 
			return duration;
		}
		public StringProperty getAddress() { 
			return address;
		}
		
		//set information
		public void setTrainingType(int training_id) {
			this.training_id.set(training_id);
		}
		public void setTrainingType(String type) {
			this.type.set(type);
		}
		public void setTraingDate(String date) {
			this.date.set(date);
		}
		public void setTime(String time) {
			this.time.set(time);
		}
		public void setDuration(float duration) {
			this.duration.set(duration);
		}
		public void setAddress(String address) {
			this.address.set(address);
		}
		
}
