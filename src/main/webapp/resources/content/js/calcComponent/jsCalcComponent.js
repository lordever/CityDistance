$(document).ready(function () {
    getCitiesForCalc();
    var body = $('body');
    body.on('click','.jsCalc',function() {
        cleanResult();
        calculate();
    });
    body.on('click','.jsCalcClean',function() {
        cleanResult();
    });
});

function getCitiesForCalc() {
    $.ajax({
        type: 'GET',
        url: window.location.origin + '/rest/getCitiesForCalc/',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        async: true,
        success: function (s) {
            fillTableForCalc(s);
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

function fillTableForCalc(items) {
    var tableTemplate = '';
    var citiesTable = $('.jsCitiesTableCalc');
    items.forEach(function (item) {
        tableTemplate += '<tr class="jsTableContentCalc">\n' +
            '  <td>'+item.cityA+'</td>\n' +
            '  <td>'+item.cityB+'</td>\n' +
            '  <td>'+item.distance+'</td>\n' +
            '</tr>\n';
    });
    if (citiesTable.length === 0)
        citiesTable.append(tableTemplate);
    else {
        $('.jsTableContentCalc').remove();
        citiesTable.append(tableTemplate);
    }
}

function calculate() {
    var city = getCityObject();

    $.ajax({
        type: 'POST',
        url: window.location.origin + '/rest/calc/',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(city),
        async: true,
        dataType: 'json',
        success: function (result) {
            displayResult(result.path, result.minDistance);
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
function getCityObject() {
    var city = {};

    city['id'] = 0;
    city['cityA'] = $('.jsCityFrom').val();
    city['cityB'] = $('.jsCityTo').val();
    city['distance'] = 0;

    return city;
}

function displayResult(path, minDistance){
    var pathText = '';
    var resultBotron = $('.resultBotron');
    path.forEach(function(item, index){
        pathText += item.name;
        if(index !== path.length -1){
            pathText += ' > ';
        }
    });
    resultBotron.append('<p>Minimal Path: '+pathText+'</p>');
    resultBotron.append('<p>Minimal Distance: '+minDistance+'</p>');
    resultBotron.append('<button class="btn btn-primary jsCalcClean" type="button">Clean</button>');
    $('.resultContainer').removeClass('sr-only');
}

function cleanResult() {
    $('p').remove();
    $('.jsCalcClean').remove();
    $('.resultContainer').addClass('sr-only');
}



