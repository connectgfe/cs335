/*  The java.net package contains the basics needed for network operations. */
import java.net.*;
/* The java.io package contains the basics needed for IO operations. */
import java.io.*;
/** The SocketClient class is a simple example of a TCP/IP Socket Client. */
import java.util.Scanner;


public class Jcli {

      OutputStreamWriter osw; 

  public Jcli(String ip, int prt) {
    /** Define a host server */
    String host = ip;
    /** Define a port */
    int port = prt;

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
       osw = new OutputStreamWriter(bos);//, "US-ASCII");

/*
TimeStamp = new java.util.Date().toString();
      String process = "Calling the Socket Server on "+ host + " port " + port +
          " at " + TimeStamp +  (char) 13;

*/

      System.out.println("**here**");

      String process = "Hello from java\n";



      /** Write across the socket connection and flush the buffer */
      osw.write(process,0,process.length());
      osw.flush();


      

      /** Instantiate a BufferedInputStream object for reading
      /** Instantiate a BufferedInputStream object for reading
       * incoming socket streams.
       */

      BufferedInputStream bis = new BufferedInputStream(connection.
          getInputStream());
      /**Instantiate an InputStreamReader with the optional
       * character encoding.
       */

      InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");


/*
      Scanner sc = new Scanner(System.in);
       

      while(sc.hasNext()){
      osw.write(process,0,process.length());

 //     osw.write(sc.next(),0,sc.next().length());
      osw.flush();


      }

*/
      /**Read the socket's InputStream and append to a StringBuffer */
      int c;
      while ( (c = isr.read()) != 13)
        instr.append( (char) c);

      /** Close the socket connection. */
      connection.close();
      System.out.println(instr);
     }
    catch (IOException f) {
      System.out.println("IOException: " + f);
    }
    catch (Exception g) {
      System.out.println("Exception: " + g);
    }
  }

   public void sendmsg(String val) throws Exception{




      /** Write across the socket connection and flush the buffer */
      osw.write(val,0,val.length());
      osw.flush();


   }


}




