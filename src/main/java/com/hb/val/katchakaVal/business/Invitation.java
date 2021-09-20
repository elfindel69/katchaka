package com.hb.val.katchakaVal.business;

import javax.persistence.*;
import java.util.Date;

@Table(name = "invitation")
@Entity
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnvoi;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLecture;

    @ManyToOne
    private Personne destinataire;

    @ManyToOne
    private Personne expediteur;

    @OneToOne(orphanRemoval = true)
    private VieCommune vieCommune;

    private boolean estAccepte;

    public boolean getEstAccepte() {
        return estAccepte;
    }

    public void setEstAccepte(boolean estAccepte) {
        this.estAccepte = estAccepte;
    }

    public Invitation() {
    }

    public VieCommune getVieCommune() {
        return vieCommune;
    }

    public void setVieCommune(VieCommune vieCommune) {
        this.vieCommune = vieCommune;
    }

    public Personne getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(Personne expediteur) {
        this.expediteur = expediteur;
    }

    public Personne getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Personne destinataire) {
        this.destinataire = destinataire;
    }

    public Date getDateLecture() {
        return dateLecture;
    }

    public void setDateLecture(Date dateLecture) {
        this.dateLecture = dateLecture;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Invitation{" +
                "id=" + id +
                ", dateEnvoi=" + dateEnvoi +
                ", dateLecture=" + dateLecture +
                ", destinataire=" + destinataire +
                ", expediteur=" + expediteur +
                ", vieCommune=" + vieCommune +
                ", estAccepte=" + estAccepte +
                '}';
    }
}