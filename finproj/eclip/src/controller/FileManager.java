package controller; 

import java.util.*;
import java.io.*;

import controller.TempTrainer;
 // class to push and pull Vector users

public class FileManager {

   private Vector<TempTrainer> users;
   

   public FileManager(){

     users = new Vector<TempTrainer>();

     pullUserData();


   }

   public int checkUser(String logUser, String pswd){

//System.out.println("no1 "+users.size());

      int cnt=0;

      for( TempTrainer user : users ){

        cnt++;
        if(user.name.equals(logUser)){
          cnt--;
          if(user.password.equals(pswd)){


                 if( logUser.equals("Merlin") && pswd.equals("7777777")){
System.out.println("Got Merlin");
             return 2;
                           

                 }else{
System.out.println("Good other user");
               return 1; 

                 }
           }
System.out.println("Try Again");
           return 3;

          }

      }


//System.out.println("no2 "+users.size());

      if(cnt==users.size()){

//System.out.println("new user");
         TempTrainer addUser = new TempTrainer(logUser, pswd);
         users.add(addUser);

//UD         pushUserData();

       return 0;

      }



     return -1;

   }

  @SuppressWarnings("unchecked")
  public void pullUserData(){

    try {
     FileInputStream ufin = new FileInputStream("users.dat");
     ObjectInputStream uois = new ObjectInputStream(ufin);
     users = (Vector) uois.readObject();
     uois.close();
     }
    catch (Exception e) { e.printStackTrace();
    }



  }

  public void pushUserData(){

    try {
       FileOutputStream ufout = new FileOutputStream("users.dat");
       ObjectOutputStream uoos = new ObjectOutputStream(ufout);
       uoos.writeObject(users);
       uoos.close();
        }
     catch (Exception e) { e.printStackTrace();
    }


  }


 


}

