import React from "react";

const CourseList = ({ courses, specialisationId, refreshCourses }) => {
  return (
    <div>
      <h2>Courses for Specialisation</h2>
      <ul>
        {courses.map((course) => (
          <li key={course.id}>
            <span>{course.name}</span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CourseList;
