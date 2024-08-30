package com.flower.service;

import com.flower.dto.FlowerDTO;
import com.flower.entity.Flower;
import com.flower.exception.FlowerNotFoundException;
import com.flower.exception.FlowerValidException;
import com.flower.repository.FlowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerService {

    private final FlowerRepository flowerRepository;

    private final ProfileService profileService;

    public FlowerService(FlowerRepository flowerRepository, ProfileService profileService) {
        this.flowerRepository = flowerRepository;
        this.profileService = profileService;
    }

    public List<Flower> create(Long profileId, FlowerDTO flowerDTO) {
        if (flowerDTO.getName() == null) {
            throw new FlowerValidException("атрибут name не должен быть пустым");
        }
        var profile = profileService.getById(profileId);
        return flowerRepository.create(profile.getId(), flowerDTO);
    }

    public void delete(Long profileId, Long id) {
        getProfileReceipt(id, profileId);
        flowerRepository.deleteById(id);
    }

    public Flower getProfileReceipt(Long id, Long profileId) {
        var profile = profileService.getById(profileId);
        var flower = flowerRepository.getByProfileIdAndId(profile.getId(), id);
        if (flower == null) {
            throw new FlowerNotFoundException("У вас не существует цветка под таким номером");
        }
        return flower;
    }

    public Flower update(Long profileId, Long id, FlowerDTO flowerDTO) {
        var flower = getProfileReceipt(id, profileId);
        if (flowerDTO.getDescription() == null && flowerDTO.getName() == null) {
            return flower;
        }
        updateDTO(flowerDTO, flower);
        return flowerRepository.update(id, flowerDTO);
    }

    private static void updateDTO(FlowerDTO flowerDTO, Flower flower) {
        if (flowerDTO.getDescription() == null) {
            flowerDTO.setDescription(flower.getDescription());
        }
        if (flowerDTO.getName() == null) {
            flowerDTO.setName(flower.getName());
        }
    }

    public List<Flower> getAllFlowers(Long profileId) {
        var profile = profileService.getById(profileId);
        return flowerRepository.getByProfileId(profile.getId());
    }
}
