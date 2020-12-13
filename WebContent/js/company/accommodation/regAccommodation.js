window.addEventListener("load",function(){
    var contentBox = document.querySelector("content-box");
    var addButton = contentBox.querySelector(".add-button");
    var delButton = contentBox.querySelector(".del-button");
    var addRoom = contentBox.querySelector(".add-room");


    addButton.onclick = fuction(){
        alert("ㅎㅇ");        
        var roomInfo = '<span class="roomInfo"> \
                    <div>방 이름 : <input type="text"  class="text-box"></div> \
                    <div>방 갯수 : <input type="text" class="text-box"></div> \
                    <div>최대 인원 수 : <input type="text" class="text-box"></div> \
                    <div>침대 갯수 : <input type="text" class="text-box"></div> \
                    <div>가격 : <input type="text" class="text-box"></div> \
                    <div>방사진 추가 <input type="file" accept="image" class="text-box"></div> \
                    <div</div>추가 사항 : <input type="text" class="text-box"></div> \
                    </span><br>';
        addRoom.insertAdjacentHTML('beforeend',roomInfo);
                }
});