/*
 * This is the server part of a multi-client chat server. Since it is 
 * not a JavaFX application, we can starts new threads in a Runnable.
 * The GUI client needs a Task  
 */

import java.io.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;
import java.awt.Point;
import java.awt.Color;





public class Server implements Serializable{

  private static ServerSocket serverSocket;
  private static List<ObjectOutputStream> outputStreams = new Vector<>();
  private static Vector<PaintObject> vector = new Vector<PaintObject>();


  public static void main(String[] args) throws IOException {

System.out.println("intro: "+outputStreams.size()+" "+vector.size());



    serverSocket = new ServerSocket(4001);
    // System.out.println("Server started on port " + SERVER_PORT);

    // Setup the server to accept many clients
    while (true) {
      Socket socket = serverSocket.accept();
      ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
      
      // TODO 1: Maintain a list of output streams so this Server can to alls
      outputStreams.add(outputToClient);

      // System.out.println("Accepted a new connection from " + socket.getInetAddress());

      // Start the loop that reads any Client's writeObject in the background in a 
      // different Thread so this program can also wait for new Client connections.
      // This thread allows the Server to wait for each client's writing of a String message.
      // TODO 2: Start a new ClientHandler in a new Thread
      ClientHandler clientHandler = new ClientHandler(inputFromClient);


      Thread thread = new Thread(clientHandler);
      thread.start();


    }
  }

  private static class ClientHandler implements Runnable {



    private ObjectInputStream input;
    PaintObject obj;

    public ClientHandler(ObjectInputStream input) {
      this.input = input;


try{
//       for( String str : vector ){
       for(  PaintObject object : vector ){
         
          outputStreams.get(outputStreams.size()-1).reset();
          outputStreams.get(outputStreams.size()-1).writeObject((PaintObject)object); 
       }

} catch(IOException e){
//} catch(ClassNotFoundException cnfe){
}



    }
 
    @Override
    public void run() {
      // TODO 3: Complete this run method with a while(true) loop
      // to read any new messages from the server. When a new read
      // happens, write the new message to all Clients

System.out.println("new: "+outputStreams.size()+" "+vector.size());






          try{
                 while(true){

                

 
//                Tj obj = (Tj)input.readObject();
System.out.println("here");

                   obj = (PaintObject)input.readObject();

//                    obj = (String)input.readObject();
//                    obj = (Tj2)input.readObject();


                    vector.add(obj);
 
                    writeVectorToClients(obj); 

 

// new
/*

                    obj = (String)input.readObject();
                    vector.add(obj);
                
//                   for( String obj : vector ){
                    writeVectorToClients(obj); 
//                    }
*/

                 }


           } catch (IOException ioe){

           } catch (ClassNotFoundException cnfe){

           }
 


/*
  
      while(true){

           msg = null;
 
          try{
            msg = (String)input.readObject();

           } catch (IOException ioe){

           } catch (ClassNotFoundException cnfe){

           }
          
           writeStringToClients(msg); 
           
 
      } 
    
*/

    
    }

    // TODO 4: Complete this message to write message to all output streams
    private void writeVectorToClients(PaintObject object) throws ClassNotFoundException{

//     private void writeVectorToClients(String object) throws ClassNotFoundException{


  
            for(ObjectOutputStream stream : outputStreams){   

              try{
                 stream.reset(); 
                 stream.writeObject((PaintObject)object);

                  } catch (IOException ioe){


                  }
 


             }

 
      }
  } 
}
