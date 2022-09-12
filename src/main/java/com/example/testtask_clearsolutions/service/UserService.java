package com.example.testtask_clearsolutions.service;

import com.example.testtask_clearsolutions.dao.UserDAO;
import com.example.testtask_clearsolutions.modela.dto.UserDTO;
import com.example.testtask_clearsolutions.modela.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserDAO userDAO;

    public User create(User user) {
        return new User(userDAO.save(user));
    }

    public User upDAte(User user, int id) {
        user.setId(id);
        return new User(userDAO.save(user));
    }

    public List<UserDTO> getALL() {
        List<User> allUsers = userDAO.findAll();
        return allUsers.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public UserDTO getById(int id) {
        User user = userDAO.findById(id).orElseThrow(ArrayIndexOutOfBoundsException::new);
        return new UserDTO(user);
    }

    public List<UserDTO> delete(int id){
        userDAO.deleteById(id);
        List<User> allUsers = userDAO.findAll();
        return allUsers.stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
