import { getApi } from "./api.js";
import { API_ROOM } from "./constant.js";
const drawIteamRoomHome = (api,id) => {
    getApi(api).then(data => {
        let htmls='';
        data.slice(0,8).forEach(item => {
            htmls += `<div class="col-xl-3 col-lg-3 col-md-6 col-6">
            <a href="/thong-tin-phong?id=${item.id}" class="item">
                <img src="/photos/${item.image}" alt="">
                <h4>${item.price} Triệu/Tháng</h4>
                <h5>${item.dientich}m<sup>2</sup></h5>
                <p style="text-align: center">${item.address}</p>
            </a>
        </div>`
        });
        const divRoomHome = document.querySelector(`#${id}`);
        divRoomHome.innerHTML = htmls;
    });
}

drawIteamRoomHome(`${API_ROOM}?keyword=cầu giấy`,`cau-giay`);
drawIteamRoomHome(`${API_ROOM}?keyword=thanh xuân`,`thanh-xuan`);
drawIteamRoomHome(`${API_ROOM}?keyword=hà đông`,`ha-dong`);
drawIteamRoomHome(`${API_ROOM}?keyword=ba đình`,`ba-dinh`);
drawIteamRoomHome(`${API_ROOM}?keyword=tây hồ`,`tay-ho`);
drawIteamRoomHome(`${API_ROOM}?keyword=đống đa`,`dong-da`);
drawIteamRoomHome(`${API_ROOM}?keyword=từ liêm`,`tu-liem`);
drawIteamRoomHome(`${API_ROOM}?keyword=hai bà trưng`,`hai-ba-trung`);

