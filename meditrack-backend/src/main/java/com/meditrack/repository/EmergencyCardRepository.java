package com.meditrack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meditrack.entity.EmergencyCard;


public interface EmergencyCardRepository extends JpaRepository<EmergencyCard, Long>
{

	Optional<EmergencyCard> findByQrToken(String token);

	Optional<EmergencyCard> findByPatientId(Long id);

}
