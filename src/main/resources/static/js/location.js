$('document').ready(function(){

    $('table #editButton').on('click',function(event){
        event.preventDefault();

        var href=$(this).attr('href');

        $.get(href, function(location, status){
            $('#ddlCountryEdit').val(location.countryid);
            $('#idEdit').val(location.id);
            $('#cityEdit').val(location.city);
            $('#addressEdit').val(location.address);
            $('#detailsEdit').val(location.details);
            $('#descEdit').val(location.description);
        });
        $('#editModal').modal();
    });

        $('table #detailsButton').on('click',function(event){
            event.preventDefault();
            var href=$(this).attr('href');
            $.get(href, function(location, status){
                $('#countryDetails').val(location.country.nationality);
                $('#ddlStateDetails').val(location.stateid);
                $('#idDetails').val(location.id);
                $('#cityDetails').val(location.city);
                $('#addressDetails').val(location.address);
                $('#detailsDetails').val(location.details);
                $('#descDetails').val(location.description);
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
