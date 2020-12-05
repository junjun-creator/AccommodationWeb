window.addEventListener('load', function() {
    //var activeMenu = document.querySelector('.aside');
    //activeMenu.children[1].children[1].classList.add('active');
    var openChkAll = document.querySelector('.open-chk-all');
    var delChkAll = document.querySelector('.del-chk-all');

    openChkAll.onclick = function() {
        var openChks = document.querySelectorAll('.open-chk');

        for (var i = 0; i < openChks.length; i++) {
            if (openChkAll.checked) {
                openChks[i].checked = true;
                continue;
            }
            openChks[i].checked = false;
        }
    }

    delChkAll.onclick = function() {
        var delChks = document.querySelectorAll('.del-chk');

        for (var i = 0; i < delChks.length; i++) {
            if (delChkAll.checked) {
                delChks[i].checked = true;
                continue;
            }
            delChks[i].checked = false;
        }
    }
});