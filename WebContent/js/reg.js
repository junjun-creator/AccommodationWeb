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
            (checkbox[0].checked || checkbox[1].checked)){
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
            (checkbox[0].checked || checkbox[1].checked)){
                button_submit.classList.remove('disabled');
                button_submit.disabled = false;
            }
            else{
                button_submit.classList.add('disabled');
                button_submit.disabled = true;
            }
        });

        // 이메일 유효성 검사
        // var email_input = document.querySelector('.email');
        // var input_box_email = email_input.parentNode.parentNode;
        // email_input.addEventListener("change", function(){
        //     var regExp =  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i;
        //     if(regExp.test(email_input.value)){
        //         email_input.classList.add('pass');
        //         input_box_email.classList.remove('discorrect');
        //     }else{
        //         if(email_input.classList.contains('pass'))
        //             email_input.classList.remove('pass');
        //             input_box_email.classList.add('discorrect');
        //     }

        //     var count_validation = 0;
        //     for(var i=0;i<inputAll.length;i++){
        //         if(regExp_list[i].test(inputAll[i].value)){
        //             count_validation++;
        //         }
        //     }
        //     if(count_validation == 5 &&
        //     password_input.value == password_check_input.value &&
        //     (checkbox[0].checked || checkbox[1].checked)){
        //         button_submit.classList.remove('disabled');
        //         button_submit.disabled = false;
        //     }
        //     else{
        //         button_submit.classList.add('disabled');
        //         button_submit.disabled = true;
        //     }
        // });

        // email_input.addEventListener("keydown",function(){
        //     var regExp =  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i;
        //     if(regExp.test(email_input.value)){
        //         email_input.classList.add('pass');
        //         input_box_email.classList.remove('discorrect');
        //     }
        //     else{
        //         if(email_input.classList.contains('pass'))
        //             email_input.classList.remove('pass');
        //             input_box_email.classList.add('discorrect');
        //     }
        // });
        // email_input.addEventListener("keyup",function(){
        //     var regExp =  /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]+$/i;
        //     if(regExp.test(email_input.value)){
        //         email_input.classList.add('pass');
        //         input_box_email.classList.remove('discorrect');
        //     }
        //     else{
        //         if(email_input.classList.contains('pass'))
        //             email_input.classList.remove('pass');
        //             input_box_email.classList.add('discorrect');
        //     }

        //     var count_validation = 0;
        //     for(var i=0;i<inputAll.length;i++){
        //         if(regExp_list[i].test(inputAll[i].value)){
        //             count_validation++;
        //         }
        //     }
        //     if(count_validation == 5 &&
        //     password_input.value == password_check_input.value &&
        //     (checkbox[0].checked || checkbox[1].checked)){
        //         button_submit.classList.remove('disabled');
        //         button_submit.disabled = false;
        //     }
        //     else{
        //         button_submit.classList.add('disabled');
        //         button_submit.disabled = true;
        //     }
        // });

        // //비밀번호 유효성 검사
        // var password_input = document.querySelector('.password');
        // var input_box_password = password_input.parentNode.parentNode;
        // password_input.addEventListener("change", function(){
        //     var regExp =  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
        //     if(regExp.test(password_input.value)){
        //         password_input.classList.add('pass');
        //         input_box_password.classList.remove('discorrect');
        //     }else{
        //         if(password_input.classList.contains('pass'))
        //             password_input.classList.remove('pass');
        //             input_box_password.classList.add('discorrect');
        //     }
            
        //     if(password_input.value == password_check_input.value){
        //         password_check_input.classList.add('pass');
        //         input_box_password_check.classList.remove('discorrect');
        //     }
        //     else{
        //         if(password_check_input.classList.contains('pass'))
        //             password_check_input.classList.remove('pass');
        //             input_box_password_check.classList.add('discorrect');
        //     }

        //     var count_validation = 0;
        //     for(var i=0;i<inputAll.length;i++){
        //         if(regExp_list[i].test(inputAll[i].value)){
        //             count_validation++;
        //         }
        //     }
        //     if(count_validation == 5 &&
        //     password_input.value == password_check_input.value &&
        //     (checkbox[0].checked || checkbox[1].checked)){
        //         button_submit.classList.remove('disabled');
        //         button_submit.disabled = false;
        //     }
        //     else{
        //         button_submit.classList.add('disabled');
        //         button_submit.disabled = true;
        //     }
        // });

        // password_input.addEventListener("keyup",function(){
        //     var regExp =  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
        //     if(regExp.test(password_input.value)){
        //         password_input.classList.add('pass');
        //         input_box_password.classList.remove('discorrect');
        //     }
        //     else{
        //         if(password_input.classList.contains('pass'))
        //             password_input.classList.remove('pass');
        //             input_box_password.classList.add('discorrect');
        //     }
            
        //     if(password_input.value == password_check_input.value){
        //         password_check_input.classList.add('pass');
        //         input_box_password_check.classList.remove('discorrect');
        //     }
        //     else{
        //         if(password_check_input.classList.contains('pass'))
        //             password_check_input.classList.remove('pass');
        //             input_box_password_check.classList.add('discorrect');
        //     }

        //     var count_validation = 0;
        //     for(var i=0;i<inputAll.length;i++){
        //         if(regExp_list[i].test(inputAll[i].value)){
        //             count_validation++;
        //         }
        //     }
        //     if(count_validation == 5 &&
        //     password_input.value == password_check_input.value &&
        //     (checkbox[0].checked || checkbox[1].checked)){
        //         button_submit.classList.remove('disabled');
        //         button_submit.disabled = false;
        //     }
        //     else{
        //         button_submit.classList.add('disabled');
        //         button_submit.disabled = true;
        //     }
        // });
        // password_input.addEventListener("keydown",function(){
        //     var regExp =  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
        //     if(regExp.test(password_input.value)){
        //         password_input.classList.add('pass');
        //         input_box_password.classList.remove('discorrect');
        //     }
        //     else{
        //         if(password_input.classList.contains('pass'))
        //             password_input.classList.remove('pass');
        //             input_box_password.classList.add('discorrect');
        //     }
            
        //     if(password_input.value == password_check_input.value){
        //         password_check_input.classList.add('pass');
        //         input_box_password_check.classList.remove('discorrect');
        //     }
        //     else{
        //         if(password_check_input.classList.contains('pass'))
        //             password_check_input.classList.remove('pass');
        //             input_box_password_check.classList.add('discorrect');
        //     }
        // });

        // //비밀번호 확인 유효성 검사
        // var password_check_input = document.querySelector('.password-check');
        // var input_box_password_check = password_check_input.parentNode.parentNode;

        // password_check_input.addEventListener("change", function(){
        //     if(password_input.value == password_check_input.value){
        //         password_check_input.classList.add('pass');
        //         input_box_password_check.classList.remove('discorrect');
        //     }else{
        //         if(password_check_input.classList.contains('pass'))
        //             password_check_input.classList.remove('pass');
        //             input_box_password_check.classList.add('discorrect');
        //     }

        //     var count_validation = 0;
        //     for(var i=0;i<inputAll.length;i++){
        //         if(regExp_list[i].test(inputAll[i].value)){
        //             count_validation++;
        //         }
        //     }
        //     if(count_validation == 5 &&
        //     password_input.value == password_check_input.value &&
        //     (checkbox[0].checked || checkbox[1].checked)){
        //         button_submit.classList.remove('disabled');
        //         button_submit.disabled = false;
        //     }
        //     else{
        //         button_submit.classList.add('disabled');
        //         button_submit.disabled = true;
        //     }
        // });

        // password_check_input.addEventListener("keyup",function(){
        //     if(password_input.value == password_check_input.value){
        //         password_check_input.classList.add('pass');
        //         input_box_password_check.classList.remove('discorrect');
        //     }
        //     else{
        //         if(password_check_input.classList.contains('pass'))
        //             password_check_input.classList.remove('pass');
        //             input_box_password_check.classList.add('discorrect');
        //     }

        //     var count_validation = 0;
        //     for(var i=0;i<inputAll.length;i++){
        //         if(regExp_list[i].test(inputAll[i].value)){
        //             count_validation++;
        //         }
        //     }
        //     if(count_validation == 5 &&
        //     password_input.value == password_check_input.value &&
        //     (checkbox[0].checked || checkbox[1].checked)){
        //         button_submit.classList.remove('disabled');
        //         button_submit.disabled = false;
        //     }
        //     else{
        //         button_submit.classList.add('disabled');
        //         button_submit.disabled = true;
        //     }
        // });
        // password_check_input.addEventListener("keydown",function(){
        //     if(password_input.value == password_check_input.value){
        //         password_check_input.classList.add('pass');
        //         input_box_password_check.classList.remove('discorrect');
        //     }
        //     else{
        //         if(password_check_input.classList.contains('pass'))
        //             password_check_input.classList.remove('pass');
        //             input_box_password_check.classList.add('discorrect');
        //     }
        // });

        // //이름 유효성 검사
        // var name_input = document.querySelector('.name');
        // var input_box_name = name_input.parentNode.parentNode;
        // name_input.addEventListener("change", function(){
        //     var regExp = /^[가-힣]+$/;
        //     if(regExp.test(name_input.value)){
        //         name_input.classList.add('pass');
        //         input_box_name.classList.remove('discorrect');
        //     }else{
        //         if(name_input.classList.contains('pass'))
        //             name_input.classList.remove('pass');
        //             input_box_name.classList.add('discorrect');
        //     }

        //     var count_validation = 0;
        //     for(var i=0;i<inputAll.length;i++){
        //         if(regExp_list[i].test(inputAll[i].value)){
        //             count_validation++;
        //         }
        //     }
        //     if(count_validation == 5 &&
        //     password_input.value == password_check_input.value &&
        //     (checkbox[0].checked || checkbox[1].checked)){
        //         button_submit.classList.remove('disabled');
        //         button_submit.disabled = false;
        //     }
        //     else{
        //         button_submit.classList.add('disabled');
        //         button_submit.disabled = true;
        //     }
        // });

        // name_input.addEventListener("keyup",function(){
        //     var regExp =  /^[가-힣]+$/;
        //     if(regExp.test(name_input.value)){
        //         name_input.classList.add('pass');
        //         input_box_name.classList.remove('discorrect');
        //     }
        //     else{
        //         if(name_input.classList.contains('pass'))
        //             name_input.classList.remove('pass');
        //             input_box_name.classList.add('discorrect');
        //     }

        //     var count_validation = 0;
        //     for(var i=0;i<inputAll.length;i++){
        //         if(regExp_list[i].test(inputAll[i].value)){
        //             count_validation++;
        //         }
        //     }
        //     if(count_validation == 5 &&
        //     password_input.value == password_check_input.value &&
        //     (checkbox[0].checked || checkbox[1].checked)){
        //         button_submit.classList.remove('disabled');
        //         button_submit.disabled = false;
        //     }
        //     else{
        //         button_submit.classList.add('disabled');
        //         button_submit.disabled = true;
        //     }
        // });
        // name_input.addEventListener("keydown",function(){
        //     var regExp =  /^[가-힣]+$/;
        //     if(regExp.test(name_input.value)){
        //         name_input.classList.add('pass');
        //         input_box_name.classList.remove('discorrect');
        //     }
        //     else{
        //         if(name_input.classList.contains('pass'))
        //             name_input.classList.remove('pass');
        //             input_box_name.classList.add('discorrect');
        //     }
        // });
        
        // //생년월일 유효성 검사
        // var	birthday_input = document.querySelector('.birthday');
        // var input_box_birthday = birthday_input.parentNode.parentNode;
        
        // birthday_input.addEventListener("change", function(){
        //     var regExp = /^[0-9]{8}$/;
        //     if(regExp.test(birthday_input.value)){
        //         birthday_input.classList.add('pass');
        //         input_box_birthday.classList.remove('discorrect');
        //     }else{
        //         if(birthday_input.classList.contains('pass'))
        //             birthday_input.classList.remove('pass');
        //             input_box_birthday.classList.add('discorrect');
        //     }

        //     var count_validation = 0;
        //     for(var i=0;i<inputAll.length;i++){
        //         if(regExp_list[i].test(inputAll[i].value)){
        //             count_validation++;
        //         }
        //     }
        //     if(count_validation == 5 &&
        //     password_input.value == password_check_input.value &&
        //     (checkbox[0].checked || checkbox[1].checked)){
        //         button_submit.classList.remove('disabled');
        //         button_submit.disabled = false;
        //     }
        //     else{
        //         button_submit.classList.add('disabled');
        //         button_submit.disabled = true;
        //     }
        // });

        // birthday_input.addEventListener("keyup",function(){
        //     var regExp =  /^[0-9]{8}$/;
        //     if(regExp.test(birthday_input.value)){
        //         birthday_input.classList.add('pass');
        //         input_box_birthday.classList.remove('discorrect');
        //     }
        //     else{
        //         if(birthday_input.classList.contains('pass'))
        //             birthday_input.classList.remove('pass');
        //             input_box_birthday.classList.add('discorrect');
        //     }

        //     var count_validation = 0;
        //     for(var i=0;i<inputAll.length;i++){
        //         if(regExp_list[i].test(inputAll[i].value)){
        //             count_validation++;
        //         }
        //     }
        //     if(count_validation == 5 &&
        //     password_input.value == password_check_input.value &&
        //     (checkbox[0].checked || checkbox[1].checked)){
        //         button_submit.classList.remove('disabled');
        //         button_submit.disabled = false;
        //     }
        //     else{
        //         button_submit.classList.add('disabled');
        //         button_submit.disabled = true;
        //     }
        // });
        // birthday_input.addEventListener("keydown",function(){
        //     var regExp =  /^[0-9]{8}$/;
        //     if(regExp.test(birthday_input.value)){
        //         birthday_input.classList.add('pass');
        //         input_box_birthday.classList.remove('discorrect');
        //     }
        //     else{
        //         if(birthday_input.classList.contains('pass'))
        //             birthday_input.classList.remove('pass');
        //             input_box_birthday.classList.add('discorrect');
        //     }
        // });

        // //연락처 유효성 검사
        // var phone_input = document.querySelector('.phone');
        // var input_box_phone = phone_input.parentNode.parentNode;
        // phone_input.addEventListener("change", function(){
        //     var regExp =  /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
        //     if(regExp.test(phone_input.value)){
        //         phone_input.classList.add('pass');
        //         input_box_phone.classList.remove('discorrect');
        //     }else{
        //         if(phone_input.classList.contains('pass'))
        //             phone_input.classList.remove('pass');
        //             input_box_phone.classList.add('discorrect');
        //     }

        //     var count_validation = 0;
        //     for(var i=0;i<inputAll.length;i++){
        //         if(regExp_list[i].test(inputAll[i].value)){
        //             count_validation++;
        //         }
        //     }
        //     if(count_validation == 5 &&
        //     password_input.value == password_check_input.value &&
        //     (checkbox[0].checked || checkbox[1].checked)){
        //         button_submit.classList.remove('disabled');
        //         button_submit.disabled = false;
        //     }
        //     else{
        //         button_submit.classList.add('disabled');
        //         button_submit.disabled = true;
        //     }
        // });

        // phone_input.addEventListener("keyup",function(){
        //     var regExp =  /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
        //     if(regExp.test(phone_input.value)){
        //         phone_input.classList.add('pass');
        //         input_box_phone.classList.remove('discorrect');
        //     }
        //     else{
        //         if(phone_input.classList.contains('pass'))
        //             phone_input.classList.remove('pass');
        //             input_box_phone.classList.add('discorrect');
        //     }

        //     var count_validation = 0;
        //     for(var i=0;i<inputAll.length;i++){
        //         if(regExp_list[i].test(inputAll[i].value)){
        //             count_validation++;
        //         }
        //     }
        //     if(count_validation == 5 &&
        //     password_input.value == password_check_input.value &&
        //     (checkbox[0].checked || checkbox[1].checked)){
        //         button_submit.classList.remove('disabled');
        //         button_submit.disabled = false;
        //     }
        //     else{
        //         button_submit.classList.add('disabled');
        //         button_submit.disabled = true;
        //     }
        // });
        // phone_input.addEventListener("keydown",function(){
        //     var regExp =  /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
        //     if(regExp.test(phone_input.value)){
        //         phone_input.classList.add('pass');
        //         input_box_phone.classList.remove('discorrect');
        //     }
        //     else{
        //         if(phone_input.classList.contains('pass'))
        //             phone_input.classList.remove('pass');
        //             input_box_phone.classList.add('discorrect');
        //     }
        // });

        for(var j=0;j<checkbox.length;j++){
            (function(m){
                checkbox[m].addEventListener("click",function(){
                    var count_validation = 0;
                    for(var i=0;i<inputAll.length;i++){
                        if(regExp_list[i].test(inputAll[i].value)){
                            count_validation++;
                        }
                    }
                    if(count_validation == 5 &&
                    password_input.value == password_check_input.value &&
                    (checkbox[0].checked || checkbox[1].checked)){
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