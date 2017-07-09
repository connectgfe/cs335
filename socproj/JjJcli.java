/*
import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class JjJcli {

  private static final String HOST = "127.0.0.1";

  private static final int PORT = 3500;

  public static void main(String[] args) throws Exception {
    SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
    Socket s = sf.createSocket(HOST, PORT);
    OutputStream out = s.getOutputStream();
    out.write("\nConnection established.\n\n".getBytes());
    out.flush();
    int theCharacter = 0;
    theCharacter = System.in.read();
    while (theCharacter != '~') // The '~' is an escape character to exit
    {
      out.write(theCharacter);
      out.flush();
      theCharacter = System.in.read();
    }

    out.close();
    s.close();
  }
}
*/

import java.security.cert.Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class JjJcli {
  public static void main(String[] argv) throws Exception {
    int port = 3500;
    String hostname = "127.0.0.1";
    SSLSocketFactory factory = HttpsURLConnection.getDefaultSSLSocketFactory();
    SSLSocket socket = (SSLSocket) factory.createSocket(hostname, port);

    socket.startHandshake();

    // Retrieve the server's certificate chain
    Certificate[] serverCerts = socket.getSession().getPeerCertificates();

    socket.close();
  }
}
