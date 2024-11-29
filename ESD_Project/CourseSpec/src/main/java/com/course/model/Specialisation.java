package com.course.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="specialisation")
public class Specialisation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="specialisation_id",unique = true, nullable = false)
	private Long specialisationId;

	@Column(name="code",unique = true, nullable = false)
	private String code;

	@Column
	private String name;
	@Column
	private String description;
	@Column
	private int year;
	@Column
	private int creditsRequired;

	@ManyToMany
	@JoinTable(name = "specialisation_course", joinColumns = @JoinColumn(name = "specialisation_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;

	public Specialisation() {
		super();
	}

	public Specialisation(Long specialisationId, String code, String name, String description, int year,
			int creditsRequired, List<Course> courses) {
		super();
		this.specialisationId = specialisationId;
		this.code = code;
		this.name = name;
		this.description = description;
		this.year = year;
		this.creditsRequired = creditsRequired;
		this.courses = courses;
	}

	public Long getSpecialisationId() {
		return specialisationId;
	}

	public void setSpecialisationId(Long specialisationId) {
		this.specialisationId = specialisationId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public int getCreditsRequired() {
		return creditsRequired;
	}

	public void setCreditsRequired(int creditsRequired) {
		this.creditsRequired = creditsRequired;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, courses, creditsRequired, description, name, specialisationId, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Specialisation other = (Specialisation) obj;
		return Objects.equals(code, other.code) && Objects.equals(courses, other.courses)
				&& creditsRequired == other.creditsRequired && Objects.equals(description, other.description)
				&& Objects.equals(name, other.name) && Objects.equals(specialisationId, other.specialisationId)
				&& year == other.year;
	}

}
