package com.hb.val.katchakaVal.business;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "vie_commune")
@Entity
public class VieCommune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private static final int NB_CREDITS_PAR_DEFAUT = 0;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private int nbCredits;

    @OneToOne(mappedBy = "vieCommune", orphanRemoval = true)
    private Invitation invitation;

    @OneToMany(mappedBy = "vieCommune", orphanRemoval = true)
    private List<Message> messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public VieCommune() {
    }

    public Invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

    public int getNbCredits() {
        return nbCredits;
    }

    public void setNbCredits(int nbCredits) {
        this.nbCredits = nbCredits;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VieCommune{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", nbCredits=" + nbCredits +
                ", invitation=" + invitation +
                '}';
    }
}