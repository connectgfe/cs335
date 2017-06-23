import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstGui extends JFrame implements WindowListener, ActionListener{


   JFrame frame;
   int numClick = 0;
   TextField text = new TextField(20);
   JLabel dog = new JLabel();
   JLabel dog2 = new JLabel();
   JMenuBar menuBar;
   JMenu menu, submenu;
   JMenu menuItem;
   JRadioButtonMenuItem rbutton;




   public FirstGui(String title){

   frame = new JFrame(title);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   frame.setPreferredSize(new Dimension(350,350));
   

   addWindowListener(this); 
   Button clickit= new Button("Clickme");
   
   clickit.addActionListener(this); 
   frame.add(clickit,BorderLayout.NORTH);
   frame.add(text,BorderLayout.SOUTH);

   menuBar= new JMenuBar(); 
   menu= new JMenu("A Menu");
   menuBar.add(menu); 
   frame.setJMenuBar(menuBar);

   

   frame.pack(); 
   frame.setVisible(true);



   }


// note: actionPerformed is called just after user perfoms an action
//       as part of ActionListenter interface

// find IconDemo in Oracle docs for loading Icon in ActionListener


   public void actionPerformed(ActionEvent e) {
 

          numClick++;
          frame.add(dog,BorderLayout.WEST);
          frame.add(dog2,BorderLayout.EAST);

          text.setText("Button Clicked " + numClick + " times");
     
          if(numClick%2==0){
             dog2.setIcon(null);
             dog.setIcon(new ImageIcon("dog.png"));
          }
     
          if(numClick%2!=0){
             dog.setIcon(null); 
             dog2.setIcon(new ImageIcon("dog.png"));
          }

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
