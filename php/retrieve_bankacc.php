<?php
	
	$connection = mysqli_connect("localhost","id14250915_bank","Dopeshit123.","id14250915_db_bank");

	$profileID = $_POST["profileID"];	
	
	$result = array();
	$result['account'] = array();
	$select = "SELECT * from account where profileID = '$profileID'";
	$responce = mysqli_query($connection,$select);

	while ($row = mysqli_fetch_array($responce)) {
	    	$index['profileID'] = $row['0'];
			$index['account_no'] = $row['1'];
            $index['unique_code'] = $row['2'];
			$index['cvv'] = $row['3'];
			$index['expires'] = $row['4'];
			$index['card_pin'] = $row['5'];
			$index['account_name'] = $row['6'];
			$index['account_balance'] = $row['7'];
            $index['isBlocked'] = $row['8'];


			array_push($result['account'], $index);
		}	
		
		$result["succes"] =1;
		echo json_encode($result);

	mysqli_close($connection);

?>