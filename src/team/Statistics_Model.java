package team;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Statistics_Model {	
    private final SimpleStringProperty colomon1;
 	private final SimpleStringProperty colomon2;
 	private final SimpleStringProperty colomon3;
 	private final SimpleStringProperty colomon4;
 		 
 		public Statistics_Model(String names,String total,String home,String away) {
 				this.colomon1 = new SimpleStringProperty(names);
 				this.colomon2 = new SimpleStringProperty(total);
 				this.colomon3 =new SimpleStringProperty(home);
 				this.colomon4=new SimpleStringProperty(away);
 				
 			}
 			
 			public void setColomon1(String name) {
 				colomon1.set(name);
 			}
 			public void setColomon2(String num) {
 				colomon2.set(num);
 			}
 			
 			public void setColomon3(String n) {
 				colomon3.set(n);
 			}
 			public void setColomon4(String num) {
 				colomon4.set(num);
 			}
 			
 			public StringProperty getColomon1() {
 				return colomon1;
 			}
 		
 			public StringProperty getColomon2() {
 				return colomon2;
 			}
 			
 			public StringProperty getColomon3() {
 				return colomon3;
 			}
 		
 			public StringProperty getColomon4() {
 				return colomon4;
 			}

}
