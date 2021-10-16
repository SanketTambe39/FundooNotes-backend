package com.example.fundoonotesbackend.repo;

import com.example.fundoonotesbackend.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserData,Integer> {

    @Query(value = "SELECT * FROM userregistration where email=:email_Id", nativeQuery = true)
    public Optional<UserData> findByEmailid(String email_Id);

}
