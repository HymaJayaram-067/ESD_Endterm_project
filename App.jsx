import React, { useEffect, useState } from "react";
import SpecialisationForm from "./components/SpecialisationForm";
import SpecialisationList from "./components/SpecialisationList";
import CourseForm from "./components/CourseForm";
import CourseList from "./components/CourseList";
import { getAllSpecialisations } from "./services/specialisationService";
import { getCoursesBySpecialisation } from "./services/courseService";

const App = () => {
  const [specialisations, setSpecialisations] = useState([]);
  const [selectedSpecialisationId, setSelectedSpecialisationId] = useState(null);
  const [courses, setCourses] = useState([]);

  const fetchSpecialisations = async () => {
    try {
      const response = await getAllSpecialisations();
      setSpecialisations(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const fetchCourses = async (specialisationId) => {
    try {
      const response = await getCoursesBySpecialisation(specialisationId);
      setCourses(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    fetchSpecialisations();
  }, []);

  useEffect(() => {
    if (selectedSpecialisationId) {
      fetchCourses(selectedSpecialisationId);
    }
  }, [selectedSpecialisationId]);

  return (
    <div>
      <h1>Specialisation & Course Management</h1>
      <SpecialisationForm refreshSpecialisations={fetchSpecialisations} />
      <SpecialisationList
        specialisations={specialisations}
        onSelect={setSelectedSpecialisationId}
        refreshSpecialisations={fetchSpecialisations}
      />
      
      {selectedSpecialisationId && (
        <>
          <CourseForm
            specialisationId={selectedSpecialisationId}
            refreshCourses={() => fetchCourses(selectedSpecialisationId)}
          />
          <CourseList
            courses={courses}
            specialisationId={selectedSpecialisationId}
            refreshCourses={() => fetchCourses(selectedSpecialisationId)}
          />
        </>
      )}
    </div>
  );
};

export default App;
