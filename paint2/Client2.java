//package controller_view;
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
  GraphicsContext gc;
  int val,drw;
  Vector<PaintObject> allPaintObjects;
  private ColorPicker colorPicker;
  private GridPane gridPane;



  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    BorderPane all = new BorderPane();
    canvas = new Canvas(800, 550);
    all.setCenter(canvas);

    gridPane = createGridPane();
    all.setBottom(gridPane);

    gc = canvas.getGraphicsContext2D();
    allPaintObjects = new Vector<>();


    Scene scene = new Scene(all, 800, 650);

    primaryStage.setScene(scene);
    primaryStage.show();
    initCanvas();

//    drw=2; 


  }


    public void initCanvas(){

     

     canvas.setOnMouseClicked(new EventHandler<MouseEvent>(){

    @Override
    public void handle(MouseEvent arg0) {


       val++;

       if(val%2!=0){


        inXval = arg0.getX();
        inYval = arg0.getY(); 


System.out.println("in: "+val+" "+drw+" "+inXval+" "+inYval);

       getMouseMove();


       }else{

       outXval = arg0.getX();
       outYval = arg0.getY(); 

System.out.println("out: "+val+" "+drw+" "+outXval+" "+outYval);

       // make new PaintObject
      if(drw==2){

       Rectangle rectangle = new Rectangle(Color.BLUE,new Point((int)inXval,(int)inYval),new Point((int)outXval,(int)outYval));


     allPaintObjects.add(rectangle);

     }


      if(drw==3){


       Oval oval = new Oval(Color.BLUE,new Point((int)inXval,(int)inYval),new Point((int)outXval,(int)outYval));


     allPaintObjects.add(oval);

     }

      if(drw==1){

       Line line = new Line(Color.BLUE,new Point((int)inXval,(int)inYval),new Point((int)outXval,(int)outYval));


     allPaintObjects.add(line);

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

System.out.println("cur: "+drw+" "+curXval+" "+curYval);




       }


    
     
   gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
   
 
   drawTempPaintObject();


   drawPaintObjects();
   


     }
    });




   }


   public void drawTempPaintObject(  ){



System.out.println("In temp paint: "+val+" "+drw);


        if(drw==2){


     Rectangle rectangle = new Rectangle(Color.BLUE,new Point((int)inXval,(int)inYval),new Point((int)curXval,(int)curYval));

     rectangle.draw(gc); 

       }

      if(drw==3){


       Oval oval = new Oval(Color.BLUE,new Point((int)inXval,(int)inYval),new Point((int)curXval,(int)curYval));

     oval.draw(gc); 

      } 


      if(drw==1){


      Line line = new Line(Color.BLUE,new Point((int)inXval,(int)inYval),new Point((int)curXval,(int)curYval));

    line.draw(gc); 


      }


   }


   public void drawPaintObjects(){

System.out.println("In paint objs: "+val+" "+drw);
  
   for( PaintObject po: allPaintObjects){
        po.draw(gc);
      }

   }




  private GridPane createGridPane() {
    // TODO 1: Construct 2 RadioButton objects
    RadioButton rect = new RadioButton("Rectangle");
    RadioButton oval = new RadioButton("Oval");
    RadioButton line = new RadioButton("Line");


    // TODO 2: Construct a ToggleGroup so only one can be selected
    // and add the radio buttons to it


    ToggleGroup group = new ToggleGroup();
    rect.setToggleGroup(group);
    oval.setToggleGroup(group);
    line.setToggleGroup(group);
    
    

    GridPane gridPane = new GridPane();
    gridPane.setHgap(3);
    gridPane.setVgap(3);
    gridPane.setAlignment(Pos.CENTER);

    gridPane.add(rect, 0, 0);
    gridPane.add(oval, 1, 0);
    gridPane.add(line, 2, 0);



    // TODO 3: Add the ColorPicker that will be needed when the color is changed

    colorPicker = new ColorPicker();
    colorPicker.setOnAction(new ColorChanger());

    gridPane.add(colorPicker, 3, 0);

    // Execute this code when one RadioButon is clicked
    rect.setOnAction(event -> {

    rect.setSelected(true);
    rect.requestFocus();
System.out.println("this is mouse cliked val "+val);

    drw=2;


/*
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setHeaderText("You just clicked RadioButton one");
      alert.showAndWait();
*/

    });

    // Execute this code when the other RadioButon is clicked
    oval.setOnAction(event -> {

    oval.setSelected(true);
    oval.requestFocus();

System.out.println("this is mouse cliked val "+val);

    drw=3;



/*
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setHeaderText("You just clicked RadioButton two");
      alert.showAndWait();
*/
    });


    line.setOnAction(event -> {

    line.setSelected(true);
    line.requestFocus();

System.out.println("this is mouse cliked val "+val);

     drw=1;

//   gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
//   drawPaintObjects();



/*
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setHeaderText("You just clicked RadioButton two");
      alert.showAndWait();
*/
    });




    return gridPane;
  }


  private class ColorChanger implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

     Color color = colorPicker.getValue();

     gridPane.setStyle("-fx-background-color: '"+color+"'");

System.out.println(color);


    }
  }



}
