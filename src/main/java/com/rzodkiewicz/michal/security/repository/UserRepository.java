package com.rzodkiewicz.michal.security.repository;

import com.rzodkiewicz.michal.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findOneByUsername(String username);
}
