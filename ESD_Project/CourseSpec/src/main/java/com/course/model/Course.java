package com.course.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Long courseId;
	@Column(name = "course_code", unique = true, nullable = false)
	private String courseCode;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private int year;
	@Column
	private String term;
	@Column
	private String faculty;
	@Column
	private int credits;
	@Column
	private int capacity;
	@ManyToMany(mappedBy = "courses")
	private List<Specialisation> specialisations;

	
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Specialisation> getSpecialisations() {
		return specialisations;
	}

	public void setSpecialisations(List<Specialisation> specialisations) {
		this.specialisations = specialisations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacity, courseCode, courseId, credits, description, faculty, name, specialisations, term,
				year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return capacity == other.capacity && Objects.equals(courseCode, other.courseCode)
				&& Objects.equals(courseId, other.courseId) && credits == other.credits
				&& Objects.equals(description, other.description) && Objects.equals(faculty, other.faculty)
				&& Objects.equals(name, other.name) && Objects.equals(specialisations, other.specialisations)
				&& Objects.equals(term, other.term) && year == other.year;
	}

}
