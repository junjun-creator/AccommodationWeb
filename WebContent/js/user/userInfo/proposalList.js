window.addEventListener("load",function(){
    var prev_btn = document.querySelector(".btn-left");
    var next_btn = document.querySelector(".btn-right")
    var proposal_ = document.querySelector(".proposal-item-container");
    var proposal_info = document.querySelectorAll(".proposal-info");

    var proposalCount=0;
    prev_btn.addEventListener("click",function(e){
        if(proposalCount>0)
            proposalCount--;
        else
            proposalCount = proposal_info.length-2;

        proposal_.style.transform="translateX("+(-350)*proposalCount+"px)";
    });

    next_btn.addEventListener("click",function(e){
        if(proposalCount <= proposal_info.length-2-1)
            proposalCount++;
        else
            proposalCount = 0;

        proposal_.style.transform="translateX("+(-350)*proposalCount+"px)";
    });
});