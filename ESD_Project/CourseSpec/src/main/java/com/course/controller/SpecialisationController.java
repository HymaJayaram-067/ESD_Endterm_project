package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.Course;
import com.course.model.Specialisation;
import com.course.service.CourseService;
import com.course.service.SpecialisationService;

@RestController
@RequestMapping("/api/specialisations")
public class SpecialisationController {

    @Autowired
    private SpecialisationService specialisationService;

    @Autowired
    private CourseService courseService;

    // Create or Update Specialisation
    @PostMapping("/createUpdateSpecialisation")
    public ResponseEntity<Specialisation> createOrUpdateSpecialisation(@RequestBody Specialisation specialisation) {
        Specialisation savedSpecialisation = specialisationService.createOrUpdateSpecialisation(specialisation);
        return ResponseEntity.ok(savedSpecialisation);
    }

    // Get all Specialisations
    @GetMapping("/findAllSpecialisations")
    public ResponseEntity<List<Specialisation>> getAllSpecialisations() {
        List<Specialisation> specialisations = specialisationService.getAllSpecialisations();
        return specialisations.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(specialisations);
    }

    // Get Specialisation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Specialisation> getSpecialisationById(@PathVariable Long id) {
        Specialisation specialisation = specialisationService.getSpecialisationById(id);
        return ResponseEntity.ok(specialisation);
    }

    // Delete Specialisation by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialisation(@PathVariable Long id) {
        specialisationService.deleteSpecialisation(id);
        return ResponseEntity.noContent().build();
    }

    // Add a course to Specialisation
    @PostMapping("/{specialisationId}/courses/{courseId}")
    public ResponseEntity<Specialisation> addCourseToSpecialisation(@PathVariable Long specialisationId,
            @PathVariable Long courseId) {
        Specialisation updatedSpecialisation = specialisationService.addCourseToSpecialisation(specialisationId, courseId);
        return updatedSpecialisation != null 
            ? ResponseEntity.ok(updatedSpecialisation)
            : ResponseEntity.notFound().build();
    }

    // Get Courses by Specialisation ID
    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> getCoursesBySpecialisation(@PathVariable Long id) {
        List<Course> courses = specialisationService.getCoursesBySpecialisation(id);
        return courses != null && !courses.isEmpty() 
            ? ResponseEntity.ok(courses)
            : ResponseEntity.noContent().build();
    }

    // Create or Update Multiple Courses
    @PostMapping("/createUpdateCourses")
    public ResponseEntity<List<Course>> createOrUpdateCourses(@RequestBody List<Course> courses) {
        List<Course> savedCourses = courseService.createOrUpdateCourses(courses);
        return ResponseEntity.ok(savedCourses);
    }

    // Create or Update Specialisation with Courses
    @PostMapping("/createUpdateSpecialisationWithCourses")
    public ResponseEntity<Specialisation> createOrUpdateSpecialisationWithCourses(
            @RequestBody Specialisation specialisation) {
        Specialisation savedSpecialisation = specialisationService.createOrUpdateSpecialisationWithCourses(specialisation);
        return ResponseEntity.ok(savedSpecialisation);
    }

    // Create or Update Multiple Specialisations
    @PostMapping("/createUpdateSpecialisations")
    public ResponseEntity<List<Specialisation>> createOrUpdateSpecialisations(@RequestBody List<Specialisation> specialisations) {
        List<Specialisation> savedSpecialisations = specialisationService.createOrUpdateSpecialisations(specialisations);
        return ResponseEntity.ok(savedSpecialisations);
    }

    // Create or Update Course
    @PostMapping("/createUpdateCourse")
    public ResponseEntity<Course> createOrUpdateCourse(@RequestBody Course course) {
        Course savedCourse = courseService.createOrUpdateCourse(course);
        return ResponseEntity.ok(savedCourse);
    }

    // Delete Course by ID under a specific Specialisation
    @DeleteMapping("/{specialisationId}/courses/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long specialisationId, @PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }
}
