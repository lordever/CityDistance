$(document).ready(function () {
    $('.jsEditBtn').click(function () {
        editCity();
    });
});

function editCity() {
    var formValid = isValid();
    if (formValid) {
        var toAddition = {};
        toAddition["cityA"] = $('#jsCityA').val();
        toAddition["cityB"] = $('#jsCityB').val();
        toAddition["distance"] = $('#jsDistance').val();
        sendData(toAddition);
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

function sendData(toAddition) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: window.location.href + "/rest/edit",
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
