package com.course.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.model.Specialisation;


public interface SpecialisationRepository extends JpaRepository<Specialisation, Long> {
}

