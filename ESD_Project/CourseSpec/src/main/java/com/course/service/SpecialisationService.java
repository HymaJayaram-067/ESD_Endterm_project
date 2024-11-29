package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.Course;
import com.course.model.Specialisation;
import com.course.repo.CourseRepository;
import com.course.repo.SpecialisationRepository;
import com.course.handles.BadRequestException;
import com.course.handles.ResourceNotFoundException;

@Service
public class SpecialisationService {

    @Autowired
    private SpecialisationRepository specialisationRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;  // Autowired CourseService for course-related operations

    // Create or Update Specialisation
    public Specialisation createOrUpdateSpecialisation(Specialisation specialisation) {
        if (specialisation.getCode() == null || specialisation.getCode().isEmpty()) {
            throw new BadRequestException("Specialisation code cannot be empty.");
        }
        return specialisationRepository.save(specialisation);
    }

    // Create or Update Specialisation with Courses
    public Specialisation createOrUpdateSpecialisationWithCourses(Specialisation specialisation) {
        if (specialisation.getCode() == null || specialisation.getCode().isEmpty()) {
            throw new BadRequestException("Specialisation code cannot be empty.");
        }

        // Check if courses are provided, and add them to the specialisation
        if (specialisation.getCourses() != null) {
            for (Course course : specialisation.getCourses()) {
                courseService.createOrUpdateCourse(course); // Ensure each course is created or updated
            }
        }
        return specialisationRepository.save(specialisation);
    }

    // Create or Update Multiple Specialisations
    public List<Specialisation> createOrUpdateSpecialisations(List<Specialisation> specialisations) {
        for (Specialisation specialisation : specialisations) {
            if (specialisation.getCode() == null || specialisation.getCode().isEmpty()) {
                throw new BadRequestException("Specialisation code cannot be empty.");
            }
        }
        return specialisationRepository.saveAll(specialisations);
    }

    // Get all Specialisations
    public List<Specialisation> getAllSpecialisations() {
        return specialisationRepository.findAll();
    }

    // Get Specialisation by ID
    public Specialisation getSpecialisationById(Long id) {
        return specialisationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Specialisation not found with ID: " + id));
    }

    // Delete Specialisation by ID
    public void deleteSpecialisation(Long id) {
        if (!specialisationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Specialisation not found with ID: " + id);
        }
        specialisationRepository.deleteById(id);
    }

    // Add a course to a Specialisation
    public Specialisation addCourseToSpecialisation(Long specialisationId, Long courseId) {
        Specialisation specialisation = specialisationRepository.findById(specialisationId)
                .orElseThrow(() -> new ResourceNotFoundException("Specialisation not found with ID: " + specialisationId));
        
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + courseId));
        
        // Check if the course is already added to the specialisation to avoid duplication
        if (specialisation.getCourses().contains(course)) {
            throw new BadRequestException("Course is already added to this specialisation.");
        }

        specialisation.getCourses().add(course);
        specialisationRepository.save(specialisation);
        return specialisation;
    }

    // Get courses by Specialisation ID
    public List<Course> getCoursesBySpecialisation(Long specialisationId) {
        Specialisation specialisation = specialisationRepository.findById(specialisationId)
                .orElseThrow(() -> new ResourceNotFoundException("Specialisation not found with ID: " + specialisationId));
        
        return specialisation.getCourses();
    }
}
