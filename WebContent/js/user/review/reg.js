window.addEventListener('load', function() {
    var starContainer = document.querySelector('.star-container');
    var comment = document.querySelector('.comment');
    var submitBtn = document.querySelector('.submit-btn');

    starContainer.onclick = function(e) {
        var t = e.target;
        if (t.nodeName != 'DIV' && t.classList.contains('pick')) {
            t.style.color = 'rgba(209, 209, 209, 0.596)';
            t.classList.remove('pick');
        } else if (t.nodeName != 'DIV' && !t.classList.contains('pick')) {
            t.style.color = 'gold';
            t.classList.add('pick');
        }
    }

    submitBtn.onclick = function() {
        if (comment.value == '') {
            alert('리뷰를 등록해주세요.');
            comment.style.border = '1px solid #fc0453';
            return false;
        } else
            alert('리뷰가 등록되었습니다.')
    }
});