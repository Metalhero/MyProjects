$('document').ready(function(){

    $('table #editButton').on('click',function(event){
        event.preventDefault();

        var href=$(this).attr('href');

        $.get(href, function(vehicleStatus, status){
            $('#idEdit').val(vehicleStatus.id);
            $('#detailsEdit').val(vehicleStatus.details);
            $('#descEdit').val(vehicleStatus.description);
        });
        $('#editModal').modal();
    });

        $('table #detailsButton').on('click',function(event){
            event.preventDefault();
            var href=$(this).attr('href');
            $.get(href, function(vehicleStatus, status){
                $('#idDetails').val(vehicleStatus.id);
                $('#detailsDetails').val(vehicleStatus.details);
                $('#descDetails').val(vehicleStatus.description);
                //$('#lastModifiedByDetails').val(state.lastModifiedBy);
                //$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T"," "));
            });
            $('#detailsModal').modal();
        });

$('table #deleteButton').on('click',function(event){
    event.preventDefault();
    var href= $(this).attr('href');
    $('#confirmDeleteBtn').attr('href', href);
    $('#deleteModal').modal();
});

});
