package fr.humanbooster.fx.katchaka.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.katchaka.business.Statut;

import java.util.Optional;

public interface StatutDao extends JpaRepository<Statut, Long> {

    Statut findByNom(String nom);

}
