//package model;

import java.io.*;
import java.awt.Point;
import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;
import java.awt.Color;




public class Line extends PaintObject implements Serializable{


   private ColorTypeConverter con;


   public Line(Color color, Point x, Point y){

   super(color,x,y);

   con = new ColorTypeConverter();

   }

    public void draw(GraphicsContext gc){

    javafx.scene.paint.Color color2 = con.Awt2Fx(color);


     gc.setStroke(color2);
     gc.strokeLine(x.getX(),x.getY(),y.getX(),y.getY());


    }



}
