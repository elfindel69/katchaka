package com.hb.val.katchakaVal.dao;

import com.hb.val.katchakaVal.business.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationDao extends JpaRepository<Invitation,Long> {
}
