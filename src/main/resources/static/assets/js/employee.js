$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page		
		var href = $(this).attr('href');
		$.get(href, function(employee, status){	
			$('#idEdit').val(employee.id);		
			$('#titleEdit').val(employee.title);
			$('#initialsEdit').val(employee.initials);
			$('#socialSecurityNumberEdit').val(employee.socialSecurityNumber);
			$('#firstnameEdit').val(employee.firstname);	
			$('#lastnameEdit').val(employee.lastname);
			$('#othernameEdit').val(employee.othername);
			$('#genderEdit').val(employee.gender);	
			$('#countryEdit').val(employee.countryid);
			$('#addressEdit').val(employee.address);
			$('#dateOfBirthEdit').val(employee.dateOfBirth.substr(0,10));
			$('#hireDateEdit').val(employee.hireDate.substr(0,10));
			$('#stateEdit').val(employee.stateid);
			$('#cityEdit').val(employee.city);	
			$('#phoneEdit').val(employee.phone);
			$('#mobileEdit').val(employee.mobile);
			$('#maritalStatusEdit').val(employee.maritalStatus);	
			$('#emailEdit').val(employee.email);
			$('#jobtitleEdit').val(employee.jobtitleid);
			$('#employeetypeEdit').val(employee.employeetypeid);				
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
	
	$('.table #photoButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page
		var href = $(this).attr('href');
		$('#photoModal #employeePhoto').attr('src', href);
		$('#photoModal').modal('show');	
	});
});