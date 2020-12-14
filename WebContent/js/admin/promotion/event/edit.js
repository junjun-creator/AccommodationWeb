window.addEventListener('load', function() {
    // 날짜
    var startDate = document.querySelector('.start-date');
    startDate.value = getFormatDate(new Date());

    // 날짜를 'yyyy-mm-dd' 형태로 변환하는 함수(커스터마이징 가능)
    function getFormatDate(date) {
        var year = date.getFullYear();              // yyyy
        var month = 1 + date.getMonth();            // M
        month = month >= 10 ? month : '0' + month;  // month 두자리로 저장
        var day = date.getDate();                   // d
        day = day >= 10 ? day : '0' + day;          // day 두자리로 저장
        return year + '-' + month + '-' + day;      // 'yyyy-mm-dd' 형태로 리턴
    };
});