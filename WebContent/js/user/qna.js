window.addEventListener("load", function(){
    var qna = document.querySelector(".qna-sec");
    var changeTab = qna.querySelector(".change-list");
	var myQnA = qna.querySelector(".myQnA");
	var section = qna.querySelector(".section");
	var qnaCreat = qna.querySelector(".qna-creat");
	var qnaList = qna.querySelector(".qna-list");
	var qnaSecList = qna.querySelector(".qna-sec-list");
	
	changeTab.addEventListener("click",function(e){
		e.preventDefault();
		
		if(e.target.innerHTML=="내 문의"){
			var li =e.target.parentElement;
			li.classList.add("current-tab");
			qnaCreat.style.display = "none";
		    qnaList.style.display = "block";
			li.nextElementSibling.classList.remove("current-tab");
		return;
		}
		if(e.target.innerHTML=="문의하기"){
			var li =e.target.parentElement;
			li.classList.add("current-tab");
			qnaList.style.display = "none";
			qnaCreat.style.display = "block";
			li.previousElementSibling.classList.remove("current-tab");
			return;
		}
		
	});
    
	function creat(){

		var request =new XMLHttpRequest();

		request.onload = function(){
			qnaCreat.innerHTML="";
		var tr ='<h1 class="d-none">문의 작성</h1>\
			<form action="">\
			<select name="category" id="" class="category">\
				<option value="" selected disabled>문의 유형을 선택해 주세요</option>\
				<option value="이벤트">이벤트</option>\
				<option value="예약/결제">예약/결제</option>\
				<option value="취소/환불">취소/환불</option>\
				<option value="서비스 이용">서비스 이용</option>\
				<option value="회원/개인정보">회원/개인정보</option>\
				<option value="리뷰">리뷰</option>\
				<option value="기타">기타</option>\
			</select>\
			<textarea name="" cols="50" rows="10" placeholder="문의할 내용을 적어주세요." required autofocus></textarea>\
			<input type="submit" value="보내기" >\
		</form>';
			qnaCreat.insertAdjacentHTML('beforeend', tr);
		}
		request.open("GET","",true)
        request.send();
	}


	function list(){
		var request = new XMLHttpRequest();
       
        request.onload = function(){ 
		  
				
				qnaSecList.innerHTML="";
				
				var qna = JSON.parse(request.responseText);
				
				for(var i=0;i<qna.length;i++){
					var tr = '<li>\
						 <input type="checkbox" id="'+qna[i].id+'" class="checkbox" name="check" onclick="doOpenCheck(this);">\
							<div>\
								<p>'+qna[i].title+'</p>\
								<p class="p-detail">'+qna[i].answerContent+'</p>\
								<p>'+qna[i].answerRegdate+'</p>\
							</div>\
							<p>Master</p>\
							<label for="'+qna[i].id+'"><span></span></label>\
						</li>';
					qnaSecList.insertAdjacentHTML('beforeend', tr);
				}
            	
        };
        request.open("GET","/api/user/QnA",true)
        request.send();
        
	}
});