#include <stdio.h>
#include <unistd.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <openssl/ssl.h>
#include <openssl/err.h>
#include <openssl/x509.h>
#include <openssl/x509v3.h>
#include <openssl/stack.h>
#include <sys/fcntl.h>
#include <time.h>
#include <signal.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <netinet/in.h>
#include <openssl/conf.h>
#define FAIL -1

X509 *okCert;
pid_t proid;
int sock;
int chdcnt=0;

void Servlet(SSL* ssl) // Serve the connection -- threadable 
{   char buf[1024];
    char reply[1024];
    int sd, bytes;
    const char* HTMLecho="<html><body><pre>%s</pre></body></html>\n\n";
 

    if ( SSL_accept(ssl) == FAIL )     // do SSL-protocol accept //
        ERR_print_errors_fp(stderr);
    else
    {
   //    ShowCerts(ssl);        // get any certificates //
       bytes = SSL_read(ssl, buf, sizeof(buf)); // get request //

 
       proid = fork();       
       if(proid == 0){
       
       close(sock);


         while ( bytes > 0 )
         {

             
            buf[bytes] = 0;
            if(strcmp(buf,"quit\n")==0){break;} 
            printf("Client msg: %s", buf);
            sprintf(reply, HTMLecho, buf);   // construct reply 
            SSL_write(ssl, reply, strlen(reply)); // send reply 
            bytes = SSL_read(ssl, buf, sizeof(buf));

         }


   
        sleep(3);
        sd = SSL_get_fd(ssl); 
//        SSL_free(ssl);  
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





void Certs(X509 *cert)
{    char *line;
 
    if ( cert != NULL )
    {
        printf("Certificates:\n");
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
        printf("Info: No Client certificates configured.\n");

//        exit(0);
}


int verify_callback2(int preverify, X509_STORE_CTX* x509_ctx)
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

    return 0;
}



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

int create_socket(int port)
{
    int s;
    struct sockaddr_in addr;

    addr.sin_family = AF_INET;
    addr.sin_port = htons(port);
    addr.sin_addr.s_addr = htonl(INADDR_ANY);

    s = socket(AF_INET, SOCK_STREAM, 0);
    if (s < 0) {
	perror("Unable to create socket");
	exit(EXIT_FAILURE);
    }

    if (bind(s, (struct sockaddr*)&addr, sizeof(addr)) < 0) {
	perror("Unable to bind");
	exit(EXIT_FAILURE);
    }

    if (listen(s, 1) < 0) {
	perror("Unable to listen");
	exit(EXIT_FAILURE);
    }

    return s;
}


/*
void init_openssl()
{ 
    SSL_load_error_strings();	
    OpenSSL_add_ssl_algorithms();
}
*/
#if (SSLEAY_VERSION_NUMBER >= 0x0907000L)
# include <openssl/conf.h>
#endif

void init_openssl_library()
{
  (void)SSL_library_init();

  SSL_load_error_strings();

  /* ERR_load_crypto_strings(); */
  
  OPENSSL_config(NULL);
    
  /* Include <openssl/opensslconf.h> to get this define */
#if defined (OPENSSL_THREADS)
  fprintf(stdout, "Warning: thread locking is not implemented\n");
#endif
}


void cleanup_openssl()
{
    EVP_cleanup();
}

SSL_CTX *create_context()
{
    const SSL_METHOD *method;
    SSL_CTX *ctx;

    method = SSLv23_server_method();

    ctx = SSL_CTX_new(method);


    SSL_CTX_set_verify(ctx,SSL_VERIFY_PEER | SSL_VERIFY_FAIL_IF_NO_PEER_CERT,verify_callback);

  
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
    

    if (!ctx) {
	perror("Unable to create SSL context");
	ERR_print_errors_fp(stderr);
	exit(EXIT_FAILURE);
    }

    return ctx;
}

void configure_context(SSL_CTX *ctx)
{
    SSL_CTX_set_ecdh_auto(ctx, 1);

    /* Set the key and cert */
    if (SSL_CTX_use_certificate_chain_file(ctx, "domain.crt") <= 0) {
        ERR_print_errors_fp(stderr);
	exit(EXIT_FAILURE);
    }

    if (SSL_CTX_use_PrivateKey_file(ctx, "domain.key", SSL_FILETYPE_PEM) <= 0 ) {
        ERR_print_errors_fp(stderr);
	exit(EXIT_FAILURE);
    }
}

int main(int argc, char **argv)
{
    SSL_CTX *ctx;

    init_openssl_library();
    ctx = create_context();

    configure_context(ctx);

    sock = create_socket(3500);
     SSL *ssl;

     ssl = SSL_new(ctx);


    signal(SIGCHLD, SIG_IGN);


    printf("2verify: %d %d\n",SSL_get_verify_mode(ssl), SSL_get_verify_depth(ssl));


    /* Handle connections */
    while(1) {
        struct sockaddr_in addr;
        uint len = sizeof(addr);
        const char reply[] = "tEsT\n";

        int client = accept(sock, (struct sockaddr*)&addr, &len);

        int fd1=open("log2.txt", O_WRONLY | O_APPEND);
        char *address = inet_ntoa(addr.sin_addr);
        time_t t = time(NULL);
        struct tm *tm = localtime(&t);
        char s[64];
        strftime(s, sizeof(s), "%c", tm);
   
        strcat(address,s);
        write(fd1,address,strlen(address));         



        if (client < 0) {
            perror("Unable to accept");
            exit(EXIT_FAILURE);
        }



     STACK_OF(X509_NAME) *test = SSL_get_client_CA_list(ssl); 
     if( test==NULL){
      printf("3: no CA files loaded\n");}else
    { printf("3: CA files loaded\n");}

        
 
        SSL_set_fd(ssl, client);


        Servlet(ssl);

//        ShowCerts(ssl);

/*
        if (SSL_accept(ssl) <= 0) {

            ERR_print_errors_fp(stderr);
        }
        else {

            SSL_write(ssl, reply, strlen(reply));
        }

        SSL_free(ssl);
        close(client);
*/ 

    }

    close(sock);
    SSL_CTX_free(ctx);
//    cleanup_openssl();
}

