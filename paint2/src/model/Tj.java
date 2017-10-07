
import java.io.Serializable;
import javafx.scene.canvas.GraphicsContext;
import java.awt.Color;


public class Tj extends Atj implements Serializable {



   private ColorTypeConverter con;
   Color color;


  public Tj(){}






    public void draw(GraphicsContext gc){

    javafx.scene.paint.Color color2 = con.Awt2Fx(color);


     gc.setFill(color2);

/*
     // pink
     if(x.getX()<y.getX() && x.getY()<y.getY()){

     gc.fillRect(x.getX(),x.getY(),Math.abs((y.getX()-x.getX())),Math.abs((y.getY()-x.getY())));

     }

*/

     }

}
