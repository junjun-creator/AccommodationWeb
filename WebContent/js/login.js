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
			var xhr = new XMLHttpRequest();
			xhr.open('post','./login');
			xhr.onreadystatechange=function(){
				if(xhr.readyState === 4 && xhr.status === 200){
					var valid = xhr.response;
					console.log(JSON.parse(valid).valid);
					if(JSON.parse(valid).valid == 0)
						alert('아이디 또는 비밀번호가 정확하지 않습니다.');
					else
						window.location.href="http://localhost:8080/index";
				}
			}
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			var data='';
			var email = document.querySelector(".email").value;
			var password = document.querySelector(".password").value;
			data += 'email='+email;
			data += '&password='+password;
			//unsent 0
			xhr.send(data);
			// 1
			//2
			//3
			//4
		});

});