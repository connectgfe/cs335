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
  double inXval, inYval, curXval, curYval, outXval, outYval;
;
  GraphicsContext gc;
  int val;

  Vector<PaintObject> allPaintObjects;


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    BorderPane all = new BorderPane();
    canvas = new Canvas(800, 550);
    all.setCenter(canvas);

    gc = canvas.getGraphicsContext2D();
    allPaintObjects = new Vector<>();


    Scene scene = new Scene(all, 800, 650);

    primaryStage.setScene(scene);
    primaryStage.show();
    initCanvas();

    


  }


    public void initCanvas(){

     
    

     canvas.setOnMouseClicked(new EventHandler<MouseEvent>(){

    @Override
    public void handle(MouseEvent arg0) {


       val++;

       if(val%2!=0){


        inXval = arg0.getX();
        inYval = arg0.getY(); 


       System.out.println("in: "+val+" "+inXval+" "+inYval);

       getMouseMove();


       }else{

       outXval = arg0.getX();
       outYval = arg0.getY(); 

       System.out.println("out: "+val+" "+outXval+" "+outYval);

//       drawRectangle();

     Rectangle rectangle = new Rectangle(Color.BLUE,new Point((int)inXval,(int)inYval),new Point((int)outXval,(int)outYval));



     allPaintObjects.add(rectangle);

       }
       


//      getMouseMove();


       

//   drawRectangle();


     }
    });



/*
     canvas.setOnMouseReleased(new EventHandler<MouseEvent>(){

    @Override
    public void handle(MouseEvent arg0) {
        outXval = arg0.getX();
        outYval = arg0.getY(); 

       val=0;
       System.out.println("out: "+val+" "+outXval+" "+outYval);

//   drawRectangle();



     }
    });

*/


   }



   public void getMouseMove(){


//System.out.println("move val1: "+val);

     canvas.setOnMouseMoved(new EventHandler<MouseEvent>(){

    @Override
    public void handle(MouseEvent arg0) {

//System.out.println("move val2: "+val);

       if(val%2!=0){
      drawPaintObjects();


        curXval = arg0.getX();
        curYval = arg0.getY(); 

       System.out.println("cur: "+curXval+" "+curYval);




       }


//   gc.clearRect(inXval, inYval, curXval, curYval);
// draw canvas

    
     
   gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
   
 
   drawRectangle();


   drawPaintObjects();
   
//        }  


     }
    });




   }


   public void drawRectangle(  ){


//   Rectangle rectangle = new Rectangle(Color.BLUE,new Point((int)inXval,(int)inYval),new Point((int)inXval+50,(int)inYval+50));


 System.out.println("In rct"+val);


     Rectangle rectangle = new Rectangle(Color.BLUE,new Point((int)inXval,(int)inYval),new Point((int)curXval,(int)curYval));



     rectangle.draw(gc); 


   }


   public void drawPaintObjects(){

//   gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
   
   for( PaintObject po: allPaintObjects){
        po.draw(gc);
      }

   }



}
