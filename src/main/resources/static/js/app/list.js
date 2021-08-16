var main = {
    init: function () {
        var _this = this;
        $('#list-search').on('click', function () {
            _this.search();
        });
    }, search: function () {
        var ccd = $('.ccd').val();

        $.ajax({
            type: 'GET',
            url: '/api/v1/board/'+ccd,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 검색되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
}