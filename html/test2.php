<html> 
   <body>

      <form action = "<?php $_PHP_SELF ?>" method = "POST">
         enter service: <input type = "text" name = "service"  />
         <input type = "submit" />
      </form>




<?php

   if( $_POST["service"] == "service1" || $_POST["service"] == "service2" ) {

      echo  $_POST['service']. " is valid service".  "<br />";

      $dbhost = '127.0.0.1';
      $dbuser = 'root';
      $dbpass = 'connectgfe1!';
      $dbname = $_POST["service"];
      $conn = mysqli_connect($dbhost, $dbuser, $dbpass, $dbname);
   
      if(! $conn ) {
        die('could not connect to mysql: ' . mysql_error());
      }
   
      echo 'connected successfully to mysql'. "<br />";;

// do stuff with databse

      $sql = 'select name';
      $retval = $conn->query($sql);
   
      if(! $retval ) {
        die('Could not get data: ' . mysqli_error());
      }

/*
      $row= $retval->fetch_assoc();
      echo "name: ".$row["name"].  "<br> ";
*/
      while($row = mysqli_fetch_assoc($result)) {
        echo "name " . $row["name"]. "<br>";
      }



// close database
//      mysql_close($conn);

   }else{
   
      echo  $_POST['service']. " is not valid service". "<br />";
 
  }


?>



   </body>
</html>
                       
