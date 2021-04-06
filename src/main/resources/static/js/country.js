$('document').ready(function(){
    $('table #editButton').on('click',function(event){
        event.preventDefault();

        var href=$(this).attr('href');

        $.get(href, function(country, status){
            $('#idEdit').val(country.id);
            $('#descEdit').val(country.description);
            $('#capitalEdit').val(country.capital);
            $('#codeEdit').val(country.code);
            $('#continentEdit').val(country.continent);
            $('#nationalityEdit').val(country.nationality);
        });
        $('#editModal').modal();
    });

            $('table #detailsButton').on('click',function(event){
                event.preventDefault();
                var href=$(this).attr('href');
                $.get(href, function(country, status){
                    $('#idDetails').val(country.id);
                    $('#nationalityDetails').val(country.nationality);
                    $('#codeDetails').val(country.code);
                    $('#capitalDetails').val(country.capital);
                    $('#continentDetails').val(country.continent);
                    $('#descDetails').val(country.description);
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
