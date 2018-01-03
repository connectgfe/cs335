<html> 
   <body>

      <form action = "<?php $_PHP_SELF ?>" method = "POST">
         enter service: <input type = "text" name = "service"  />
         <input type = "submit" />
      </form>




<?php

   if( $_POST["service"] == "service1" || $_POST["service"] == "services" ) {

      echo  $_POST['service']. " is valid service".  "<br />";

      $dbhost = '127.0.0.1';
      $dbuser = 'root';
      $dbpass = 'connectgfe1!';
      $dbname = $_POST["service"];
//      $dbname = 'service1';
      $conn = new mysqli($dbhost, $dbuser, $dbpass, $dbname);
   
      if(! $conn ) {
        die('could not connect to mysql: ' . mysql_error());
      }
   
      echo 'connected successfully to mysql'. "<br />";;

// do stuff with databse

         $sql = "show tables";

//       $sql = "select name from serv1";
//       $sql = "select table_name from information_schema.tables where table_schema='service1'";
 
        $retval = $conn->query($sql);


// note how calls are made to retval, below operate the same

// 1

/*
        $row2 = $retval->fetch_array(MYSQLI_NUM);
        printf("%s \n", $row2[0]);

        $row2 = $retval->fetch_array(MYSQLI_NUM);
        printf("%s \n", $row2[0]);
*/


// 2 
        
      if (mysqli_num_rows($retval) > 0) {
        // output data of each row

/*
        // for use in table with assoc data
        while($row = mysqli_fetch_array($retval,MYSQLI_ASSOC)) {
          echo "name: " . $row["name"].  "<br>";
        }
*/


        // for use in any query
        while($row = $retval->fetch_array(MYSQLI_NUM)) {
           echo $row[0]. "<br>";
        }
 
      } 

////


// close database
//      mysql_close($conn);

   }else{
   
      echo  $_POST['service']. " is not valid service". "<br />";
 
  }


?>



   </body>
</html>
                       
