package com.semicolon.services.serviceImplementation;

import com.semicolon.data.model.*;
import com.semicolon.data.repositories.UserRepository;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.AddUserResponse;
import com.semicolon.dto.response.UserDtoResponse;
import com.semicolon.dto.response.UserUpdateResponse;
import com.semicolon.services.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.semicolon.data.model.UserRole.ADMINISTRATORS;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser(ValidateUserRequest validateUserRequest) {
        User user = userRepository.findUserByEmailAddressAndPassword(validateUserRequest.getEmailAddress(), validateUserRequest.getPassword());
        if(user.getRole() == ADMINISTRATORS){
            List<User> users = userRepository.findAll();
            return users;
        }
        throw new NullPointerException("You are not allowed to get all users");
    }

    @Override
    public AddUserResponse addUser(UserDtoRequest userDtoRequest) {
        CreditCardInformation creditCardInformation = new CreditCardInformation();
        User user = new User();
        user.setAddress(userDtoRequest.getAddress());
        user.setName(userDtoRequest.getName());
        user.setPassword(userDtoRequest.getPassword());
        user.setRole(userDtoRequest.getRole());
        user.setAge(userDtoRequest.getAge());
        user.setGender(userDtoRequest.getGender());
        user.setAddress(userDtoRequest.getAddress());
        user.setPhoneNumber(userDtoRequest.getPhoneNumber());
        user.setEmailAddress(userDtoRequest.getEmailAddress());
        userRepository.save(user);
        AddUserResponse addUserResponse = new AddUserResponse();
        addUserResponse.setId(user.getUserId());
        addUserResponse.setMessage("Successfully added user");
        return addUserResponse;
    }

    @Override
    public UserUpdateResponse updateUser(UserUpdateRequest userUpdateRequest) {
        User foundUser = userRepository.findUserByEmailAddressAndPassword(userUpdateRequest.getEmailAddress(), userUpdateRequest.getPassword());
        if(foundUser == null){
            throw new NullPointerException("User not found");
        }else {
            if(userUpdateRequest.getAddress() != null) {
                foundUser.setAddress(userUpdateRequest.getAddress());
            }
            if(userUpdateRequest.getName() != null) {
                foundUser.setName(userUpdateRequest.getName());
            }
            if(userUpdateRequest.getPassword() != null) {
                foundUser.setPassword(userUpdateRequest.getPassword());
            }
            if(userUpdateRequest.getGender() != null){
                foundUser.setGender(userUpdateRequest.getGender());
            }
            if(userUpdateRequest.getPhoneNumber() != null) {
                foundUser.setPhoneNumber(userUpdateRequest.getPhoneNumber());
            }
            if(userUpdateRequest.getEmailAddress() != null) {
                foundUser.setEmailAddress(userUpdateRequest.getEmailAddress());
            }
            if (userUpdateRequest.getAge() != foundUser.getAge()){
                foundUser.setAge(userUpdateRequest.getAge());
            }
        }
        userRepository.save(foundUser);
        UserUpdateResponse addUserResponse = new UserUpdateResponse();
        addUserResponse.setMessage("Your account has been updated Successfully");
        return addUserResponse;
    }

    @Override
    public String removeUser(ValidateUserRequest validateUserRequest) {
        User user = userRepository.findUserByEmailAddressAndPassword(validateUserRequest.getEmailAddress(), validateUserRequest.getPassword());
        if(user == null){
            throw new NullPointerException("User not found");
        }
        userRepository.delete(user);
        return "User has been deleted Successfully";
    }

    @Override
    public UserDtoResponse getUserDto( ValidateUserRequest validateUserRequest) {
        User user = userRepository.findUserByEmailAddressAndPassword(validateUserRequest.getEmailAddress().toLowerCase(), validateUserRequest.getPassword());
        if(user == null){
            throw new NullPointerException("User not found");
        }
        UserDtoResponse userDtoResponse = new UserDtoResponse();
        userDtoResponse.setAddress(user.getAddress());
        userDtoResponse.setName(user.getName());
        userDtoResponse.setPassword(user.getPassword());
        userDtoResponse.setRole(user.getRole());
        userDtoResponse.setAge(user.getAge());
        userDtoResponse.setGender(user.getGender());
        userDtoResponse.setPhoneNumber(user.getPhoneNumber());
        userDtoResponse.setEmailAddress(user.getEmailAddress());
        return userDtoResponse;
    }
}
