package com.example.springbootrestfulwebservices.dto;

import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;

}
