<?php
	
	$connection = mysqli_connect("localhost","id14250915_bank","Dopeshit123.","id14250915_db_bank");

	$profileID = $_POST["profileID"];	

	$result = array();
	$result['transactions'] = array();
	$select = "SELECT * from transactions where profileID = '$profileID' ORDER BY transaction_id DESC;";
	$responce = mysqli_query($connection,$select);

	while ($row = mysqli_fetch_array($responce)) {
			$index['profileID'] = $row['0'];
			$index['account_no'] = $row['1'];
			$index['transaction_id'] = $row['2'];
			$index['timestamp'] = $row['3'];
			$index['sending_account'] = $row['4'];
			$index['destination_account'] = $row['5'];
			$index['transaction_payee'] = $row['6'];
			$index['transaction_amount'] = $row['7'];
			$index['trans_type'] = $row['8'];



			array_push($result['transactions'], $index);
		}	
		
		$result["succes"] =1;
		echo json_encode($result);

	mysqli_close($connection);

?>