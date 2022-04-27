$('document').ready(function(){
		
	$('table #editButton').on('click', function(event){		
		event.preventDefault();//to prvent from showing json-like page				
		var href = $(this).attr('href');		
		$.get(href, function(contact, status){	
			$('#idEdit').val(contact.id);		
			$('#firstnameEdit').val(contact.firstname);
			$('#lastnameEdit').val(contact.lastname);			 
			$('#remarksEdit').val(contact.remarks);
			$('#phoneEdit').val(contact.phone);
			$('#mobileEdit').val(contact.mobile);
			$('#emailEdit').val(contact.email);						
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