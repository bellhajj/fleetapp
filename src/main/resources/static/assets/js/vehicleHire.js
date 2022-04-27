$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page		
		var href = $(this).attr('href');
		$.get(href, function(vehicleHire, status){	
			$('#idEdit').val(vehicleHire.id);		
			$('#vehicleEdit').val(vehicleHire.vehicleid);
			$('#clientEdit').val(vehicleHire.clientid);
			$('#dateOutEdit').val(vehicleHire.dateOut.substr(0,10));
			$('#timeOutEdit').val(vehicleHire.timeOut);	
			$('#loctionEdit').val(vehicleHire.locationid);
			$('#dateInEdit').val(vehicleHire.dateIn.substr(0,10));
			$('#timeInEdit').val(vehicleHire.timeIn);	
			$('#priceEdit').val(vehicleHire.price);
			$('#remarksEdit').val(vehicleHire.remarks);								
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
		$.get(href, function(vehicleHire, status){				
			$('#vehicleDetails').val(vehicleHire.vehicleid);
			$('#clientDetails').val(vehicleHire.clientid);
			$('#dateOutDetails').val(vehicleHire.dateOut.substr(0,10));
			$('#timeOutDetails').val(vehicleHire.timeOut);	
			$('#loctionDetails').val(vehicleHire.locationid);
			$('#dateInDetails').val(vehicleHire.dateIn.substr(0,10));
			$('#timeInDetails').val(vehicleHire.timeIn);	
			$('#priceDetails').val(vehicleHire.price);
			$('#remarksDetails').val(vehicleHire.remarks);						
		});
		$('#detailModal').modal('show');		
	});
});