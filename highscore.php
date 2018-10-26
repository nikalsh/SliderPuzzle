<?php


if ($_SERVER['REQUEST_METHOD'] === 'GET'){
foreach(file("log.txt") as $line) {
    echo $line;
}
}




if ($_SERVER['REQUEST_METHOD'] === 'POST'){
	$entityBody = file_get_contents('php://input')."\r\n";
file_put_contents("log.txt", $entityBody, FILE_APPEND | LOCK_EX);

}
exit(0);



?>