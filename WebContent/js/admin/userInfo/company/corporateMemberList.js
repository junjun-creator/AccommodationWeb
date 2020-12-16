window.addEventListener("load",function(){
	
	var page = document.querySelector(".page");
	var page_list = document.querySelector(".pager-list").children;
	
	if(page.value == "" || page.value == 1){
		page_list[0].classList.add("active-page");
	}
	else{
		page_list[page.value-1].classList.add("active-page");
	}
});