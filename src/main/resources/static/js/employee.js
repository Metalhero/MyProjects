$('document').ready(function(){

    $('table #editButton').on('click',function(event){
        event.preventDefault();

        var href=$(this).attr('href');

        $.get(href, function(employee, status){
            $('#idEdit').val(employee.id);
            $('#firstnameEdit').val(employee.firstname);
            $('#lastnameEdit').val(employee.lastname);
            $('#titleEdit').val(employee.title);
            $('#birthDateEdit').val(employee.dateOfBirth);
            $('#genderEdit').val(employee.gender);
            $('#emailEdit').val(employee.email);
            $('#mobileEdit').val(employee.mobile);
        });
        $('#editModal').modal();
    });

        $('table #detailsButton').on('click',function(event){
            event.preventDefault();
            var href=$(this).attr('href');
            $.get(href, function(employee, status){
                $('#idDetails').val(employee.id);
                $('#firstnameDetails').val(employee.firstname);
                $('#lastnameDetails').val(employee.lastname);
                $('#titleDetails').val(employee.title);
                $('#birthDateDetails').val(employee.dateOfBirth);
                $('#genderDetails').val(employee.gender);
                $('#emailDetails').val(employee.email);
                $('#mobileDetails').val(employee.mobile);
            });
            $('#detailsModal').modal();
        });


$('table #deleteButton').on('click',function(event){
    event.preventDefault();
    var href= $(this).attr('href');
    $('#confirmDeleteBtn').attr('href', href);
    $('#deleteModal').modal();
});

$('.table #photoButton').on('click',function(event) {
   event.preventDefault();
   var href = $(this).attr('href');
   $('#photoModal #employeePhoto').attr('src', href);
   $('#photoModal').modal();
});

});
