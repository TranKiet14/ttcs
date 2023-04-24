import { getApi } from "./api.js";


export const drawItemRoom = (api) => {
    getApi(api).then(data => {
        let htmls = '';
        data.forEach(item => {
            htmls += `<div class="col-xl-3 col-lg-3 col-md-6 col-6">
                            <a href="/thong-tin-phong?id=${item.id}" class="item">
                                <img src="/photos/${item.image}" alt="">
                                <h5>${item.price} Triệu/Tháng</h5>
                                <h6>${item.dientich}m<sup>2</sup></h6>
                                <p style="text-align: center">${item.address}</p>
                            </a>
                        </div>`;
        });
        const divRooms=document.querySelector("#room");
        divRooms.innerHTML=htmls;
    });
}