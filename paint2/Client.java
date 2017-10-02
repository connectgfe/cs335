//package controller_view;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

import java.awt.Point;
import java.util.Vector;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
  * A GUI for Netpaint that has all paint objects drawn upon a Canvas.
  * This file also represents the controller as it controls how paint objects
  * are drawn and sends new paint objects to the server. All Client objects
  * also listen to the server to read the Vector of PaintObjects and
  * repaint every time any client adds a new one. 
  * 
  * @author YOUR NAME
  * 
 */
public class Client extends Application {


  Canvas canvas; 
  double inXval, inYval, outXval, outYval;
  GraphicsContext gc;


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    BorderPane all = new BorderPane();
    canvas = new Canvas(800, 550);
    all.setCenter(canvas);

    gc = canvas.getGraphicsContext2D();
    Scene scene = new Scene(all, 800, 650);

    primaryStage.setScene(scene);
    primaryStage.show();
    initCanvas();



  }


    public void initCanvas(){

     

     canvas.setOnMousePressed(new EventHandler<MouseEvent>(){

    @Override
    public void handle(MouseEvent arg0) {
        inXval = arg0.getX();
        inYval = arg0.getY(); 

       System.out.println("in: "+inXval+" "+inYval);

     }
    });




     canvas.setOnMouseReleased(new EventHandler<MouseEvent>(){

    @Override
    public void handle(MouseEvent arg0) {
        outXval = arg0.getX();
        outYval = arg0.getY(); 

       System.out.println("out: "+outXval+" "+outYval);

     }
    });


   drawRectangle();

   }


   public void drawRectangle(){


   Rectangle rectangle = new Rectangle(Color.BLUE,new Point((int)inXval,(int)inYval),new Point((int)inXval+50,(int)inYval+50));



//   Rectangle rectangle = new Rectangle(Color.BLUE,new Point((int)inXval,(int)inYval),new Point((int)outXval,(int)outYval));



   rectangle.draw(gc); 

   }

}
