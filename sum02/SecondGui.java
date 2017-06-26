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



public class SecondGui extends Application{


   MenuBar menuBar;
   BorderPane window;
   
   public static void main(String[] args){
    launch(args);   

   }

   public void start(Stage stage){

    stage.setTitle("Trial");
    window = new BorderPane();
    Scene scene = new Scene(window, 250, 250);

    setupMenus();
    window.setTop(menuBar);    

    stage.setScene(scene);
   
    stage.show();
   }

   public void setupMenus(){

    MenuItem first = new MenuItem("FirstSub");
    MenuItem second = new MenuItem("SecondSub"); 

    Menu subm = new Menu("Subm");
    subm.getItems().addAll(first,second);

    MenuItem nonsub = new MenuItem("StandAlone");
    Menu mens = new Menu("Munus");

    mens.getItems().addAll(subm,nonsub);

    menuBar = new MenuBar();
    menuBar.getMenus().addAll(mens); 

    MenuItemListener menuListen = new MenuItemListener();
    
    nonsub.setOnAction(menuListen);

   }

   public void setView(String val){
  
    window.setCenter(val);

   }



}

 class MenuItemListener implements EventHandler<ActionEvent> {

  @Override
  public void handle(ActionEvent e) {

  String text = ( (MenuItem) e.getSource()).getText();

   if (text.equals("StandAlone")){

     setView("dog.png");
   }


  }




 }
