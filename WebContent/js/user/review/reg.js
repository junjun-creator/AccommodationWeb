window.addEventListener('load', function() {
    var starContainer = document.querySelector('.star-container');
    var stars = document.querySelectorAll('.fa-star');
    var comment = document.querySelector('.comment');
    var submitBtn = document.querySelector('.submit-btn');

    starContainer.onclick = function(e) {
        var t = e.target;
        if (t.nodeName == 'path' || t.nodeName == 'svg')
            t.classList.toggle('pick');
        
        console.log(e);
    }

    // var togglePick = function(e) {
    //     console.log(1);
    //     for (let j = 0; j < i + 1; j++) {
    //         if (e.target.nodeName == 'path' || e.target.nodeName == 'svg') {
    //             stars[j].classList.toggle('pick');
    //             console.log(j + 1);
    //         }
    //     }
    // };

    // for (let i = 0; i < stars.length; i++) {
    //     stars[i].onclick = togglePick;
    //     stars[i].addEventListener('click', togglePick);
    //     stars[i].removeEventListener('click', togglePick);
    // }

    submitBtn.onclick = function(e) {
        if (comment.value == '') {
            e.preventDefault();
            alert('리뷰를 등록해주세요.');
            comment.style.border = '1px solid #fc0453';
        } else
            alert('리뷰가 등록되었습니다.')
    }
});