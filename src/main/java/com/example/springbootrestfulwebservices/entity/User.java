package com.example.springbootrestfulwebservices.entity;

import com.example.springbootrestfulwebservices.dto.UserDtoRecord;
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

    public User(UserDtoRecord userDtoRecord) {
        this(userDtoRecord.id(), userDtoRecord.firstName(), userDtoRecord.lastName(), userDtoRecord.email());
//        this.firstName = userDtoRecord.firstName();
//        this.lastName = userDtoRecord.lastName();
//        this.email = userDtoRecord.email();
    }

}
