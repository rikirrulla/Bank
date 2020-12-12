<?php
	
	$connection = mysqli_connect("localhost","id14250915_bank","Dopeshit123.","id14250915_db_bank");

	$id = $_POST["profileID"];
	$password = $_POST["password"];

	
	$sql = "UPDATE profiles SET password = '$password' WHERE profileID = '$id'";

	$result = mysqli_query($connection,$sql);

	if($result){
		echo "Data Updated";
	} else {
		echo "Failed";
	}

	mysqli_close($connection);

?>