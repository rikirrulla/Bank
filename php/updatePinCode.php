<?php
	
	$connection = mysqli_connect("localhost","id14250915_bank","Dopeshit123.","id14250915_db_bank");

	$id = $_POST["profileID"];
	$card_pin = $_POST["card_pin"];

	
	$sql = "UPDATE account SET card_pin = '$card_pin' WHERE profileID = '$id'";

	$result = mysqli_query($connection,$sql);

	if($result){
		echo "Data Updated";
	} else {
		echo "Failed";
	}

	mysqli_close($connection);

?>