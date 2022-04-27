$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page		
		var href = $(this).attr('href');
		$.get(href, function(client, status){	
			$('#idEdit').val(client.id);		
			$('#nameEdit').val(client.name);
			$('#detailsEdit').val(client.details);
			$('#websiteEdit').val(client.website);
			$('#addressEdit').val(client.address);	
			$('#stateEdit').val(client.stateid);
			$('#countryEdit').val(client.countryid);
			$('#cityEdit').val(client.city);	
			$('#phoneEdit').val(client.phone);
			$('#mobileEdit').val(client.mobile);
			$('#emailEdit').val(client.email);						
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
		$.get(href, function(client, status){			
			/*$('#cityDetails').val(client.city);
			$('#stateDetails').val(client.stateid);
			$('#countryDetails').val(client.countryid);
			$('#addressDetails').val(client.address); */					
		});
		$('#detailModal').modal('show');		
	});
});