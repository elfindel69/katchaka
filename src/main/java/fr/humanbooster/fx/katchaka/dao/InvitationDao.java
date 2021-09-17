package fr.humanbooster.fx.katchaka.dao;

import fr.humanbooster.fx.katchaka.business.Invitation;
import fr.humanbooster.fx.katchaka.business.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvitationDao extends JpaRepository<Invitation,Long> {
    List<Invitation> findAllByExpediteur(Personne personne);
    List<Invitation> findAllByDestinataire(Personne personne);
}
