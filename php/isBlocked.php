<?php
	
	$connection = mysqli_connect("localhost","id14250915_bank","Dopeshit123.","id14250915_db_bank");

	$account_no = $_POST["account_no"];
	$isBlocked = $_POST["isBlocked"];

	
	$sql = "UPDATE account SET isBlocked = '$isBlocked' WHERE account_no = '$account_no'";

	$result = mysqli_query($connection,$sql);

	if($result){
		echo "Data Updated";
	} else {
		echo "Failed";
	}

	mysqli_close($connection);

?>