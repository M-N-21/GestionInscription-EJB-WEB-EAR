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
public class Cours implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String programme;
    @OneToMany(mappedBy = "cours")
	private List<Inscription> inscriptions = new ArrayList<Inscription>();
	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cours(int id, String name, String programme, List<Inscription> inscriptions) {
		super();
		this.id = id;
		this.name = name;
		this.programme = programme;
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
	public String getProgramme() {
		return programme;
	}
	public void setProgramme(String programme) {
		this.programme = programme;
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
