window.addEventListener("load",function(){
		var regExp_list = [/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i,
                    /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/
                        ];
        var checkbox = document.querySelectorAll('.checkbox');
        var button_submit = document.querySelector('.button-submit').firstElementChild;
        var inputAll = document.querySelectorAll('.check-validation');
        
        var reg_form_container = document.querySelector(".reg-form-container");

        reg_form_container.addEventListener("change",function(e){
            
            var input_box = e.target.parentNode.parentNode;
            var regExp;
            switch(e.target.id){
                case "email":
                    regExp =  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i;
                    
                    break;
                case "password":
                    regExp =  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
                    break;
            }

            var count_validation = 0;
            for(var i=0;i<inputAll.length;i++){
                if(regExp_list[i].test(inputAll[i].value)){
                    count_validation++;
                }
            }

            if(count_validation == 2){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }

			if(regExp.test(e.target.value)){
                e.target.classList.add('pass');
                input_box.classList.remove('discorrect');
            }else{
                if(e.target.classList.contains('pass'))
                    e.target.classList.remove('pass');
                    input_box.classList.add('discorrect');
            }
        });

        reg_form_container.addEventListener("keyup",function(e){
            var input_box = e.target.parentNode.parentNode;
            var regExp;
            switch(e.target.id){
                case "email":
                    regExp =  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i;
                    
                    break;
                case "password":
                    regExp =  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
                    break;
            }

            var count_validation = 0;
            for(var i=0;i<inputAll.length;i++){
                if(regExp_list[i].test(inputAll[i].value)){
                    count_validation++;
                }
            }

            if(count_validation == 2){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }

			if(regExp.test(e.target.value)){
                e.target.classList.add('pass');
                input_box.classList.remove('discorrect');
            }else{
                if(e.target.classList.contains('pass'))
                    e.target.classList.remove('pass');
                    input_box.classList.add('discorrect');
            }
        });

		//로그인 ajax 유효성검사
		
		var login_button = document.querySelector(".button-submit").firstElementChild;
		
		login_button.addEventListener("click",function(){
			var returnURL = login_button.nextElementSibling.value;
			var xhr = new XMLHttpRequest();
			xhr.open('post','./signin');
			xhr.onreadystatechange=function(){
				if(xhr.readyState === 4 && xhr.status === 200){
					var valid = xhr.response;
					if(JSON.parse(valid).valid == 0){
						alert('아이디 또는 비밀번호가 정확하지 않습니다.');
					}
					else{
						if(JSON.parse(valid).returnURL != null && JSON.parse(valid).returnURL != "")
							window.location.href="http://localhost:8080"+JSON.parse(valid).returnURL;
						else
							window.location.href="http://localhost:8080/index";
					}
				}
			}
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			var data='';
			var email = document.querySelector(".email").value;
			var password = document.querySelector(".password").value;
			data += 'email='+email;
			data += '&password='+password;
			
			if(returnURL.indexOf("updateInfo"))
				returnURL = returnURL.replace("updateInfo","memberInfo");
			data += '&return-url='+returnURL;
			xhr.send(data);
		});
		
		var forget = document.querySelector(".forget");
		forget.addEventListener("click",function(){
			var search = window.open("http://localhost:8080/search",'아이디/비밀번호 찾기','width=500px,height=500px');
			search.addEventListener("load",function(){
				var category = search.document.querySelector(".category");
				
				category.addEventListener("click",function(e){
					e.stopPropagation();
					var beforePick = search.document.querySelector(".pick");
					beforePick.classList.remove("pick");
					e.target.classList.add("pick");
					var forms = search.document.querySelectorAll(".search-form");
					if(forms[0].classList.contains("choose")){
						forms[0].classList.remove("choose");
						forms[1].classList.add("choose");
					}
					else{
						forms[1].classList.remove("choose");
						forms[0].classList.add("choose");
					}
					
				});
				
				var button = search.document.querySelector(".search-main");
				button.addEventListener("click",function(e){
					if(e.target.classList.contains("e")){
						e.stopPropagation();
						var name = e.target.parentNode.firstElementChild.lastElementChild.firstElementChild.firstElementChild.value;
						var phone = e.target.previousElementSibling.lastElementChild.firstElementChild.firstElementChild.value;
						
						var xhr = new XMLHttpRequest();
						xhr.open('post','./search');
						xhr.onreadystatechange=function(){
							if(xhr.readyState === 4 && xhr.status === 200){
								var result = JSON.parse(xhr.response);
								if(result.result == 0)
									alert("요청하신 정보로 등록된 이메일이 존재하지 않습니다.");
								else
									alert("확인된 이메일 : "+result.userEmail);
							}
						}
						xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
						var data='';
						data += 'name='+name;
						data += '&phone='+phone;
						data += '&category=0';
						
						xhr.send(data);
					}
					else if(e.target.classList.contains("p")){
						e.stopPropagation();
						var name = e.target.parentNode.firstElementChild.lastElementChild.firstElementChild.firstElementChild.value;
						var phone = e.target.previousElementSibling.lastElementChild.firstElementChild.firstElementChild.value;
						var email = e.target.previousElementSibling.previousElementSibling.lastElementChild.firstElementChild.firstElementChild.value;
						
						var xhr = new XMLHttpRequest();
						xhr.open('post','./search');
						xhr.onreadystatechange=function(){
							if(xhr.readyState === 4 && xhr.status === 200){
								var result = JSON.parse(xhr.response);
								if(result.result == 0)
									alert("요청하신 정보로 등록된 정보가 존재하지 않습니다.");
								else
									alert("확인된 비밀번호 : "+result.password);
							}
						}
						xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
						var data='';
						data += 'name='+name;
						data += '&phone='+phone;
						data += '&email='+email;
						data += '&category=1';
						
						xhr.send(data);
					}
				});
				
			});
		});
		
		
});