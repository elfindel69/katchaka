package fr.humanbooster.fx.katchaka.service;


import fr.humanbooster.fx.katchaka.business.Invitation;
import fr.humanbooster.fx.katchaka.business.Personne;

import java.util.List;

public interface InvitationService {
    List<Invitation> recupererInvitationsEnvoyees(Personne personne);
    List<Invitation> recupererInvitationsRecues(Personne personne);

    Invitation accepterInvitation(Long id);
    Invitation declinerInvitation(Long id);
    Invitation recupererInvitation(Long id);
    Invitation inviter(Long expediteurId, Long destinataireId);
}
