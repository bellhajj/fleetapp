$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page		
		var href = $(this).attr('href');
		$.get(href, function(vehicleType, status){	
			$('#idEdit').val(vehicleType.id);		
			$('#descriptionEdit').val(vehicleType.description);
			$('#detailsEdit').val(vehicleType.details);							
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
		$.get(href, function(vehicleType, status){			
			$('#idDetails').val(vehicleType.id);
			$('#descriptionDetails').val(vehicleType.description);
			$('#detailsDetails').val(vehicleType.details);							
		});
		$('#detailModal').modal('show');		
	});
});