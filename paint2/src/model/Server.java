/*
 * This is the server part of a multi-client chat server. Since it is 
 * not a JavaFX application, we can starts new threads in a Runnable.
 * The GUI client needs a Task  
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class Server {

  private static ServerSocket serverSocket;
  private static List<ObjectOutputStream> outputStreams = new Vector<>();



  public static void main(String[] args) throws IOException {
    serverSocket = new ServerSocket(4001);
    // System.out.println("Server started on port " + SERVER_PORT);

    // Setup the server to accept many clients
    while (true) {
      Socket socket = serverSocket.accept();
      ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream ouputToClient = new ObjectOutputStream(socket.getOutputStream());
      
      // TODO 1: Maintain a list of output streams so this Server can to alls
      outputStreams.add(ouputToClient);

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
    String msg;


    public ClientHandler(ObjectInputStream input) {
      this.input = input;
    }
 
    @Override
    public void run() {
      // TODO 3: Complete this run method with a while(true) loop
      // to read any new messages from the server. When a new read
      // happens, write the new message to all Clients



          try{
                 while(true){

                    msg = null;
 
                    msg = (String)input.readObject();

                    writeStringToClients(msg); 
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
    private void writeStringToClients(String message) throws ClassNotFoundException{

 
  
            for(ObjectOutputStream stream : outputStreams){   

              try{
                 stream.reset(); 
                 stream.writeObject(msg);

                  } catch (IOException ioe){


                  }
 


             }

 
      }
  } 
}
