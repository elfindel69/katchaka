package com.hb.val.katchakaVal.business;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private static final int NB_CREDITS_INITIAL = 0;

    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "le pseudo doit contenir que des caractères alphanumériques")
    private String pseudo;

    @Min(value=5, message="le mot de passe doit contenir au moins 5 caractères")
    private String motDePasse;

    @Email(message = "l'email doit être au bon format")
    @NotBlank(message = "l'email doit être renseigné")
    private String email;

    @Temporal(TemporalType.DATE)
    @Past(message="la date de naissance doit être dans le passé")
    private Date dateDeNaissance;

    @Lob
    @Min(value=20, message = "la bio doit faire au moins 20 caractères")
    private String bio;

    private int nbCredits;

    private boolean estFumeur;

    @ManyToMany
    @NotNull(message = "au moins un intérêt doit être renseigné")
    private List<Interet> interets;

    @ManyToOne
    @NotNull(message="la ville doit être renseignée")
    private Ville ville;

    @ManyToOne
    @NotNull(message="le statut doit être renseigné")
    private Statut statut;

    @ManyToOne
    @NotNull(message="le genre doit être renseigné")
    private Genre genre;

    @ManyToOne
    @NotNull(message="le genre recherché doit être renseigné")
    private Genre genreRecherche;

    @OneToMany(mappedBy = "expediteur", orphanRemoval = true)
    private List<Message> messagesRecus;

    @OneToMany(mappedBy = "destinataire", orphanRemoval = true)
    private List<Message> messagesEnvoyes;

    public Personne() {
    }

    public List<Message> getMessagesEnvoyes() {
        return messagesEnvoyes;
    }

    public void setMessagesEnvoyes(List<Message> messagesEnvoyes) {
        this.messagesEnvoyes = messagesEnvoyes;
    }

    public List<Message> getMessagesRecus() {
        return messagesRecus;
    }

    public void setMessagesRecus(List<Message> messagesRecus) {
        this.messagesRecus = messagesRecus;
    }

    public Genre getGenreRecherche() {
        return genreRecherche;
    }

    public void setGenreRecherche(Genre genreRecherche) {
        this.genreRecherche = genreRecherche;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public List<Interet> getInterets() {
        return interets;
    }

    public void setInterets(List<Interet> interets) {
        this.interets = interets;
    }

    public boolean getEstFumeur() {
        return estFumeur;
    }

    public void setEstFumeur(boolean estFumeur) {
        this.estFumeur = estFumeur;
    }

    public int getNbCredits() {
        return nbCredits;
    }

    public void setNbCredits(int nbCredits) {
        this.nbCredits = nbCredits;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", email='" + email + '\'' +
                ", dateDeNaissance=" + dateDeNaissance +
                ", bio='" + bio + '\'' +
                ", nbCredits=" + nbCredits +
                ", estFumeur=" + estFumeur +
                ", ville=" + ville +
                ", statut=" + statut +
                ", genre=" + genre +
                ", genreRecherche=" + genreRecherche +
                '}';
    }
}