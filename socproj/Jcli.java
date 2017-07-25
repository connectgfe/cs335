/*  The java.net package contains the basics needed for network operations. */
import java.net.*;
/* The java.io package contains the basics needed for IO operations. */
import java.io.*;
/** The SocketClient class is a simple example of a TCP/IP Socket Client.
 *
 */
import java.util.*;

public class Jcli {

public static void main(String[] args) {
    /** Define a host server */
    String host = "www.luckywishbone.com";  
//    String host =  "127.0.0.1";
    /** Define a port */
//    int port = 3500;
    int port = 80;
    StringBuffer instr = new StringBuffer();
    String TimeStamp;

 try {

      /** Obtain an address object of the server */
      InetAddress address = InetAddress.getByName(host);
      /** Establish a socket connetion */


      Socket connection = new Socket(address, port);
      /** Instantiate a BufferedOutputStream object */

     System.out.println("SocketClient initialized");

     BufferedOutputStream bos = new BufferedOutputStream(connection.
          getOutputStream());

      /** Instantiate an OutputStreamWriter object with the optional character
       * encoding.
       */
      OutputStreamWriter osw = new OutputStreamWriter(bos);//, "US-ASCII");

/*
TimeStamp = new java.util.Date().toString();
      String process = "Calling the Socket Server on "+ host + " port " + port +
          " at " + TimeStamp +  (char) 13;

*/

      System.out.println("**here**");

      String process = "Hello from java\n";

      /** Write across the socket connection and flush the buffer */
//      osw.write(process,0,process.length());
//      osw.flush();

      /** Instantiate a BufferedInputStream object for reading
      /** Instantiate a BufferedInputStream object for reading
       * incoming socket streams.
       */

      BufferedInputStream bis = new BufferedInputStream(connection.
          getInputStream());
      /**Instantiate an InputStreamReader with the optional
       * character encoding.
       */

      InputStreamReader isr = new InputStreamReader(bis, "UTF-8");

      BufferedReader br = new BufferedReader(isr);

      String line= null;

      while( (line = br.readLine()) !=null){

          System.out.println(line);
      }
      /**Read the socket's InputStream and append to a StringBuffer */


      String bf="000000000000000000";
      char[] buff=bf.toCharArray();


      String enco= isr.getEncoding();
      int c;


      System.out.println("here2 "+enco);

      Scanner sc = new Scanner(System.in);


      isr.read(buff,0,15);

       System.out.println(buff);

/*
      while ( (c = isr.read(buff,0,15)) != 13 && sc.hasNext()){
       // instr.append( (char) c);

     // Close the socket connection. 
//      connection.close();
      System.out.println(buff);

      String next= sc.next();
      osw.write(next,0,next.length());
      osw.flush();

 

      }
 
*/

      connection.close();

   }
   catch (IOException f) {
      System.out.println("IOException: " + f);
    }
    catch (Exception g) {
      System.out.println("Exception: " + g);
    }
  }
}
