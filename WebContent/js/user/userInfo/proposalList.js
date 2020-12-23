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

   function numberWithCommas(x) {
       return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
   }

   var btn_more = document.querySelector(".btn-more");
   var offer_count = document.querySelector(".offer-count");
   
   if(offer_count.value <= 3)
      btn_more.style.display='none';
      
   btn_more.addEventListener("click",function(e){
      e.preventDefault();
      
      var page = document.querySelector(".page").value;
      var offer_id = document.querySelector(".offer-id").value;
      
      var xhr = new XMLHttpRequest();
      xhr.open('post','./offerList');
      xhr.onreadystatechange=function(){
         if(xhr.readyState === 4 && xhr.status === 200){
            var html = document.querySelector("#more-template").innerHTML;
            var result = xhr.response;
            var jsonResult = JSON.parse(result);
            var offer_sec = document.querySelector(".offer-sec");
            var currentOffer = document.querySelector(".picked");
            var offerPrice = currentOffer.lastElementChild.value;
            var offer_id = currentOffer.querySelector("input").value;
            var checkinDate = e.currentTarget.querySelector("input").nextElementSibling.value;
            var checkoutDate = e.currentTarget.querySelector("input").nextElementSibling.nextElementSibling.value;
            var headcount = e.currentTarget.querySelector("input").nextElementSibling.nextElementSibling.nextElementSibling.value;
            
            for(var i=0;i<jsonResult.length-1;i++){
               var resultHTML = '';
               
               resultHTML = html.replace("{accName}",jsonResult[i].accName)
                           .replace("{fileRoute}",(jsonResult[i].fileRoute).split(",", 1))
                           .replace("{roomName}",jsonResult[i].roomName)
                           .replace("{bedCount}",jsonResult[i].bedCount)
                           .replace("{maxHeadcount}",jsonResult[i].maxHeadcount)
                           .replace("{price}",numberWithCommas(jsonResult[i].price))
                           .replace("{offerPrice}",numberWithCommas(offerPrice))
                           .replace("{accId}",jsonResult[i].accId)
                           .replace("{roomId}",jsonResult[i].roomId)
                           .replace("{checkinDate}",checkinDate)
                           .replace("{checkoutDate}",checkoutDate)
                           .replace("{sendingPrice}",offerPrice)
                           .replace("{headcount}",headcount);
                           
               offer_sec.insertAdjacentHTML('beforeend',resultHTML);
               
            }//아이템 추가 완료
            var pageNum = document.querySelector(".page");
            pageNum.value= (page)*1+1;
            if(jsonResult[jsonResult.length-1].offerCount <= page*3)
               btn_more.style.display = 'none';
            else
               btn_more.href = "?page="+((page)*1+1)+"&offerId="+offer_id;
            
            /* 불러온 결과를 insertajacent로 삽입 해주고, 다음 페이지 번호값을 변경해서 input에 저장해주고
               전체 갯수를 input hidden으로 받아와서 전체갯수와 현재 페이지*3을 비교해서 전체갯수가 더 적으면 더보기 버튼비활성화*/ 
         }
      }
      xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
      var data='';
      data += 'page='+page;
      data += '&offerId='+offer_id;
      xhr.send(data);
   });
   
   var proposalInfo = document.querySelectorAll(".proposal-info");
   console.log(proposalInfo);
   for(var card of proposalInfo){
      card.addEventListener("click",function(e){
         e.stopPropagation();
         
         var beforeTarget = document.querySelector(".picked");
         beforeTarget.classList.remove("picked");
         e.currentTarget.classList.add("picked");
         var offerPrice = e.currentTarget.lastElementChild.value;
         var checkinDate = e.currentTarget.querySelector("input").nextElementSibling.value;
         var checkoutDate = e.currentTarget.querySelector("input").nextElementSibling.nextElementSibling.value;
         var headcount = e.currentTarget.querySelector("input").nextElementSibling.nextElementSibling.nextElementSibling.value;
         var offer_id = e.currentTarget.querySelector("input").value;
         
         
         var xhr = new XMLHttpRequest();
         xhr.open('post','./offerList'); // 1
         xhr.onreadystatechange=function(){ // 2(settinㅎ만)
            if(xhr.readyState === 4 && xhr.status === 200){
               var result = xhr.response;
               
               document.querySelector(".page").value=2;
               document.querySelector(".offer-id").value=offer_id;
               
               var html = document.querySelector("#more-template").innerHTML;
               var jsonResult = JSON.parse(result);
               var offer_sec = document.querySelector(".offer-sec");
               var resultHTML = '';
               for(var i=0;i<jsonResult.length-1;i++){
                  resultHTML += html.replace("{accName}",jsonResult[i].accName)
                              .replace("{fileRoute}",(jsonResult[i].fileRoute).split(",", 1))
                              .replace("{roomName}",jsonResult[i].roomName)
                              .replace("{bedCount}",jsonResult[i].bedCount)
                              .replace("{maxHeadcount}",jsonResult[i].maxHeadcount)
                              .replace("{price}",numberWithCommas(jsonResult[i].price))
                              .replace("{offerPrice}",numberWithCommas(offerPrice))
                              .replace("{sendingPrice}",offerPrice)
                              .replace("{accId}",jsonResult[i].accId)
                              .replace("{roomId}",jsonResult[i].roomId)
                              .replace("{checkinDate}",checkinDate)
                              .replace("{checkoutDate}",checkoutDate)
                              .replace("{headcount}",headcount);
                              
               }
               offer_sec.innerHTML = resultHTML;
               
               if(jsonResult[jsonResult.length-1].offerCount <= 3)
                  btn_more.style.display = 'none';
               else{
                  btn_more.href = "?page=2&offerId="+offer_id;
                  btn_more.style.display = 'block';
               }
               
               
            }
         }
         xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); //3
         var data='';
         data += 'page=1';
         data += '&offerId='+offer_id;
         xhr.send(data); //4 0~5 UN
      },true);
   }
   
   // firstElementChild.lastElementChild.firstElementChild.lastElementChild.lastElementChild.firstElementChild
   var reserve_btn = document.querySelector(".offer-sec");
   reserve_btn.addEventListener("click",function(e){
      e.stopPropagation();

      if(e.target.className == "submit-btn"){
         var checkinDate = e.target.nextElementSibling;
         var checkoutDate = checkinDate.nextElementSibling;
         var price = checkoutDate.nextElementSibling;
         var accId = price.nextElementSibling;
         var roomId = accId.nextElementSibling;
         var headcount = roomId.nextElementSibling;
         
         window.location.href = `/user/reservation/pay?accId=${accId.value}&roomId=${roomId.value}&price=${price.value}&checkinDate=${checkinDate.value}&checkoutDate=${checkoutDate.value}&headcount=${headcount.value}`;
      }
   });
});