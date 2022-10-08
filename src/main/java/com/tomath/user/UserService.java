package com.tomath.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service public class UserService {
    @Autowired
    UserRepository usersRepository;

    public List<User> getUsersList() {
        return usersRepository.findAll();
    }

    public Long createUser(User user) {
        return usersRepository.save(user).getId();
    }

    public User loadUser(String loginUser) {
        return usersRepository.findUserByEmail(loginUser);
    }

    public void deleteUser(Long id) {
        User user = usersRepository.findUserById(id);
        usersRepository.delete(user);
    }
}
