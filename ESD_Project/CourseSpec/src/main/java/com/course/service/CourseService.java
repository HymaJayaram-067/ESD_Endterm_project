package com.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.Course;
import com.course.repo.CourseRepository;
import com.course.handles.BadRequestException;
import com.course.handles.ResourceNotFoundException;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Create or Update a single Course
    public Course createOrUpdateCourse(Course course) {
        if (course.getCourseCode() == null || course.getCourseCode().isEmpty()) {
            throw new BadRequestException("Course code cannot be empty.");
        }
        return courseRepository.save(course);
    }

    // Create or Update Multiple Courses
    public List<Course> createOrUpdateCourses(List<Course> courses) {
        for (Course course : courses) {
            if (course.getCourseCode() == null || course.getCourseCode().isEmpty()) {
                throw new BadRequestException("Course code cannot be empty.");
            }
        }
        return courseRepository.saveAll(courses);
    }

    // Get Course by ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + id));
    }

    // Delete Course by ID
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Course not found with ID: " + id);
        }
        courseRepository.deleteById(id);
    }

    // Find Course by Code (Additional helper method)
    public Optional<Course> findByCourseCode(String courseCode) {
        return courseRepository.findByCourseCode(courseCode);
    }
}
