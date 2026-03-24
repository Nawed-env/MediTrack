package com.meditrack_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meditrack_backend.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{

}
