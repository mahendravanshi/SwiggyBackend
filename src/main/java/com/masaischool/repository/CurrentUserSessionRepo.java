package com.masaischool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masaischool.model.CurrentUserSession;

@Repository
public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession, Integer> {
	
	public Optional<CurrentUserSession> findByUuid(String uuid);

	
}
