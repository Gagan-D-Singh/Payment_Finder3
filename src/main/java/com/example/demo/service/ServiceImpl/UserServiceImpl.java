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
    }
}
