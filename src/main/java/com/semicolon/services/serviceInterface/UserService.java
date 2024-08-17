package com.semicolon.services.serviceInterface;

import com.semicolon.data.model.*;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.AddUserResponse;
import com.semicolon.dto.response.UserDtoResponse;
import com.semicolon.dto.response.UserUpdateResponse;

import java.util.List;

public interface UserService {
    List<User> getAllUser(ValidateUserRequest validateUserRequest);
    AddUserResponse addUser(UserDtoRequest userDtoRequest);
    UserUpdateResponse updateUser(UserUpdateRequest userUpdateRequest);
    String removeUser(ValidateUserRequest validateUserRequest);
    UserDtoResponse getUserDto( ValidateUserRequest validateUserRequest);

}
