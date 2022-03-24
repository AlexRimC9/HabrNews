package com.project.repository;

import com.project.domain.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {
   Privilege findByName(String name);
}
