$(document).ready(function () {
    getMyClubList();
});

function getMyClubList() {
    $.ajax({
        type: 'GET',
        url: '/myclub',
        dataType: 'json',
        success: function (result) {
            // 가입한 모임 목록을 표시하는 함수 호출
            displayClubList(result.DTOList);
        },
        error: function (xhr, status, error) {
            alert(error);
        }
    });
}

function displayClubList(clubList) {
    var html = '';
    for (var i = 0; i < clubList.length; i++) {
        var club = clubList[i];
        html += '<div>';
        html += '<h3>' + club.clubName + '</h3>';
        html += '<p>' + club.clubDescription + '</p>';
        html += '</div>';
    }
    $('#clubList').html(html);
}