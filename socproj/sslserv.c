#include <errno.h>
#include <unistd.h>
#include <malloc.h>
#include <string.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <resolv.h>
#include <openssl/conf.h>
#include "openssl/ssl.h"
#include "openssl/err.h"
#include <sys/fcntl.h>
#include <time.h>
#include <signal.h>
#include <stdlib.h> 
#include <sys/wait.h>
#define FAIL    -1

X509 *okCert;
pid_t proid;
int chdcnt=0;
int server; 
FILE *snd;

 int verify_callback(int preverify_ok, X509_STORE_CTX *ctx)
 {
    char    buf[256];
    char    buf2[256]; 
    X509   *cert;
    int     err;
    SSL    *ssl;
    int     index=0;  

 
    cert = X509_STORE_CTX_get_current_cert(ctx);
    err = X509_STORE_CTX_get_error(ctx);


//    depth = X509_STORE_CTX_get_error_depth(ctx);

    /*
     * Retrieve the pointer to the SSL of the connection currently treated
     * and the application specific data stored into the SSL object.
     */
    ssl = X509_STORE_CTX_get_ex_data(ctx, SSL_get_ex_data_X509_STORE_CTX_idx());


    X509_NAME_oneline(X509_get_subject_name(cert), buf, 256);

   X509_NAME_oneline(X509_get_subject_name(okCert), buf2, 256);



    printf(" %s\n%s\n",buf,buf2);

    if(strcmp(buf,buf2)==0){ 
    printf("success\n");
    return 1;
    }else{ 
    printf("socfail\n"); 
    return 0;}


}


int OpenListener(int port)
{   int sd;
    struct sockaddr_in addr;
 
    sd = socket(AF_INET, SOCK_STREAM, 0);
    bzero(&addr, sizeof(addr));
    addr.sin_family = AF_INET;
    addr.sin_port = htons(port);
    addr.sin_addr.s_addr = INADDR_ANY;
    if ( bind(sd, (struct sockaddr*)&addr, sizeof(addr)) != 0 )
    {
        perror("can't bind port");
        abort();
    }
    if ( listen(sd, 10) != 0 )
    {
        perror("Can't configure listening port");
        abort();
    }

    signal(SIGCHLD, SIG_IGN);

    return sd;
}
 
int isRoot()
{
    if (getuid() != 0)
    {
        return 0;
    }
    else
    {
        return 1;
    }
 
}
SSL_CTX* InitServerCTX(void)
{   SSL_METHOD *method;
    SSL_CTX *ctx;
 
    OpenSSL_add_all_algorithms();  /* load & register all cryptos, etc. */
    SSL_load_error_strings();   /* load all error messages */

    method = SSLv23_server_method();
//    method = TLSv1_2_server_method();  /* create new server-method instance */
    ctx = SSL_CTX_new(method);   /* create new context from method */

 
//    SSL_CTX_set_verify(ctx,SSL_VERIFY_PEER | SSL_VERIFY_FAIL_IF_NO_PEER_CERT,verify_callback);

  
    printf("1verify: %d %d\n",SSL_CTX_get_verify_mode(ctx), SSL_CTX_get_verify_depth(ctx));


//    STACK_OF(X509_NAME) *certn = SSL_load_client_CA_file("/usr/lib/ssl/certs/Equifax_Secure_CA.pem");

     STACK_OF(X509_NAME) *certn = SSL_load_client_CA_file("mycert.pem");




    if( certn==NULL){
      printf("1: no CA files loaded\n");}else
    { printf("1: CA files loaded\n");

    SSL_CTX_set_client_CA_list(ctx,certn);


    }


     STACK_OF(X509_NAME) *test = SSL_CTX_get_client_CA_list(ctx); 

     if( test==NULL){
       printf("2: no CA files loaded\n");}else
    { printf("2: CA files loaded\n");}



// create faux ssl to load okCert used for verify

    const SSL_METHOD *m;
    SSL_CTX *c;
    m = SSLv23_server_method();
    c = SSL_CTX_new(m);
    SSL_CTX_use_certificate_chain_file(c, "mycert.pem"); 
    SSL *s;
    s = SSL_new(c);
    okCert =SSL_get_certificate(s);   
    //Certs(okCert);
    


   // peer auth

    
    if ( ctx == NULL )
    {
        ERR_print_errors_fp(stderr);
        abort();
    }
    return ctx;
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
 
void ShowOwnCerts(SSL* ssl)
{   X509 *cert;
    char *line;
 
    cert = SSL_get_certificate(ssl); /* Get certificates (if available) */
    if ( cert != NULL )
    {
        printf("Server certificates:\n");
        line = X509_NAME_oneline(X509_get_subject_name(cert), 0, 0);
        printf("Subject: %s\n", line);
        free(line);
        line = X509_NAME_oneline(X509_get_issuer_name(cert), 0, 0);
        printf("Issuer: %s\n", line);
        free(line);
        X509_free(cert);
    }
    else
        printf("No Server certificates.\n");
}
 
void ShowCerts(SSL* ssl)
{   X509 *cert;
    char *line;
 
    cert = SSL_get_peer_certificate(ssl); /* Get certificates (if available) */
    if ( cert != NULL )
    {
        printf("Client certificates:\n");
        line = X509_NAME_oneline(X509_get_subject_name(cert), 0, 0);
        printf("Subject: %s\n", line);
        free(line);
        line = X509_NAME_oneline(X509_get_issuer_name(cert), 0, 0);
        printf("Issuer: %s\n", line);
        free(line);
        X509_free(cert);
    }
    else
        printf("No Client certificates.\n");
}

void Servlet(SSL* ssl) /* Serve the connection -- threadable */
{   char buf[1024];
    char reply[1024]="got it";
    int sd, bytes;
    const char* HTMLecho="<html><body><pre>%s</pre></body></html>\n\n";
 
    if ( SSL_accept(ssl) == FAIL )     /* do SSL-protocol accept */
        ERR_print_errors_fp(stderr);
    else
    {
       ShowCerts(ssl);        /* get any certificates */
       bytes = SSL_read(ssl, buf, sizeof(buf)); /* get request */

 
       proid = fork();       
       if(proid == 0){
       
       close(server);

        // attempt to send file 
        SSL_write(ssl,snd,10);

   

         while ( bytes > 0 )
         {

             
            buf[bytes] = 0;
            if(strcmp(buf,"quit\n")==0){break;} 
            printf("Client msg: %s", buf);

            sprintf(reply, HTMLecho, buf);   /* construct reply */
    //        SSL_write(ssl, reply, strlen(reply)); /* send reply */
            bytes = SSL_read(ssl, buf, sizeof(buf));

         }

 //printf("no1\n");
   
        sleep(3);
        sd = SSL_get_fd(ssl); 
        SSL_free(ssl);  
        close(sd); 
 printf("**end2*** %d\n", proid);
         
        exit(0);
      }


     printf("child ends with: %d\n",proid);
     chdcnt++;

     while(chdcnt){
     proid=waitpid( (pid_t) -1 , NULL, WNOHANG);
      if(proid < 0)
      exit(0); 
     else if(proid == 0) break;
     else chdcnt--;
    }
         
       
   }
  
          
    sd = SSL_get_fd(ssl);       /* get socket connection */
     
    SSL_free(ssl);         /* release SSL state */

printf("**end***\n");
    close(sd);          /* close connection */
   

}
 
int main(int count, char *strings[])
{   SSL_CTX *ctx;
    char *portnum;
    snd = fopen("sendit.txt", "r");

    

/* 
    if(!isRoot())
    {
        printf("This program must be run as root/sudo user!!");
        exit(0);
    }
*/

    if ( count != 2 )
    {
        printf("Usage: %s <portnum>\n", strings[0]);
        exit(0);
    }
    SSL_library_init();
 
    portnum = strings[1];
    ctx = InitServerCTX();        /* initialize SSL */
//    LoadCertificates(ctx, "domain.crt", "domain.key"); /* load certs */
    LoadCertificates(ctx, "mycert.pem", "mycert.pem"); /* load certs */


    server = OpenListener(atoi(portnum));    /* create server listen at port socket */
    while (1)
    {   struct sockaddr_in addr;
        socklen_t len = sizeof(addr);
        SSL *ssl;

       
        int client = accept(server, (struct sockaddr*)&addr, &len);  /* accept connection as usual */
        // prints client info 
        printf("Connection: %s:%d\n",inet_ntoa(addr.sin_addr), ntohs(addr.sin_port));
        int fd1=open("log2.txt", O_WRONLY | O_APPEND);
        char *address = inet_ntoa(addr.sin_addr);
 
        int plen = snprintf(NULL, 0, "%d", ntohs(addr.sin_port));
        char portno[20];
        snprintf(portno, plen+1, "%d", ntohs(addr.sin_port));
        strcat(address,portno);


        time_t t = time(NULL);
        struct tm *tm = localtime(&t);
        char s[64];
        strftime(s, sizeof(s), "%c", tm);
        s[strlen(s)]='\n';  
         s[strlen(s)+1]='\0';  

        strcat(address,s);
        write(fd1,address,strlen(address));         

       ssl = SSL_new(ctx);              /* get new SSL state with context */

//        ShowOwnCerts(ssl);

printf("verify3: %d\n",SSL_get_verify_mode(ssl));

//    SSL_set_verify(ssl,SSL_VERIFY_PEER,0);
       

        SSL_set_fd(ssl, client);      /* set connection socket to SSL state */


        Servlet(ssl);         /* service connection */
    }
    close(server);          /* close server socket */
    SSL_CTX_free(ctx);         /* release context */
}

