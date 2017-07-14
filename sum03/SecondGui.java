import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.text.*;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SecondGui extends Application{


   MenuBar menuBar;
   BorderPane window;
   ImageView thepic; 
   Image pic; 
   Button button;  
   Text greeting;
   TextField inputBox;

 
   public static void main(String[] args){
    launch(args);   

   }

   public void start(Stage stage){

    stage.setTitle("Test Client");
    window = new BorderPane();
    Scene scene = new Scene(window, 350, 250);

    setupMenus();
    setupButton(); 

    window.setTop(menuBar);    

    startView("dog.png");

    stage.setScene(scene);
   
    stage.show();
   }

   public void setupMenus(){

// use feh then if needed: convert -resize 10% first.png second.png then jpegtran -rotate 90 if need to rotate
    MenuItem first = new MenuItem("Buns1");

    MenuItem second = new MenuItem("SecondSub"); 

    Menu subm = new Menu("Subm");
    subm.getItems().addAll(first,second);

    MenuItem nonsub = new MenuItem("Dog pic");
    Menu mens = new Menu("Munus");

    mens.getItems().addAll(subm,nonsub);

    menuBar = new MenuBar();
    menuBar.getMenus().addAll(mens); 

    MenuItemListener menuListen = new MenuItemListener();
    
    nonsub.setOnAction(menuListen);
    first.setOnAction(menuListen);
    second.setOnAction(menuListen);
   }

   public void setupButton(){

    button = new Button("Enter");
    window.setAlignment(button,Pos.CENTER); 
    window.setRight(button); 

    ButtonListener buttonListen = new ButtonListener();

    button.setOnAction(buttonListen);

   }


   public void setView(String val){

    window.setCenter(null); 
    pic = new Image(val);
    thepic = new ImageView();
    thepic.setImage(pic); 
    window.setCenter(  thepic );


   }

   public void startView(String val){

    greeting = new Text(0,0,"Enter Valid IP");
    Font font = new Font(30); 
    greeting.setFont(font);

    window.setAlignment(greeting,Pos.CENTER);
    window.setBottom(greeting);     

    inputBox = new TextField();
    window.setAlignment(inputBox,Pos.CENTER);

    window.setLeft(inputBox);

/*
    pic = new Image(val);
    thepic = new ImageView();
    thepic.setImage(pic); 
   
    window.setBottom(  thepic );
*/
   }

/*
   public void addButton(){


   ImageIcon middleButtonIcon = createImageIcon("images/middle.gif");
   b2 = new JButton("Middle button", middleButtonIcon);
   b2.setVerticalTextPosition(AbstractButton.BOTTOM);
   b2.setHorizontalTextPosition(AbstractButton.CENTER);
   b2.setMnemonic(KeyEvent.VK_M);

   window.setCenter(b2);

   }
*/


   class MenuItemListener implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {

     String text = ( (MenuItem) e.getSource()).getText();

      if (text.equals("Dog pic")){

       setView("dog.png");
      }

       if (text.equals("Buns1")){

       setView("buns3.png");
      }

      if (text.equals("SecondSub")){

       setView(null);
      }


    }

   }

   class ButtonListener implements EventHandler<ActionEvent> {

    @Override

    public void handle(ActionEvent e)  {

    String val = inputBox.getText();
    Jcli client = new Jcli(val,3500);

     Text msg  = new Text(val);
    Font font = new Font(30); 
    greeting.setFont(font);

    window.setBottom(msg);     




    }



   }




}
