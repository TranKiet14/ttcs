import { getApi } from "./api.js"
export const drawRoomInfo = (api) =>{
    getApi(api).then(item => {
        let htmls='';
            htmls += `<div class="col-9">
            <div class="inner-two">
                <div class="title">Thông tin phòng</div>
            </div>
            <div class="row">
                <div class="col-6">
                    <img src="/photos/${item.image}" alt="" style="width: 100%;max-height: 300px;object-fit: cover; border-radius: 10px;">
                </div>
                <div class="col-6">
                    <div class="infor-room">
                        <div class="address">
                            <i class="fa-solid fa-location-dot"></i> ${item.address}
                        </div>
                        <div class="price">
                            <i class="fa-solid fa-comment-dollar"></i> ${item.price} triệu
                        </div>
                        <div class="dientich">
                            Diện tích: ${item.dientich}m<sup>2</sup>
                        </div>
                        <div class="type">
                            ${item.type}
                        </div>
                        <a href="${item.linkImages}" target="_blank" style="color: rgb(62, 26, 205);">Ảnh và video chi tiết</a>
                    </div>
                </div>
                <div class="col-12">
                    <div class="infor-room">
                        <div class="noithat">${item.noithat}</div>
                        <div class="dichvu">${item.dichvu}</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-3">
            <div class="inner-one">
                <div class="owner">
                    <div class="avatar">
                        <img src="/assets/images/Facebook-Avatar_3.png" alt="">
                    </div>
                    <p>${item.client.name}</p>
                    <div class="phone">
                        <i class="fa-solid fa-phone"></i>
                        <span>${item.client.phone}</span>
                    </div>
                </div>
            </div>
        </div>`
        const divRoomInfo = document.querySelector("#room-info");
        divRoomInfo.innerHTML=htmls;
    });
}