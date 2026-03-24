package com.meditrack_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meditrack_backend.Entity.EmergencyCard;

public interface EmergencyCardRepository extends JpaRepository<EmergencyCard, Long>
{

}
