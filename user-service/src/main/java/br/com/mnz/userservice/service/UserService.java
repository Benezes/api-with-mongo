package br.com.mnz.userservice.service;

import br.com.mnz.userservice.models.UserModel;
import br.com.mnz.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserModel getUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(UUID userId) {
        Optional<UserModel> userModel = userRepository.findById(userId);
        if (userModel.isPresent())
            return userModel.get();
        throw new RuntimeException("Id not found");
    }

    public UserModel createUser(UserModel user) {
        user.setUserId(UUID.randomUUID());
        return userRepository.save(user);
    }

    public void deleteUser(UUID userId) {
        Optional<UserModel> user = userRepository.findById(userId);
        if (user.isPresent())
            userRepository.delete(user.get());
    }

    public UserModel updateUser(UUID userId, UserModel userModel) {
        Optional<UserModel> user = userRepository.findById(userId);
        if (user.isPresent()){
            user.get().setEmail(userModel.getEmail());
            user.get().setFirstName(userModel.getFirstName());
            user.get().setLastName(userModel.getLastName());
            return userRepository.save(user.get());
        }
        throw new RuntimeException("Id not found");
    }
}
