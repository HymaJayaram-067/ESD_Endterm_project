import axios from "axios";

const API_URL = "http://localhost:8080/api/specialisations"; // Your backend URL

export const getAllSpecialisations = () => {
  return axios.get(`${API_URL}/findAllSpecialisations`);
};

export const createOrUpdateSpecialisation = (specialisation) => {
  return axios.post(`${API_URL}/createUpdateSpecialisation`, specialisation);
};
