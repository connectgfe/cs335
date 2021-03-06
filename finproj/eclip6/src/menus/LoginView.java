package menus;

import java.util.Observable;
import java.util.Observer;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.*;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.awt.Point;

import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.net.*;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import javafx.scene.Node;


import persistence.FileManager;
import network.User;
import model.SafariZone;
import persistence.GameLoader;
import map.TextView;

public class LoginView extends BorderPane implements Observer {
  


        private Menu userMenuBar, adminMenuBar;
        private TextField acctT;
        private PasswordField pswdT; 
        private Button loginB, playB, pauseB, stopB, createU;
        private GridPane acctGrid, loginGrid, buttonGrid;
        private Label acctLabl, pswdLabl, loginMsg, userMsg; 
        private FileManager man;
        private Observer textView;
        private GameLoader gameLoader;


        public LoginView(FileManager man, GameLoader gameLoader, Observer textView){
 
          this.man=man; 
          this.gameLoader=gameLoader; 
          this.textView=textView;  
          this.setPrefWidth(600);
          this.setPrefHeight(400);
          acctGrid = new GridPane();

          loginGrid = new GridPane();
          setUpLoginGrids();

         }
     




// all grids: buttonGrid loginGrid acctGrid createU(button)

    public void setUpLoginGrids(){

    loginB = new Button("Login");
    loginB.setFont( new Font("Arial", 14));


    acctT = new TextField();
    pswdT = new PasswordField();
    acctLabl = new Label("Account Name");
    pswdLabl = new Label("Password");   
    loginMsg = new Label("Sign In");
    acctLabl.setFont( new Font("Arial", 18));
    pswdLabl.setFont( new Font("Arial", 18));
    loginMsg.setFont( new Font("Arial", 24));


    this.setAlignment(loginMsg, Pos.CENTER); 
    this.setMargin(loginMsg, new Insets(10,10,10,10));
    this.setTop(loginMsg);


    acctT.setMaxHeight(15.0);
    pswdT.setMaxHeight(15.0);
    acctT.setMaxWidth(125.0);
    pswdT.setMaxWidth(125.0);

    acctGrid.add(acctLabl,1,1);
    acctGrid.add(pswdLabl,1,2);
    acctGrid.add(acctT,2,1);
    acctGrid.add(pswdT,2,2);
    acctGrid.setHgap(5); 
    acctGrid.setVgap(5); 
 
    this.setAlignment(acctGrid, Pos.CENTER); 
    this.setMargin(acctGrid, new Insets(10,10,10,10));
    this.setCenter(acctGrid);

    this.setAlignment(loginGrid, Pos.CENTER); 
    this.setMargin(loginGrid, new Insets(10,10,100,125));
    this.setBottom(loginGrid);

    loginGrid.add(loginB,1,1);

    createU = new Button("Create"); 
    this.setAlignment(createU, Pos.CENTER); 
    this.setMargin(createU, new Insets(10,10,100,125));
 

    LoginButtonListener handler1 = new LoginButtonListener();

    loginB.setOnAction(handler1);
    createU.setOnAction(handler1);


    }


  public void setUserMsg(String val){

      this.setCenter(null);
      this.setTop(null);
      this.setBottom(null);
      userMsg = new Label(val);
      userMsg.setFont( new Font("Arial", 24));
      this.setCenter(userMsg);


 }

  private void setViewToAdmin(Observer newView) {
       this.setCenter(null);
       this.setBottom(null);       
       this.setCenter((Node) newView);
   }

  private void setViewTo(Observer newView) {
       this.setCenter(null);
       this.setTop(null);
       this.setBottom(null);       
       this.setCenter((Node) newView);
   }

  private void setViewAdminCreate() {
       this.setCenter(acctGrid);
       this.setBottom(createU);       
   }

  private void adminHelper(){  

        this.setTop(null);
  }


  // has adminOptions menu
  public void setUpAdminMenus(){


    MenuBar mainMenu = new MenuBar();


    AdminMenuItemListener adminMenuListener = new AdminMenuItemListener();

    MenuItem createUser = new MenuItem("Create User");

    Menu usr = new Menu("Users");


    for( User usu : man.getUserVector() ){

    MenuItem val =  new MenuItem(usu.name);
    val.setOnAction(adminMenuListener);

    usr.getItems().addAll(val);

    }
 
  
    Menu adminOptions = new Menu("Admin");
    
    adminOptions.getItems().addAll(usr,createUser);

    createUser.setOnAction(adminMenuListener);

    mainMenu.getMenus().addAll(adminOptions);

    this.setTop(mainMenu); 
  }





  // menuListener for Admin
  private class AdminMenuItemListener implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
      // Find out the text of the adminOptions that was just clicked

      String text = ((MenuItem) e.getSource()).getText();
         // creates new User 

         if (text.equals("Create User")){


           setViewAdminCreate();
    
         }


         for( String user : man.getUserNames() ){

            if (text.equals(user)){


 System.out.println("Got User: "+user);
                    man.removeUser(user);
                    man.pushUserData();
                    adminHelper();
                    setUpAdminMenus(); 
                    setViewToAdmin(textView);
   
 
            }
    
          } 


     }
 } 



   // handles both login and create user
   private class LoginButtonListener implements EventHandler<ActionEvent>{

      @Override
      public void handle(ActionEvent arg0){
   
        if(loginB==(Button) arg0.getSource()){

         // make one call to check user.... 
           if(acctT.getText().equals("") || pswdT.getText().equals("")){
System.out.println("View:User Error1");
           } else {
               User temp=man.getUser(acctT.getText(),pswdT.getText());
            
               if(temp!=null){
System.out.println("View:Returning User");              
                   // have confirm to load last game
                  Alert alert = new Alert(AlertType.CONFIRMATION);
                  alert.setHeaderText("Load Previous Game?");
                  Optional<ButtonType> result = alert.showAndWait();
   
                  if(result.get() == ButtonType.OK){
System.out.println("Set SafariZone previous for ret User"); 
                  // check player loc in loaded game
//System.out.println("Player Previous: "+temp.getSafariZone().getTrainerLoc().getX()+" "+temp.getSafariZone().getTrainerLoc().getY());   
                      // load User prev game
                      gameLoader.setSafariZone(null);
                      gameLoader.setSafariZone(temp.getSafariZone());
                      textView = null;
                      textView = new TextView(gameLoader.getSafariZone());
                      gameLoader.getSafariZone().addObserver(textView);
 

                   } else {
System.out.println("Set SafariZone current for ret User"); 
                      // set User SafariZone to current game   
                      temp.setSafariZone(gameLoader.getSafariZone());
                      man.pushUserData();
                   }
                      // set up admin User menu and game view
                      if(temp.name.equals("Merlin") && temp.password.equals("7777777")){
System.out.println("View:Admin");              
                         setUpAdminMenus();
                         setViewToAdmin(textView);
                       } else {
                    // set up current Uesr game view
                         setViewTo(textView);
                       }
//                     setUserMsg("Welcome Back User");               
                  
               } else {
                   man.setUser(acctT.getText(),pswdT.getText());
System.out.println("View:New User");              
System.out.println("Set SafariZone current for new"); 
                   //get user and set SafariZone to current game 
                    man.getUser(acctT.getText(),pswdT.getText()).setSafariZone(gameLoader.getSafariZone());
                    man.pushUserData();
                    setViewTo(textView);
               }
           }
          acctT.setText("");
          pswdT.setText("");
        }


//////////      
         if(createU==(Button) arg0.getSource()){

    System.out.println("Got Create");


System.out.println("View:Admin Create New User");
                    man.setUser(acctT.getText(),pswdT.getText());
            // set created user new SafariZone 
                    man.getUser(acctT.getText(),pswdT.getText()).setSafariZone(new SafariZone()); 

                    man.pushUserData();
                    adminHelper();
                    setUpAdminMenus(); 
                    setViewToAdmin(textView);
                    acctT.setText("");
                    pswdT.setText("");
 
/*
             window.setTop(null);
             setUpUserMenus();
             setUpAdminMenus();
             window.setTop(mainMenu); 
             window.setCenter(vbox);
             window.setBottom(null);
             acctT.setText("");
             pswdT.setText("");
*/

         }

///////////


      }

   }


@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	
           

}




}

