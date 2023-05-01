package br.com.mnz.userservice.controller;

import br.com.mnz.userservice.models.UserModel;
import br.com.mnz.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/firstName/{firstName}")
    public UserModel getUserById(@PathVariable(value = "firstName") String firstName) {
        return userService.getUserByFirstName(firstName);
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserModel getUserById(@PathVariable(value = "userId") UUID userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable(value = "userId") UUID userId) {
        userService.deleteUser(userId);
    }

    @PutMapping("/{userId}")
    public UserModel updateUser(@PathVariable(value = "userId") UUID userId, @RequestBody UserModel userModel) {
        return userService.updateUser(userId, userModel);
    }
}
