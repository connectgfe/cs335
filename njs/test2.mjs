import express from 'express';
import erv from 'express-react-views';
import test_class1 from './test_class1.mjs';
import child_process from 'child_process';
import fs from 'fs';
import path from 'path';

console.log('********** testing console');

const app = express();
const exec = child_process.exec;
const xy_out = fs;
var buf = new Buffer(100);

exec('./t_sc xy_in.dat', (e, stdout, stderr)=> {

    if (e instanceof Error) {
        console.error(e);
        throw e;
    }
    console.log('stdout ', stdout);
    console.log('stderr ', stderr);
});



// note: readFileSync may be helpful


xy_out.readFile('xy_out.dat','utf8', function(err,buf) {
    console.log('start read');
    console.log(buf);
    console.log('end read');
 
});


// send an html file to port4000 with sendFile
//app.get('/', function(req,res){
//  res.sendFile('/home/gesposito/gen_t/njs/test_html2.html');
//});


var jam = new test_class1();
var test_it = jam.echo(buf);

app.get('/', function(req,res){

//  res.sendFile('/home/gesposito/gen_t/njs/test_txt.txt');

    res.send(JSON.stringify(buf.toString()));

});  


app.listen(4000, () => {
  console.log('Example app listening on port 4000!');
  console.log('JSON VIEW: http://localhost:4000');
  console.log('TRAIN/VISUALIZE (1000 iterations): http://localhost:4000/visualize/1000');
});


//app.set('views', './views');
//app.set('view engine', 'jsx');
//app.engine('jsx', erv.createEngine());

//const renderHtml = (req,res)=> { 
//  res.render('index',"this is another test");
//};

//app.get('/visualize', renderHtml);


