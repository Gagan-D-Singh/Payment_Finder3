package com.example.demo.dto;

//Encapsulation → Prevent exposing entity structures directly.
//Security → Hide sensitive fields (e.g., passwordHash, CVV, bank details).
//Performance → Reduce response size by returning only needed fields.
//Data Transformation → Format or modify data before sending to the client.


import lombok.*;

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
}

// Hides passwordHash field to improve security.


