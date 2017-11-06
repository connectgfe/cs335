package controller; 

import java.util.*;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;



import controller.TempTrainer;
 // class to push and pull Vector users

public class FileManager {

   private Vector<TempTrainer> users;
   

   public FileManager(){

     users = new Vector<TempTrainer>();

     pullUserData();


   }

   public int checkUser(String logUser, String pswd){

System.out.println("No. users: "+users.size());

      int cnt=0;

      for( TempTrainer user : users ){

        cnt++;
        if(user.name.equals(logUser)){
          cnt--;
          if(user.password.equals(pswd)){


                 if( logUser.equals("Merlin") && pswd.equals("7777777")){
System.out.println("FileMan:Got Merlin");
             return 2;
                           

                 }else{
System.out.println("FileMan:Returning User");
               return 1; 

                 }
            } 
          }
       }

//System.out.println("no2 "+users.size());

      if(cnt==users.size()){

System.out.println("FileMan:New User");
         TempTrainer addUser = new TempTrainer(logUser, pswd);
         users.add(addUser);

         pushUserData();

       return 0;

      }



     return -1;

   }

  @SuppressWarnings("unchecked")
  public void pullUserData(){

    try {
     FileInputStream ufin = new FileInputStream("trainers.dat");
     ObjectInputStream uois = new ObjectInputStream(ufin);
     users = (Vector) uois.readObject();
     uois.close();
     }
    catch (Exception e) { e.printStackTrace();
    }



  }

  public void pushUserData(){

    try {
       FileOutputStream ufout = new FileOutputStream("trainers.dat");
       ObjectOutputStream uoos = new ObjectOutputStream(ufout);
       uoos.writeObject(users);
       uoos.close();
        }
     catch (Exception e) { e.printStackTrace();
    }


  }

 public Vector<TempTrainer> getUser(){

    return users;

 }


}

