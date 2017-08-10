$(document).ready(function () {
    $('.jsCalc').click(function () {
        fillFields();
    });
});

function fillFields(){
    var toPass = {};
    toPass["cityA"] = $('#jsCityA').val();
    toPass["cityB"] = $('#jsCityB').val();

    sendData(toPass);
}

function sendData(toPass){
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: 'http://localhost:8080/calc',
        data: JSON.stringify(toPass),
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
}

