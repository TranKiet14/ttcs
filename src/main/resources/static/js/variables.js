export let params = {
    keyword: '',
    min: '',
    max: '',
}
export const urlParams = new URLSearchParams(window.location.search);
const pathUrl = window.location.pathname;
export const endpoint = pathUrl.split('/').pop();


