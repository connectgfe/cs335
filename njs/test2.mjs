import express from 'express';
import erv from 'express-react-views';
import test_class1 from './test_class1.mjs';
import path from 'path';
const app = express();


console.log('********** testing console');

// send an html file to port4000 with sendFile
app.get('/', function(req,res){
  res.sendFile('/home/gesposito/gen_t/njs/test_html.html');
});


app.listen(4000, () => {
  console.log('Example app listening on port 4000!');
  console.log('JSON VIEW: http://localhost:4000');
  console.log('TRAIN/VISUALIZE (1000 iterations): http://localhost:4000/visualize/1000');
});


var jam = new test_class1();
var test_it = jam.echo('hello_3');



//app.set('views', './views');
//app.set('view engine', 'jsx');
//app.engine('jsx', erv.createEngine());

//const renderHtml = (req,res)=> { 
//  res.render('index',"this is another test");
//};

//app.get('/visualize', renderHtml);


