import axios from "axios";

const baseURL="http://localhost:8080/api";

class BoxService {

    findAll = async () => {
        return await axios.get(baseURL+'/listboxes').then(res => res);
      };

      saveBox = async (data) => {
        return await axios.post(baseURL+'/addbox', data).then(res => res);
    };

}
export default BoxService;