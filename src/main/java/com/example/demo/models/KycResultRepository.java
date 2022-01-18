package com.example.demo.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface KycResultRepository extends JpaRepository<KycResult, String> {
	Optional<KycResult> findByToken(String token);
	String deleteByToken(String token);	
}