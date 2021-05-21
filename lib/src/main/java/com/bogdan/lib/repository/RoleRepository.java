package com.bogdan.lib.repository;

import com.bogdan.lib.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
