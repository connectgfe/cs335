package controller;

import java.util.Observer;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.net.*;
import java.io.*;
import javafx.concurrent.Task;
import javafx.collections.ObservableList;
import java.awt.Point;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Optional;
import javafx.concurrent.Task;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/*
import model.SafariZone;
import views.TextView;
import views.LoginView;
*/

import map.GraphicView;
import map.MapView;
import map.PokemonView;
import map.TextView;
import menus.LoginView;
import model.SafariZone;
import javafx.concurrent.Task;
import persistence.FileManager;
import persistence.GameLoader;

public class SafariZoneMain extends Application {

	//private SafariZone theGame;
        private GameLoader gameLoader; 	
	private MenuBar menuBar;
	private Observer currentView;
	private Observer textView;
	private Observer graphicView; // to be implemented after textView
        private Observer loginView;
	
	private BorderPane window;
	public static final int height = 400;
	public static final int width = 600;
	
	char keyPressed;


        private Socket socket;
        private ObjectOutputStream outputToServer;
        private ObjectInputStream inputFromServer;
        private static final String Address = "localhost";
        public Point altPlayer;
        FileManager man = new FileManager();




	public static void main(String[] args) {
		   launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

                // sets up server connnection
//                openConnection();
		
                primaryStage.setTitle("SafariZone");
		keyPressed = 'z';
		window = new BorderPane();
		Scene scene = new Scene(window, width, height);


		setupMenus();
		window.setTop(menuBar);
		initializeGameForTheFirstTime();
	        setIntroView();	
		
		scene.setOnKeyReleased(new moveListener());
		
		//Setup the views
		textView = new TextView(gameLoader.getSafariZone());

		graphicView = new GraphicView(gameLoader.getSafariZone());

                loginView = new LoginView(man,gameLoader,graphicView);

		gameLoader.getSafariZone().addObserver(textView);
		gameLoader.getSafariZone().addObserver(graphicView);


//		setViewTo(graphicView); 
	
//		setViewTo(loginView); 
//		setViewTo(textView); //change to graphicView once graphicView is implemented
		
		primaryStage.setScene(scene);


		primaryStage.show();
		
	}
	



   private void setIntroView(){




  Image img = new Image("/images/shrubs/ground-g.bmp");
  ImageView view = new ImageView(img);
  view.setFitHeight(height);
  view.setFitWidth(width);

   window.setCenter(null);
   window.setCenter(view);


   }


	
	private void setViewTo(Observer newView) {
	    window.setCenter(null);
	    currentView = newView;
	    window.setCenter((Node) currentView);
	}
	
	
	public void initializeGameForTheFirstTime() {
	    gameLoader = new GameLoader( new SafariZone());
	}
	
	
	private void setupMenus() {
	    MenuItem textV = new MenuItem("Text");
	    MenuItem graphicV = new MenuItem("Graphics");

	    Menu views = new Menu("Views");
	    views.getItems().addAll(textV,graphicV); //, graphicV

            Menu user = new Menu("User");
	    MenuItem signIn = new MenuItem("Sign In");
            MenuItem signOut = new MenuItem("Sign Out");
            user.getItems().addAll(signIn, signOut);  
           	
	    MenuItem newGame = new MenuItem("New Game");
	    Menu options = new Menu("Options");
	    options.getItems().addAll(user, newGame, views);
	    
	    menuBar = new MenuBar();
	    menuBar.getMenus().addAll(options);
	 
	    // Add the same listener to all menu items requiring action
	    MenuItemListener menuListener = new MenuItemListener();
	    newGame.setOnAction(menuListener);
	    textV.setOnAction(menuListener);
 	    graphicV.setOnAction(menuListener);
              
            signIn.setOnAction(menuListener); 
            signOut.setOnAction(menuListener); 


//	    graphicV.setOnAction(menuListener);
	}
	
	
	public class moveListener implements EventHandler<KeyEvent> {

		@Override
		public void handle(KeyEvent event) {
				
                                if(event.getCode() == KeyCode.UP){
					keyPressed = 'U';
				gameLoader.getSafariZone().movePlayer(keyPressed);
				}
				else if(event.getCode() == KeyCode.DOWN){
					keyPressed = 'D';
   		                gameLoader.getSafariZone().movePlayer(keyPressed);
		

	}
				else if(event.getCode() == KeyCode.LEFT){
					keyPressed = 'L';
	                        gameLoader.getSafariZone().movePlayer(keyPressed);

}
				else if(event.getCode() == KeyCode.RIGHT){
					keyPressed = 'R';
	                        gameLoader.getSafariZone().movePlayer(keyPressed);

	}





//////// in progress: send point to server ie comment if needed

/*
           try {


                  outputToServer.writeObject(gameLoader.getSafariZone().getTrainerLoc());


//System.out.println("PkMain: "+gameLoader.getSafariZone().getTrainerLoc().getX()+" "+gameLoader.getSafariZone().getTrainerLoc().getY());
	



         	} catch (IOException e) {
			e.printStackTrace();
		}

*/
                
        
		}
		
	}
	
	private class MenuItemListener implements EventHandler<ActionEvent> {

	    @Override
	    public void handle(ActionEvent e) {
	      // Find out the text of the JMenuItem that was just clicked
	      String text = ((MenuItem) e.getSource()).getText();
	      if (text.equals("New Game")){

                SafariZone newGame = new SafariZone();
                  if( man.getUserFromSafariZone(gameLoader.getSafariZone())!=null){
                man.getUserFromSafariZone(gameLoader.getSafariZone()).setSafariZone(newGame); 
                loginView=null;  
                 }            
                gameLoader.setSafariZone(null);
                gameLoader.setSafariZone(newGame);
                graphicView = null;
                graphicView = new GraphicView(gameLoader.getSafariZone());
                gameLoader.getSafariZone().addObserver(graphicView);
 

                textView = null;
                textView = new TextView(gameLoader.getSafariZone());
                gameLoader.getSafariZone().addObserver(textView);
                
                loginView = new LoginView(man,gameLoader,graphicView);
                setViewTo(graphicView);
           

	      }else if (text.equals("Text")){
	        setViewTo(textView);
	      }else if (text.equals("Graphics")){
	        setViewTo(graphicView);
	      }else if (text.equals("Sign In")){
 
 		setViewTo(loginView);

	      }else if (text.equals("Sign Out")){
    
                // FileManager will push User data
  
//UD                man.pushUserData();  
                // new SafariZone and textView
                gameLoader.setSafariZone(null); 
                gameLoader.setSafariZone(new SafariZone());
                textView = null; 
                graphicView = null; 


                textView = new TextView(gameLoader.getSafariZone()); 

                graphicView = new GraphicView(gameLoader.getSafariZone()); 
                loginView = new LoginView(man,gameLoader,graphicView);
                gameLoader.getSafariZone().addObserver(textView); 
                gameLoader.getSafariZone().addObserver(graphicView); 

                setIntroView(); 
      //          setViewTo(graphicView);
	
              }
	    }
	}

  
//////////////// work in progress




  private void openConnection() {
    // Our server is on our computer, but make sure to use the same port.
    try {
      socket = new Socket(Address, 4001);
      outputToServer = new ObjectOutputStream(socket.getOutputStream());
      inputFromServer = new ObjectInputStream(socket.getInputStream());

      altPlayer = new Point();


      // SeverListener will have a while(true) loop
      ServerListener listener = new ServerListener();
      // Note: Need setDaemon when started with a JavaFX App, or it crashes.

      Thread thread = new Thread(listener);
      thread.setDaemon(true);
      thread.start();


    } catch (IOException e) {
    }
  }

 private class ServerListener extends Task<Object> {

    @Override
    public void run()  {


         while(true){

           try {
                 altPlayer = (Point)inputFromServer.readObject();
          
System.out.println("C: altPlayer: "+altPlayer.getX()+" "+altPlayer.getY());         

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
           
         }


    }

   @Override
    protected Object call() throws Exception {
      // Not using this call, but we need to override it to compile
      return null;
    }
  }



/////////////////////////

}

