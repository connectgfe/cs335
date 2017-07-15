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

        static Socket connect;

 

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


    public static Socket getSock(){
     return connect;

    }


    public static void setSock(Socket soc){

     ftest.connect= soc;

    }

    @FXML
    private TextField txtfield;

    @FXML
    private TextField txtbox;


    public ftest(){}

    @FXML
    public void initialize(){}


    @FXML 
    public void pressed() throws IOException{

//    System.out.println(txtbox.getText());
   
    int check=0;

    String host = "127.0.0.1";//txtfield.getText();
    String input=txtfield.getText();

    if(input.length()<1){return;}

    int port = Integer.parseInt(input);//3500;
    

    try{

      InetAddress address = InetAddress.getByName(host);
      connect = new Socket(address, port);
      check= connect.getPort();

      setSock(connect); 

      System.out.println("SocketClient initialized");

         BufferedOutputStream bos = new BufferedOutputStream(connect.getOutputStream());
       OutputStreamWriter   osw = new OutputStreamWriter(bos);
      System.out.println("**here**");

      String val="HellOOOO";


      osw.write(val,0,val.length());
      osw.flush();


     }
    catch (IOException f) {
      System.out.println("IOException: " + f);
    }
    catch (Exception g) {
      System.out.println("Exception: " + g);
    }
   

   if(check!=0){

 
    loadtwo = new FXMLLoader(getClass().getResource("soccon.fxml"));

    roottwo = loadtwo.load();
    Scene scenetwo = new Scene(roottwo);
    Stage secondStage = new Stage();
    secondStage.setScene(scenetwo);
    secondStage.show();

   }


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


   System.out.println("heretwo "+getSock().getPort());
    String val = txtbox.getText();



          BufferedOutputStream bos = new BufferedOutputStream(getSock().getOutputStream());
       OutputStreamWriter   osw = new OutputStreamWriter(bos);

      
      osw.write(val,0,val.length());
      osw.flush();

     txtbox.setText("");


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


