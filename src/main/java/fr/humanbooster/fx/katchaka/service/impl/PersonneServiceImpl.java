package fr.humanbooster.fx.katchaka.service.impl;

import fr.humanbooster.fx.katchaka.business.*;
import fr.humanbooster.fx.katchaka.dao.PersonneDao;
import fr.humanbooster.fx.katchaka.service.PersonneService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonneServiceImpl implements PersonneService {

    private PersonneDao personneDao;

    public PersonneServiceImpl(PersonneDao personneDao) {
        this.personneDao = personneDao;
    }

    @Override
    public Personne ajouterPersonne(Personne personne) {
        return personneDao.save(personne);
    }

    @Override
    public List<Personne> recupererPersonnes() {
        return personneDao.findAll();
    }

    @Override
    public List<Personne> recupererPersonnesParVille(Ville nom) {
        return personneDao.findByVille(nom);
    }

    @Override
    public List<Personne> recupererPersonnes(String email) {
        return personneDao.findByEmail(email);
    }

    @Override
    public List<Personne> recupererPersonnesParPseudo(String pseudo) {
        return personneDao.findByPseudo(pseudo);
    }


    @Override
    public List<Personne> recupererPersonnes(Ville ville, Genre genre, Statut statut) {
        return personneDao.findByVilleAndGenreAndStatut(ville, genre, statut);
    }

    @Override
    public List<Personne> recupererPersonnes(List<Ville> villes, Genre genre, Statut statut, Date dateDebut, Date dateFin,
                                             Interet interet) {
        return personneDao.findByVilleInAndGenreAndStatutAndDateDeNaissanceBetweenAndInteretsContains(villes, genre, statut,
                dateDebut, dateFin, interet);
    }

    @Override
    public List<Personne> recupererPersonnesParInteretDesc() {
        return personneDao.findPersonnesByInteretsDesc();
    }

    @Override
    public List<Personne> recupererPersonnes(Ville ville) {
        return personneDao.findPersonnesByVille(ville);
    }

    @Override
    public List<Personne> recupererPersonnes(Ville ville, Genre genre, Statut statut, Date dateDebut, Date dateFin) {
        return personneDao.findByVilleAndGenreAndStatutAndDateDeNaissanceBetween(ville, genre, statut,dateDebut,dateFin);
    }

    @Override
    public Page<Personne> recupererPersonnesParPseudoFilter(String filter, Pageable pageable){
        return personneDao.findPersonnesByPseudoContaining(filter,pageable);
    }

    @Override
    public Personne recupererPersonneParId(Long id) {
        return personneDao.findById(id).orElse(null);
    }

}
