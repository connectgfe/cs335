package controller_view;
import java.io.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import java.awt.Point;
import java.awt.Color;
import java.util.Vector;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
//import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import model.ColorTypeConverter;
import model.PaintObject;
import model.Rectangle;
import model.Line;
import model.Oval;
import model.Picture;

/**
  * A GUI for Netpaint that has all paint objects drawn upon a Canvas.
  * This file also represents the controller as it controls how paint objects
  * are drawn and sends new paint objects to the server. All Client objects
  * also listen to the server to read the Vector of PaintObjects and
  * repaint every time any client adds a new one. 
  * 
  * @author Giuio Esposito
  * 
 */
public class Client extends Application implements Serializable{


  Canvas canvas; 
  double inXval, inYval, curXval, curYval, outXval, outYval;
  GraphicsContext gc;
  int val,drw;
  Vector<PaintObject> allPaintObjects;
  private ColorPicker colorPicker;
  private GridPane gridPane;
  Color color;
  private ColorTypeConverter con;


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    BorderPane all = new BorderPane();
    canvas = new Canvas(800, 550);
    all.setCenter(canvas);

    con = new ColorTypeConverter();
    color = Color.BLUE;

    gridPane = createGridPane();
    all.setBottom(gridPane);

    gc = canvas.getGraphicsContext2D();
    allPaintObjects = new Vector<>();


    Scene scene = new Scene(all, 800, 650);

    primaryStage.setScene(scene);
    primaryStage.show();
    initCanvas();
    drw=2; 

  }


    public void initCanvas(){

     

     canvas.setOnMouseClicked(new EventHandler<MouseEvent>(){

    @Override
    public void handle(MouseEvent arg0) {


       val++;

       if(val%2!=0){


        inXval = arg0.getX();
        inYval = arg0.getY(); 


//System.out.println("in: "+val+" "+drw+" "+inXval+" "+inYval);

       getMouseMove();


       }else{

       outXval = arg0.getX();
       outYval = arg0.getY(); 

//System.out.println("out: "+val+" "+drw+" "+outXval+" "+outYval);

       // make new PaintObject
      if(drw==2){

       Rectangle rectangle = new Rectangle(color,new Point((int)inXval,(int)inYval),new Point((int)outXval,(int)outYval));


     allPaintObjects.add(rectangle);

   gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
   drawPaintObjects();
 


     }


      if(drw==3){


       Oval oval = new Oval(color,new Point((int)inXval,(int)inYval),new Point((int)outXval,(int)outYval));


     allPaintObjects.add(oval);

   gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
   drawPaintObjects();
 

     }

      if(drw==1){

       Line line = new Line(color,new Point((int)inXval,(int)inYval),new Point((int)outXval,(int)outYval));


     allPaintObjects.add(line);

   gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
   drawPaintObjects();
 

      }


      if(drw==4){

       Picture picture = new Picture(new Point((int)inXval,(int)inYval),new Point((int)outXval,(int)outYval), "doge.jpeg");


     allPaintObjects.add(picture);

   gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
   drawPaintObjects();
 

      }


       }
       



     }
    });




   }



   public void getMouseMove(){


//System.out.println("move val1: "+val);

     canvas.setOnMouseMoved(new EventHandler<MouseEvent>(){

    @Override
    public void handle(MouseEvent arg0) {

//System.out.println("move val2: "+val);

       if(val%2!=0){


        curXval = arg0.getX();
        curYval = arg0.getY(); 

    
     
   gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
   
    drawPaintObjects();

   drawTempPaintObject();
}

   


     }
    });




   }


   public void drawTempPaintObject(  ){



//System.out.println("In temp paint: "+val+" "+drw);


        if(drw==2){


     Rectangle rectangle = new Rectangle(color,new Point((int)inXval,(int)inYval),new Point((int)curXval,(int)curYval));

     rectangle.draw(gc); 

       }

      if(drw==3){


       Oval oval = new Oval(color,new Point((int)inXval,(int)inYval),new Point((int)curXval,(int)curYval));

     oval.draw(gc); 

      } 


      if(drw==1){


      Line line = new Line(color,new Point((int)inXval,(int)inYval),new Point((int)curXval,(int)curYval));

    line.draw(gc); 


      }



      if(drw==4){

       Picture picture = new Picture(new Point((int)inXval,(int)inYval),new Point((int)curXval,(int)curYval), "doge.jpeg");

      picture.draw(gc);


      }




   }


   public void drawPaintObjects(){

//System.out.println("In paint objs: "+val+" "+drw);
  
   for( PaintObject po: allPaintObjects){
        po.draw(gc);
      }

   }




  private GridPane createGridPane() {


    RadioButton rect = new RadioButton("Rectangle");
    RadioButton oval = new RadioButton("Oval");
    RadioButton line = new RadioButton("Line");
    RadioButton picture = new RadioButton("Picture");



    ToggleGroup group = new ToggleGroup();
    rect.setToggleGroup(group);
    oval.setToggleGroup(group);
    line.setToggleGroup(group);
    picture.setToggleGroup(group);
 
    

    GridPane gridPane = new GridPane();
    gridPane.setHgap(3);
    gridPane.setVgap(3);
    gridPane.setAlignment(Pos.CENTER);

    gridPane.add(rect, 0, 0);
    gridPane.add(oval, 1, 0);
    gridPane.add(line, 2, 0);
    gridPane.add(picture, 3, 0);





    colorPicker = new ColorPicker(con.Awt2Fx(color));
    colorPicker.setOnAction(new ColorChanger());

    gridPane.add(colorPicker, 4, 0);

    // Execute this code when one RadioButon is clicked
    rect.setOnAction(event -> {

    rect.setSelected(true);
    rect.requestFocus();
//System.out.println("this is mouse cliked val "+val);

    drw=2;



    });

    // Execute this code when the other RadioButon is clicked
    oval.setOnAction(event -> {

    oval.setSelected(true);
    oval.requestFocus();

//System.out.println("this is mouse cliked val "+val);

    drw=3;


    });


    line.setOnAction(event -> {

    line.setSelected(true);
    line.requestFocus();

//System.out.println("this is mouse cliked val "+val);

     drw=1;

    });

    picture.setOnAction(event -> {

    picture.setSelected(true);
    picture.requestFocus();

//System.out.println("this is mouse cliked val "+val);

     drw=4;


    });




    return gridPane;
  }


  private class ColorChanger implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

    javafx.scene.paint.Color color2 = colorPicker.getValue();

    color = con.Fx2Awt(color2);


//System.out.println(color);


    }
  }



}
