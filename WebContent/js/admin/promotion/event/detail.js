window.addEventListener('load', function() {
    var delBtn = document.querySelector('.btn-delete');

    delBtn.onclick = function() {
        if (!confirm("해당 게시물을 삭제하시겠습니까?"))
            return false;
    }
});