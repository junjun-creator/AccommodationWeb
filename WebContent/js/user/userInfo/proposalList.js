window.addEventListener("load",function(){
    var prev_btn = document.querySelector(".btn-left");
    var next_btn = document.querySelector(".btn-right")
    var proposal_ = document.querySelector(".proposal-item-container");
    prev_btn.addEventListener("click",function(e){
        alert(1111);
    });

    next_btn.addEventListener("click",function(e){
        proposal_.style.transform="translateX(-350px)";
    });
});