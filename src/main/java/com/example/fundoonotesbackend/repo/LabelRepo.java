package com.example.fundoonotesbackend.repo;

import com.example.fundoonotesbackend.model.LabelData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepo extends JpaRepository<LabelData, Integer> {
}
