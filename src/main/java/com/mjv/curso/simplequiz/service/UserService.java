package com.mjv.curso.simplequiz.service;

import com.mjv.curso.simplequiz.builder.UserMapper;
import com.mjv.curso.simplequiz.dto.UserDTO;
import com.mjv.curso.simplequiz.model.User;
import com.mjv.curso.simplequiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void createUser(UserDTO userDTO) {
        User userEntity = userMapper.toEntity(userDTO);
        userRepository.save(userEntity);
    }

    public List<UserDTO> getAllUsersOrderedByName() {
        List<User> users = userRepository.findAllByOrderByName();
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }



}