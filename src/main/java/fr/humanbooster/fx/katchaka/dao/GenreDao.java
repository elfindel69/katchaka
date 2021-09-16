package fr.humanbooster.fx.katchaka.dao;

import fr.humanbooster.fx.katchaka.business.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDao extends JpaRepository<Genre, Long> {
    Genre findByNom(String nom);
}
