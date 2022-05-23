package com.polytech.kursova.repository;

import com.polytech.kursova.entity.Case;
import com.polytech.kursova.entity.CaseId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaseRepository extends JpaRepository<Case, CaseId> {
    Optional<Case> findCaseById(CaseId id);
}
