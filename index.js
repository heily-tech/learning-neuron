
$('#selectRoomName').change(function(){
   $("#selectRoomName option:selected").each(function () {

    if($(this).val()== '1'){ //직접입력일 경우
       $("#roomName").val('');                        //값 초기화
       $("#roomName").attr("disabled",false); //활성화
    }else{ //직접입력이 아닐경우
       $("#roomName").val('날짜-강의자-방번호?');      //선택값 입력
       $("#roomName").attr("disabled",true); //비활성화
    }
   });
});

$('#selectRoomCode').change(function(){
   $("#selectRoomCode option:selected").each(function () {

    if($(this).val()== '1'){ //직접입력일 경우
       $("#roomCode").val('');                        //값 초기화
       $("#roomCode").attr("disabled",false); //활성화
    }else{ //직접입력이 아닐경우
       $("#roomCode").val('난수 생성');      //선택값 입력
       $("#roomCode").attr("disabled",true); //비활성화
    }
   });
});

fetch("footer.html").then(response => {
    return response.text()
}).then(data => {
    document.querySelector("footer").innerHTML = data;
});

fetch("index_header.html").then(response => {
  return response.text()
}).then(data => {
  document.querySelector("header").innerHTML = data;
});
