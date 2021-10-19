package com.example.fundoonotesbackend.repo;

import com.example.fundoonotesbackend.model.CollaboratorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollabaratorRepo extends JpaRepository<CollaboratorData, Integer> {
}
