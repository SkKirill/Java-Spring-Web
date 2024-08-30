package com.flower.controller;

import com.flower.dto.FlowerDTO;
import com.flower.entity.Flower;
import com.flower.service.FlowerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flower")
public class FlowerController {
    private final FlowerService flowerService;

    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{profileId}")
    public List<Flower> create(@RequestBody @Valid FlowerDTO flowerDTO,
                               @PathVariable(name = "profileId") Long profileId) {
        return flowerService.create(profileId, flowerDTO);
    }

    @GetMapping("/{id}/{profileId}")
    public Flower getById(@PathVariable(name = "id") Long id,
                          @PathVariable(name = "profileId") Long profileId) {
        return flowerService.getProfileReceipt(id, profileId);
    }

    @GetMapping("/{profileId}")
    public List<Flower> getAll(@PathVariable(name = "profileId") Long profileId) {
        return flowerService.getAllFlowers(profileId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}/{profileId}")
    public Flower update(@RequestBody @Valid FlowerDTO flowerDTO,
                         @PathVariable(name = "id") Long id,
                         @PathVariable(name = "profileId") Long profileId) {
        return flowerService.update(profileId, id, flowerDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}/{profileId}")
    public void delete(@PathVariable(name = "id") Long id,
                       @PathVariable(name = "profileId") Long profileId) {
        flowerService.delete(profileId, id);
    }
}
