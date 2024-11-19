package com.vagas.iuri.repository;

import com.vagas.iuri.enums.RoleName;
import com.vagas.iuri.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleName roleName);
}
