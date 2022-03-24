package com.project.repository;

import com.project.domain.Habr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabrRepository extends JpaRepository<Habr, String> {
    Habr findByThemes(String themes);
}
