package com.flower.service;

import com.flower.dto.ProfileDTO;
import com.flower.entity.Profile;
import com.flower.exception.ProfileAlreadyExistException;
import com.flower.exception.ProfileNotFoundException;
import com.flower.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile create(ProfileDTO profileDTO) {
        if (profileRepository.getByLogin(profileDTO.getLogin()) != null) {
            throw new ProfileAlreadyExistException("Пользователь с таким login уже существует");
        }
        return profileRepository.create(
                new Profile(
                        profileDTO.getFio(),
                        profileDTO.getLogin(),
                        profileDTO.getPassword()
                )
        );
    }

    public List<Profile> getAllProfile() {
        return profileRepository.getAllProfile();
    }

    public Profile getById(Long id) {
        var profile = profileRepository.getById(id);
        if (profile == null) {
            throw new ProfileNotFoundException("Пользователь с таким id не найден");
        }
        return profile;
    }
}
