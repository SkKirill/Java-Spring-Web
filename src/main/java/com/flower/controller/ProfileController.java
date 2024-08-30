package com.flower.controller;

import com.flower.dto.ProfileDTO;
import com.flower.entity.Profile;
import com.flower.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Profile create(@RequestBody @Valid ProfileDTO profileDTO) {
        return profileService.create(profileDTO);
    }

    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable(name = "id") Long id) {
        return profileService.getById(id);
    }

    @GetMapping()
    public List<Profile> getAllProfile() {
        return profileService.getAllProfile();
    }
}
