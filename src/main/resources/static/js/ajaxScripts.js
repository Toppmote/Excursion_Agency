$(document).ready(function () {

    //Форма добавления города
    let $cityForm = $("#cityForm");

    //Отправка формы добавления города
    $cityForm.on('submit', function (e) {
        e.preventDefault();
        let formData = new FormData(this);
        let photo = $("#photo");
        formData.append("photo", photo.prop('files')[0])
        $.ajax({
            type: 'POST',
            url: $cityForm.attr('action'),
            enctype: "multipart/form-data",
            data: formData,
            processData: false,
            contentType: false,
        }).done(function (response) {
            $("#modalAddCity").hide();
            showNewCity(response);
        });
    });

    //Удалить город
    $(document).on('click', '.btn-city-delete', function () {
        let id = $(this).attr("id");
        $.ajax({
            type: 'GET',
            url: "/delete_city_from_page/" + id
        }).done(function () {
            $("#city_" + id).remove();
        });
    });

    //Отобразить город
    function showNewCity(city) {
        let $newCard = $('<div class="col city_card">' +
            '<div class="card shadow-sm">' +
            '<img src="" alt="Город" class="img-fluid">' +
            '<div class="card-body">' +
            '<p class="card-text"></p>' +
            '<div class="d-flex justify-content-between align-items-center">' +
            '<a href="">' +
            '<div class="btn-group">\n' +
            '<button type="button" class="btn btn-sm btn-outline-info">Подробнее</button>\n' +
            '</div>' +
            '</a>' +
            '<div class="btn-group">' +
            '<button type="button" class="btn-city-delete btn btn-sm btn-outline-danger" id="">Удалить</button>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>'
        )
        $("img", $newCard).attr('src', city.photo);
        $("p", $newCard).text(city.name);
        $("a", $newCard).attr('href', "cities/" + city.id);
        $(".btn-city-delete", $newCard).attr('id', city.id);
        $($newCard).attr('id', "city_" + city.id);
        $('#add-card').before($newCard);
    }

});
