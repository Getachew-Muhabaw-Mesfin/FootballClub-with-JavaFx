package player;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PlayerModel {
	private SimpleIntegerProperty jersyNumber = new SimpleIntegerProperty();
	private SimpleStringProperty fullName = new SimpleStringProperty();
	private SimpleStringProperty gender = new SimpleStringProperty();
	private SimpleStringProperty dob = new SimpleStringProperty();
	private SimpleStringProperty bloodType = new SimpleStringProperty();
	private SimpleStringProperty position = new SimpleStringProperty();
	private SimpleStringProperty foot = new SimpleStringProperty();
	private SimpleStringProperty contract = new SimpleStringProperty();
	
	//constractor method
	public PlayerModel (int jersyNumber, String fullName, String gender, String dob, String bloodType, String position, String foot, String contract) {
		this.jersyNumber.set(jersyNumber);
		this.fullName.set(fullName);
		this.gender.set(gender);
		this.dob.set(dob);
		this.bloodType.set(bloodType);
		this.position.set(position);
		this.foot.set(foot);
		this.contract.set(contract);
	}
	
	// get information
	public IntegerProperty getJersyNumber() { 
		return jersyNumber;
	}
	public StringProperty getFullName() { 
		return fullName;
	}
	public StringProperty getGender() { 
		return gender;
	}
	public StringProperty getDob() { 
		return dob;
	}
	public StringProperty getBloodType() { 
		return bloodType;
	}
	public StringProperty getPosition() { 
		return position;
	}
	public StringProperty getFoot() { 
		return foot;
	}
	public StringProperty getContract() { 
		return contract;
	}
	
	//set information
	public void setJersyNumber(int jersyNumber) {
		this.jersyNumber.set(jersyNumber);
	}
	public void setFullName(String fullName) {
		this.fullName.set(fullName);
	}
	public void setGender(String gender) {
		this.gender.set(gender);
	}
	public void setDob(String dob) {
		this.dob.set(dob);
	}
	public void setBloodType(String bloodType) {
		this.bloodType.set(bloodType);
	}
	public void setPosition(String position) {
		this.position.set(position);
	}
	public void setFoot(String foot) {
		this.foot.set(foot);
	}
	public void setContract(String contract) {
		this.contract.set(contract);
	}


}
