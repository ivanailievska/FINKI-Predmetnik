package com.finki.ukim.mk.predmetnik.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
