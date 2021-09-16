package fr.humanbooster.fx.katchaka.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.katchaka.business.Ville;
import fr.humanbooster.fx.katchaka.dao.VilleDao;
import fr.humanbooster.fx.katchaka.service.VilleService;

// On indique à Spring que cette classe appartient à la couche de service
@Service
public class VilleServiceImpl implements VilleService {

	// Ce service a besoin d'une DAO
	private VilleDao villeDao;
	
	// Constructeur qui va provoquer une injection de dépendance
	// La dépendance est villeDao
	// Spring va tout d'abord instancier un objet de type VilleDao
	// avant d'instancier un objet de type VilleService
	public VilleServiceImpl(VilleDao villeDao) {
		super();
		this.villeDao = villeDao;
	}


	@Override
	public Ville ajouterVille(String nom) {
		return villeDao.save(new Ville(nom));
	}


	@Override
	public List<Ville> recupererVilles() {
		return villeDao.findAll();
	}

	@Override
	public Ville recupererVilleParNom(String nom) {
		return villeDao.findByNom(nom);
	}

	@Override
	public List<Ville> recupererVilles(String filtre) {
		return villeDao.findByNomContaining(filtre);
	}

}