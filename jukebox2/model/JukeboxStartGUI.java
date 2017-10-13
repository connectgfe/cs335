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

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

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



public class JukeboxStartGUI extends Application {
  


        private static BorderPane window;
        private MenuBar menuBar;
        private TextField acctT;
        private PasswordField pswdT; 
        private Button loginB, logoutB;
        private GridPane acctGrid, buttonGrid;
        private Label acctLabl, pswdLabl, loginMsg; 
        private Vector<User> users;
        private FileManager man;
        private User mainUser;
        private String mainHours, mainPlays;
        private MenuItem hoursVal, playsVal;
  
    @Override
    public void start(Stage stage) throws Exception {


        window = new BorderPane(); 
        window.setStyle( "-fx-background-image: url(\"file:jukeboxLabel.jpeg\")");

        users = new Vector<User>();

        acctGrid = new GridPane();
 
        buttonGrid = new GridPane();

        Scene scene = new Scene(window, 300, 250);
      
        man = new FileManager();

        setUpGrids();

//        setUpMenus();

//        window.setTop(menuBar); 
        stage.setScene(scene);

        stage.show();

//        man = new FileManager();



    }

    // main method to support non-JavaFX-aware environments:

    public static void main(String[] args) {
        launch(args); 
    }



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


    window.setAlignment(acctGrid, Pos.CENTER); 
    window.setMargin(acctGrid, new Insets(10,10,10,10));
    window.setCenter(acctGrid);

    window.setAlignment(buttonGrid, Pos.CENTER); 
    window.setMargin(buttonGrid, new Insets(10,10,100,125));
    window.setBottom(buttonGrid);

    buttonGrid.add(loginB,1,1);
 
    ButtonListener handler1 = new ButtonListener();
    loginB.setOnAction(handler1);



    }


  private void setUpMenus() {

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

    MenuItem quit = new MenuItem("Quit");
    Menu options = new Menu("Menu");
    options.getItems().addAll(account, playlist, quit);

    menuBar = new MenuBar();
    menuBar.getMenus().addAll(options);

    // Add the same listener to all menu items requiring action
    MenuItemListener menuListener = new MenuItemListener();

//    totHours.setOnAction(menuListener);
//    dailyPlays.setOnAction(menuListener);
    quit.setOnAction(menuListener);

    textAreaV.setOnAction(menuListener);
/*
    textAreaD.setOnAction(menuListener);
    intermediate.setOnAction(menuListener);
*/
  }


  private class MenuItemListener implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
      // Find out the text of the JMenuItem that was just clicked
      String text = ((MenuItem) e.getSource()).getText();
        if (text.equals("Quit")){
            
            loginMsg.setText("Sign In"); 
            window.setTop(loginMsg);
            window.setCenter(acctGrid);
            window.setBottom(buttonGrid);

        }else if (text.equals("TextArea")){

             mainUser.setMins(2.3);
             mainHours = mainUser.getMins();
             hoursVal.setText(mainHours);
             man.push();

        }else if (text.equals("Drawing")){

        }else if (text.equals("New Game")){

        }else if (text.equals("Intermediate")){
  
        }else if (text.equals("RandomAI")){

        }

     }
 } 




   private class ButtonListener implements EventHandler<ActionEvent>{

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
/*
         if(button2==(Button) arg0.getSource()){

          txtbox1.setText("");
          txtbox2.setText("");


         }

*/


      }



   }

  public class FileManager {

  
   public FileManager(){

    pull();
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

      for( User user : users ){

        cnt++;
        if(user.getName().equals(logUser)){
          cnt--;
          if(user.getPassword().equals(pswd)){

             mainUser = user; 
             mainHours = mainUser.getMins();
             mainPlays = mainUser.getPassword();
//             hoursVal.setText(mainHours); 
//             playsVal.setText(mainPlays); 
             setUpMenus();
 
             loginMsg.setText("Success");   
             window.setTop(menuBar);
             window.setCenter(null);
             window.setBottom(null);

          }else{
             loginMsg.setText("Try Again");   
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
     push();

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
  public void pull(){

    try {
     FileInputStream fin = new FileInputStream("thequeue.dat");
     ObjectInputStream ois = new ObjectInputStream(fin);
     users = (Vector) ois.readObject();
     ois.close();
     }
    catch (Exception e) { e.printStackTrace(); 
    }



  }

  public void push(){

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


/*
  public class FileMan2 {

    public FileMan2(){};

    public  void checkUser(String user, String pswd) {
        try{
            // Create new file
           // String content = "This is the content to write into create file";
            String path="Users/"+user;
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                loginMsg.setText("New User");
                file.createNewFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Write in file
            bw.write(pswd+"\n");
            bw.write("0"+"\n");
            LocalDate date = LocalDate.now();
            bw.write(date.toString()+"\n");
            String day= Integer.toString(date.getDayOfYear());
            bw.write(day);
            bw.close();

            }else{

            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);
            StringBuilder usrPswd = new StringBuilder(br.readLine());
            StringBuilder totMins = new StringBuilder(br.readLine());
            StringBuilder dateJoin = new StringBuilder(br.readLine());
            StringBuilder dayDate = new StringBuilder(br.readLine());
         
System.out.println("User: "+acctT.getText()+"\n"+"Password: "+usrPswd+"\n"+"Total Min Used: "+totMins+"\n"+"Date Joined: "+dateJoin+"\n"+"Day: "+dayDate);
            updatePlays(acctT.getText()); 
              if(usrPswd.toString().equals(pswdT.getText())){
                  loginMsg.setText("Success");
              }else{
                  loginMsg.setText("Bad Pswd");
              }  
          
             br.close(); 
            }
            // Close connection
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
  

     public void updatePlays(String user){

           File users = new File("Users");
           File[] list = users.listFiles();
        
           
           for(File file : list){

             if(file.getName().equals(user)){
System.out.println("got: "+file.getName());             
                try{
                  FileReader tempFr = new FileReader(file.getAbsoluteFile());
                  FileReader fr = new FileReader(file.getAbsoluteFile());
                  BufferedReader tempBr = new BufferedReader(tempFr);
                  BufferedReader br = new BufferedReader(fr);
              
         //         StringBuilder ln2 = new StringBuilder(br.readLine());
                    int cnt=0; 
                    while(tempBr.readLine()!=null){ 

                     cnt++;
                    }


                FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
                BufferedWriter bw = new BufferedWriter(fw);



                    for(int i=0;i<cnt;i++){

                       bw.write("hello");
                    }



            FileReader tfr = new FileReader(file.getAbsoluteFile());
            BufferedReader tbr = new BufferedReader(tfr);
            StringBuilder usrPswd = new StringBuilder(tbr.readLine());
            StringBuilder totMins = new StringBuilder(tbr.readLine());
            StringBuilder dateJoin = new StringBuilder(tbr.readLine());
            StringBuilder dayDate = new StringBuilder(tbr.readLine());
         
System.out.println("User: "+acctT.getText()+"\n"+"Password: "+usrPswd+"\n"+"Total Min Used: "+totMins+"\n"+"Date Joined: "+dateJoin+"\n"+"Day: "+dayDate);



//           StringBuilder ln1 = new StringBuilder(br.readLine());
 
// System.out.println(ln1);             

//                 bw.write("hello");
                 }catch(Exception e){
                   System.out.println(e);
                 } 
            
            }

          }
   
     }



  }



*/





}

