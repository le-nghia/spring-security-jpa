$(document).ready(function() {

// Show delete brand confirmation modal
    $("#brandInfoTable").on('click', '.delete-btn', function() {
        $("#deletedBrandName").text($(this).data("name"));
        $("#deleteSubmitBtn").attr("data-id", $(this).data("id"));
        $('#confirmDeleteModal').modal('show');
    });

    // Submit delete brand
    $("#deleteSubmitBtn").on('click' , function() {
        $.ajax({
            url : "/brand/api/delete/" + $(this).attr("data-id"),
            type : 'DELETE',
            dataType : 'json',
            contentType : 'application/json',
            success : function(data) {
                $('#confirmDeleteModal').modal('hide').html(data);
            }
        });
    });

});