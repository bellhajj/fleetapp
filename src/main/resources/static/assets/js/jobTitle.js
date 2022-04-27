$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page		
		var href = $(this).attr('href');
		$.get(href, function(jobTitle, status){	
			$('#idEdit').val(jobTitle.id);		
			$('#descriptionEdit').val(jobTitle.description);
			$('#detailsEdit').val(jobTitle.details);							
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
		$.get(href, function(jobTitle, status){			
			$('#idDetails').val(jobTitle.id);
			$('#descriptionDetails').val(jobTitle.description);
			$('#detailsDetails').val(jobTitle.details);							
		});
		$('#detailModal').modal('show');		
	});
});