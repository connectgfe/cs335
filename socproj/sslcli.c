//http://simplestcodings.blogspot.com/2010/08/secure-server-client-using-openssl-in-c.html

#include <stdio.h>
#include <errno.h>
#include <unistd.h>
#include <malloc.h>
#include <string.h>
#include <sys/socket.h>
#include <resolv.h>
#include <netdb.h>
#include <openssl/ssl.h>
#include <openssl/err.h>
#include <stdlib.h>
#include <sys/types.h>
#include <fcntl.h>
 
#define FAIL    -1
 
int verify_callback(int preverify, X509_STORE_CTX* x509_ctx)
{
    int depth = X509_STORE_CTX_get_error_depth(x509_ctx);
    int err = X509_STORE_CTX_get_error(x509_ctx);
    
    X509* cert = X509_STORE_CTX_get_current_cert(x509_ctx);
    X509_NAME* iname = cert ? X509_get_issuer_name(cert) : NULL;
    X509_NAME* sname = cert ? X509_get_subject_name(cert) : NULL;
    
//    print_cn_name("Issuer (cn)", iname);
//    print_cn_name("Subject (cn)", sname);
    
    if(depth == 0) {
        /* If depth is 0, its the server's certificate. Print the SANs too */
//        print_san_name("Subject (san)", cert);
    }

    return preverify;
}


void LoadCertificates(SSL_CTX* ctx, char* CertFile, char* KeyFile)
{
    /* set the local certificate from CertFile */
    if ( SSL_CTX_use_certificate_file(ctx, CertFile, SSL_FILETYPE_PEM) <= 0 )
    {
        ERR_print_errors_fp(stderr);
        abort();
    }
    /* set the private key from KeyFile (may be the same as CertFile) */
    if ( SSL_CTX_use_PrivateKey_file(ctx, KeyFile, SSL_FILETYPE_PEM) <= 0 )
    {
        ERR_print_errors_fp(stderr);
        abort();
    }
    /* verify private key */
    if ( !SSL_CTX_check_private_key(ctx) )
    {
        fprintf(stderr, "Private key does not match the public certificate\n");
        abort();
    }
}


int OpenConnection(const char *hostname, int port)
{   int sd;
    struct hostent *host;
    struct sockaddr_in addr;
 
    if ( (host = gethostbyname(hostname)) == NULL )
    {
        perror(hostname);
        abort();
    }
    sd = socket(AF_INET, SOCK_STREAM, 0);
    bzero(&addr, sizeof(addr));
    addr.sin_family = AF_INET;
    addr.sin_port = htons(port);
    addr.sin_addr.s_addr = *(long*)(host->h_addr);
    if ( connect(sd, (struct sockaddr*)&addr, sizeof(addr)) != 0 )
    {
        close(sd);
        perror(hostname);
        abort();
    }
    return sd;
}
 
SSL_CTX* InitCTX(void)
{   SSL_METHOD *method;
    SSL_CTX *ctx;
 
    OpenSSL_add_all_algorithms();  /* Load cryptos, et.al. */
    SSL_load_error_strings();   /* Bring in and register error messages */
    method = SSLv23_client_method();  /* Create new client-method instance */
    ctx = SSL_CTX_new(method);   /* Create new context */

//    SSL_CTX_set_verify(ctx,SSL_VERIFY_PEER, verify_callback);


    if ( ctx == NULL )
    {
        ERR_print_errors_fp(stderr);
        abort();
    }
    return ctx;
}
 
void ShowCerts(SSL* ssl)
{   X509 *cert;
    char *line;
 
    cert = SSL_get_peer_certificate(ssl); /* get the server's certificate */
    if ( cert != NULL )
    {
        printf("Server certificates:\n");
        line = X509_NAME_oneline(X509_get_subject_name(cert), 0, 0);
        printf("Subject: %s\n", line);
        free(line);       /* free the malloc'ed string */
        line = X509_NAME_oneline(X509_get_issuer_name(cert), 0, 0);
        printf("Issuer: %s\n", line);
        free(line);       /* free the malloc'ed string */
        X509_free(cert);     /* free the malloc'ed certificate copy */
    }
    else
        printf("Info: No Server certificates configured.\n");
}

void ShowOwnCerts(SSL* ssl)
{   X509 *cert;
    char *line;
 
    cert = SSL_get_certificate(ssl); /* get the server's certificate */
    if ( cert != NULL )
    {
        printf("Client certificates:\n");
        line = X509_NAME_oneline(X509_get_subject_name(cert), 0, 0);
        printf("Subject: %s\n", line);
        free(line);       /* free the malloc'ed string */
        line = X509_NAME_oneline(X509_get_issuer_name(cert), 0, 0);
        printf("Issuer: %s\n", line);
        free(line);       /* free the malloc'ed string */
        X509_free(cert);     /* free the malloc'ed certificate copy */
    }
    else
        printf("Info: No Client certificates configured.\n");
}

void conn(SSL *ssl){

   printf("**begin typing***\n");

   char* line;
   size_t len=0;
   char buf[1024];
   int bytes;

   bytes = SSL_read(ssl, buf, sizeof(buf)); 


   while(getline(&line,&len,stdin)>0 ){
    buf[bytes]=0;
    printf("Serv msg: %s\n",buf);
    SSL_write(ssl,line,strlen(line));

  //  bytes = SSL_read(ssl, buf, sizeof(buf)); 


   // client sends interrupt from stdin "quit"
    if(strcmp(line,"quit\n")==0){break;}
   }

}
 

 
int main(int count, char *strings[])
{   SSL_CTX *ctx;
    int server;
    SSL *ssl;
    char buf[60000];
    char buf2[20000]; 
    char buf3[20000];
    int bytes, bytes2, bytes3;
    char *hostname, *portnum;
 
    if ( count != 3 )
    {
        printf("usage: %s <hostname> <portnum>\n", strings[0]);
        exit(0);
    }
    SSL_library_init();
    hostname=strings[1];
    portnum=strings[2];
 
    ctx = InitCTX();

//    LoadCertificates(ctx,"domain.crt", "domain.key");
    LoadCertificates(ctx,"mycert.pem", "mycert.pem");


    server = OpenConnection(hostname, atoi(portnum));
    ssl = SSL_new(ctx);      /* create new SSL connection state */
    ShowOwnCerts(ssl);

    SSL_set_fd(ssl, server);    /* attach the socket descriptor */
    if ( SSL_connect(ssl) == FAIL )   /* perform the connection */
        ERR_print_errors_fp(stderr);
    else
    {   
 
        printf("Connected with %s encryption\n", SSL_get_cipher(ssl));
        ShowCerts(ssl);        /* get any certs */
       
//char *msg = "GET /index.html HTTP/1.1\r\nHost: www.coke.com\r\n\r\n";

//char *msg = "GET HTTP/1.1\r\nHost: www.pepsi.com\r\n\r\n";


      char msg[50]="GET /en-us/ HTTP/1.1\r\nHost: ";
       strcat(msg,hostname);

//     char *end="\r\n\r\n";

//     char *end="\r\nUser-Agent: Mozilla/5.0\r\nAccept: text/xml,application/xml,application/xhtml+xml,text/html*/*\r\nAccept-Language: en-us\r\nAccept-Charset: ISO-8859-1,utf-8\r\nConnection: keep-alive\r\n\r\n";

     char *end="\r\nUser-Agent: Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36\r\nAccept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\r\nAccept-Language: en-US,en;q=0.8\r\nAccept-Encoding: gzip, deflate\r\nConnection: keep-alive\r\n\r\n";


//     char *end="\r\nUser-Agent: Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36\r\nAccept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\r\nAccept-Language: en-US,en;q=0.8\r\nAccept-Charset: utf-8\r\nConnection: keep-alive\r\n\r\n";





     strcat(msg,end);

    printf("%s",msg);


//        char *msg = "Begin Transmission\n";
 
       SSL_write(ssl, msg, strlen(msg));   // encrypt & send message */


        
     
        bytes = SSL_read(ssl, buf, sizeof(buf)); // get reply & decrypt 
        bytes2 =SSL_read(ssl, buf2, sizeof(buf2)); 
        bytes3 =SSL_read(ssl, buf3, sizeof(buf3)); 

        sleep(1);

    //    int fd1 = open("buf.html", O_WRONLY | O_APPEND);


      int fd1=open("buf.html", O_RDWR | O_CREAT | O_TRUNC, 0640); 
    
      printf("%d %d %d bytes read\n",bytes,bytes2,bytes3);
        

        buf[bytes] = 0;

        buf2[bytes2]=0;
        buf3[bytes3]=0;
      
       strcat(buf,buf2);
       strcat(buf,buf3);
        write(fd1,buf,strlen(buf));

        printf("Received1: %s\n%s\n%s\n", buf,buf2,buf3);

        system("google-chrome buf.html");




 //       conn(ssl);

//        sleep(3);

//        SSL_free(ssl);        /* release connection state */
    }
    close(server);         /* close socket */
//    SSL_CTX_free(ctx);        /* release context */
    return 0;
}
