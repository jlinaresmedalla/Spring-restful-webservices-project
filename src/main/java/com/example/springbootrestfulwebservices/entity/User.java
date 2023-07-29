package com.example.springbootrestfulwebservices.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @Column(nullable = false)
    private String firstName;
    @NonNull
    @Column(nullable = false)
    private String lastName;
    @NonNull
    @Column(nullable = false, unique = true)
    private String email;
}
