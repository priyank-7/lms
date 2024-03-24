package com.lms.Repositories;

import com.lms.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {

    Optional <Role> findByName(String name);
}
