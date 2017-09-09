import javafx.scene.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.*;
import java.io.*;

public class TemperatureConverterGUI extends Application {


        FXMLLoader loadone;

        Parent rootone;

 

    @Override
    public void start(Stage primaryStage) throws Exception {
        // just load fxml file and display it in the stage:
        loadone = new FXMLLoader(getClass().getResource("tempConverter.fxml"));
        rootone = loadone.load();
        Scene sceneone = new Scene(rootone);
        primaryStage.setScene(sceneone);
        primaryStage.show();
    }

    // main method to support non-JavaFX-aware environments:

    public static void main(String[] args) {
        // starts the FX toolkit, instantiates this class, 
        // and calls start(...) on the FX Application thread:
        launch(args); 
    }


    @FXML
    private TextField txtbox; 

    @FXML
    private Button button;

    @FXML
    public void pressed() throws IOException{
   
 
    }


 }

