$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page		
		var href = $(this).attr('href');
		$.get(href, function(location, status){	
			$('#idEdit').val(location.id);		
			$('#cityEdit').val(location.city);
			$('#stateEdit').val(location.stateid);
			$('#countryEdit').val(location.countryid);
			$('#addressEdit').val(location.address);							
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
		$.get(href, function(location, status){			
			$('#cityDetails').val(location.city);
			$('#stateDetails').val(location.stateid);
			$('#countryDetails').val(location.countryid);
			$('#addressDetails').val(location.address);							
		});
		$('#detailModal').modal('show');		
	});
});