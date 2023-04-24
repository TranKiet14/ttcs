import { fetchApi } from "./fetchApi.js";
const urlParams = new URLSearchParams(window.location.search);
const keyword = urlParams.get('keyword');
const divTitle=document.querySelector("#title")
const path = window.location.pathname;
const district = path.split('/').pop();
if(district=='cau-giay'){
    divTitle.innerHTML="Phòng trọ Cầu Giấy";
} else if(district=='thanh-xuan-ha-dong'){
    divTitle.innerHTML="Phòng trọ Thanh Xuân và Hà Đông";
} else if(district=='tay-ho-hoan-kiem'){
    divTitle.innerHTML="Phòng trọ Tây Hồ và Hoàn Kiếm";
} else if(district=='ba-dinh-dong-da'){
    divTitle.innerHTML="Phòng trọ Ba Đình và Đống Đa";
} else if(district=='tu-liem'){
    divTitle.innerHTML="Phòng trọ Từ Liêm";
} else if(district=='hoang-mai-hai-ba-trung'){
    divTitle.innerHTML="Phòng trọ Hoàng Mai và Hai Bà Trưng";
}
fetchApi(`/api/rooms/search?keyword=${keyword}`).then(data => {
        let htmls = "";
        data.forEach(item => {
            htmls += `<div class="col-xl-3 col-lg-3 col-md-6 col-6">
                           <a href="#" class="item">
                               <img src="/photos/${item.image}" alt="">
                               <h5>${item.price} Triệu/Tháng</h5>
                               <h6>${item.dientich}m<sup>2</sup></h6>
                           </a>
                       </div>`;
        });
        const divRooms=document.querySelector("#room");
        divRooms.innerHTML=htmls;
});



