//package model;
import java.io.*;



public class User implements Serializable{

     String name;
     String password;
     String dateJoined;
     double totalMinUsed;

   public User(String name, String password, String dateJoined){
 
     totalMinUsed = 0.0; 
     this.name = name; 
     this.password = password;
     this.dateJoined = dateJoined; 
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


}
