window.addEventListener('load', function() {
    var chkAll = document.querySelector('.checkbox-all');
    var chks = document.querySelectorAll('.checkbox-single');

    var nameInput = document.querySelector('.name-input');
    var phoneInput = document.querySelector('.phone-input');
    var submitBtn = document.querySelector('.submit-btn');

    /* 전체선택 체크박스 클릭이벤트 */
    chkAll.onclick = function() {
        for (var i = 0; i < chks.length; i++) {
            if (chkAll.checked) {
                chks[i].checked = true;
                checkForm(nameInput, phoneInput, chkAll);
                continue;
            }
            chks[i].checked = false;
            checkForm(nameInput, phoneInput, chkAll);
        }
    }

    /* 싱글선택 체크박스 클릭이벤트 */
    for (var i = 0; i < chks.length; i++) {
        (function(i) {
            chks[i].onclick = function() {
                if (!chks[i].checked) {
                    chkAll.checked = false;
                    checkForm(nameInput, phoneInput, chkAll);
                    return;
                }

                var cnt = 0;
                for (var j = 0; j < chks.length; j++) {
                    if (chks[j].checked) {
                        cnt++;
                    }
                }
                
                if (cnt == chks.length) {
                    chkAll.checked = true;
                    checkForm(nameInput, phoneInput, chkAll);
                }
            }
        })(i);
    }
    
    /* 예약자이름 input 체크 */
    nameInput.onkeyup = function() {
        checkForm(nameInput, phoneInput, chkAll);
    }

    /* 휴대폰 번호 input 체크 */
    phoneInput.onkeyup = function() {
        checkForm(nameInput, phoneInput, chkAll);
    }



    /* 모든 form 채워지면 결제하기 버튼 활성화하는 함수 */
    function checkForm(nameInput, phoneInput, chkAll) {
        if (nameInput.value != '' && phoneInput.value != '' && chkAll.checked) {
            submitBtn.style.opacity = 1;
            submitBtn.disabled = false;
            return;
        } 
        submitBtn.style.opacity = 0.3;
        submitBtn.disabled = true;
    }

});