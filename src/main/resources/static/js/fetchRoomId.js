import { fetchApi } from "./fetchApi.js";
const path = window.location.pathname;
const endpoint = path.split('/').pop();
const divTitle=document.querySelector("#title")
if(endpoint=='phong-cua-toi'){
    divTitle.innerHTML="Phòng của tôi";
}
fetchApi(`/api/rooms`).then(data => {
        let htmls = "";
        data.forEach(item => {
            htmls += `<div class="col-xl-3 col-lg-3 col-md-6 col-6">
                           <a href="#" class="item">
                               <img src="D:/photos/${item.image}" alt="">
                               <h5>${item.price} Triệu/Tháng</h5>
                               <h6>${item.dientich}m<sup>2</sup></h6>
                           </a>
                       </div>`;
        });
        const divRooms=document.querySelector("#room");
        divRooms.innerHTML=htmls;
});