package fr.humanbooster.fx.katchaka.business;

import java.util.List;

import javax.persistence.*;

@Entity
public class Interet {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nom;
    
    @ManyToMany(mappedBy="interets")
    private List<Personne> personnes;

    public Interet() {
    }

    public Interet(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    @Override
    public String toString() {
        return "Interet{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}