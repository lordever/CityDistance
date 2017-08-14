$(document).ready(function () {
    getCities();
    var body = $('body');
    body.on('click', '.jsSaveBtn', function () {
        addCity();
    });
    body.on('click', '.jsEditBtn', function () {
        getCityFromFields();
    });
    body.on('click', '.jsFillForEditBtn', function () {
        $('.additionBlock').addClass('hidden').removeClass('show');
        $('.editBlock').addClass('show').removeClass('hidden');
        getCity($(this).val());
    });
    body.on('click', '.toAdditionCity', function () {
        toAddition();
    });
    body.on('click', '.jsEditBtn', function () {
        editCity();
    });
    body.on('click', '.jsDeleteBtn', function () {
        deleteCity($(this).val());
    });
});

function getCities() {
    $.ajax({
        type: 'GET',
        url: window.location.origin + '/rest/getCities/',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        async: true,
        success: function (s) {
            fillTable(s);
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

function fillTable(items) {
    var tableTemplate = '';
    var citiesTable = $('.jsCitiesTable');
    items.forEach(function (item) {
        tableTemplate += '<tr class="jsTableContent">\n' +
            '   <td>'+item.id+'</td>\n' +
            '   <td>'+item.cityA+'</td>\n' +
            '   <td>'+item.cityB+'</td>\n' +
            '   <td>'+item.distance+'</td>\n' +
            '   <td>\n' +
            '       <button class="btn btn-warning jsFillForEditBtn" type="button" value="'+item.id+'">Edit</button>\n' +
            '   </td>\n' +
            '   <td>\n' +
            '       <button class="btn btn-danger jsDeleteBtn" type="button" value="'+item.id+'">Delete</button>\n' +
            '   </td>\n' +
            '</tr>';
    });
    if(citiesTable.length === 0)
        citiesTable.append(tableTemplate);
    else {
        $('.jsTableContent').remove();
        citiesTable.append(tableTemplate);
    }
}

function getCity(id) {
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
    console.log('ID Delete:'+id);
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
    getCities();
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
