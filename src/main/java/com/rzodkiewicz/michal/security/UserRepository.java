package com.rzodkiewicz.michal.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends JpaRepository<User, Long>{

    User findOneByUsername(String username);
}
