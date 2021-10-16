package com.example.fundoonotesbackend.service;

import com.example.fundoonotesbackend.dto.UserDTO;
import com.example.fundoonotesbackend.exceptions.UserRegistrationException;
import com.example.fundoonotesbackend.model.UserData;
import com.example.fundoonotesbackend.repo.UserRepo;
import com.example.fundoonotesbackend.util.Response;
import com.example.fundoonotesbackend.util.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    Token myToken;

    @Override
    public Response addUser(UserDTO userDTO) {
        Optional<UserData> isPresent = userRepo.findByEmailid(userDTO.getEmail());
        if(isPresent.isPresent()) {
            throw new UserRegistrationException(400, "User already present");
        }
        UserData userData = new UserData(userDTO);
        userRepo.save(userData);
        String token = myToken.createToken(Math.toIntExact(userData.getUserId()));
        return new Response(200, "User Successfully added",token);
    }

    @Override
    public Response updateUser(String token, UserDTO userDTO) {
        Long id = myToken.decodeToken(token);
        Optional<UserData> isUserPresent = userRepo.findById(Math.toIntExact(id));

        if(!isUserPresent.isPresent()) {
            throw new UserRegistrationException(400, "Contact is not saved!!");
        }
        System.out.println("user to update is"+ isUserPresent.get());
        UserData userData = isUserPresent.get();
        userData.updateUserModel(userDTO);
        userRepo.save(userData);
        return new Response(200, "user updated succsessfull",userData);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public List<UserData> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserData getUserById(Long userId) {
        return userRepo.findById(Math.toIntExact(userId)).orElse(null);
    }
    @Override
    public Optional<UserData> getUserByEmailId(String emailId) {
        return userRepo.findByEmailid(emailId);
    }
}
