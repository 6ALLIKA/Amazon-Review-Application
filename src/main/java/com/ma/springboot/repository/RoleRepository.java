package com.ma.springboot.repository;

import com.ma.springboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(Role.RoleName roleName);
}
