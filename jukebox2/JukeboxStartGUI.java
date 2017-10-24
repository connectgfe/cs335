package controller_view;

/**
 * This program is a functional spike to determine the interactions are 
 * actually working. It is an event-driven program with a graphical user
 * interface to affirm the functionality all Iteration 1 tasks have been 
 * completed and are working correctly. This program will be used to 
 * test your code for the first 100 points of the JukeBox project.
 */

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
import java.time.LocalDate;
import java.util.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import java.util.concurrent.TimeUnit;
import java.time.LocalDate;
import model.Song;
import model.SongCell;
import model.User;

public class JukeboxStartGUI extends Application {
  


        private static BorderPane window;
        private MenuBar mainMenu;
        private Menu userMenuBar, adminMenuBar;
        private TextField acctT;
        private PasswordField pswdT; 
        private Button loginB, playB, pauseB, stopB, createU;
        private GridPane acctGrid, loginGrid, buttonGrid;
        private Label acctLabl, pswdLabl, loginMsg, playsMsg; 
        private Vector<User> users;
        private FileManager man;
        private User mainUser;
        private String mainHours, mainPlays;
        private MenuItem hoursVal, song1, song2, song3;
        private LinkedList<Song> songs; 
        private LinkedList<String> songQueue; 
        private static MediaPlayer player;
        Song capture, swingCheese, lopingSting;
        private ListView<Song> songList;
        private ObservableList<Song> songsList = FXCollections.observableArrayList();
        private ListView<String> displayList;
        ObservableList<SongCell> data =
                FXCollections.observableArrayList(
                    new SongCell("Capture", "GameFreak","0:05","Capture.mp3"),
                    new SongCell("LopingSting", "Kevin MacLeod","0:04","LopingSting.mp3"),
                    new SongCell("SwingCheese", "FreePlay Music","0:15","SwingCheese.mp3")
                );


 
    @Override
    public void start(Stage stage) throws Exception {


        window = new BorderPane(); 

        

        users = new Vector<User>();

        songs = new LinkedList<Song>();

        songQueue = new LinkedList<String>();

        acctGrid = new GridPane();

        buttonGrid = new GridPane();

        loginGrid = new GridPane();

        Scene scene = new Scene(window, 330, 300);
      
        man = new FileManager();

        setUpLoginMenu();

        setUpTableView();

        addSongs();

        addUsers();

        play();

        stage.setScene(scene);

        stage.show();


    }


    public static void main(String[] args) {
        launch(args); 
    }



   public void addSongs(){

    if(songs.size()==0){
 
    capture = new Song("Capture.mp3");
    songs.add(capture);

    swingCheese = new Song("SwingCheese.mp3");
    songs.add(swingCheese);

    lopingSting = new Song("LopingSting.mp3");
    songs.add(lopingSting);
    }

   }

   public void addUsers(){

     User merlin = new User("Merlin", "7777777", LocalDate.now());
     users.add(merlin);
     User chris = new User("Chris", "1", LocalDate.now());
     users.add(chris);
     User devon = new User("Devon", "22", LocalDate.now());
     users.add(devon);
     User river = new User("River", "333", LocalDate.now());
     users.add(river);
     User ryan  = new User("Ryan", "4444", LocalDate.now());
     users.add(ryan);

   }

   public void play(){

        if(songQueue.size()==0){ return;}
          
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

//System.out.println("Stopped");

                songQueue.poll();
//System.out.println("Dequeue");


                if (songQueue.size()!=0) {
                    //Plays the subsequent files
//System.out.println("Songs has next");
 
                MediaPlayer player = new MediaPlayer(media);
                play();

                }

                return;
            }
        });

    }


// all grids: buttonGrid loginGrid acctGrid createU(button)

    public void setUpTableView(){
    	displayList = new ListView<String>();
    	ObservableList<String> emails = FXCollections.observableArrayList();
    	emails.add("hello");
    	emails.add("song2");
    	TableView<SongCell> table = new TableView();
    	table.setEditable(true);
    	TableColumn playsCol = new TableColumn("Plays");
        TableColumn titleCol = new TableColumn("Title");
        TableColumn artistCol = new TableColumn("Artist");
        TableColumn timeCol = new TableColumn("Time");
        final Label label = new Label("Song List");
        label.setFont(new Font("Arial", 20));
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(label, table);
        window.setCenter(vbox);
        titleCol.setCellValueFactory(
                new PropertyValueFactory<SongCell, String>("songTitle"));
        playsCol.setCellValueFactory(
                new PropertyValueFactory<SongCell, Integer>("songPlays"));
        artistCol.setCellValueFactory(
                new PropertyValueFactory<SongCell, String>("artist"));
        timeCol.setCellValueFactory(
                new PropertyValueFactory<SongCell, String>("songLength"));
    	table.setItems(data);
    	table.getColumns().addAll(playsCol,titleCol,artistCol,timeCol);
    	table.getColumns().get(0).setVisible(false);
		   table.getColumns().get(0).setVisible(true);
    	table.setOnMouseClicked(new EventHandler<MouseEvent>() {
    		@Override
    		 public void handle(MouseEvent click) {
    			if (click.getClickCount() == 2 && mainUser!=null) {
    		  TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
    		   int col = 1;
    		    int row = pos.getRow();
    		    SongCell item = table.getItems().get(row);
    		   System.out.println("Selected Value, " + item.filePath);
    		   if(mainUser.totalPlays<3) {
    			   item.setSongPlays();
    		   }
    		   table.getColumns().get(0).setVisible(false);
    		   table.getColumns().get(0).setVisible(true);
    		   System.out.println("Song plays, " + item.songPlays);
               if(mainUser.totalPlays>=3) {
	            	Alert alert = new Alert(AlertType.INFORMATION);
 	               alert.setTitle("Daily Max Alert"); 
 	               alert.setHeaderText(null);
 	               alert.setContentText("You have used your daily plays");
 	              alert.showAndWait();
	             }
               else {
            	   
            		   mainUser.totalPlays++;
            	   
               }
    		   
    		   
    		   // main loop for both user and song plays
    	        for( Iterator<Song> iter = songs.iterator(); iter.hasNext();){

    	           Song sng = iter.next();
    	 
    	          if(item.filePath.equals(sng.filePath)){


    	//System.out.println(mainUser.name);

    	             LocalDate day = LocalDate.now();
    	             
    	             // reset user plays if next day
    	             if(day.getDayOfYear()>mainUser.firstPlay.getDayOfYear()){
    	//System.out.println("reseting user plays");
    	               mainUser.totalPlays=0;

    	             }

    	              // reset song plays if next day
    	             if(day.getDayOfYear()>sng.firstPlay.getDayOfYear()){
    	//System.out.println("reseting song plays");
    	               sng.resetSongPlays();

    	             }

    	             sng.setPlays(day); 

    	             // send alert that song reached max plays
    	             if(sng.plays>2){
    	               
    	               Alert alert = new Alert(AlertType.INFORMATION);
    	               alert.setTitle("Daily Max Alert");
    	               alert.setHeaderText(null);
    	               alert.setContentText("This song has reached daily max plays");

    	               alert.showAndWait();

    	             }
    	             
    	             
    	 
    	            // play if user plays availale
    	            if(mainUser.song3.equals("(song 3)") && sng.plays<3){

    	//System.out.println(sng.filePath+" "+sng.plays+" "+sng.firstPlay.getDayOfYear());

    	               if(songQueue.size()!=0){
    	                 songQueue.add(sng.filePath);
    	                 sng.plays++;
    	               }else{
    	                songQueue.add(sng.filePath);
    	                 sng.plays++;
    	                play();
    	               } 



    	              
    	            // add song to user plays
    	              if(mainUser.song1.equals("(song 1)")){

    	                mainUser.setSongOne(item.getSongTitle(), LocalDate.now());
    	//System.out.println("song 1");

    	              }else if(mainUser.song2.equals("(song 2)")){

    	                mainUser.setSongTwo(item.filePath);
    	//System.out.println("song 2");

    	              }else if(mainUser.song3.equals("(song 3)")){

    	                mainUser.setSongThree(item.filePath);
    	//System.out.println("song 3");

    	              }
    	              setUpUserMenus();
    		   
    		   
    			}
    		  }
    		 }}}});

    }



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

    song1 = new MenuItem(mainUser.song1);
    song2 = new MenuItem(mainUser.song2);
    song3 = new MenuItem(mainUser.song3);

    Menu dailyPlays = new Menu("Daily Plays");

    dailyPlays.getItems().addAll(song1, song2, song3);

    Menu account = new Menu("Account");
    account.getItems().addAll(totHours, dailyPlays);

    // add songs for menu selections

    UserMenuItemListener userMenuListener = new UserMenuItemListener();

    Menu playlist = new Menu("Playlist");

      for( Song song : songs ){
   
        MenuItem sng = new MenuItem(song.filePath);
        sng.setOnAction(userMenuListener);
        playlist.getItems().addAll(sng);
        
      }

    MenuItem quit = new MenuItem("Sign Out");
    Menu userOptions = new Menu("Menu");
    userOptions.getItems().addAll(account, playlist, quit);

    // main menuBar
    mainMenu = new MenuBar();

    mainMenu.getMenus().addAll(userOptions);


    // Add the same listener to all menu items requiring action

    quit.setOnAction(userMenuListener);


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



  public void setUpLoginMenu(){

    LoginMenuItemListener loginMenuListener = new LoginMenuItemListener();

    MenuItem login = new MenuItem("Sign In");

    login.setOnAction(loginMenuListener);

    Menu userLog = new Menu("User");
    userLog.getItems().addAll(login);

    mainMenu = new MenuBar();


    mainMenu.getMenus().addAll(userLog);

    window.setTop(mainMenu);

  }


  private class LoginMenuItemListener implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
      // Find out the text of the JMenuItem that was just clicked
      String text = ((MenuItem) e.getSource()).getText();

          if (text.equals("Sign In")){


           window.setCenter(null);
           setUpLoginGrids();

          }

     }


  }





  // menuListener for User
  private class UserMenuItemListener implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
      // Find out the text of the JMenuItem that was just clicked
      String text = ((MenuItem) e.getSource()).getText();
        if (text.equals("Sign Out")){

          setUpLoginMenu();
          window.setTop(mainMenu);  
          setUpTableView();
        }
       
        // main loop for both user and song plays
        for( Iterator<Song> iter = songs.iterator(); iter.hasNext();){

           Song sng = iter.next();
 
          if(text.equals(sng.filePath)){


//System.out.println(mainUser.name);

             LocalDate day = LocalDate.now();
             
             // reset user plays if next day
             if(day.getDayOfYear()>mainUser.firstPlay.getDayOfYear()){
//System.out.println("reseting user plays");
               mainUser.resetPlays();

             }

              // reset song plays if next day
             if(day.getDayOfYear()>sng.firstPlay.getDayOfYear()){
//System.out.println("reseting song plays");
               sng.resetSongPlays();

             }

             sng.setPlays(day); 

             // send alert that song reached max plays
             if(sng.plays>2){
               
               Alert alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Daily Max Alert");
               alert.setHeaderText(null);
               alert.setContentText("This song has reached daily max plays");

               alert.showAndWait();

             }


            if(!mainUser.song3.equals("(song 3)")){
//System.out.println("used up songs");
              playsMsg = new Label("No Plays Available");
              window.setCenter(playsMsg);
 

            }
 
            // play if user plays availale
            if(mainUser.song3.equals("(song 3)") && sng.plays<3){

//System.out.println(sng.filePath+" "+sng.plays+" "+sng.firstPlay.getDayOfYear());

               if(songQueue.size()!=0){
                 songQueue.add(sng.filePath);
                 sng.plays++;
               }else{
                songQueue.add(sng.filePath);
                 sng.plays++;
                play();
               } 




            // add song to user plays
              if(mainUser.song1.equals("(song 1)")){

                mainUser.setSongOne(text, LocalDate.now());
//System.out.println("song 1");

              }else if(mainUser.song2.equals("(song 2)")){

                mainUser.setSongTwo(text);
//System.out.println("song 2");

              }else if(mainUser.song3.equals("(song 3)")){

                mainUser.setSongThree(text);
//System.out.println("song 3");

              }



             // push new user play
//UD             man.pushUserData();
        

             // update mainMenu
             if(mainUser.name.equals("Merlin")){
             window.setTop(null);
             setUpUserMenus();
             setUpAdminMenus();
             window.setTop(mainMenu);

             }else{

              window.setTop(null);
              setUpUserMenus();
              window.setTop(mainMenu);
              }



           }



         }

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

           setUpLoginMenu();
           window.setTop(mainMenu);    
           setUpTableView();
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

//System.out.println("got it 2"); 

           Alert alert = new Alert(AlertType.CONFIRMATION);

           alert.setHeaderText("Remove User?");

           Optional<ButtonType> result = alert.showAndWait();
             if (result.get() == ButtonType.OK){

             iter.remove(); 

             window.setTop(null);
             setUpUserMenus();
             setUpAdminMenus();
             window.setTop(mainMenu);
//UD             man.pushUserData(); 


//System.out.println("removed user"); 

             } else {
//System.out.println("cancel"); 

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

//UD    pullUserData();
 
   }

   public void checkUser(String logUser, String pswd){

//System.out.println("no1 "+users.size());

      int cnt=0;
/*
      if( logUser.equals("Merlin") && pswd.equals("7777777")){ 
    
System.out.println("got it"); 
       setUpUserMenus();
       setUpAdminMenus();
       window.setTop(mainMenu);
       window.setCenter(buttonGrid);
       window.setBottom(null);
  
      }else{
*/
      for( User user : users ){

        cnt++;
        if(user.getName().equals(logUser)){
          cnt--;
          if(user.getPassword().equals(pswd)){

                 if( logUser.equals("Merlin") && pswd.equals("7777777")){ 
//System.out.println("Got Merlin");
                   mainUser = user; 
                   mainHours = mainUser.getMins();
                   mainPlays = mainUser.getPassword();
                   setUpUserMenus();
                   setUpAdminMenus();
                   window.setTop(mainMenu);
                   window.setBottom(null);
                   setUpTableView();


                 }else{

             mainUser = user; 
             mainHours = mainUser.getMins();
             mainPlays = mainUser.getPassword();
             setUpUserMenus();
             setUpTableView();
             window.setTop(mainMenu);
             setUpTableView();
             window.setBottom(null);

             }

          }else{
             loginMsg.setText("Try Again");   
          }

        }

      } 

   //  }

//System.out.println("no2 "+users.size());

      if(cnt==users.size()){

//System.out.println("new user");

         loginMsg.setText("        New User\nRe-enter Acct/Pswd");   
         User addUser = new User(logUser, pswd, LocalDate.now());
         users.add(addUser); 


      }

//System.out.println("no3 "+users.size());

//UD     pushUserData();

   } 

  public void getVector(){


  }

  @SuppressWarnings("unchecked")
  public void pullUserData(){

    try {
     FileInputStream ufin = new FileInputStream("users.dat");
     ObjectInputStream uois = new ObjectInputStream(ufin);
     users = (Vector) uois.readObject();
     uois.close();
     }
    catch (Exception e) { e.printStackTrace(); 
    }


    try {
     FileInputStream sfin = new FileInputStream("songs.dat");
     ObjectInputStream sois = new ObjectInputStream(sfin);
     songs = (LinkedList) sois.readObject();
     sois.close();
     }
    catch (Exception e) { e.printStackTrace(); 
    }



  }

  public void pushUserData(){

    try {
       FileOutputStream ufout = new FileOutputStream("users.dat");
       ObjectOutputStream uoos = new ObjectOutputStream(ufout);
       uoos.writeObject(users);
       uoos.close();
        }
     catch (Exception e) { e.printStackTrace(); 
    }


    try {
       FileOutputStream sfout = new FileOutputStream("songs.dat");
       ObjectOutputStream soos = new ObjectOutputStream(sfout);
       soos.writeObject(songs);
       soos.close();
        }
     catch (Exception e) { e.printStackTrace(); 
    }



  }


 }


}


