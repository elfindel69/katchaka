package fr.humanbooster.fx.katchaka.business;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class VieCommune {
    
    private static final int NB_CREDITS_PAR_DEFAUT = 10;
    
    // Determine quell est la clé primaire de la table
    @Id
    
    // L'annotation ci-dessous ajoute un auto-incrément sur la collone id VieCommune
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    private int nbCredits;
    
    // Tous les messages échangés pendant la vie commune
    @OneToMany(mappedBy="vieCommune")
    private List<Message> messages;
    
    @OneToOne
    private Invitation invitation;

    public VieCommune() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbCredits() {
        return nbCredits;
    }

    public void setNbCredits(int nbCredits) {
        this.nbCredits = nbCredits;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
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