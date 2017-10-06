//package model;
import java.io.*;
import java.awt.Point;
import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import java.awt.Color;


/**
 * PaintObject
 * 
 * PaintObject is the superclass of paint objects Oval, Rectangle, Line, and
 * Picture that can be drawn using a Color, two Points, and some Canvas methods.   
 * 
 * @author Giulio Esposito
 *
 */
public abstract class PaintObject implements Serializable{
  
  
    public Point x;
    public Point y; 
    public Color color;
    public String str; 



 

    public PaintObject(Color color, Point x, Point y){

    this.x=x;
    this.y=y;
    this.color=color;

    }

    public PaintObject(Point x, Point y, String str){

    this.x=x;
    this.y=y;
    this.str=str;


    }


    public void draw(GraphicsContext gc){
 
//     gc.setFill(color); 
//     gc.drawImage(x.getX(),x.getY(),y.getX(),y.getY());


    }

}
