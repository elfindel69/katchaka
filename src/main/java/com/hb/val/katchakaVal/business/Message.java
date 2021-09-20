package com.hb.val.katchakaVal.business;

import javax.persistence.*;
import java.util.Date;

@Table(name = "message")
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenu;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnvoi;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLecture;

    @ManyToOne
    private Personne expediteur;

    @ManyToOne
    private Personne destinataire;

    @ManyToOne
    private VieCommune vieCommune;

    public VieCommune getVieCommune() {
        return vieCommune;
    }

    public void setVieCommune(VieCommune vieCommune) {
        this.vieCommune = vieCommune;
    }

    public Message() {
    }

    public Personne getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Personne destinataire) {
        this.destinataire = destinataire;
    }

    public Personne getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(Personne expediteur) {
        this.expediteur = expediteur;
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

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", contenu='" + contenu + '\'' +
                ", dateEnvoi=" + dateEnvoi +
                ", dateLecture=" + dateLecture +
                ", expediteur=" + expediteur +
                ", destinataire=" + destinataire +
                ", vieCommune=" + vieCommune +
                '}';
    }
}