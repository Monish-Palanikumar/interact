package com.hcl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "experience")
	private Integer experience;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "grade_preference")
	private Integer gradePreference;

	@Column(name = "board_preference")
	private String boardPreference;

	@Column(name = "subject_preference")
	private String subjectPreference;

	@Column(name = "about")
	private String about;

	@Column(name = "rating")
	private Float rating;

	@Column(name = "availability")
	private String availability;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Integer getGradePreference() {
		return gradePreference;
	}

	public void setGradePreference(Integer gradePreference) {
		this.gradePreference = gradePreference;
	}

	public String getBoardPreference() {
		return boardPreference;
	}

	public void setBoardPreference(String boardPreference) {
		this.boardPreference = boardPreference;
	}

	public String getSubjectPreference() {
		return subjectPreference;
	}

	public void setSubjectPreference(String subjectPreference) {
		this.subjectPreference = subjectPreference;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", experience=" + experience + ", contactNumber="
				+ contactNumber + ", gradePreference=" + gradePreference + ", boardPreference=" + boardPreference
				+ ", subjectPreference=" + subjectPreference + ", about=" + about + ", rating=" + rating
				+ ", availability=" + availability + ", username=" + username + ", password=" + password + "]";
	}

}
