$(document).ready(function () {
    var body = $('body');
    body.on('click','.jsCalc',function() {
        cleanResult();
        calculate();
    });
    body.on('click','.jsCalcClean',function() {
        cleanResult();
    });
});
function calculate() {
    var city = getCityObject();

    $.ajax({
        type: 'POST',
        url: window.location.origin + '/rest/calc/',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(city),
        async: true,
        dataType: 'json',
        success: function (s) {
            console.log(s);
            getPath(s);
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
function getPath(minDistance){
    $.ajax({
        type: 'GET',
        url: window.location.origin + '/rest/path/',
        contentType: 'application/json; charset=utf-8',
        async: true,
        dataType: 'json',
        success: function (s) {
            displayResult(s, minDistance);
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
    $('.resultContainer').addClass('show').removeClass('hidden');
}

function cleanResult() {
    $('p').remove();
    $('.jsCalcClean').remove();
    $('.resultContainer').addClass('hidden').removeClass('show');
}



