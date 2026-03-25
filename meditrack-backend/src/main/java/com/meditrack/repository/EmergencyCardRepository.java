package com.meditrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meditrack.entity.EmergencyCard;


public interface EmergencyCardRepository extends JpaRepository<EmergencyCard, Long>
{

}
