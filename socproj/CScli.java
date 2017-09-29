import java.util.*;
import java.net.*;
import java.io.*;


public class CScli {
public static void main(String[] args) {
 try {
// Connect to a Server and get the two streams from the server
System.out.println("Client started");
Socket server = new Socket("localhost", 4000);
System.out.println("This Client found a server on port 4000");

// Do some IO with the server
ObjectOutputStream output = new ObjectOutputStream(server.getOutputStream());
ObjectInputStream input = new ObjectInputStream(server.getInputStream());


   Scanner sc = new Scanner(System.in);

   while(sc.hasNext()){


    output.writeObject(sc.next());
//input.readObject();
  }

// Do some IO with the server
// Close the connection to the server
 server.close();
} catch (IOException e) {
e.printStackTrace();
} 

//catch (ClassNotFoundException e) {
//e.printStackTrace();
// }
 }
}
