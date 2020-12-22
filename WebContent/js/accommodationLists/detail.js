window.addEventListener("load",function(){
    // 날짜
    var checkinDate = document.querySelector('.checkin-date');
    var checkoutDate = document.querySelector('.checkout-date');
    var submitBtn = document.querySelector('.submit-btn');

    submitBtn.onclick = function(e) {
        if (checkinDate.value == '' || checkoutDate.value == '') {
            alert('예약하실 날짜를 정확하게 입력해 주세요.');
            e.preventDefault();
        }
        
        if (checkinDate.value >= checkoutDate.value) {
            alert('체크아웃 날짜가 체크인 날짜보다 같거나 빠를 수 없습니다.\n다시 확인해 주세요.');
            e.preventDefault();
        }
    }
    
    checkinDate.value = getFormatDate(new Date());

    

    // 날짜를 'yyyy-mm-dd' 형태로 변환하는 함수(커스터마이징 가능)
    function getFormatDate(date) {
        var year = date.getFullYear();              // yyyy
        var month = 1 + date.getMonth();            // M
        month = month >= 10 ? month : '0' + month;  // month 두자리로 저장
        var day = date.getDate();                   // d
        day = day >= 10 ? day : '0' + day;          // day 두자리로 저장
        return year + '-' + month + '-' + day;      // 'yyyy-mm-dd' 형태로 리턴
    };


	var zzim = document.querySelector(".zzim");
	zzim.addEventListener("click",function(e){
		e.preventDefault();
		var userId = e.target.nextElementSibling;
		var accId = userId.nextElementSibling;
		var xhr = new XMLHttpRequest();
		xhr.open('post','./detail');
		xhr.onreadystatechange=function(){
			if(xhr.readyState === 4 && xhr.status === 200){
				var result = xhr.response;
				if(JSON.parse(result).result != 0){
					if(e.target.classList.contains("unzzimed")){
						e.target.classList.remove("unzzimed");
						e.target.classList.add("zzimed");
					}
					else{
						e.target.classList.remove("zzimed");
						e.target.classList.add("unzzimed");
					}
				}
					
			}
		}
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		var data='';
		data += 'userId='+userId.value;
		data += '&accId='+accId.value;
		if(e.target.classList.contains("unzzimed")){
			data += '&status=0';
		}
		else{
			data += '&status=1';
		}
		xhr.send(data);
	});
	
});