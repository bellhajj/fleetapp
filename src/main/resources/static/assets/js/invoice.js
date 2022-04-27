$('document').ready(function(){
	
	$('table #editButton').on('click', function(event){
		event.preventDefault();//to prvent from showing json-like page		
		var href = $(this).attr('href');
		$.get(href, function(invoice, status){			
			$('#idEdit').val(invoice.id);
			$('#clientEdit').val(invoice.clientid);
			var invoiceDate = invoice.invoiceDate.substr(0,10); // Select only the date part of the date. Anything beyond is time
			$('#invoiceDateEdit').val(invoiceDate);
			$('#invoiceStatusEdit').val(invoice.invoicestatusid);			
			$('#remarksEdit').val(invoice.remarks);					
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
		$.get(href, function(invoice, status){			
			$('#idDetails').val(invoice.id);
			$('#clientDetails').val(invoice.clientid);
			$('#invoiceDateDetails').val(invoice.invoiceDate.substr(0,10));
			$('#invoiceStatusDetails').val(invoice.invoicestatusid);
			$('#remarksDetails').val(invoice.remarks);											
		});
		$('#detailModal').modal('show');		
	});
});