package fr.humanbooster.fx.katchaka.service;


import fr.humanbooster.fx.katchaka.business.Interet;

import java.util.List;

public interface InteretService {
    Interet ajouterInteret(String nom);

    List<Interet> recupererInterets();

    List<Interet> recupererInterets(String filtre);

    Interet recupererInteret(String nom);
}
