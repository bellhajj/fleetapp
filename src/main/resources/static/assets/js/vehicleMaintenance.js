$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page		
		var href = $(this).attr('href');
		$.get(href, function(vehicleMaintenance, status){	
			$('#idEdit').val(vehicleMaintenance.id);		
			$('#startDateEdit').val(vehicleMaintenance.startDate.substr(0,10));
			$('#endDateEdit').val(vehicleMaintenance.endDate.substr(0,10));
			$('#vehicleEdit').val(vehicleMaintenance.vehicleid);
			$('#priceEdit').val(vehicleMaintenance.price);	
			$('#supplierEdit').val(vehicleMaintenance.supplierid);
			$('#remarksEdit').val(vehicleMaintenance.remarks);							
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
		$.get(href, function(vehicleMaintenance, status){			
			$('#priceDetails').val(vehicleMaintenance.price);
			$('#supplierDetails').val(vehicleMaintenance.supplierid);
			$('#remarksDetails').val(vehicleMaintenance.remarks);
			$('#startDateDetails').val(vehicleMaintenance.startDate.substr(0,10));
			$('#endDateDetails').val(vehicleMaintenance.endDate.substr(0,10));
			$('#vehicleDetails').val(vehicleMaintenance.vehicleid); 					
		});
		$('#detailModal').modal('show');		
	});
});