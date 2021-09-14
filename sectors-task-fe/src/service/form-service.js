import axios from "axios";

const API_URL = 'http://localhost:8080/api/form';

class FormService {

    saveForm(username, sectorId, agreeToTerm) {
        return axios.post(API_URL, {
            username,
            sectorId,
            agreeToTerm
        })
    }

    updateForm(id, username, sectorId, agreeToTerm) {
        return axios.put(API_URL + '/' + id, {
            username,
            sectorId,
            agreeToTerm
        })
    }
}

export default new FormService;

