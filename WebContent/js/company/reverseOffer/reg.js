window.addEventListener('load', function () {
    var prevBtn = document.querySelector('.btn-left');
    var nextBtn = document.querySelector('.btn-right');
    var proposal = document.querySelector('.proposal-item-container');
    var proposalInfo = document.querySelectorAll('.proposal-info');

    var proposalCount = 0;







    /****************************** 캐러셀 **********************************/
    prevBtn.addEventListener('click', function (e) {
        if (proposalCount > 0) proposalCount--;
        else proposalCount = proposalInfo.length - 2;

        proposal.style.transform = 'translateX(' + -350 * proposalCount + 'px)';
    });

    nextBtn.addEventListener('click', function (e) {
        if (proposalCount <= proposalInfo.length - 2 - 1) proposalCount++;
        else proposalCount = 0;

        proposal.style.transform = 'translateX(' + -350 * proposalCount + 'px)';
    });






    /****************************** 페이저 Ajax 처리 **********************************/
    // for (var card of proposalInfo) {
    //     card.addEventListener('click', function (e) {
	// 		e.stopPropagation();
	// 		console.log("e.target :", e.target);
	// 		console.log("e.currentTarget :", e.currentTarget);
	// 		console.log(" test :", e.currentTarget.querySelector('input').nextElementSibling);

	// 		var beforeTarget = document.querySelector('.picked');
	// 		beforeTarget.classList.remove('picked');
	// 		e.currentTarget.classList.add('picked');
	// 		var offerPrice = e.currentTarget.lastElementChild.value;
	// 		var checkinDate = e.currentTarget.querySelector('input').nextElementSibling.value;
	// 		var checkoutDate = e.currentTarget.querySelector('input').nextElementSibling.nextElementSibling.value;
	// 		var headcount = e.currentTarget.querySelector('input').nextElementSibling.nextElementSibling.nextElementSibling.value;
	// 		var offerId = e.currentTarget.querySelector('input').value; // 맨위에
			
	// 		console.log("offerPrice :", offerPrice);
	// 		console.log("checkinDate :", checkinDate);
	// 		console.log("checkoutDate :", checkoutDate);
	// 		console.log("headcount :", headcount);
	// 		console.log("offerId :", offerId);

	// 		var xhr = new XMLHttpRequest();
	// 		xhr.open('post', './reg'); // 1

	// 		xhr.onreadystatechange = function () { // 2
	// 			if (xhr.readyState === 4 && xhr.status === 200) {
	// 				var result = xhr.response;

	// 				// 더보기 기능
	// 				// document.querySelector('.page').value = 2; 
	// 				//document.querySelector('.offer-id').value = offerId; 

	// 				//var html = document.querySelector('#more-template').innerHTML;
	// 				var jsonResult = JSON.parse(result);
	// 				console.log("result ", result);
	// 				console.log("jsonResult ", jsonResult);
	// 				// var offerSec = document.querySelector('.offer-sec');
	// 				// var resultHTML = '';
	// 				// for (var i = 0; i < jsonResult.length; i++) {
	// 				// 	resultHTML += html
	// 				// 		.replace('{accName}', jsonResult[i].accName)
	// 				// 		.replace('{fileRoute}', jsonResult[i].fileRoute)
	// 				// 		.replace('{roomName}', jsonResult[i].roomName)
	// 				// 		.replace('{bedCount}', jsonResult[i].bedCount)
	// 				// 		.replace('{maxHeadcount}', jsonResult[i].maxHeadcount)
	// 				// 		.replace('{price}', numberWithCommas(jsonResult[i].price))
	// 				// 		.replace('{offerPrice}', numberWithCommas(offerPrice))
	// 				// 		.replace('{sendingPrice}', offerPrice)
	// 				// 		.replace('{accId}', jsonResult[i].accId)
	// 				// 		.replace('{roomId}', jsonResult[i].roomId)
	// 				// 		.replace('{checkinDate}', checkinDate)
	// 				// 		.replace('{checkoutDate}', checkoutDate)
	// 				// 		.replace('{headcount}', headcount);
	// 				// }
	// 				// offerSec.innerHTML = resultHTML;

	// 				// 더보기 기능
	// 				// if (jsonResult[jsonResult.length - 1].offerCount <= 3) btn_more.style.display = 'none';
	// 				// else {
	// 				// 	btn_more.href = '?page=2&offerId=' + offerId;
	// 				// 	btn_more.style.display = 'block';
	// 				// }
	// 			}
	// 		};
	// 		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); //3
	// 		var data = '';// queryString
	// 		date += 'page=1';
	// 		data += '&offerId=' + offerId;
	// 		xhr.send(data); //4 0~4
	// 	}, true);
    // }

    // function numberWithCommas(x) {
    //     return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    // }
});
