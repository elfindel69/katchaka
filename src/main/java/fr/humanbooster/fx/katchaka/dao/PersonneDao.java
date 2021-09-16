package fr.humanbooster.fx.katchaka.dao;

import fr.humanbooster.fx.katchaka.business.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PersonneDao extends JpaRepository<Personne, Long> {
    List<Personne> findByVille(Ville nom);

    List<Personne> findByEmail(String email);

    List<Personne> findByPseudo(String pseudo);

    List<Personne> findByVilleAndGenreAndStatut(Ville ville, Genre genre, Statut statut);

    List<Personne> findByVilleAndGenreAndStatutAndDateDeNaissanceBetween(Ville ville, Genre genre, Statut statut,
                                                                         Date dateDebut, Date dateFin);

    List<Personne> findByVilleInAndGenreAndStatutAndDateDeNaissanceBetweenAndInteretsContains(List<Ville> villes, Genre genre,
                                                                                        Statut statut, Date dateDebut,
                                                                                        Date dateFin, Interet interet);

    // Cette méthode est annnotée avec @Query
    // par défaut on doit trouver une requête HQL
    @Query("FROM Personne p WHERE p.invitationsEnvoyees is empty")
    List<Personne> findSansInvitation();

    // Cette méthode fait référence à une requête SQL
    @Query(value="SELECT * FROM personne where nb_credits>450 LIMIT 3", nativeQuery=true)
    List<Personne> findHighest3NbCredits();

    @Query("FROM Personne ORDER BY interets.size DESC ")
    List<Personne>findPersonnesByInteretsDesc();

    @Query("SELECT v.personnes FROM Ville v WHERE v=:ville")
    List<Personne> findPersonnesByVille(@Param("ville") Ville ville);

    Page<Personne> findPersonnesByPseudoContaining(String filter, Pageable pageable);
}
