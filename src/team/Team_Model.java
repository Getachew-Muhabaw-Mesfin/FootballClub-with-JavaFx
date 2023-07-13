package team;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Team_Model {
	private final SimpleStringProperty col1;
	private final SimpleStringProperty  col2;
	

	public Team_Model(String Info,String discription) {
		this.col1 = new SimpleStringProperty(Info);
		this.col2 = new SimpleStringProperty(discription);
		
	}
	
	public void setTeam(String teaminfo) {
		col1.set(teaminfo);
	}
	
	public void setDescription(String disc) {
		col2.set(disc);
	}
	
	public StringProperty getTeam() {
		return col1;
	}
	public StringProperty  getDescriptions() {
		return col2;
	}
}
