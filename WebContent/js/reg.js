var regExp_list = [/^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i,
                /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/,
                /^[가-힣]+$/,
                /^[0-9]{8}$/,
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
        case "email":
            regExp =  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i;
            
            break;
        case "password":
            regExp =  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
            break;
        case "password-check":
            break;
        case "name":
            regExp = /^[가-힣]+$/;
            break;
        case "phone":
            regExp =  /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
            break;
        case "birthday":
            regExp =  /^[0-9]{8}$/;
            break;
    }

    var password_input = e.currentTarget.children[1].lastElementChild.firstElementChild.firstElementChild;
    var password_check_input = e.currentTarget.children[2].lastElementChild.firstElementChild.firstElementChild;
    if(e.target.id != "password-check" && e.target.id != "checkbox-3" && e.target.id != "checkbox-2"){

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

    var count_validation = 0;
    for(var i=0;i<inputAll.length;i++){
        if(regExp_list[i].test(inputAll[i].value)){
            count_validation++;
        }
    }

    if(count_validation == 5 &&
    password_input.value == password_check_input.value &&
    (checkbox[0].checked || checkbox[1].checked)
	&& email_check.classList.contains("no-duplication")){
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
    switch(e.target.id){
        case "email":
            regExp =  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i;
            email_check.classList.remove("no-duplication");
            break;
        case "password":
            regExp =  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
            break;
        case "password-check":
            break;
        case "name":
            regExp = /^[가-힣]+$/;
            break;
        case "phone":
            regExp =  /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
            break;
        case "birthday":
            regExp =  /^[0-9]{8}$/;
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

    var count_validation = 0;
    for(var i=0;i<inputAll.length;i++){
        if(regExp_list[i].test(inputAll[i].value)){
            count_validation++;
        }
    }

    if(count_validation == 5 &&
    password_input.value == password_check_input.value &&
    (checkbox[0].checked || checkbox[1].checked)
	&& email_check.classList.contains("no-duplication")){
        button_submit.classList.remove('disabled');
        button_submit.disabled = false;
    }
    else{
        button_submit.classList.add('disabled');
        button_submit.disabled = true;
    }
});

for(var j=0;j<checkbox.length;j++){
    (function(m){
        checkbox[m].addEventListener("click",function(){
            var count_validation = 0;
            for(var i=0;i<inputAll.length;i++){
                if(regExp_list[i].test(inputAll[i].value)){
                    count_validation++;
                }
            }

			var password_i = document.querySelector(".password").value;
			var password_c = document.querySelector(".password-check").value;
            if(count_validation == 5 &&
            password_i== password_c &&
            (checkbox[0].checked || checkbox[1].checked)
			&& email_check.classList.contains("no-duplication")){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }
        });
    })(j);
}

var email_check = document.querySelector(".email-check");
email_check.addEventListener("click",function(e){
	e.preventDefault();
	var email = document.querySelector(".email").value;
	if(email == null || email == ''){
		alert('이메일을 입력해주세요.');
	}
	else{
		
		var xhr = new XMLHttpRequest();
		xhr.open('post','./checkId');
		xhr.onreadystatechange=function(){
			if(xhr.readyState === 4 && xhr.status === 200){
				var duplicate = xhr.response;
				if(JSON.parse(duplicate).duplicate == 1)
					alert('중복된 아이디 입니다. 다른아이디를 입력해주세요.');
				else{
					email_check.classList.add("no-duplication");
					
					var count_validation = 0;
				    for(var i=0;i<inputAll.length;i++){
				        if(regExp_list[i].test(inputAll[i].value)){
				            count_validation++;
				        }
				    }
					var password_i = document.querySelector(".password").value;
					var password_c = document.querySelector(".password-check").value;
				    if(count_validation == 5 &&
				    password_i == password_c &&
				    (checkbox[0].checked || checkbox[1].checked)){
				        button_submit.classList.remove('disabled');
				        button_submit.disabled = false;
				    }
				    else{
				        button_submit.classList.add('disabled');
				        button_submit.disabled = true;
				    }
				}
			}
		}
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		var data='';
		var email = document.querySelector(".email").value;
		data += 'email='+email;
		xhr.send(data);
	}
});