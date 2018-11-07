<?php

if ($_SERVER['REQUEST_METHOD'] === 'GET') {
    foreach (file("log.txt") as $line) {
        echo $line;
    }
}


$match;

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    
    $entityBody = file_get_contents('php://input') . "\r\n";

if(!preg_match('/[^A-Za-z0-9\s\r\n]/', $entityBody))
{
    file_put_contents("log.txt", $entityBody, FILE_APPEND | LOCK_EX);

}
}



exit(0);
?>