$(document).ready(function () {

    searchAjax();

    function searchAjax() {
        var data = {};
        data["query"] = 'Hello world';

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "localhost/cities/addTest",
            data: JSON.stringify(data),
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);
                display(data);
            },
            error: function (e) {
                console.log("ERROR: ", e);
                display(e);
            },
            done: function (e) {
                console.log("DONE: ", e);
            }
        });
    }
});