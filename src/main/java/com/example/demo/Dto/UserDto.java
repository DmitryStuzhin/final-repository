package com.example.demo.Dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
    private Integer age;

    public static UserDto makeDto(String username, int age) {
        return UserDto.builder()
                .username(username)
                .age(age)
                .build();
    }
}
