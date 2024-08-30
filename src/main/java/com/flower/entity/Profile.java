package com.flower.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Profile {

    private Long id;

    @NonNull
    private final String fio;

    @NonNull
    private final String login;

    @NonNull
    @JsonIgnore
    private final String password;
}
