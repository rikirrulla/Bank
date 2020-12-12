<?php
	
	$connection = mysqli_connect("localhost","id14250915_bank","Dopeshit123.","id14250915_db_bank");

	$result = array();
	$result['profile'] = array();
	$select = "SELECT * from profiles";
	$responce = mysqli_query($connection,$select);

	while ($row = mysqli_fetch_array($responce)) {
			$index['profileID'] = $row['0'];
			$index['username'] = $row['1'];
			$index['password'] = $row['2'];
			$index['fullname'] = $row['3'];
			$index['city'] = $row['4'];
			$index['address'] = $row['5'];
			$index['telephone_number'] = $row['6'];


			array_push($result['profile'], $index);
		}	
		
		$result["succes"] =1;
		echo json_encode($result);

	mysqli_close($connection);

?>