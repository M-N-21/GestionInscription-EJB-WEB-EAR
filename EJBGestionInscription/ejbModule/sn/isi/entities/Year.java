package sn.isi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Year implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "year")
	private List<Inscription> inscriptions = new ArrayList<Inscription>();
	public Year() {
		super();
	}
	public Year(int id, String name, List<Inscription> inscriptions) {
		super();
		this.id = id;
		this.name = name;
		this.inscriptions = inscriptions;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName();
	}
}
