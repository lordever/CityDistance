$(document).ready(function () {
    var body = $('body');
    body.on('click','.jsSaveBtn',function() {
        addCity();
    });
    body.on('click','.jsEditBtn',function() {
        getCityFromFields();
    });
    body.on('click','.jsFillForEditBtn',function() {
        $('.additionBlock').addClass('hidden').removeClass('show');
        $('.editBlock').addClass('show').removeClass('hidden');
        getCity($(this).val());
    });
    body.on('click','.toAdditionCity',function() {
        toAddition();
    });
    body.on('click','.jsEditBtn',function() {
        editCity();
    });
    body.on('click','.jsDeleteBtn',function() {
        deleteCity($(this).val());
    });
});
function getCity(id){
    $.ajax({
        type: 'GET',
        url: window.location.origin + '/rest/get/' + id,
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        async: true,
        success: function (s) {
            prepareForEdit(s);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR.status + ' ' + jqXHR.responseText);
            console.log(errorThrown)
        },
        done: function (d) {
            console.log('DONE: ' + d);
        }
    });
}
function prepareForEdit(city) {
    $('.jsCityId').val(city.id);
    $('.jsCityA').val(city.cityA);
    $('.jsCityB').val(city.cityB);
    $('.jsDistance').val(city.distance);
}
function addCity() {
    var city = getCityFromFields();

    $.ajax({
        type: 'POST',
        url: window.location.origin + '/rest/add',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(city),
        dataType: 'json',
        async: true,
        success: function (s) {
            console.log('SUCCESS: ' + s.id + ' ' +
                s.cityA + ' ' +
                s.cityB + ' ' +
                s.distance);
            displayTable();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR.status + ' ' + jqXHR.responseText);
            console.log(errorThrown)
        },
        done: function (d) {
            console.log('DONE: ' + d);
        }
    });
}
function editCity() {
    var city = getCityFromFields();

    $.ajax({
        type: 'PUT',
        url: window.location.origin + '/rest/edit',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(city),
        dataType: 'json',
        async: true,
        success: function (s) {
            console.log('SUCCESS: ' + s.id + ' ' +
                s.cityA + ' ' +
                s.cityB + ' ' +
                s.distance);
            displayTable();
            toAddition();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR.status + ' ' + jqXHR.responseText);
            console.log(errorThrown)
        },
        done: function (d) {
            console.log('DONE: ' + d);
        }
    });
}

function deleteCity(id) {
    $.ajax({
        type: 'DELETE',
        url: window.location.origin + '/rest/delete/' + id,
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        async: true,
        success: function (s) {
            console.log('SUCCESS: ' + s.id + ' ' +
                s.cityA + ' ' +
                s.cityB + ' ' +
                s.distance);
            displayTable();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR.status + ' ' + jqXHR.responseText);
            console.log(errorThrown)
        },
        done: function (d) {
            console.log('DONE: ' + d);
        }
    });
}

function getCityFromFields() {
    var formValid = isValid();
    var toPass = {};
    if (formValid) {
        toPass["id"] = $('#jsCityId').val();
        toPass["cityA"] = $('#jsCityA').val();
        toPass["cityB"] = $('#jsCityB').val();
        toPass["distance"] = $('#jsDistance').val();
    }
    return toPass;
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
        if (index === size - 1 && $(this).val() === '0') {
            formGroup.addClass('has-error').removeClass('has-success');
        }
    });
    return isValid;
}

function displayTable() {
    nullifyFields();
    var table = $('#jsTable');
    if (table.length === 0)
        location.href = '/cities';
    table.load(window.location.href + " #jsTable");
}

function nullifyFields() {
    var inputs = $('input');
    inputs.each(function (index) {
        var formGroup = $(this).parent();
        if (index === 0)
            $(this).val('0');
        else {
            $(this).val('');
        }
        formGroup.removeClass('has-error').removeClass('has-success');
    });
}

function toAddition() {
    $('.additionBlock').addClass('show').removeClass('hidden');
    $('.editBlock').addClass('hidden').removeClass('show');
}
