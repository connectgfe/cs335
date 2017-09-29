import java.io.*;
import java.net.*;


public class CSserv {


public static void main(String[] args) {
 try {
   System.out.println("Server started");
   ServerSocket server = new ServerSocket(4000);
   Socket connection = server.accept();
   System.out.println("This Server just got a Client at port 4000");
   // Make both connection steams available
   ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
   ObjectInputStream input = new ObjectInputStream(connection.getInputStream());



   // Do some IO.
   // Close the connection



try
{
    for (;;)
    {
        Object object = input.readObject();

    System.out.println((String)object);
       

    if((String)object=="quit"){

    System.out.println("END");

    break;
    }    
        // ...
    }
}
catch (SocketTimeoutException exc)
{
    // you got the timeout
}
catch (EOFException exc)
{
    // end of stream
}
catch (IOException exc)
{
    // some other I/O error: print it, log it, etc.
    exc.printStackTrace(); // for example
}

/*
   Object line =null;

   while( (line = (String)input.readObject()) !=null){ 
  
   System.out.println(line);

  }
*/
   connection.close();
} catch (IOException e) {
e.printStackTrace();

} 
catch (ClassNotFoundException e) {
e.printStackTrace();
 }

 }
}
