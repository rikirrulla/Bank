<?php
	
	$connection = mysqli_connect("localhost","id14250915_bank","Dopeshit123.","id14250915_db_bank");

	$profileid = $_POST["profileID"];
	$account_no = $_POST["account_no"];
	$timestamp = $_POST["timestamp"];
	$sending_account = $_POST["sending_account"];
	$destination_account = $_POST["destination_account"];
	$transaction_payee = $_POST["transaction_payee"];
	$transaction_amount = $_POST["transaction_amount"];
	$trans_type = $_POST["trans_type"];

	
	$sql = "INSERT INTO transactions (profileID, account_no, timestamp, sending_account, destination_account, transaction_payee, transaction_amount, trans_type) VALUES ('$profileid','$account_no','$timestamp','$sending_account','$destination_account','$transaction_payee','$transaction_amount','$trans_type')";

	$result = mysqli_query($connection,$sql);

	if($result){
		echo "Data Inserted";
	} else {
		echo "Failed";
	}

	mysqli_close($connection);

?>