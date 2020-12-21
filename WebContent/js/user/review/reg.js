window.addEventListener('load', function() {
    var starContainer = document.querySelector('.star-container');
    var stars = document.querySelectorAll('.fa-star');
    var comment = document.querySelector('.comment');
    var submitBtn = document.querySelector('.submit-btn');
	var score = document.querySelector('.score');
    
starContainer.addEventListener('click', function(e) {
        var t = e.target;
		
        while (t.tagName != 'DIV') {
            t = t.parentNode;
        }
        console.log(t.nextElementSibling.value);
		
		score.value = t.nextElementSibling.value;
		
        for (var i = 0; i < stars.length; i++)
            stars[i].style.color = 'rgba(209, 209, 209, 0.596)';

        for (var i = 0; i < stars.length; i++) {
            if (i <= t.nextElementSibling.value)
                stars[i].style.color = 'gold';
        }
    });

    submitBtn.onclick = function(e) {
        if (comment.value == '') {
            e.preventDefault();
            alert('리뷰를 등록해주세요.');
            comment.style.border = '1px solid #fc0453';
        } else
            alert('리뷰가 등록되었습니다.')

    }
});