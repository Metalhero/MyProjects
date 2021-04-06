$('document').ready(function(){

    $('table #editButton').on('click',function(event){
        event.preventDefault();

        var href=$(this).attr('href');

        $.get(href, function(client, status){
            $('#idEdit').val(client.id);
            $('#firstnameEdit').val(client.firstname);
            $('#lastnameEdit').val(client.lastname);
            $('#titleEdit').val(client.title);
            $('#birthDateEdit').val(client.dateOfBirth);
            $('#genderEdit').val(client.gender);
            $('#cityEdit').val(client.city);
            $('#addressEdit').val(client.address);
            $('#emailEdit').val(client.email);
            $('#mobileEdit').val(client.mobile);
        });
        $('#editModal').modal();
    });

        $('table #detailsButton').on('click',function(event){
            event.preventDefault();
            var href=$(this).attr('href');
            $.get(href, function(client, status){
                $('#idDetails').val(client.id);
                $('#firstnameDetails').val(client.firstname);
                $('#lastnameDetails').val(client.lastname);
                $('#titleDetails').val(client.title);
                $('#birthDateDetails').val(client.dateOfBirth);
                $('#genderDetails').val(client.gender);
                $('#cityDetails').val(client.city);
                $('#addressDetails').val(client.address);
                $('#emailDetails').val(client.email);
                $('#mobileDetails').val(client.mobile);
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
