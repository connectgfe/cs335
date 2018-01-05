<html> 
   <body>


<?php


      $dbhost = '127.0.0.1';
      $dbuser = 'root';
      $dbpass = 'connectgfe1!';
      $dbname = 'services';
      $conn = new mysqli($dbhost, $dbuser, $dbpass, $dbname);
   
      if(! $conn ) {
        die('could not connect to mysql: ' . mysql_error());
      }
  
      echo 'connected successfully to mysql'. "<br />";


// do stuff with databse

      $sql = "show tables";
 
      $retval = $conn->query($sql);
 

        while($row = $retval->fetch_array(MYSQLI_NUM)){

//          printf("%s\n", $row2[0]);
         echo $row[0]. "<br/>";

        }



$form = newt_form();

$ok_button = newt_button(30, 50, "Run Tool");
    
newt_form_add_component($form, $ok_button);



 
// close database
      mysql_close($conn);


?>


 

   </body>
</html>
                       
