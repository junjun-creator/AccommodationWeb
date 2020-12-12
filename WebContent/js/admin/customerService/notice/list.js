window.addEventListener('load', function() {
	var subCon = document.querySelector(".sub-container");
	var selectAll = subCon.querySelector(".selectAllDelete");
	var delChk = document.querySelectorAll(".deleteChk");
	var openAll = subCon.querySelector(".selectAllPubs");
	var publChk = document.querySelectorAll(".pubChk");
	
		selectAll.onclick = function(){
			for (var i = 0; i < delChk.length; i++) {
              delChk[i].checked = selectAll.checked;
            };
		};
         
        
        for(var i=0; i<delChk.length ; i++){
	        delChk[i].addEventListener('click', function(){
	            for (var j = 0; j < delChk.length; j++) {
		              if (delChk[j].checked === false) {
		                selectAll.checked = false;
		                return;
		              };
		            };
	            selectAll.checked = true;                                   
	        }, false);
        }; 

		openAll.onclick = function(){
			for (var i = 0; i < publChk.length; i++) {
              publChk[i].checked = openAll.checked;
            };
		};
         
        
        for(var i=0; i<publChk.length ; i++){
	        publChk[i].addEventListener('click', function(){
	            for (var j = 0; j < publChk.length; j++) {
		              if (publChk[j].checked === false) {
		                openAll.checked = false;
		                return;
		              };
		            };
	            openAll.checked = true;                                   
	        }, false);
        }; 
});
