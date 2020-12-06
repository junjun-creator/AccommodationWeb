window.addEventListener('load', function() {
    var images = document.querySelectorAll(".category-img");
    var dirImgs_hover = ["images/main/hotel-icon-hover.png",
                "images/main/motel-icon-hover.png",
                "images/main/guesthouse-icon-hover.png",
                "images/main/resort-icon-hover.png",
                "images/main/pension-icon-hover.png"];
    var dirImgs = ["images/main/hotel-icon.png",
                "images/main/motel-icon.png",
                "images/main/guesthouse-icon.png",
                "images/main/resort-icon.png",
                "images/main/pension-icon.png"];

    // for(var i=0;i<images.length;i++){
    //     // images[i].addEventListener("hover",function(){
    //     //     images[i].firstElementChild.setAttribute('src',dirImgs[i]);
    //     // });

    //     images[i].onmouseover = function(){
            
    //         this.firstElementChild.src = dirImgs_hover[i];
    //     };
    // }


    images[0].onmouseover = function(){
        this.firstElementChild.src = dirImgs_hover[0];
    };
    images[1].onmouseover = function(){
        this.firstElementChild.src = dirImgs_hover[1];
    };
    images[2].onmouseover = function(){
        this.firstElementChild.src = dirImgs_hover[2];
    };
    images[3].onmouseover = function(){
        this.firstElementChild.src = dirImgs_hover[3];
    };
    images[4].onmouseover = function(){
        this.firstElementChild.src = dirImgs_hover[4];
    };

    images[0].onmouseout = function(){
        this.firstElementChild.src = dirImgs[0];
    };
    images[1].onmouseout = function(){
        this.firstElementChild.src = dirImgs[1];
    };
    images[2].onmouseout = function(){
        this.firstElementChild.src = dirImgs[2];
    };
    images[3].onmouseout = function(){
        this.firstElementChild.src = dirImgs[3];
    };
    images[4].onmouseout = function(){
        this.firstElementChild.src = dirImgs[4];
    };

    //프로모션 이미지 슬라이딩
    var btnLeft = document.querySelector(".btn-left").firstElementChild;
    var btnRight = document.querySelector(".btn-right").firstElementChild;

    btnLeft.addEventListener("click",function(){
        alert(1);
    });
    btnRight.addEventListener("click",function(){
        alert(2);
    });


    //============================ 이벤트 페이지 ===============================
});

