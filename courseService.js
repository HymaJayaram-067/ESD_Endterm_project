import axios from "axios";

const API_URL = "http://localhost:8080/api/specialisations"; // Your backend URL

export const getCoursesBySpecialisation = (specialisationId) => {
  return axios.get(`${API_URL}/${specialisationId}/courses`);
};

export const addCourseToSpecialisation = (specialisationId, courseId) => {
  return axios.post(`${API_URL}/${specialisationId}/courses/${courseId}`);
};

export const createOrUpdateCourse = (course) => {
  return axios.post(`${API_URL}/createUpdateCourse`, course);
};
