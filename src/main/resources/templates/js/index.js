
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
/*
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
*/

const tabList = document.querySelectorAll('.tab_menu .list li');
const contents = document.querySelectorAll('.tab_menu .cont_area .cont')
let activeCont = ''; // 현재 활성화 된 컨텐츠 (기본:#tab1 활성화)

for(var i = 0; i < tabList.length; i++){
    tabList[i].querySelector('.btn').addEventListener('click', function(e){
        e.preventDefault();
        for(var j = 0; j < tabList.length; j++){
            // 나머지 버튼 클래스 제거
            tabList[j].classList.remove('is_on');

            // 나머지 컨텐츠 display:none 처리
            contents[j].style.display = 'none';
        }

        // 버튼 관련 이벤트
        this.parentNode.classList.add('is_on');

        // 버튼 클릭시 컨텐츠 전환
        activeCont = this.getAttribute('href');
        document.querySelector(activeCont).style.display = 'block';
    });
}



    anychart.onDocumentReady(function () {
    var data = [
{
    "x": "IT",
    "value": 59,
    category: "Sino-Tibetan"
},
{
    "x": "Python",
    "value": 283,
    category: "Indo-European"
},
{
    "x": "소프트웨어",
    "value": 544,
    category: "Indo-European"
},
{
    "x": "JAVA",
    "value": 527,
    category: "Indo-European"
}, {
    "x": "C++",
    "value": 422,
    category: "Afro-Asiatic"
}, {
    "x": "HTML",
    "value": 62,
    category: "Afro-Asiatic"
}
    ];
    var chart = anychart.tagCloud(data);
    chart.angles([0]);
    chart.container("innerChart");
    chart.draw();
});    anychart.onDocumentReady(function () {
    var data = [
{
    "x": "IT",
    "value": 59,
    category: "Sino-Tibetan"
},
{
    "x": "Python",
    "value": 283,
    category: "Indo-European"
},
{
    "x": "소프트웨어",
    "value": 544,
    category: "Indo-European"
},
{
    "x": "JAVA",
    "value": 527,
    category: "Indo-European"
}, {
    "x": "C++",
    "value": 422,
    category: "Afro-Asiatic"
}, {
    "x": "HTML",
    "value": 62,
    category: "Afro-Asiatic"
}, {
    "x": "flutter",
    "value": 47,
    category: "Afro-Asiatic"
}
    ];
    var chart = anychart.tagCloud(data);
    chart.angles([0]);
    chart.container("innerChart2");
    chart.draw();
});