
import javafx.scene.*;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader; 
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.*;
import java.net.*;
import javafx.application.Application;
import java.io.*;

public class fxCont {



    @FXML
    private TextField txtfield;

    @FXML
    private Button button;


    @FXML
    private TextField txtbox;

    Jcli client;

    public fxCont(){}

    @FXML
    public void initialize(){}


    @FXML 
    public void pressed(ActionEvent event) throws IOException{
/*
    String val = txtfield.getText();
    client = new Jcli(val,3500);  
*/


 Parent blah = FXMLLoader.load(getClass().getResource("soccom.fxml"));
            Scene scene = new Scene(blah);
            Window orig = button.getOwner();
            orig.setScene(scene);
/* 
    FXMLLoader loadit = new FXMLLoader(getClass().getResource("soccon.fxml"));
    button.getScene().setRoot(loadit.getRoot());
*/
/*
FXMLLoader loader = new FXMLLoader(getClass().getResource("soccon.fxml"));

Stage stage = (Stage) button.getScene().getWindow();
Scene scene = new Scene(loader.getRoot());
stage.setScene(scene);
*/   
//    System.out.println(txtfield.getText());

    }

    public void sendtxt()  {

    String val = txtbox.getText();
        
//    client.sendmsg(val);


    }

   
}


 
