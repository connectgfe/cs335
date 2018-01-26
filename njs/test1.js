var http = require('http');
var t1 = require('./mod_test1');

http.createServer(function (req, res){ 
       res.writeHead( 200, {'Content-Type': 'text/html'});
       res.write("testing function: with 2 " + 2*t1.find2X(4));
       res.end('   Hello World   P ' );
}).listen(4000);  
