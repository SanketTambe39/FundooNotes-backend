package com.example.fundoonotesbackend.service;

import com.example.fundoonotesbackend.dto.UserDTO;
import com.example.fundoonotesbackend.model.UserData;
import com.example.fundoonotesbackend.util.Response;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Response addUser(UserDTO userDTO);
    Response updateUser(String token, UserDTO userDTO);
    void deleteUser(Integer userId);
    List<UserData> getUsers();
    UserData getUserById(Long userId);
    Optional<UserData> getUserByEmailId(String emailId);

}
