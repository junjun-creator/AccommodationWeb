window.addEventListener('load', function() {
    var chkAll = document.querySelector('.checkbox-all');
    var chks = document.querySelectorAll('.checkbox-single');

    var nameInput = document.querySelector('.name-input');
    var phoneInput = document.querySelector('.phone-input');
    var submitBtn = document.querySelector('.submit-btn');

    // 모든 정보가 채워졌을 때, 결제하기 버튼이 활성화되어야 한다.
    // 그런데 onkeyup 이벤트로 체크를 하고 있어서 처음에 페이지가 로딩되었을 때는 이 부분이 먹히지 않는다.
    // 그래서 전역에 페이지 실행되자마자 체크한번하라고 바로 밑줄에서 호출함
    checkForm(nameInput, phoneInput, chkAll);

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

    submitBtn.onclick = function() {
        if (!confirm('예약을 완료하시겠습니까?'))
            return false;
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