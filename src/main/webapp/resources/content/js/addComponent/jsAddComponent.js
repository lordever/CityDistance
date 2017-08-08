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
        var toAddition = {};
        toAddition["cityA"] = $('#jsCityA').val();
        toAddition["cityB"] = $('#jsCityB').val();
        toAddition["distance"] = $('#jsDistance').val();
        if (marker === 'addition')
            sendData(toAddition, '/rest/add');
        if (marker === 'edit')
            sendData(toAddition, '/rest/edit');
    }
}

function isValid() {
    var isValid = true;

    $('input:gt(1)').each(function () {
        var formGroup = $(this).parent();
        if ($(this).val() !== '') {
            formGroup.addClass('has-success').removeClass('has-error');
        } else {
            formGroup.addClass('has-error').removeClass('has-success');
            isValid = false;
        }
    });

    return isValid;
}

function sendData(toAddition, url) {
    console.log(window.location.href + url);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: window.location.href + url,
        data: JSON.stringify(toAddition),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log('SUCCESS: ', data);
            display(data);
        },
        error: function (e) {
            console.log('ERROR: ', e);
            display(e);
        },
        done: function (d) {
            console.log("DONE: ", d);
            display(d);
        }
    });
}

function display(data) {
    var json = "<h4>Ajax Response</h4><pre>"
        + JSON.stringify(data, null, 4) + "</pre>";
    $('#feedback').html(json);
    $('#jsTable').load(window.location.href + " #jsTable");
}
