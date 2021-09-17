package fr.humanbooster.fx.katchaka.service;


import fr.humanbooster.fx.katchaka.business.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PersonneService {

    Personne enregisterPersonne(Personne personne);

    List<Personne> recupererPersonnes();

    List<Personne> recupererPersonnesParVille(Ville nom);

    List<Personne> recupererPersonnes(String email);

    List<Personne> recupererPersonnesParPseudo(String pseudo);

    List<Personne> recupererPersonnes(Ville ville, Genre genre, Statut statut, Date dateDebut, Date dateFin);

    List<Personne> recupererPersonnes(Ville ville, Genre genre, Statut statut);

    List<Personne> recupererPersonnes(List<Ville> villes, Genre genre, Statut statut, Date dateDebut, Date dateFin,
                                      Interet interet);

    List<Personne> recupererPersonnesParInteretDesc();

    List<Personne> recupererPersonnes(Ville ville);

    Page<Personne> recupererPersonnesParPseudoFilter(String filter,Pageable pageable);

    Personne recupererPersonneParId(Long id);

    boolean supprimerPersonne(Long id);

    Personne recupererPersonne(String email, String password);


}
