package com.example.demo.service.ServiceImpl;

import com.example.demo.dto.UserDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll() // 1. Fetch all users from DB
                .stream()  // 2. Convert the list into a Stream
                .map(user -> UserDTO.builder()  // 3. Transform each User entity to UserDTO
                        .userId(user.getUserId())
                        .email(user.getEmail())
                        .username(user.getUsername())
                        .phone(user.getPhone())
                        .address(user.getAddress())
                        .build())  // 4. Create a UserDTO object using Builder pattern
                .collect(Collectors.toList());  // 5. Convert the Stream back to a List
    }

    @Override
    public Optional<UserDTO> getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(user -> UserDTO.builder()
                        .userId(user.getUserId())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .phone(user.getPhone())
                        .address(user.getAddress())
                        .build());
    }
}
