package views;

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


import controller.FileManager;
import controller.TempTrainer;
public class LoginView extends BorderPane implements Observer {
  


        private MenuBar mainMenu;
        private Menu userMenuBar, adminMenuBar;
        private TextField acctT;
        private PasswordField pswdT; 
        private Button loginB, playB, pauseB, stopB, createU;
        private GridPane acctGrid, loginGrid, buttonGrid;
        private Label acctLabl, pswdLabl, loginMsg, userMsg; 
        private FileManager man;


        public LoginView(FileManager man){

          this.man=man; 

          this.setPrefWidth(600);
          this.setPrefHeight(400);
          acctGrid = new GridPane();

          loginGrid = new GridPane();
          mainMenu = new MenuBar();

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

/*
  // has mainMenu and userOptions menu
  private void setUpUserMenus() {

    hoursVal = new MenuItem(Double.toString(mainUser.totalMinUsed)); 
    Menu totHours = new Menu("Total Minutes Used");
    totHours.getItems().addAll(hoursVal);

    song1 = new MenuItem(mainUser.song1);
    song2 = new MenuItem(mainUser.song2);
    song3 = new MenuItem(mainUser.song3);

    Menu dailyPlays = new Menu("Daily Plays");

    dailyPlays.getItems().addAll(song1, song2, song3);

    Menu account = new Menu("Account");

    account.getItems().addAll(totHours, dailyPlays);

    // add songs for menu selections

    UserMenuItemListener userMenuListener = new UserMenuItemListener();


    MenuItem quit = new MenuItem("Sign Out");
    Menu userOptions = new Menu("Menu");
    userOptions.getItems().addAll(account, quit);

    // main menuBar
    mainMenu = new MenuBar();

    mainMenu.getMenus().addAll(userOptions);


    // Add the same listener to all menu items requiring action

    quit.setOnAction(userMenuListener);


  }

*/

 public void setUserMsg(String val){

   this.setCenter(null);
   this.setTop(null);
   this.setBottom(null);
   userMsg = new Label(val);
   userMsg.setFont( new Font("Arial", 24));
   this.setCenter(userMsg);


 }


  // has adminOptions menu
  public void setUpAdminMenus(){
 
    AdminMenuItemListener adminMenuListener = new AdminMenuItemListener();

    MenuItem quit2 = new MenuItem("Sign Out");
    MenuItem createUser = new MenuItem("Create User");

    Menu usr = new Menu("Users");


    for( TempTrainer usu : man.getUser() ){

    MenuItem val =  new MenuItem(usu.name);
    val.setOnAction(adminMenuListener);

    usr.getItems().addAll(val);

    }
 
  
    Menu adminOptions = new Menu("Admin");
    
    adminOptions.getItems().addAll(usr,createUser,quit2);

    quit2.setOnAction(adminMenuListener);

    createUser.setOnAction(adminMenuListener);

    mainMenu.getMenus().addAll(adminOptions);

    this.setTop(mainMenu); 
    this.setCenter(null);
    this.setBottom(null); 
  }




  public void setUpLoginMenu(){
 
    LoginMenuItemListener loginMenuListener = new LoginMenuItemListener();

    MenuItem login = new MenuItem("Sign In");

    login.setOnAction(loginMenuListener);

    Menu userLog = new Menu("User");
    userLog.getItems().addAll(login); 

    mainMenu = new MenuBar();


    mainMenu.getMenus().addAll(userLog);
  
    this.setTop(mainMenu);

  } 


  private class LoginMenuItemListener implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
      // Find out the text of the JMenuItem that was just clicked
      String text = ((MenuItem) e.getSource()).getText();
 
          if (text.equals("Sign In")){

           
           setUpLoginGrids();        
          }

     }


  }


/*
  // menuListener for User
  private class UserMenuItemListener implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
      // Find out the text of the JMenuItem that was just clicked
      String text = ((MenuItem) e.getSource()).getText();
        if (text.equals("Sign Out")){

            setUpLoginMenu();            
            this.setTop(mainMenu);
            this.setCenter(vbox);
        

        }

     }

 } 
*/


  // menuListener for Admin
  private class AdminMenuItemListener implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
      // Find out the text of the adminOptions that was just clicked

      String text = ((MenuItem) e.getSource()).getText();
        if (text.equals("Sign Out")){

            setUpLoginGrids();            
//            this.setTop(mainMenu);
//            this.setCenter(vbox);
        }

         // creates new User 
         if (text.equals("Create User")){
    
//            setUpLoginGrids();        
//            this.setCenter(acctGrid);
//            this.setBottom(createU);

        }
       
/*
        // finds and removes User
        for( Iterator<User> iter = users.iterator(); iter.hasNext();){

           User usr = iter.next();
           if (text.equals(usr.name)){

//System.out.println("got it 2"); 

           Alert alert = new Alert(AlertType.CONFIRMATION);

           alert.setHeaderText("Remove User?");

           Optional<ButtonType> result = alert.showAndWait();
             if (result.get() == ButtonType.OK){

             iter.remove(); 

             this.setTop(null);
             setUpUserMenus();
             setUpAdminMenus();
             this.setTop(mainMenu);

//UD             man.pushUserData(); 


//System.out.println("removed user"); 

             } else {
//System.out.println("cancel"); 

             }

           }

        }

*/

     }
 } 



   // handles both login and create user
   private class LoginButtonListener implements EventHandler<ActionEvent>{

      @Override
      public void handle(ActionEvent arg0){
   
         if(loginB==(Button) arg0.getSource()){

            if(acctT.getText().equals("") || pswdT.getText().equals("")){

System.out.println("View:User Error1");

            } else if(man.checkUser(acctT.getText(),pswdT.getText())==0){
System.out.println("View:New User");              
              setUserMsg("Welcome New User");
               }
              else if(man.checkUser(acctT.getText(),pswdT.getText())==1){
System.out.println("View:Returning User");              
               setUserMsg("Welcome Back User");
  
               }
              else{
//if(man.checkUser(acctT.getText(),pswdT.getText())==2){
 System.out.println("View:Admin");              

             setUserMsg("Welcome Admin");

            setUpAdminMenus();
               }


          acctT.setText("");
          pswdT.setText("");

         }

      }

/*
         if(createU==(Button) arg0.getSource()){

          man.checkUser(acctT.getText(),pswdT.getText());

             window.setTop(null);
 //            setUpUserMenus();
             setUpAdminMenus();
             window.setTop(mainMenu); 
             window.setCenter(vbox);
             window.setBottom(null);
             acctT.setText("");
             pswdT.setText("");


         }
*/


   }


@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	
}




}

