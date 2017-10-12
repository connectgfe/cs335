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


public class JukeboxStartGUI extends Application {
  


        private BorderPane window;
        private TextField acctT;
        private PasswordField pswdT; 
        private Button loginB, logoutB;
        private GridPane acctGrid, buttonGrid;
        private Label acctLabl, pswdLabl, loginMsg; 
        private FileManager man;


    @Override
    public void start(Stage stage) throws Exception {


        window = new BorderPane(); 
        window.setStyle( "-fx-background-image: url(\"file:doge.jpeg\")");


        acctGrid = new GridPane();
 
        buttonGrid = new GridPane();

        Scene scene = new Scene(window, 300, 250);

        setUp();

        stage.setScene(scene);

        stage.show();

        man = new FileManager();

    }

    // main method to support non-JavaFX-aware environments:

    public static void main(String[] args) {
        launch(args); 
    }



    public void setUp(){

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


   private class ButtonListener implements EventHandler<ActionEvent>{

      @Override
      public void handle(ActionEvent arg0){
   
         if(loginB==(Button) arg0.getSource()){

            if(acctT.getText().equals("") || pswdT.getText().equals("")){
              loginMsg.setText("Try Again");
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

    public FileManager(){};

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
            bw.write(pswd);
            bw.close();

            }else{

            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);

System.out.println(br.readLine());
 
              if(br.readLine().equals(pswdT.getText())){
System.out.println("no1");


                  loginMsg.setText("Success");
              }else{
System.out.println("no2");


                  loginMsg.setText("Try Again");
              }  
          
             br.close(); 
            }
            // Close connection
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
  }



}

