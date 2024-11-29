package com.course.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.model.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByCourseCode(String courseCode);
}

