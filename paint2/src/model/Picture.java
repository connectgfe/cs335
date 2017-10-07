//package model;


import java.awt.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

//import javax.swing.ImageIcon;


import java.io.*;


public class Picture extends PaintObject implements Serializable{


//   Point x,y;
//   String pic;
//    Image image;


//    File file;


   public Picture(Point x, Point y, String pic){



     super(x,y,pic);
   
//     this.x=x;
//     this.y=y;
    
//     file= new File(pic);
//     image = new Image(file.toURI().toString());
//     image = new Image("file:doge.jpeg");
//     image = new Image("file:doge.jpeg");


   }

    public void draw(GraphicsContext gc){


//    gc.drawImage(image,x.getX(),x.getY(), 25,25);
//    gc.drawImage(image, 30 ,40, 25 , 25);

     Image image = new Image("file:doge.jpeg");


     if(x.getX()<y.getX() && x.getY()<y.getY()){

     gc.drawImage(image,x.getX(),x.getY(),Math.abs((y.getX()-x.getX())),Math.abs((y.getY()-x.getY())));

     }
     if(x.getX()>y.getX() && x.getY()>y.getY()){

     gc.drawImage(image,y.getX(),y.getY(),Math.abs((y.getX()-x.getX())),Math.abs((y.getY()-x.getY())));

     }

     if(x.getX()<y.getX() && x.getY()>y.getY()){

     gc.drawImage(image,x.getX(),y.getY(),Math.abs((y.getX()-x.getX())),Math.abs((y.getY()-x.getY())));

     }

     if(x.getX()>y.getX() && x.getY()<y.getY()){

     gc.drawImage(image,y.getX(),x.getY(),Math.abs((y.getX()-x.getX())),Math.abs((y.getY()-x.getY())));

     }
 


  }


}
