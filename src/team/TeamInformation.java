package team;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TeamInformation {
	
	


	public static Pane team() {
		Button history=new Button("History");
		Button general_info=new Button("General Information");
		Button statics=new  Button("Display Statistics");
		Button honors=new Button("Honors");
		Button comment=new Button ("Feedback");
		
		
		//set for the size of Buttons
		history.setMinSize(200,50);
		general_info.setMinSize(200,50);
		statics.setMinSize(200,50);
		honors.setMinSize(200,50);
		comment.setMinSize(200,50);
	
		HBox hBox2 = new HBox();
		
		//set action
		history.setOnAction(e->{
			hBox2.getChildren().clear();
				hBox2.getChildren().add(history());
		
		           });
		
		
		general_info.setOnAction(e->{
			hBox2.getChildren().clear();
			hBox2.getChildren().add(General_info.generalInformation());
			
		});
		
		
		statics.setOnAction(e->{
			hBox2.getChildren().clear();
			hBox2.getChildren().add(Statistics.statics());
		});
	
		
		honors.setOnAction(e->{
			hBox2.getChildren().clear();
			hBox2.getChildren().add( honors());
			
		});
		
		
		comment.setOnAction(e->{
			hBox2.getChildren().clear();
			hBox2.getChildren().add(feedBack());
	        });
		
		
		VBox box=new VBox();
		box.getChildren().addAll(history,general_info,statics,honors,comment);
		
		//team infromation 
		box.setId("team-vbox");
		
		HBox hBox=new HBox();
		hBox.getChildren().addAll(box, hBox2);
		hBox.setSpacing(100);
		
	    return hBox;
		
	}

	public static VBox history()  {
		
		Label name=new Label("Saint George Sports Club"); 
		  name.setFont(new Font("Calisto MT", 24));
		Text founded=new Text("Founded Year: 1935 (1928 E.C)");
		Text his=new Text("\n Saint George Sports Club is a professional football club based in Addis Ababa, Ethiopia. "
							+ "\n  They play in the top division of Ethiopian football,"
							+ " \n the Ethiopian Premier League. Founded in 1935, the club was the first in Ethiopia and was established "
							+ "\n  as a symbol of Ethiopian nationalism and resistance against the occupying forces of fascist Italy."
							+ "\n  The club's first jerseys were brown and white, affordable cloth for the cash strapped club at the time."
							+ "\n ");
		 his.setFont(new Font("Times New Roman", 16));
		Image img1=new Image("st1.jpg");
		Image img2=new Image("11.jpg");
		Image img3=new Image("st2.jpg");
		
		ImageView imgView1=new ImageView(img1);
		
		  imgView1.setFitHeight(250); 
	      imgView1.setFitWidth(250); 
	      
	      
	      
	      ImageView imgView2 = new ImageView(img2);
	      imgView2.setFitHeight(250); 
          imgView2.setFitWidth(250); 
	    
	      
	      ImageView imgView3 = new ImageView(img3); 
	      imgView3.setFitHeight(250); 
	      imgView3.setFitWidth(250); 
	      
	  	Image im1=new Image("22.jpg");
		Image im2=new Image("222.jpg");
		Image im3=new Image("33.jpg");
		
		ImageView iV1=new ImageView(im1);
		
		  iV1.setFitHeight(250); 
	      iV1.setFitWidth(250); 
	      
	      
	      ImageView iV2 = new ImageView(im2);
	      iV2.setFitHeight(250); 
          iV2.setFitWidth(250); 
	    
	      
	      ImageView iV3 = new ImageView(im3); 
	      iV3.setFitHeight(250); 
	      iV3.setFitWidth(250); 
     
	     HBox imgBox=new HBox();
		imgBox.getChildren().addAll(imgView1,imgView2,imgView3);
		imgBox.setSpacing(30);
		
		HBox img2Box=new HBox();
		img2Box.getChildren().addAll(iV1,iV2,iV3);
			
		img2Box.setSpacing(30);

       Text text=new Text("Source: from Saint George Sports Club website");
       text.setFont(new Font("Bell MT", 18));
	
		VBox historybox=new VBox();
		historybox.getChildren().addAll(name,his,founded,imgBox,img2Box,text);
		
		return historybox;
		
	}
	

public static HBox honors() {
		 TreeItem<String> leage = new TreeItem<String>("Ethiopian Premier League: 29");
		 
		 leage.setExpanded(false);
		 leage.getChildren().addAll(
		     new TreeItem<String>("1950,19966,1967,1968"),
		     new TreeItem<String>("1971,1975,1985,1986"),
		     new TreeItem<String>("1987,1990,1991,1992"),
		     new TreeItem<String>("1994,1995,1996,1999"),
		     new TreeItem<String>("2000,2002,2003,2005"),
		     new TreeItem<String>("2006,2008,2009,2010,"),
		     new TreeItem<String>("2012,2014,2015,2016,2017")
		 );
		 
		 TreeItem<String> etCup = new TreeItem<String>("Ethiopian Cup: 12");
		 etCup.setExpanded(false);
		 etCup.getChildren().addAll(
		     new TreeItem<String>("1952,1953,1957,1973"),
		     new TreeItem<String>("1974,1975,1977,1993"),
		     new TreeItem<String>("1999,2009,2011,2016")
		     
		   
		 );
		 
		 TreeItem<String> etScup = new TreeItem<String>("Ethiopian Super Cup: 16");
		 etScup.setExpanded(false);
		 
		 etScup.getChildren().addAll(
		     new TreeItem<String>("1985,1986,1987,1994"),
		     new TreeItem<String>("1995,1996,1999,2001"),
		     new TreeItem<String>("2002,2003,2005,2006"),
		     new TreeItem<String>("2009,2010,2015,2017")
		   
		 );
		 
		 TreeItem<String> aaCup = new TreeItem<String>("Addis Ababa City Cup: 6");
		 aaCup.setExpanded(false);
		 
		 
		 
		 aaCup.getChildren().addAll(
		     new TreeItem<String>("2009,2010,2011"),
		     new TreeItem<String>("2013,2017,2019")
		
		 );
	  
		 
//		 TreeItem<String> caf = new TreeItem<String>("CAF Champions League: 9 appearances");
//		 caf.setExpanded(false);
//		 caf.getChildren().addAll(
//		 new TreeItem<String>("1997 -First Round"),
//	     new TreeItem<String>("2000 -First Round"),
//	     new TreeItem<String>("2001 -First Round"),
//	     new TreeItem<String>("2003 – Preliminary Round"),
//	     new TreeItem<String>("2004 -First Round"),
//	     new TreeItem<String>("2006 -First Round"),
//	     new TreeItem<String>("2007 -First Round"),
//	     new TreeItem<String>("2010 – Preliminary Round"),
//	     new TreeItem<String>("2016 -First Round")
//	
//		 );
//		 
//		 
//		 TreeItem<String> champion = new TreeItem<String>("African Cup of Champions Clubs: 10 appearances");
//		 champion.setExpanded(false);
//		 champion.getChildren().addAll(
//		 new TreeItem<String>("1967 -Semi Final"),
//	     new TreeItem<String>("1968 -First Round"),
//	     new TreeItem<String>("1969 -First Round"),
//	     new TreeItem<String>("1972 – Second Round"),
//	     new TreeItem<String>("1976 -First Round"),
//	     new TreeItem<String>("1986 -Second Round"),
//	     new TreeItem<String>("2007 -First Round"),
//	     new TreeItem<String>("1991 – Withdrew in First Round"),
//	     new TreeItem<String>("1992 -Preliminary Round"),
//	     new TreeItem<String>("1993 -Preliminary Round"),
//	     new TreeItem<String>("1996 -Second Round")
//	
//		 );
//		 TreeItem<String> confederation = new TreeItem<String>("CAF Confederation Cup: 1 appearance");
//		 confederation.setExpanded(false);
//		 
//		 confederation.getChildren().addAll(
//		     new TreeItem<String>("2012 -First Round")
//	        );
//		 TreeItem<String> cafwiner = new TreeItem<String>("CAF Cup Winners' Cup: 3 appearances");
//		 cafwiner.setExpanded(false);
//	     cafwiner.getChildren().addAll(
//		     new TreeItem<String>("1975 -First Round"),
//		     new TreeItem<String>("1978 -Preliminary Round"),
//		     new TreeItem<String>("1994 -Second Round")
//		
//		 );
//		 HBox tree2box=new HBox();
//		 tree2box.getChildren().addAll(caf,champion,confederation,cafwiner);
//		
		  HBox treeBox=new HBox();
		  TreeView<String> lg = new TreeView<String>(leage);
			 TreeView<String> cup= new TreeView<String>(etCup);
			 TreeView<String> supercup = new TreeView<String>(etScup);
			 TreeView<String> aacup = new TreeView<String>(aaCup);
		        treeBox.getChildren().addAll(lg,cup,supercup,aacup);
				treeBox.setSpacing(30);
				treeBox.setPadding(new Insets(0,0,200,0));
	return treeBox;
		
		
	}
	
	public static VBox feedBack() {
		
		TextArea ta=new TextArea();
		ta.autosize();
		Button save=new Button("Submit");
		VBox comment=new VBox();
		comment.getChildren().addAll(ta,save);
		
		save.setOnAction(e->{
			
		});
		return comment;
	}
	
	 
	
public static class General_info{
		private static TableView<Team_Model> infoTable;
		
public static VBox generalInformation() {
			   infoTable = new TableView<>();
				final Label label = new Label(" Generla Information About  Saint George S.C   ");
					   label.setFont(new Font("Calisto MT", 24));

			        TableColumn<Team_Model, String> col1 = new TableColumn("Attributies");
			        col1.setMinWidth(400);
			        col1.setCellValueFactory(cellData -> cellData.getValue().getTeam());
			 
			        TableColumn<Team_Model, String> col2 = new TableColumn("Description");
			        col2.setMinWidth(400);
			        col2.setCellValueFactory(cellData -> cellData.getValue().getDescriptions());
			 
			        infoTable.getColumns().addAll(col1, col2);
			        infoTable.setItems(getUserData());
			       
			        
			        VBox v=new VBox();
			        v.getChildren().addAll(label,infoTable);
			        
			        return v;
			      
			      }
	  private final static ObservableList<Team_Model> getUserData() {
		  ObservableList<Team_Model> list = FXCollections.observableArrayList();
          list.add(new Team_Model("Team Name", " Saint George S.C." ));
		  list.add(new Team_Model("Founde On", "1935 (1928 E.C)"));
		  list.add( new Team_Model("Nick Name", "The Horsemen,The Patriot,The Aradas" ));
		  list.add( new Team_Model( "Team Country", "Ethiopia"));
		  list.add(new Team_Model("Team City", "Addis Ababa" ));
		  list.add( new Team_Model( "Leage", "	Ethiopian Premier League"));
	      list.add( new Team_Model( "Brand", "Saint George"));
	      
	      list.add( new Team_Model("Cost", "60 million ETB"));
	      list.add(new Team_Model("Budget", "60 million ETB"));
	      list.add(new Team_Model("Presidant", "Ato Abinet Gebremeskel"));
	      list.add( new Team_Model("Manager", "Maahier Davids"));
	      list.add( new Team_Model("Email", "info@stgeorgefc.com"));
	      list.add(new Team_Model("Phone Number", "+251-011-4-663-679"));
	      list.add( new Team_Model("Website", "https://saintgeorgefc.com/"));
	      list.add(new Team_Model("Number Of Players", "27"));
	      list.add(new Team_Model("Numbers of Fans ", "32 registerd and 8 million throughout country"));
	      list.add(new Team_Model( "Stadium", "Addis Ababa Stadium"));
	      list.add(new Team_Model("Stadium Capacity", "34,000"));
	    
	      return list;
	   
	  }

	}

	//Statics Class
	

	public static class Statistics{
		private static TableView<Statistics_Model> statTable;
  public static VBox statics() {
	            statTable= new TableView<>();
			     final Label label = new Label("Statistical Information About  Saint George S.C in 2020  ");
				   label.setFont(new Font("Calisto MT", 24));
//				   TableColumn<Team_Model, String> col1 = new TableColumn("Attributies");
//			        col1.setMinWidth(400);
//			        col1.setCellValueFactory(cellData -> cellData.getValue().getTeam());
			 
		        TableColumn <Statistics_Model,String>col1 = new TableColumn(" ");
		        col1.setMinWidth(200);
		        col1.setCellValueFactory(cellData -> cellData.getValue().getColomon1());
		        
		        TableColumn <Statistics_Model,String>col2 = new TableColumn("Total");
		        col2.setMinWidth(200);
		        col2.setCellValueFactory(cellData -> cellData.getValue().getColomon2());
		        
		        TableColumn <Statistics_Model,String>col3 = new TableColumn("Home");
		        col3.setMinWidth(200);
		        col3.setCellValueFactory(cellData -> cellData.getValue().getColomon3());
		 
		        TableColumn<Statistics_Model,String> col4 = new TableColumn("Away");
		        col4.setMinWidth(200);
		        col4.setCellValueFactory(cellData -> cellData.getValue().getColomon4());
		 
		        statTable.setItems(getUserList());
		        statTable.getColumns().addAll(col1, col2,col3,col4);
		        
		        VBox v=new VBox();
		        v.getChildren().addAll(label,statTable);
		        
		        return v;
		        
		      }
  private final static ObservableList<Statistics_Model> getUserList() {
	  ObservableList<Statistics_Model> datas = FXCollections.observableArrayList();

      datas.add(new Statistics_Model( "Rank","3"," "," "));
      datas.add(new Statistics_Model("Matches Played ", "13","6","7"));
      datas.add(new Statistics_Model( "Wins", "7","3","4"));
      datas.add(new Statistics_Model( "Draws", "3","1","2"));
      datas.add(new Statistics_Model( "Losses", "3","2","1"));
      datas.add( new Statistics_Model( "Goals For", "26","11","15"));
      datas.add( new Statistics_Model( "Goals Against", "17","7","10"));
      datas.add(new Statistics_Model( "Points", "24","10","14"));
      datas.add(new Statistics_Model( "Clean Sheets", "3","2","1"));
      datas.add( new Statistics_Model( "Avg.goals Scored p/m", "2","1.83","2.14"));
      datas.add(new Statistics_Model( "Avg.goals Conceded p/m", "1.3","1.17","1.43"));
      datas.add(new Statistics_Model( "Avg.time 1st goal Scored", "-","-","-"));
      datas.add(new Statistics_Model( "Avg.time 1st goal conced", "-","-","-"));
      datas.add(new Statistics_Model( "Faild to Score", "4","2","2"));
      datas.add(new Statistics_Model( "Biggest Victory", "4-1","4-1","4-1"));
      datas.add(new Statistics_Model( "Biggest Defeat", "0-1","0-1","0-1"));

      return datas;
         }
	
	}
	
}
