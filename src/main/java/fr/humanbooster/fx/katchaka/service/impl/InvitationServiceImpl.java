package fr.humanbooster.fx.katchaka.service.impl;

import fr.humanbooster.fx.katchaka.business.Invitation;
import fr.humanbooster.fx.katchaka.business.Personne;
import fr.humanbooster.fx.katchaka.dao.InvitationDao;

import fr.humanbooster.fx.katchaka.service.InvitationService;
import fr.humanbooster.fx.katchaka.service.PersonneService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InvitationServiceImpl implements InvitationService {
    private final InvitationDao invitationDao;
    private final PersonneService personneService;

    public InvitationServiceImpl(InvitationDao invitationDao, PersonneService personneService) {
        this.invitationDao = invitationDao;
        this.personneService = personneService;
    }

    @Override
    public List<Invitation> recupererInvitationsEnvoyees(Personne personne) {
        return invitationDao.findAllByExpediteur(personne);
    }

    @Override
    public List<Invitation> recupererInvitationsRecues(Personne personne) {
        return invitationDao.findAllByDestinataire(personne);
    }

    @Override
    public boolean accepterInvitation(Long id) {
        return updateInvitation(id,true);
    }

    @Override
    public boolean declinerInvitation(Long id) {
        return updateInvitation(id,false);
    }

    private boolean updateInvitation(Long id,boolean estAcceptee) {
        Invitation invitation = recupererInvitation(id);
        if(invitation == null){
            return false;
        }else{
            if(estAcceptee){
                invitation.setEstAccepte(true);
            }
            invitation.setDateLecture(new Date());
           invitation =  invitationDao.save(invitation);
           if(invitation == null){
               return false;
           }else {
               return true;
           }
        }
    }

    public Invitation recupererInvitation(Long id) {
        return invitationDao.findById(id).orElse(null);
    }

    @Override
    public Invitation inviter(Long expediteurId, Long destinataireId) {
        Invitation invitation = new Invitation();

       invitation.setExpediteur(personneService.recupererPersonneParId(expediteurId));
      invitation.setDestinataire(personneService.recupererPersonneParId(destinataireId));
        return invitationDao.save(invitation);
    }
}
