package com.hb.val.katchakaVal.business;

import javax.persistence.*;
import java.util.List;

@Table(name = "genre")
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy="genre",orphanRemoval = true)
    private List<Personne> personnes;

    @OneToMany(mappedBy = "genre", orphanRemoval = true)
    private List<Personne> personnesRecherchant;

    public List<Personne> getPersonnesRecherchant() {
        return personnesRecherchant;
    }

    public void setPersonnesRecherchant(List<Personne> personnesRecherchant) {
        this.personnesRecherchant = personnesRecherchant;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    public Genre() {
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
        return "Genre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}