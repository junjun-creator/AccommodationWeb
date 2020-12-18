window.addEventListener("load",function(){
	var picked_item_sec = document.querySelector(".picked-item-sec");
	
	deleteBtn.addEventListener("click",function(e){
		if(e.target.tagName == 'BUTTON'){
			e.stopPropagation();
			var accId = e.target.nextElementSibling.value;
			var userId =e.target.nextElementSibling.nextElementSibling.value;
			var xhr = new XMLHttpRequest();
			xhr.open('post','./pickList');
			xhr.onreadystatechange=function(){
				if(xhr.readyState === 4 && xhr.status === 200){
					var valid = xhr.response;
					console.log('성');
				}
			}
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			var data='';
			data += 'accId='+accId;
			data += '&userId='+userId;
			xhr.send(data);
		}
	})
});