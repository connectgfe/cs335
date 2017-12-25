<?php
// CSC 337 Project Best Reads
//
// 1) Use a query parameter from AJAX to echo back an array of image urls. 
// To return an array to a JavaScript you need json_encode. Do not hard 
// code the array. This service should work if more folders are added.
$urls = ["./books/2001spaceodessy", "./books/wizardofoz"];
echo json_encode($urls);
// Output would be this (json_encode adds an escape character: \ before /
// [".\/books\/2001spaceodessy",".\/books\/wizardofoz"]


// 2) Use a different query parameter to echo back the html for one information
// page containing the book cover, title, author, ...
?>