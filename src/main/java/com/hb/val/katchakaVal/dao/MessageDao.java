package com.hb.val.katchakaVal.dao;

import com.hb.val.katchakaVal.business.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDao extends JpaRepository<Message,Long> {
}
