package io.csra.wily.starter.thing.presentation.controller;

import io.csra.wily.exceptions.NotFoundException;
import io.csra.wily.starter.thing.persistence.ThingRepository;
import io.csra.wily.starter.thing.presentation.model.ThingDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Everything in this controller will have no security applied to it. These are public endpoints.
 */
@Controller
@RequestMapping("/api/public/things")
public class PublicController {

    private ThingRepository thingRepository;

    public PublicController(final ThingRepository thingRepository) {
        this.thingRepository = thingRepository;
    }

    @GetMapping()
    @ResponseBody
    public List<ThingDTO> getThings() {
        final List<ThingDTO> dtos = thingRepository.getThings();

        if (dtos.isEmpty()) {
            throw new NotFoundException();
        }

        return dtos;
    }

}
