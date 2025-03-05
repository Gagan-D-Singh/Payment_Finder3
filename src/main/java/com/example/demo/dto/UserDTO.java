package com.example.demo.dto;

//Encapsulation → Prevent exposing entity structures directly.
//Security → Hide sensitive fields (e.g., passwordHash, CVV, bank details).
//Performance → Reduce response size by returning only needed fields.
//Data Transformation → Format or modify data before sending to the client.


import com.example.demo.entity.AccountStatus;
import jakarta.annotation.Nonnull;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long userId;
    private String username;
    private String email;
    private String phone;
    private String address;
    private String status;
    private String reason;
    private LocalDate updatedAt;
}

// Hides passwordHash field to improve security.


