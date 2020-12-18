window.addEventListener("load",function(){
	var picked_item_sec = document.querySelector(".picked-item-sec");
	
	picked_item_sec.addEventListener("click",function(e){
		console.log(e.target.tagName);
		if(e.target.tagName == 'BUTTON'){
			e.stopPropagation();
			if((confirm("정말로 삭제하시겠습니까?")) == true){
				
				var accId = e.target.nextElementSibling.value;
				var userId =e.target.nextElementSibling.nextElementSibling.value;
				var xhr = new XMLHttpRequest();
				xhr.open('post','./pickList');
				xhr.onreadystatechange=function(){
					if(xhr.readyState === 4 && xhr.status === 200){
						var result = xhr.response;
						if(JSON.parse(result).result == 0)
							alert('삭제실패');
						else{
							alert('삭제 되었습니다.');
							e.target.parentNode.parentNode.remove();
						}
					}
				}
				xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				var data='';
				data += 'accId='+accId;
				data += '&userId='+userId;
				xhr.send(data);
			}
		}
	})
});