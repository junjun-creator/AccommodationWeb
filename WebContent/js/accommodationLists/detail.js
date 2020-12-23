window.addEventListener("load",function(){
    // 날짜
   
	var submitBtn = document.querySelector('.submit-btn');
	var rvBtn = document.querySelector('.rv-btn');

    submitBtn.addEventListener('click', function(e) {
		if (checkinDate.value == '' || checkoutDate.value == '') {
            alert('예약하실 날짜를 먼저 입력해 주세요.');
            e.preventDefault();
        }
	});

	rvBtn.addEventListener('click', function(e) {
		var checkinDate = document.querySelector('.checkin-date');
		var checkoutDate = document.querySelector('.checkout-date');
		if (checkinDate.value != '' && checkoutDate.value != '') {
			var accId = e.target.nextElementSibling.value;
			var roomId = e.target.nextElementSibling.nextElementSibling.value;
			var checkinDate = e.target.nextElementSibling.nextElementSibling.nextElementSibling.value;
			var checkoutDate = e.target.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.value;
			
			location.href=`/user/reservation/pay?
				accId=${accId}&roomId=${roomId}&checkinDate=${checkinDate}&checkoutDate=${checkoutDate}`;
		} else {
			alert('예약하실 날짜를 먼저 설정해 주세요.');
			e.preventDefault();
		}

		
	});


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