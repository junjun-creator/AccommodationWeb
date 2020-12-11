window.addEventListener('load', function() {
    var chkAll = document.querySelector('.checkbox-all');
    var chks = document.querySelectorAll('.checkbox-single');

    chkAll.onclick = function() {
        for (var i = 0; i < chks.length; i++) {
            if (chkAll.checked) {
                chks[i].checked = true;
                continue;
            }
            chks[i].checked = false;
        }
    }

    for (var i = 0; i < chks.length; i++) {
        (function(i) {
            chks[i].onclick = function() {
                if (!chks[i].checked) {
                    chkAll.checked = false;
                    return;
                }

                var cnt = 0;
                for (var j = 0; j < chks.length; j++) {
                    if (chks[j].checked) {
                        cnt++;
                    }
                }
                
                if (cnt == chks.length) 
                    chkAll.checked = true;
            }
        })(i);
    }

});