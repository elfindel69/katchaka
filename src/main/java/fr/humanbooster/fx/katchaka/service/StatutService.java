package fr.humanbooster.fx.katchaka.service;


import fr.humanbooster.fx.katchaka.business.Statut;

import java.util.List;

public interface StatutService {
    Statut ajouterStatut(String nom);

    List<Statut> recupererStatuts();

    Statut recupererStatut(String nom);

    Statut recupererStatut(Long id);
}
