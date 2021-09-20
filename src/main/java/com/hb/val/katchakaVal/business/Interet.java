package com.hb.val.katchakaVal.business;

import javax.persistence.*;
import java.util.List;

@Table(name = "interet")
@Entity
public class Interet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @ManyToMany(mappedBy="interets")
    private List<Personne> personnes;

    public Interet() {
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Interet{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}