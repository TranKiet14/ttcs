import { drawRoom } from "./drawRoom.js";
import { params, urlParams, endpoint } from "./variables.js";
import { drawItemRoom } from "./drawItemRoom.js"
const a1 = document.querySelector('#a1');
const a2 = document.querySelector('#a2');
const a3 = document.querySelector('#a3');
const a4 = document.querySelector('#a4');
const divTitle = document.querySelector('#title');
function checkendpoint(){
    if(endpoint == 'cau-giay'){
        params.keyword = 'Cầu Giấy';
        divTitle.innerHTML="Phòng trọ Cầu Giấy";
    } else if(endpoint == 'thanh-xuan'){
        params.keyword = 'Thanh Xuân';
        divTitle.innerHTML="Phòng trọ Thanh Xuân";
    } else if(endpoint == 'ha-dong'){
        params.keyword = 'Hà Đông';
        divTitle.innerHTML="Phòng trọ Hà Đông";
    } else if(endpoint == 'hoan-kiem'){
        params.keyword = 'Hoàn Kiếm';
        divTitle.innerHTML="Phòng trọ Hoàn Kiếm";
    } else if(endpoint == 'dong-da'){
        params.keyword = 'Đống Đa';
        divTitle.innerHTML="Phòng trọ Đống Đa";
    } else if(endpoint == 'tay-ho'){
        params.keyword = 'Tây Hồ';
        divTitle.innerHTML="Phòng trọ Tây Hồ";
    } else if(endpoint == 'ba-dinh'){
        params.keyword = 'Ba Đình';
        divTitle.innerHTML="Phòng trọ Ba Đình";
    } else if(endpoint == 'tu-liem'){
        params.keyword = 'Từ Liêm';
        divTitle.innerHTML="Phòng trọ Từ Liêm";
    } else if(endpoint == 'hai-ba-trung'){
        params.keyword = 'Hai Bà Trưng';
        divTitle.innerHTML="Phòng trọ Hai Bà Trưng";
    }
}
a1.addEventListener('click', (event) => {
    event.preventDefault();
    params.keyword=urlParams.get('keyword');
    if(params.keyword == null){
        checkendpoint();
    }
    params.min=0;
    params.max=5;
    drawRoom();
});
a2.addEventListener('click', (event) => {
    event.preventDefault();
    params.keyword=urlParams.get('keyword');
    if(params.keyword == null){
        checkendpoint();
    }
    params.min=5;
    params.max=10;
    drawRoom();
});
a3.addEventListener('click', (event) => {
    event.preventDefault();
    params.keyword=urlParams.get('keyword');
    if(params.keyword == null){
        checkendpoint();
    }
    params.min=10;
    params.max=15;
    drawRoom();
});
a4.addEventListener('click', (event) => {
    event.preventDefault();
    params.keyword=urlParams.get('keyword');
    if(params.keyword == null){
        checkendpoint();
    }
    params.min=15;
    params.max=20;
    drawRoom();
});

const search = () =>{
    let key = urlParams.get('keyword');
    if(key != ''){
        params.keyword = key;
        divTitle.innerHTML=`Kết quả tìm kiếm của "${params.keyword}"`;
        drawRoom();
    }
};

const searchPath =() => {
    if(endpoint == 'cau-giay'){
        params.keyword = 'Cầu Giấy';
        divTitle.innerHTML="Phòng trọ Cầu Giấy";
        drawRoom();
    } else if(endpoint == 'thanh-xuan'){
        params.keyword = 'Thanh Xuân';
        divTitle.innerHTML="Phòng trọ Thanh Xuân";
        drawRoom();
    } else if(endpoint == 'ha-dong'){
        params.keyword = 'Hà Đông';
        divTitle.innerHTML="Phòng trọ Hà Đông";
        drawRoom();
    }else if(endpoint == 'hoan-kiem'){
        params.keyword = 'Hoàn Kiếm';
        divTitle.innerHTML="Phòng trọ Hoàn Kiếm";
        drawRoom();
    }else if(endpoint == 'dong-da'){
        params.keyword = 'Đống Đa';
        divTitle.innerHTML="Phòng trọ Đống Đa";
        drawRoom();
    } else if(endpoint == 'tay-ho'){
        params.keyword = 'Tây Hồ';
        divTitle.innerHTML="Phòng trọ Tây Hồ";
        drawRoom();
    } else if(endpoint == 'ba-dinh'){
        params.keyword = 'Ba Đình';
        divTitle.innerHTML="Phòng trọ Ba Đình";
        drawRoom();
    } else if(endpoint == 'tu-liem'){
        params.keyword = 'Từ Liêm';
        divTitle.innerHTML="Phòng trọ Từ Liêm";
        drawRoom();
    } else if(endpoint == 'hai-ba-trung'){
        params.keyword = 'Hai Bà Trưng';
        divTitle.innerHTML="Phòng trọ Hai Bà Trưng";
        drawRoom();
    }
}
if(urlParams.get('keyword')!=null){
    search();
}
else{
    searchPath();
}
