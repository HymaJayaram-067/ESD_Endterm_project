import React, { useState } from "react";
import { createOrUpdateCourse } from "../services/courseService";

const CourseForm = ({ specialisationId, refreshCourses }) => {
  const [courseName, setCourseName] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const newCourse = { name: courseName };
    try {
      await createOrUpdateCourse(newCourse);
      refreshCourses(); // Refresh the course list
      setCourseName(""); // Reset the form
    } catch (error) {
      console.error("Error creating course:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        value={courseName}
        onChange={(e) => setCourseName(e.target.value)}
        placeholder="Course Name"
      />
      <button type="submit">Add Course</button>
    </form>
  );
};

export default CourseForm;
