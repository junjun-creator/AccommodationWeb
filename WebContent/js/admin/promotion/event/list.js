window.addEventListener('load', function() {
    var activeMenu = document.querySelector('.aside');
    activeMenu.children[1].children[1].classList.add('active');
    var openChkAll = document.querySelector('.open-chk-all');
    var delChkAll = document.querySelector('.del-chk-all');
    var openChks = document.querySelectorAll('.open-chk');
    var delChks = document.querySelectorAll('.del-chk');

    openChkAll.onclick = function() {
        for (var i = 0; i < openChks.length; i++) {
            if (openChkAll.checked) {
                openChks[i].checked = true;
                continue;
            }
            openChks[i].checked = false;
        }
    }

    delChkAll.onclick = function() {
        for (var i = 0; i < delChks.length; i++) {
            if (delChkAll.checked) {
                delChks[i].checked = true;
                continue;
            }
            delChks[i].checked = false;
        }
    }

    for (var i = 0; i < openChks.length; i++) {
        (function(i) {
            openChks[i].onclick = function() {
                if (!openChks[i].checked) {
                    openChkAll.checked = false;
                    return;
                }

                var cnt = 0;
                for (var j = 0; j < openChks.length; j++) {
                    if (openChks[j].checked) {
                        cnt++;
                    }
                }
                
                if (cnt == openChks.length) 
                    openChkAll.checked = true;
            }
        })(i);
    }

    for (var i = 0; i < delChks.length; i++) {
        (function(i) {
            delChks[i].onclick = function() {
                if (!delChks[i].checked) {
                    delChkAll.checked = false;
                    return;
                }

                var cnt = 0;
                for (var j = 0; j < delChks.length; j++) {
                    if (delChks[j].checked) {
                        cnt++;
                    }
                }
                
                if (cnt == delChks.length) 
                    delChkAll.checked = true;
            }
        })(i);
    }
});