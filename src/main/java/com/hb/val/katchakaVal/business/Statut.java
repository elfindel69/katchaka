package com.hb.val.katchakaVal.business;

import javax.persistence.*;
import java.util.List;

@Table(name = "statut")
@Entity
public class Statut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy="statut", orphanRemoval = true)
    private List<Personne> personnes;

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    public Statut() {
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
        return "Statut{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}