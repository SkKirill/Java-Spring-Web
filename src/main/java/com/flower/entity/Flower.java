package com.flower.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Flower {

    @NonNull
    private final Long id;

    @NonNull
    @JsonIgnore
    private final Long profileId;

    private String description;

    @NonNull
    private final String name;
}
