$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page		
		var href = $(this).attr('href');
		$.get(href, function(vehicleMovement, status){	
			$('#idEdit').val(vehicleMovement.id);		
			$('#vehicleEdit').val(vehicleMovement.vehicleid);
			$('#location1Edit').val(vehicleMovement.locationid1);
			$('#location2Edit').val(vehicleMovement.locationid2);
			$('#remarksEdit').val(vehicleMovement.remarks);	
			$('#date1Edit').val(vehicleMovement.date1.substr(0,10));
			$('#date2Edit').val(vehicleMovement.date2.substr(0,10));								
		});
		$('#editModal').modal('show');		
	});
	
	
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		
		$('#deleteModal').modal('show');
	});
	
	$('table #detailButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page		
		var href = $(this).attr('href');
		$.get(href, function(vehicleMovement, status){			
			$('#vehicleDetails').val(vehicleMovement.vehicleid);
			$('#location1Details').val(vehicleMovement.locationid1);
			$('#location2Details').val(vehicleMovement.locationid2);
			$('#date1Details').val(vehicleMovement.date1.substr(0,10)); 	
			$('#date2Details').val(vehicleMovement.date2.substr(0,10));
			$('#remarksDetails').val(vehicleMovement.remarks);				
		});
		$('#detailModal').modal('show');		
	});
});