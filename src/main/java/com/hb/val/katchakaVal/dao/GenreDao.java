package com.hb.val.katchakaVal.dao;

import com.hb.val.katchakaVal.business.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDao extends JpaRepository<Genre, Long> {
}
