$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page		
		var href = $(this).attr('href');
		$.get(href, function(vehicleMake, status){	
			$('#idEdit').val(vehicleMake.id);		
			$('#descriptionEdit').val(vehicleMake.description);
			$('#detailsEdit').val(vehicleMake.details);										
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
		$.get(href, function(vehicleMake, status){			
			$('#idDetails').val(vehicleMake.id);
			$('#descriptionDetails').val(vehicleMake.description);
			$('#detailsDetails').val(vehicleMake.details);									
		});
		$('#detailModal').modal('show');		
	});
});