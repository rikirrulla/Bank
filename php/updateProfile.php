<?php
	
	$connection = mysqli_connect("localhost","id14250915_bank","Dopeshit123.","id14250915_db_bank");

	$profileID = $_POST["profileID"];
	$username = $_POST["username"];
	$fullname = $_POST["fullname"];
	$city = $_POST["city"];
	$address = $_POST["address"];
	$telephone_number = $_POST["telephone_number"];
	
	$sql = "UPDATE profiles SET username = '$username', fullname = '$fullname', city = '$city', address = '$address', telephone_number = '$telephone_number'  WHERE profileID = '$profileID'";

	$result = mysqli_query($connection,$sql);

	if($result){
		echo "Data Updated";
	} else {
		echo "Failed";
	}

	mysqli_close($connection);

?>