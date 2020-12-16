window.addEventListener("load",function(){
	
	var rank = document.querySelectorAll(".user-rank");
	console.log(rank);

	var icon = document.createElement('i');
	icon.setAttribute("class","far fa-gem");
	
	for(var i=0;i<rank.length;i++){
		(function(m){
			
			switch(rank[m].innerText){
    		
			case "1":
				rank[m].style.color = "green";
				rank[m].innerHTML = "실버<i class='fas fa-gem'></i>";
				break;
			case "2":
				rank[m].style.color = "gold";
				rank[m].innerHTML = "골드<i class='fas fa-gem'></i>";
				break;
			case "3":
				rank[m].style.color = "gray";
				rank[m].innerHTML = "플래티넘<i class='fas fa-gem'></i>";
				break;
			case "4":
				rank[m].style.color = "black";
				rank[m].innerHTML = "다이아<i class='fas fa-gem'></i>";
				break;
			}
		})(i);
	}
	
});