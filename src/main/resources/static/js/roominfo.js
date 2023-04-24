import { API_ROOM_INFO } from "./constant.js";
import { drawRoomInfo } from "./drawRoomInfo.js";
import { urlParams } from "./variables.js";

let Idroom = urlParams.get('id');
let api = `${API_ROOM_INFO}?id=${Idroom}`;
drawRoomInfo(api);