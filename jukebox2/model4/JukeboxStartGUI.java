//package controller_view;

/**
 * This program is a functional spike to determine the interactions are 
 * actually working. It is an event-driven program with a graphical user
 * interface to affirm the functionality all Iteration 1 tasks have been 
 * completed and are working correctly. This program will be used to 
 * test your code for the first 100 points of the JukeBox project.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.*;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
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
import java.time.LocalDate;
import java.util.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;





public class JukeboxStartGUI extends Application {
  


        private static BorderPane window;
        private MenuBar mainMenu;
        private Menu userMenuBar, adminMenuBar;
        private TextField acctT;
        private PasswordField pswdT; 
        private Button loginB, playB, pauseB, stopB, createU;
        private GridPane acctGrid, loginGrid, buttonGrid;
        private Label acctLabl, pswdLabl, loginMsg; 
        private Vector<User> users;
        private FileManager man;
        private User mainUser;
        private String mainHours, mainPlays;
        private MenuItem hoursVal, playsVal;
        private LinkedList<Song> songs; 
        private LinkedList<String> songQueue; 
        private static MediaPlayer player;
        Song capture, swingCheese;


 
    @Override
    public void start(Stage stage) throws Exception {


        window = new BorderPane(); 

        window.setStyle( "-fx-background-image: url(\"file:jukeboxLabel.jpeg\")");

        users = new Vector<User>();

        songs = new LinkedList<Song>();

        songQueue = new LinkedList<String>();

        acctGrid = new GridPane();

        buttonGrid = new GridPane();

        loginGrid = new GridPane();

        Scene scene = new Scene(window, 300, 250);
      
        man = new FileManager();

        setUpGrids();

        addSongs();


         play();


//        setUpMenus();

        stage.setScene(scene);

        stage.show();


    }


    public static void main(String[] args) {
        launch(args); 
    }



   public void addSongs(){

//    capture = new Song("Capture.wav");
    songQueue.add("Capture.wav");

//    swingCheese = new Song("SwingCheese.wav");
    songQueue.add("SwingCheese.wav");

   }

   public void play(){

          
        File file = new File(songQueue.get(0));

    // Create a complete path to the mp3 file
        URI uri = file.toURI();
        Media media = new Media(uri.toString());
   

//        Media media = new Media(mediaFile);
        player = new MediaPlayer(media);
        player.play();
        player.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                player.stop();

System.out.println("Stopped");

                songQueue.poll();
System.out.println("Dequeue");


                if (songQueue.size()!=0) {
                    //Plays the subsequent files
System.out.println("Songs has next");
 
                MediaPlayer player = new MediaPlayer(media);
                play();

                }



                return;
            }
        });

    }


// all grids: buttonGrid loginGrid acctGrid createU(button)

    public void setUpGrids(){

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


    window.setAlignment(loginMsg, Pos.CENTER); 
    window.setMargin(loginMsg, new Insets(10,10,10,10));
    window.setTop(loginMsg);


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

  
    Image playI = new Image("file:play-button_318-42541.jpg");
    playB = new Button();
    ImageView playView = new ImageView(playI);
    playView.setFitHeight(50);
    playView.setFitWidth(50);
    playB.setGraphic(playView);

    Image stopI = new Image("file:stop-playing-button_318-40256.jpg");
    stopB = new Button();
    ImageView stopView = new ImageView(stopI);
    stopView.setFitHeight(50);
    stopView.setFitWidth(50);
    stopB.setGraphic(stopView);

    Image pauseI = new Image("file:video-pause-button_318-33989.jpg");
    pauseB = new Button();
    ImageView pauseView = new ImageView(pauseI);
    pauseView.setFitHeight(50);
    pauseView.setFitWidth(50);
    pauseB.setGraphic(pauseView);

    window.setAlignment(buttonGrid, Pos.CENTER); 
    window.setMargin(buttonGrid, new Insets(90, 10,10,40));
    buttonGrid.setHgap(5); 
    buttonGrid.setVgap(5); 

    buttonGrid.add(playB,3,1);
    buttonGrid.add(stopB,1,1);
    buttonGrid.add(pauseB,2,1);
 
    window.setAlignment(acctGrid, Pos.CENTER); 
    window.setMargin(acctGrid, new Insets(10,10,10,10));
    window.setCenter(acctGrid);

    window.setAlignment(loginGrid, Pos.CENTER); 
    window.setMargin(loginGrid, new Insets(10,10,100,125));
    window.setBottom(loginGrid);

    loginGrid.add(loginB,1,1);

    createU = new Button("Create"); 
    window.setAlignment(createU, Pos.CENTER); 
    window.setMargin(createU, new Insets(10,10,100,125));
 

    LoginButtonListener handler1 = new LoginButtonListener();

    loginB.setOnAction(handler1);
    createU.setOnAction(handler1);


    }


  // has mainMenu and userOptions menu
  private void setUpUserMenus() {

    hoursVal = new MenuItem(mainHours); 
    Menu totHours = new Menu("Total Hours Used");
    totHours.getItems().addAll(hoursVal);

    playsVal = new MenuItem(mainPlays);
    Menu dailyPlays = new Menu("Daily Available");
    dailyPlays.getItems().addAll(playsVal);

    Menu account = new Menu("Account");
    account.getItems().addAll(totHours, dailyPlays);

    // add songs for menu selections
    MenuItem buttonV = new MenuItem("Button");
    MenuItem textAreaV = new MenuItem("TextArea");
    MenuItem textAreaD = new MenuItem("Drawing");
    Menu playlist = new Menu("Playlist");
    playlist.getItems().addAll(buttonV, textAreaV, textAreaD);

    MenuItem quit = new MenuItem("Sign Out");
    Menu userOptions = new Menu("Menu");
    userOptions.getItems().addAll(account, playlist, quit);

    // main menuBar
    mainMenu = new MenuBar();

    mainMenu.getMenus().addAll(userOptions);


    // Add the same listener to all menu items requiring action
    UserMenuItemListener userMenuListener = new UserMenuItemListener();

    quit.setOnAction(userMenuListener);

    textAreaV.setOnAction(userMenuListener);

  }


  // has adminOptions menu
  public void setUpAdminMenus(){
 
    AdminMenuItemListener adminMenuListener = new AdminMenuItemListener();

    MenuItem quit2 = new MenuItem("Sign Out");
    MenuItem createUser = new MenuItem("Create User");

    Menu usr = new Menu("Users");

    for( User usu : users ){

    MenuItem val =  new MenuItem(usu.getName());
    val.setOnAction(adminMenuListener);

    usr.getItems().addAll(val);

    }
   
    Menu adminOptions = new Menu("Admin");
    
    adminOptions.getItems().addAll(usr,createUser,quit2);

    quit2.setOnAction(adminMenuListener);

    createUser.setOnAction(adminMenuListener);

    mainMenu.getMenus().addAll(adminOptions);


   }



  // menuListener for User
  private class UserMenuItemListener implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
      // Find out the text of the JMenuItem that was just clicked
      String text = ((MenuItem) e.getSource()).getText();
        if (text.equals("Sign Out")){
            
            loginMsg.setText("Sign In"); 
            window.setTop(loginMsg);
            window.setCenter(acctGrid);
            window.setBottom(loginGrid);

        }else if (text.equals("TextArea")){

             mainUser.setMins(2.3);
             mainHours = mainUser.getMins();
             hoursVal.setText(mainHours);
             man.pushUserData();

        // will be song fields

        }else if (text.equals("Drawing")){

        }else if (text.equals("New Game")){

        }else if (text.equals("Intermediate")){
  
        }else if (text.equals("RandomAI")){

        }

     }
 } 

  // menuListener for Admin
  private class AdminMenuItemListener implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
      // Find out the text of the adminOptions that was just clicked

      String text = ((MenuItem) e.getSource()).getText();
        if (text.equals("Sign Out")){
            
            loginMsg.setText("Sign In"); 
            window.setTop(loginMsg);
            window.setCenter(acctGrid);
            window.setBottom(loginGrid);

        }

         // creates new User 
         if (text.equals("Create User")){
            
            window.setCenter(acctGrid);
            window.setBottom(createU);

        }
       

        // finds and removes User
        for( Iterator<User> iter = users.iterator(); iter.hasNext();){

           User usr = iter.next();
           if (text.equals(usr.getName())){

System.out.println("got it 2"); 

           Alert alert = new Alert(AlertType.CONFIRMATION);

           alert.setHeaderText("Remove User?");

           Optional<ButtonType> result = alert.showAndWait();
             if (result.get() == ButtonType.OK){

             iter.remove(); 

             window.setTop(null);
             setUpUserMenus();
             setUpAdminMenus();
             window.setTop(mainMenu);
             man.pushUserData(); 


System.out.println("removed user"); 

             } else {
System.out.println("cancel"); 

             }

           }

        }

     }
 } 

   // handles both login and create user
   private class LoginButtonListener implements EventHandler<ActionEvent>{

      @Override
      public void handle(ActionEvent arg0){
   
         if(loginB==(Button) arg0.getSource()){

            if(acctT.getText().equals("") || pswdT.getText().equals("")){
              loginMsg.setText("Enter Acct/Pswd");
            }else{


             if(songs.size()!=0){
              songs.add("SwingCheese.wav");
              songs.add("SwingCheese.wav");
             }else{
              songs.add("Capture.wav");
              songs.add("Capture.wav");
              play();
             } 

              man.checkUser(acctT.getText(),pswdT.getText());

            } 

          acctT.setText("");
          pswdT.setText("");

         }

         if(createU==(Button) arg0.getSource()){

          man.checkUser(acctT.getText(),pswdT.getText());

             window.setTop(null);
             setUpUserMenus();
             setUpAdminMenus();
             window.setTop(mainMenu); 
             window.setCenter(buttonGrid);
             window.setBottom(null);
             acctT.setText("");
             pswdT.setText("");


         }

      }

   }


  // class to push and pull Vector users
  public class FileManager {

  
   public FileManager(){

    pullUserData();
/*
   try {
    FileInputStream fin = new FileInputStream("thequeue.dat");
    ObjectInputStream ois = new ObjectInputStream(fin);
    users = (Vector) ois.readObject();
    ois.close();
    }
   catch (Exception e) { e.printStackTrace(); }
*/
   }

   public void checkUser(String logUser, String pswd){

//System.out.println("no1 "+users.size());

      int cnt=0;

      if( logUser.equals("Merlin") && pswd.equals("7777777")){ 
    
System.out.println("got it"); 

       setUpUserMenus();
       setUpAdminMenus();
       window.setTop(mainMenu);
       window.setCenter(buttonGrid);
       window.setBottom(null);
  
      }else{

      for( User user : users ){

        cnt++;
        if(user.getName().equals(logUser)){
          cnt--;
          if(user.getPassword().equals(pswd)){

             mainUser = user; 
             mainHours = mainUser.getMins();
             mainPlays = mainUser.getPassword();
             setUpUserMenus();
 
             loginMsg.setText("Success");   
             window.setTop(mainMenu);
             window.setCenter(buttonGrid);
             window.setBottom(null);

          }else{
             loginMsg.setText("Try Again");   
          }

        }

      } 

     }

//System.out.println("no2 "+users.size());

      if(cnt==users.size()){
         loginMsg.setText("New User");   
         User addUser = new User(logUser,pswd, "test");
         users.add(addUser); 
      }

//System.out.println("no3 "+users.size());
     pushUserData();

/*
   try {
      FileOutputStream fout = new FileOutputStream("thequeue.dat");
      ObjectOutputStream oos = new ObjectOutputStream(fout);
      oos.writeObject(users);
      oos.close();
      }
    catch (Exception e) { e.printStackTrace(); }
*/ 

   } 

  public void getVector(){


  }

  @SuppressWarnings("unchecked")
  public void pullUserData(){

    try {
     FileInputStream fin = new FileInputStream("thequeue.dat");
     ObjectInputStream ois = new ObjectInputStream(fin);
     users = (Vector) ois.readObject();
     ois.close();
     }
    catch (Exception e) { e.printStackTrace(); 
    }



  }

  public void pushUserData(){

    try {
       FileOutputStream fout = new FileOutputStream("thequeue.dat");
       ObjectOutputStream oos = new ObjectOutputStream(fout);
       oos.writeObject(users);
       oos.close();
        }
     catch (Exception e) { e.printStackTrace(); 
    }


  }


 }


}

