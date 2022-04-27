$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page		
		var href = $(this).attr('href');
		$.get(href, function(country, status){			
			$('#idEdit').val(country.id);
			$('#continentEdit').val(country.continent);
			$('#capitalEdit').val(country.capital);
			$('#nationalityEdit').val(country.nationality);
			$('#codeEdit').val(country.code);
			$('#descriptionEdit').val(country.description);					
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
		$.get(href, function(country, status){			
			$('#idDetail').val(country.id);
			$('#continentDetail').val(country.continent);
			$('#capitalDetail').val(country.capital);
			$('#nationalityDetail').val(country.nationality);
			$('#codeDetail').val(country.code);
			$('#descriptionDetail').val(country.description);								
		});
		$('#detailModal').modal('show');		
	});
});