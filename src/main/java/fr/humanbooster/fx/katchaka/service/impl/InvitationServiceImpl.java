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
    public Invitation accepterInvitation(Long id) {
        return updateInvitation(id,true);
    }

    @Override
    public Invitation declinerInvitation(Long id) {
        return updateInvitation(id,false);
    }

    private Invitation updateInvitation(Long id,boolean estAcceptee) {
        Invitation invitation = recupererInvitation(id);
        if(invitation == null){
            return null;
        }else{
            if(estAcceptee){
                System.out.println("acceptée");
                invitation.setEstAccepte(true);
            }
            System.out.println("test3");
            invitation.setDateLecture(new Date());
           invitation =  invitationDao.save(invitation);
           if(invitation == null){
               System.out.println(false);
               return null;
           }else {
               System.out.println(true);
               return invitation;
           }
        }
    }

    public Invitation recupererInvitation(Long id) {
        return invitationDao.findById(id).orElse(null);
    }

    @Override
    public Invitation inviter(Long expediteurId, Long destinataireId) {
        Invitation invitation = new Invitation(personneService.recupererPersonneParId(expediteurId),personneService.recupererPersonneParId(destinataireId));
        return invitationDao.save(invitation);
    }
}
