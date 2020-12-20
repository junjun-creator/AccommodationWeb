window.addEventListener("load",function(){
	var btn_more = document.querySelector(".btn-more");
	var reservation_count = document.querySelector(".reservation-count");
	
	if(reservation_count.value <= 4)
		btn_more.style.display='none';
	
	btn_more.addEventListener("click",function(e){
		e.preventDefault();
		
		var page = document.querySelector(".page").value;
		
		var xhr = new XMLHttpRequest();
		xhr.open('post','./reservationInfo');
		xhr.onreadystatechange=function(){
			if(xhr.readyState === 4 && xhr.status === 200){
				var html = document.querySelector("#more-template").innerHTML;
				var result = xhr.response;
				var jsonResult = JSON.parse(result);
				var reservation_list_container = document.querySelector(".reservation-list-container");
				
				for(var i=0;i<jsonResult.length-1;i++){
					var resultHTML = '';
					resultHTML = html.replace("{accName}",jsonResult[i].accName)
									.replace("{fileName}",jsonResult[i].fileName)
									.replace("{checkinDate}",jsonResult[i].checkinDate)
									.replace("{checkoutDate}",jsonResult[i].checkoutDate)
									.replace("{accId}",jsonResult[i].accId)
									.replace("{id}",jsonResult[i].id);
									
					reservation_list_container.insertAdjacentHTML('beforeend',resultHTML);
				}//아이템 추가 완료
				var pageNum = document.querySelector(".page");
				pageNum.value= (page)*1+1;
				if(jsonResult[jsonResult.length-1].reservationCount <= page*4)
					btn_more.style.display = 'none';
				
				/* 불러온 결과를 insertajacent로 삽입 해주고, 다음 페이지 번호값을 변경해서 input에 저장해주고
					전체 갯수를 input hidden으로 받아와서 전체갯수와 현재 페이지*3을 비교해서 전체갯수가 더 적으면 더보기 버튼비활성화*/ 
			}
		}
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		var data='';
		data += 'page='+page;
		xhr.send(data);
	});
	
	var container = document.querySelector(".reservation-list-container");
	
	container.addEventListener("click",function(e){
		e.stopPropagation();
		var li;
		
		if(e.target.className == 're-reserve-btn'){
			
			console.log(e.target.nextElementSibling.value);
			window.location.href="./accDetail?id="+e.target.nextElementSibling.value;
			return;
		}
		
		if(e.target.tagName == 'LI')
			li = e.target;
		else{
			li = e.target;
			while(li.tagName != 'LI'){
				li = li.parentNode;
			}
		}
		
		window.location.href="./reservationDetail?id="+li.nextElementSibling.value;
	});
	/*
	for(var item of reservationItem){
		item.addEventListener("click",function(e){
			e.stopPropagation();
			//var reservationId = e.currentTarget.nextElementSibling.value;
			//console.log(reservationId);
		});
	}
	
	var re_reserve_btn = document.querySelectorAll(".re-reserve-btn");
	
	for(var re of re_reserve_btn){
		re.addEventListener("click",function(e){
			e.stopPropagation();
			
			console.log("다시예약 선택");
		});
	}*/
});