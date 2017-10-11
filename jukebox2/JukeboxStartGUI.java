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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

import javafx.event.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.net.*;
import java.io.*;



public class JukeboxStartGUI extends Application {
  


        private BorderPane window;
        private TextField acctT, pswdT; 
        private Button loginB, logoutB;
        private GridPane acctGrid, buttonGrid;
        private Label acctLabl, pswdLabl; 

    @Override
    public void start(Stage stage) throws Exception {


        window = new BorderPane(); 

        acctGrid = new GridPane();
 
        buttonGrid = new GridPane();

        Scene scene = new Scene(window, 300, 250);

        setUp();

        stage.setScene(scene);

        stage.show();

    }

    // main method to support non-JavaFX-aware environments:

    public static void main(String[] args) {
        launch(args); 
    }



    public void setUp(){

    loginB = new Button("Login");
    acctT = new TextField();
    pswdT = new TextField();
    acctLabl = new Label("Account Name");
    pswdLabl = new Label("Password");   

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
    window.setMargin(acctGrid, new Insets(30,10,10,10));
    window.setCenter(acctGrid);

    window.setAlignment(buttonGrid, Pos.CENTER); 
    window.setMargin(buttonGrid, new Insets(10,10,50,50));
    window.setBottom(buttonGrid);

    buttonGrid.add(loginB,1,1);
 
    ButtonListener handler1 = new ButtonListener();
    loginB.setOnAction(handler1);



    }


   private class ButtonListener implements EventHandler<ActionEvent>{

      @Override
      public void handle(ActionEvent arg0){
   
         if(loginB==(Button) arg0.getSource()){

          System.out.println(acctT.getText());
          pswdT.setText(acctT.getText());


         }
/*
         if(button2==(Button) arg0.getSource()){

          txtbox1.setText("");
          txtbox2.setText("");


         }

*/


      }



   }


}

