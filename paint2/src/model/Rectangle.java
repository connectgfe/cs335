//package model;

import java.io.*;
import java.awt.Point;
import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;
import java.awt.Color;




public class Rectangle extends PaintObject implements Serializable{


   private ColorTypeConverter con;


   public Rectangle(Color color, Point x, Point y){

   super(color,x,y);

   con = new ColorTypeConverter();

   }

    public void draw(GraphicsContext gc){

    javafx.scene.paint.Color color2 = con.Awt2Fx(color);

 
     gc.setFill(color2); 


     // pink
     if(x.getX()<y.getX() && x.getY()<y.getY()){

     gc.fillRect(x.getX(),x.getY(),Math.abs((y.getX()-x.getX())),Math.abs((y.getY()-x.getY())));

     }
     // cyan + green
     if(x.getX()>y.getX() && x.getY()>y.getY()){

     gc.fillRect(y.getX(),y.getY(),Math.abs((y.getX()-x.getX())),Math.abs((y.getY()-x.getY())));

     }

     //red
     if(x.getX()<y.getX() && x.getY()>y.getY()){

     gc.fillRect(x.getX(),y.getY(),Math.abs((y.getX()-x.getX())),Math.abs((y.getY()-x.getY())));

     }

     // blue
     if(x.getX()>y.getX() && x.getY()<y.getY()){

     gc.fillRect(y.getX(),x.getY(),Math.abs((y.getX()-x.getX())),Math.abs((y.getY()-x.getY())));

     }




    }

   



}
