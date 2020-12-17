window.addEventListener("load",function(){
		var regExp_list = [
                    /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/
                        ];
        var checkbox = document.querySelectorAll('.checkbox');
        var button_submit = document.querySelector('.button-submit').firstElementChild;
        var inputAll = document.querySelectorAll('.check-validation');
        
        var reg_form_item = document.querySelector(".reg-form-item");

        reg_form_item.addEventListener("change",function(e){
            
            var input_box = e.target.parentNode.parentNode;
            var regExp;
            switch(e.target.id){
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

            if(count_validation == 1){
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

        reg_form_item.addEventListener("keyup",function(e){
            var input_box = e.target.parentNode.parentNode;
            var regExp;
            switch(e.target.id){
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
            if(count_validation == 1){
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

		//비밀번호 확인 ajax 유효성검사
		var password_check_button = document.querySelector(".button-submit").firstElementChild;
		
		password_check_button.addEventListener("click",function(){
			var xhr = new XMLHttpRequest();
			xhr.open('post','/checkPwd');
			xhr.onreadystatechange=function(){
				if(xhr.readyState === 4 && xhr.status === 200){
					var valid = xhr.response;
					console.log(JSON.parse(valid).valid);
					if(JSON.parse(valid).valid == 0)
						alert('비밀번호가 정확하지 않습니다.');
					else
						window.location.href="/user/userInfo/updateInfo";
				}
			}
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			var data='';
			var password = document.querySelector(".password").value;
			data += 'password='+password;
			xhr.send(data);
		});
		
});