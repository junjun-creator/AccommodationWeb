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
        
        var newOne = promotionItems[promotionItems.length-1].cloneNode();
        newOne.innerHTML = promotionItems[promotionItems.length-1].innerHTML;
        promotionItemContainer.prepend(newOne);
        var newOne = promotionItems[promotionItems.length-2].cloneNode();
        newOne.innerHTML = promotionItems[promotionItems.length-2].innerHTML;
        promotionItemContainer.prepend(newOne);
        var newOne = promotionItems[promotionItems.length-3].cloneNode();
        newOne.innerHTML = promotionItems[promotionItems.length-3].innerHTML;
        promotionItemContainer.prepend(newOne);

        promotionItemContainer.style.transform = "translateX("+(-326)*3+"px)";

        btnLeft.addEventListener("click",function(){
            if(promotionCount > 0){
                promotionCount--;
                promotionItemContainer.style.transform = "translateX("+(-326)*promotionCount+"px)";
            }
            else{
                
            }
        });
        btnRight.addEventListener("click",function(){
            //var promotionItemContainer = document.querySelector(".promotion-item-container");
            if(promotionCount <= promotionItems.length-3-1){

                promotionCount++;
                promotionItemContainer.style.transform = "translateX("+(-326)*promotionCount+"px)";
            }
        });