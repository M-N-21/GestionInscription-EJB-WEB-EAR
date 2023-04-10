package sn.isi.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Inscription implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String details;
    @ManyToOne
    Student student = new Student();
    @ManyToOne
    Year year = new Year();
    @ManyToOne
    Cours cours = new Cours();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	public Inscription(int id, String details, Student student, Year year, Cours cours) {
		super();
		this.id = id;
		this.details = details;
		this.student = student;
		this.year = year;
		this.cours = cours;
	}
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
