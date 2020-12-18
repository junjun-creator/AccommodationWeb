//=========== 마우스 휠 스크롤 시===============
// var scrollBase = document.querySelectorAll(".scrolling");
var scrollCount = 0;

window.onmousewheel = function(e) {
    if (e.wheelDelta == -120) {
        if (scrollCount < 3) {
            scrollCount++;
            window.scrollTo({top: (972 * scrollCount), left: 0, behavior: 'smooth'});
        }
    }
    else {
        if (scrollCount > 0) {
            scrollCount--;
            window.scrollTo({top: (972 * scrollCount), left: 0, behavior: 'smooth'});
        }
    }
}


//=========== 골든타임 페이지 =================

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
var btnLeft = document.querySelector(".btn-left");
var btnRight = document.querySelector(".btn-right");
var promotionItems = document.querySelectorAll(".promotion-item");
var promotionCount = 0;
var promotionItemContainer = document.querySelector(".promotion-item-container");

btnLeft.addEventListener("click",function(){
    if(promotionCount > 0){
        promotionCount--;
        promotionItemContainer.style.transform = "translateX("+(-306)*promotionCount+"px)";
    }
    else{
        promotionCount = promotionItems.length-3;
        promotionItemContainer.style.transform = "translateX("+(-306)*promotionCount+"px)";
    }
});
btnRight.addEventListener("click",function(){
    //var promotionItemContainer = document.querySelector(".promotion-item-container");
    if(promotionCount <= promotionItems.length-3-1){

        promotionCount++;
        promotionItemContainer.style.transform = "translateX("+(-306)*promotionCount+"px)";
    }
    else{
        promotionCount = 0;
        promotionItemContainer.style.transform = "translateX("+(-306)*promotionCount+"px)";
    }
});

setInterval(function(){
    if(promotionCount <= promotionItems.length-3-1){
        promotionCount++;
        promotionItemContainer.style.transform = "translateX("+(-306)*promotionCount+"px)";
    }
    else{
        promotionCount = 0;
        promotionItemContainer.style.transform = "translateX("+(-306)*promotionCount+"px)";
    }
},3000);
  
//============================ 이벤트 페이지 ===============================
var eventList = document.querySelector('.event-list');
var currentEvent = eventList.firstElementChild;
var prevButton = document.querySelector('.prev-btn');
var nextButton = document.querySelector('.next-btn');
var eventIndex = 0;
var eventImgCount = eventList.childElementCount;

currentEvent.classList.add('current');

prevButton.onclick = function() {
    if (currentEvent.previousElementSibling == null) {
        eventIndex -= (eventImgCount - 1); 
        var x = eventIndex * 900;
        eventList.style.transform = 'translateX(' + x + 'px)';

        currentEvent.classList.remove('current');
        currentEvent = eventList.lastElementChild;
        currentEvent.classList.add('current');
    } else {
        eventIndex++;
        var x = eventIndex * 900;
        eventList.style.transform = 'translateX(' + x + 'px)';

        currentEvent.classList.remove('current');
        currentEvent = currentEvent.previousElementSibling;
        currentEvent.classList.add('current');
    }
}

nextButton.onclick = function() {
    if (currentEvent.nextElementSibling == null) {
        eventIndex += (eventImgCount - 1); 
        var x = eventIndex * 900;
        eventList.style.transform = 'translateX(' + x + 'px)';

        currentEvent.classList.remove('current');
        currentEvent = eventList.firstElementChild;
        currentEvent.classList.add('current');
    } else {
        eventIndex--;
        var x = eventIndex * 900;
        eventList.style.transform = 'translateX(' + x + 'px)';

        currentEvent.classList.remove('current');
        currentEvent = currentEvent.nextElementSibling;
        currentEvent.classList.add('current');
    }
}

setInterval(function() {
    if (currentEvent.nextElementSibling == null) {
        eventIndex += (eventImgCount - 1); 
        var x = eventIndex * 900;
        eventList.style.transform = 'translateX(' + x + 'px)';

        currentEvent.classList.remove('current');
        currentEvent = eventList.firstElementChild;
        currentEvent.classList.add('current');
    } else {
        eventIndex--;
        var x = eventIndex * 900;
        eventList.style.transform = 'translateX(' + x + 'px)';

        currentEvent.classList.remove('current');
        currentEvent = currentEvent.nextElementSibling;
        currentEvent.classList.add('current');
    }
}, 3000);