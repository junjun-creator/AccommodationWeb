window.addEventListener('load', function() {
    var starContainer = document.querySelector('.star-container');
    var stars = document.querySelectorAll('.fa-star');
    var comment = document.querySelector('.comment');
    var submitBtn = document.querySelector('.submit-btn');
    
    stars[0].onclick = function() {
        if (stars[0].classList[3].indexOf('pick') != -1) {
            starContainer.children[0].style.color = 'rgba(209, 209, 209, 0.596)';
            stars[0].classList.remove('pick');
        } else if (stars[0].classList[3].indexOf('pick') == -1) {
            starContainer.children[0].style.color = 'gold';
            stars[0].classList.add('pick');
        }
    }

    stars[1].onclick = function() {
        for (var key in stars[1].classList) {
            console.log(stars[1].classList[key]);
        }
    }

    stars[2].onclick = function() {
        
    }

    stars[3].onclick = function() {
        
    }

    stars[4].onclick = function() {
        for (var key in stars[4].classList) {
            console.log(stars[4].classList[key]);
        }
    }

    submitBtn.onclick = function() {
        if (comment.innerText == '') {
            alert('리뷰를 등록해주세요!');
            return false;
        }
    }
});