import { drawRoom } from "./drawRoom.js";
import { endpoint } from "./variables.js";
import { drawItemRoom } from "./drawItemRoom.js";
const drawMyRoom = () =>{
    let api = `/api/rooms`;
    drawItemRoom(api);
}
const showMylistRoom = () =>{
    if(endpoint == 'phong-cua-toi'){
        drawMyRoom();
    }
}

showMylistRoom();