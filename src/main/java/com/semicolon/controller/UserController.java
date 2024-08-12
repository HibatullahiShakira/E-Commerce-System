package com.semicolon.controller;

import com.semicolon.data.model.User;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.*;
import com.semicolon.services.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.semicolon.data.model.UserRole.SELLERS;

@RestController
@RequestMapping("/user-api/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUserByAdministrators(GetUserRoleRequest getUserRoleRequest) {
        return new ResponseEntity<>(userService.getAllUser(getUserRoleRequest), HttpStatus.OK);
    }

    @GetMapping("user")
    public ResponseEntity<UserDtoResponse> getUser(@RequestBody ValidateUserRequest validateUserRequest) {
        return ResponseEntity.ok(userService.getUserDto(validateUserRequest));
    }

    @PostMapping("user/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AddUserResponse> createUser(@RequestBody UserDtoRequest userDtoRequest) {
        return ResponseEntity.ok(userService.addUser(userDtoRequest));
    }

    @PutMapping("user/update")
    public ResponseEntity<UserUpdateResponse> updateUser(@RequestBody UserUpdateRequest userUpdateRequest, ValidateUserRequest validateUserRequest) {
        UserUpdateResponse response = userService.updateUser(userUpdateRequest, validateUserRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("user/delete")
    public ResponseEntity<String> deleteUser(@RequestBody ValidateUserRequest validateUserRequest) {
        userService.removeUser(validateUserRequest);
        return new ResponseEntity<>("Contact deleted sucessfully", HttpStatus.OK);
    }

}
