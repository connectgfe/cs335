import javafx.scene.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


public class ttest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // just load fxml file and display it in the stage:

        FXMLLoader loader = new FXMLLoader(getClass().getResource("test1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // main method to support non-JavaFX-aware environments:

    public static void main(String[] args) {
        // starts the FX toolkit, instantiates this class, 
        // and calls start(...) on the FX Application thread:
        launch(args); 
    }
}


