//package model;
import java.io.*;
import java.time.LocalDate;


public class User implements Serializable{

     String name;
     String password;
     String dateJoined;
     double totalMinUsed;
     String song1, song2, song3;
     LocalDate firstDate;

   public User(String name, String password, String dateJoined){
 
     totalMinUsed = 0.0; 
     this.name = name; 
     this.password = password;
     this.dateJoined = dateJoined; 
     song1= "(song 1)";
     song2= "(song 2)";
     song3= "(song 3)";
      
   }

   public String getName(){
     return name;
   } 

   public String getPassword(){
     return password;
   } 

   public String getMins(){

     return String.valueOf(totalMinUsed);
   }

   public void setMins(Double addMins){
   
     totalMinUsed = addMins+totalMinUsed; 

   }

   public void setSongOne(String song, LocalDate firstDate){

     song1 =  song;
     this.firstDate = firstDate;
 
   }

   public void setSongTwo(String song){

     song2 =  song;
   }

   public void setSongThree(String song){

     song3 =  song;
   }

   public String getSongOne(){
 
      return song1; 
   }

   public String getSongTwo(){
 
      return song2; 
   }

   public String getSongThree(){
 
      return song3; 
   }

   public void resetPlays(){

     song1= "(song 1)";
     song2= "(song 2)";
     song3= "(song 3)";
    

   }


}
