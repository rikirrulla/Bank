<?php
	
	$connection = mysqli_connect("localhost","id14250915_bank","Dopeshit123.","id14250915_db_bank");

	$username = $_POST["username"];
	$password = $_POST["password"];
	$fullname = $_POST["fullname"];
	$city = $_POST["city"];
	$address = $_POST["address"];
	$telephone_number = $_POST["telephone_number"];
	

	$sql = "INSERT INTO profiles(username,password,fullname, city, address, telephone_number) VALUES ('$username','$password','$fullname','$city','$address','$telephone_number')";

	$result = mysqli_query($connection,$sql);

	if($result){
		echo "Data Inserted";
	} else {
		echo "Failed";
	}

	mysqli_close($connection);

?>