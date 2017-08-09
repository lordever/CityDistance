$(document).ready(function () {
    $('.jsSaveBtn').click(function () {
        fillFields('addition');
    });
    $('.jsEditBtn').click(function () {
        fillFields('edit');
    });
});

function fillFields(marker) {
    var formValid = isValid();
    if (formValid) {
        var toPass = {};
        toPass["id"] = $('#jsCityId').val();
        toPass["cityA"] = $('#jsCityA').val();
        toPass["cityB"] = $('#jsCityB').val();
        toPass["distance"] = $('#jsDistance').val();
        if (marker === 'addition')
            sendData(toPass, marker);
        if (marker === 'edit')
            sendData(toPass, marker);
    }
}

function isValid() {

    var inputs = $('input:gt(1)');
    var isValid = true;
    var size = inputs.length;
    inputs.each(function (index) {
        var formGroup = $(this).parent();
        if ($(this).val() !== '') {
            formGroup.addClass('has-success').removeClass('has-error');
        } else {
            formGroup.addClass('has-error').removeClass('has-success');
            isValid = false;
        }
        if(index === size -1 && $(this).val() === '0'){
            formGroup.addClass('has-error').removeClass('has-success');
        }
    });
    return isValid;
}

function sendData(toPass, marker) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: window.location.origin + '/rest/post',
        data: JSON.stringify(toPass),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log('SUCCESS: ', data);
            display(data, marker);
        },
        error: function (e) {
            console.log('ERROR: ', e);
            display(e, 'error');
        },
        done: function (d) {
            console.log("DONE: ", d);
            display(d, marker);
        }
    });
}

function display(data, marker) {
    var table = $('#jsTable');
    if (marker === 'edit' || table.length === 0)
        redirectToCities();
    if (marker === 'addition' || marker === 'error') {
        var json = "<h4>Ajax Response</h4><pre>"
            + JSON.stringify(data, null, 4) + "</pre>";
        $('#feedback').html(json);
        table.load(window.location.href + " #jsTable");
    }
}

function redirectToCities(){
    location.href = '/cities';
    location.hash = '/cities';
}
