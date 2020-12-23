window.addEventListener("load",function(){
			var regExp_list = [
                        /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/,
                        /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/
                        ];
        var checkbox = document.querySelectorAll('.checkbox');
        var button_submit = document.querySelector('.button-submit').firstElementChild;
        var inputAll = document.querySelectorAll('.check-validation');
        
        var reg_form_container = document.querySelector(".reg-form-container");

        reg_form_container.addEventListener("change",function(e){
            
            var input_box = e.target.parentNode.parentNode;
            var regExp;
            switch(e.target.id){
                case "password":
                    regExp =  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
                    break;
                case "phone":
                    regExp =  /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
                    break;
            }

            var password_input = e.currentTarget.children[1].lastElementChild.firstElementChild.firstElementChild;
            var password_check_input = e.currentTarget.children[2].lastElementChild.firstElementChild.firstElementChild;
            if(e.target.id != "password-check"){

                if(regExp.test(e.target.value)){
                    e.target.classList.add('pass');
                    input_box.classList.remove('discorrect');
                }else{
                    if(e.target.classList.contains('pass'))
                        e.target.classList.remove('pass');
                        input_box.classList.add('discorrect');
                }
            }
            else{
                if(password_input.value == password_check_input.value){
                    password_check_input.classList.add('pass');
                    password_check_input.parentNode.parentNode.classList.remove('discorrect');
                }else{
                    if(password_check_input.classList.contains('pass'))
                        password_check_input.classList.remove('pass');
                        password_check_input.parentNode.parentNode.classList.add('discorrect');
                }
            }

            if(regExp_list[1].test(inputAll[1].value) ||
            password_input.value == password_check_input.value){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }
        });

        reg_form_container.addEventListener("keyup",function(e){
            var input_box = e.target.parentNode.parentNode;
            var regExp;
            var regExp;
            switch(e.target.id){
                case "password":
                    regExp =  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
                    break;
                case "phone":
                    regExp =  /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
                    break;
            }

            var password_input = e.currentTarget.children[1].lastElementChild.firstElementChild.firstElementChild;
            var password_check_input = e.currentTarget.children[2].lastElementChild.firstElementChild.firstElementChild;
            if(e.target.id != "password-check"){

                if(regExp.test(e.target.value)){
                    e.target.classList.add('pass');
                    input_box.classList.remove('discorrect');
                }else{
                    if(e.target.classList.contains('pass'))
                        e.target.classList.remove('pass');
                        input_box.classList.add('discorrect');
                }
            }
            else{
                if(password_input.value == password_check_input.value){
                    password_check_input.classList.add('pass');
                    password_check_input.parentNode.parentNode.classList.remove('discorrect');
                }else{
                    if(password_check_input.classList.contains('pass'))
                        password_check_input.classList.remove('pass');
                        password_check_input.parentNode.parentNode.classList.add('discorrect');
                }
            }

            if(regExp_list[1].test(inputAll[1].value) ||
            password_input.value == password_check_input.value){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }
        });

	var button_submit = document.querySelector(".button-submit").firstElementChild;
	button_submit.addEventListener("click",function(e){
		if (!confirm('정말 수정하시겠습니까?')){
			e.preventDefault();
			return false;
		}
	});

});