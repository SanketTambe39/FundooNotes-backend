package com.example.fundoonotesbackend.repo;

import com.example.fundoonotesbackend.model.NoteData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepo extends JpaRepository<NoteData, Integer> {

    @Query(value = "SELECT * FROM notes where user_id=:userId", nativeQuery = true)
    public List<NoteData> findAllByUser(Long userId);

    @Query(value = "SELECT * FROM notes where title=:title", nativeQuery = true)
    public List<NoteData> findAllByTitle(String title);

}
