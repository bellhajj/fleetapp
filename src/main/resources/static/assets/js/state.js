$('document').ready(function() {

	$('table #editButton').on('click', function(event) {
		event.preventDefault();//to prvent from showing json-like page

		var href = $(this).attr('href');
		$.get(href, function(state, status) {
			$('#idEdit').val(state.id);
			$('#nameEdit').val(state.name);
			$('#capitalEdit').val(state.capital);
			$('#countryEdit').val(state.country.description);
			$('#codeEdit').val(state.code);
			$('#detailsEdit').val(state.details);
		});
		$('#editModal').modal('show');
	});


	$('table #deleteButton').on('click', function(event) {
		event.preventDefault();//to prvent from showing json-like page
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);

		$('#deleteModal').modal('show');
	});
	
	
	$('table #detailButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page

		var href = $(this).attr('href');
		$.get(href, function(state, status) {
			$('#idDetail').val(state.id);
			$('#detailsDetail').val(state.details);
			$('#capitalDetail').val(state.capital);
			$('#countryDetail').val(state.country.description);
			$('#codeDetail').val(state.code);
			$('#nameDetail').val(state.name);
		});
		$('#detailModal').modal('show');		
	});


});