package com.vstu.msgproj.webui.repository;

import com.vstu.msgproj.webui.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}
