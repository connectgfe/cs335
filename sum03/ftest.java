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


public class ftest extends Application {


        FXMLLoader loadone, loadtwo;

        Parent rootone, roottwo;

        Socket connection;

     BufferedOutputStream bos;

     OutputStreamWriter   osw;
 

    @Override
    public void start(Stage primaryStage) throws Exception {
        // just load fxml file and display it in the stage:
        loadone = new FXMLLoader(getClass().getResource("test2.fxml"));
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
    private TextField txtfield;

    @FXML
    private Button button;

    @FXML
    private Button buttontwo;

    @FXML
    private TextField txtbox;


    public ftest(){}

    @FXML
    public void initialize(){}


    @FXML 
    public void pressed() throws IOException{

//    System.out.println(txtbox.getText());
   

/*
    String host = "127.0.0.1";//txtfield.getText();
    int port = Integer.parseInt(txtfield.getText());//3500;

    StringBuffer instr = new StringBuffer();


      InetAddress address = InetAddress.getByName(host);


       connection = new Socket(address, port);

     System.out.println("SocketClient initialized");

     bos = new BufferedOutputStream(connection.getOutputStream());

      osw = new OutputStreamWriter(bos);
      System.out.println("**here**");

     String val="HellOOOO";


      osw.write(val,0,val.length());
      osw.flush();

*/





 
    loadtwo = new FXMLLoader(getClass().getResource("soccon.fxml"));

    roottwo = loadtwo.load();
    Scene scenetwo = new Scene(roottwo);
    Stage primaryStage = new Stage();
    primaryStage.setScene(scenetwo);
    primaryStage.show();

//    stage.toBack();

/*
FXMLLoader loader = new FXMLLoader(getClass().getResource("soccon.fxml"));

Stage stage = (Stage) button.getScene().getWindow();
Scene scene = new Scene(loader.getRoot());
stage.setScene(scene);
*/   
//    System.out.println(txtbox.getText());

    }

   @FXML 
   public void sendtxt() throws IOException {


System.out.println("heretwo");
    String val = txtbox.getText();
/*        
 System.out.println(val);
      osw.write(val,0,val.length());
      osw.flush();
*/



//    client.sendmsg(val);


    }

   
}


 
/*
import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Jcli {

      OutputStreamWriter osw; 

  public Jcli(String ip, int prt) {
    String host = ip;
    int port = prt;

    StringBuffer instr = new StringBuffer();
    String TimeStamp;

 try {

      InetAddress address = InetAddress.getByName(host);


      Socket connection = new Socket(address, port);

     System.out.println("SocketClient initialized");

     BufferedOutputStream bos = new BufferedOutputStream(connection. getOutputStream());

       osw = new OutputStreamWriter(bos);//, "US-ASCII");


      System.out.println("**here**");

      String process = "Hello from java\n";



      osw.write(process,0,process.length());
      osw.flush();


      


      BufferedInputStream bis = new BufferedInputStream(connection.
          getInputStream());

      InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");


/*

/*
      Scanner sc = new Scanner(System.in);
       

      while(sc.hasNext()){
      osw.write(process,0,process.length());

 //     osw.write(sc.next(),0,sc.next().length());
      osw.flush();


      }

*/

/*

      int c;
      while ( (c = isr.read()) != 13)
        instr.append( (char) c);

      connection.close();
      System.out.println(instr);
     }
    catch (IOException f) {
      System.out.println("IOException: " + f);
    }
    catch (Exception g) {
      System.out.println("Exception: " + g);
    }
  }

   public void sendmsg(String val) throws Exception{


      osw.write(val,0,val.length());
      osw.flush();


   }


}

*/


