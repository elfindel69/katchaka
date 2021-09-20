package com.hb.val.katchakaVal.dao;

import com.hb.val.katchakaVal.business.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneDao extends JpaRepository<Personne,Long> {
}
