package com.example.demo.service.ServiceImpl;

import com.example.demo.dto.UserDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

    @Override
    public Object[] getUserBlockedReasonStatus(String email) {
        Object[] result = userRepository.findBlockedSuspendedReasonStatus(email);

        if(result == null){
            return new Object[]{"Not Found", "User does not exist"};
        }
        return result;
    }

    @Override
    public String getLastAccUpdated(String email) {
        LocalDateTime result = userRepository.findLastUpdated(email);
        LocalDateTime currentDateTime = LocalDateTime.now();

        long days_difference = ChronoUnit.DAYS.between(result, currentDateTime);

        if(days_difference > 3){
            return "You can contact customer care for the support.";
        }
        else{
            return "Kindly wait, your will start receiving notifications on your new contact number within 3 working days";
        }

//        if(result.isBefore(currentDateTime)){
//            return "Kindly wait, your will start receiving notifications on your new contact number within 3 working days";
//        }
//        else{
//            return "You can contact customer care for the support.";
//        }
    }
}
