window.addEventListener("load",function(){
	var acc_type = document.querySelectorAll(".acc-type");
	
	for(var i=0;i<acc_type.length;i++){
		(function(m){
			switch(acc_type[m].innerText){
				case "1":
					acc_type[m].innerText = "호텔";
					break;
				case "2":
					acc_type[m].innerText = "모텔";
					break;
				case "3":
					acc_type[m].innerText = "게스트하우스";
					break;
				case "4":
					acc_type[m].innerText = "리조트";
					break;
				case "5":
					acc_type[m].innerText = "펜션";
					break;
			}
		})(i);
	}
	
	
});