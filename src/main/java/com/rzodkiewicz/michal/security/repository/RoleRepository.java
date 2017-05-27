package com.rzodkiewicz.michal.security.repository;

import com.rzodkiewicz.michal.security.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
}
