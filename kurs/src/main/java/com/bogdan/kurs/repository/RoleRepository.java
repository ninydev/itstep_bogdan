package com.bogdan.kurs.repository;

import com.bogdan.kurs.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
