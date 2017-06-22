import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstGui extends JFrame implements WindowListener, ActionListener{


   JFrame frame;
   int numClick = 0;
   TextField text = new TextField(20);
   JLabel dog = new JLabel();


   public FirstGui(String title){

   frame = new JFrame(title);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   frame.setPreferredSize(new Dimension(350,350));
   
//   JLabel dog = new JLabel(new ImageIcon("dog.png"));


// need to create action

   addWindowListener(this); 
   Button clickit= new Button("Clickme");
   
   clickit.addActionListener(this); 


   frame.add(clickit,BorderLayout.NORTH);
   
   frame.add(dog,BorderLayout.SOUTH);
// dog.setIcon(new ImageIcon("dog.png"));

   frame.add(text);

   frame.pack(); 
   frame.setVisible(true);



   }


// note: actionPerformed is called just after user perfoms an action
//       as part of ActionListenter interface

// find IconDemo in Oracle docs for loading Icon in ActionListener


   public void actionPerformed(ActionEvent e) {
 

//              JLabel dog = new JLabel(new ImageIcon("dog.png"));

//              frame.add(dog, BorderLayout.SOUTH);
//                dog.setIcon(new ImageIcon("dog.png"));
                numClick++;
                dog.setIcon(new ImageIcon("dog.png"));
               text.setText("Button Clicked " + numClick + " times");
               if(numClick==3){
               dog.setIcon(null); 
               }
/*
               if(numClick%2==0){
                add(dog,BorderLayout.CENTER); 
                 dog.setIcon(new ImageIcon("dog.png"));
               add(text,BorderLayout.CENTER);
               text.setText("Button Clicked " + numClick + " times");
                }else{
                 add(dog,BorderLayout.SOUTH); 
                 dog.setIcon(new ImageIcon("dog.png"));
                add(text,BorderLayout.SOUTH);
 
               text.setText("Button Clicked " + numClick + " times");
                }
*/
   
 //               text.setText("Button Clicked " + numClick + " times");
        }


        public void windowClosing(WindowEvent e){}
        public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}



}

class LeftAction extends AbstractAction {

    public LeftAction(String text){
   
     super(text);
     putValue(SHORT_DESCRIPTION, text);

    }


    public LeftAction(String text, ImageIcon icon,
                      String desc, Integer mnemonic) {
        super(text, icon);
        putValue(SHORT_DESCRIPTION, desc);
        putValue(MNEMONIC_KEY, mnemonic);
    }
    public void actionPerformed(ActionEvent e) {
    //    displayResult("Action for first button/menu item", e);
    }
}
