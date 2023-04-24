import { drawItemRoom } from "./drawItemRoom.js";
import { params } from "./variables.js";
import { API_ROOM } from "./constant.js";
export const drawRoom = () =>{
    let api = `${API_ROOM}?keyword=${params.keyword}`;
        if (params.min !== null) {
            api += `&minprice=${params.min}`;
        }
        if (params.max !== null) {
            api += `&maxprice=${params.max}`;
        }
    api = api.replace(/&minprice=&maxprice=/g, '');
    drawItemRoom(api);
}