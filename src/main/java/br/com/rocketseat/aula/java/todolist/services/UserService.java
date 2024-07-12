package br.com.rocketseat.aula.java.todolist.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.rocketseat.aula.java.todolist.domain.User;
import br.com.rocketseat.aula.java.todolist.dto.UserDTO;
import br.com.rocketseat.aula.java.todolist.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserDTO data) {
        var password = BCrypt.withDefaults().hashToString(12, data.password().toCharArray());

        User user = new User();
        user.setName(data.name());
        user.setEmail(data.email());
        user.setPassword(password);

        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUser(String username) {
        return userRepository.findUserByName(username);
    }
}
