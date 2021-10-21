
// Запрос для полусения курса и гиф
function getRatesAndGif() {
       $.ajax({
        url: './getCur',
        method: 'GET',
        dataType: "json",
        complete: function (data) {
            let content = JSON.parse(data.responseText).data.image_url;
            let compared = JSON.parse(data.responseText).comparedRates;
            document.getElementById("giphyme").innerHTML = '<center><img src = "'+content+'"  title="'+compared+'"></center>';
        }
    })
}