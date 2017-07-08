package com.rzodkiewicz.michal.security.repository;

import com.rzodkiewicz.michal.security.domain.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long>{

}
