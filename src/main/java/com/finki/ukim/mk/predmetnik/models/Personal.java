package com.finki.ukim.mk.predmetnik.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Personal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;

	@ManyToOne
	private Student owner;

	@ManyToMany
	private List<Course> personalCourses;

	public Personal() {}

	public Personal(Student owner, List<Course> personalCourses) {
		this.owner = owner;
		this.personalCourses = personalCourses;
	}
}
