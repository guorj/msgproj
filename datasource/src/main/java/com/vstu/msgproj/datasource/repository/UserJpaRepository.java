package com.vstu.msgproj.datasource.repository;


import com.vstu.msgproj.datasource.model.UserVisitInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserVisitInfo, Long> {
}
