all:  Serv Cli TLSserv

Serv:
	gcc  -o sslserv sslserv.c -L/usr/lib -lssl -lcrypto
Cli: 
	gcc -o  sslcli sslcli.c -L/usr/lib -lssl -lcrypto
	
	gcc  -o sslcli2 sslcli2.c -L/usr/lib -lssl -lcrypto

TLSserv:
	gcc -o tlsserv tlsserv.c  -L/usr/lib -lssl -lcrypto

