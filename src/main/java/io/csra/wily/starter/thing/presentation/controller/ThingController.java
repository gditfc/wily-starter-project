package io.csra.wily.starter.thing.presentation.controller;

import io.csra.wily.components.converter.DozerMapperPlus;
import io.csra.wily.exceptions.NotFoundException;
import io.csra.wily.starter.thing.persistence.ThingRepository;
import io.csra.wily.starter.thing.presentation.model.ThingDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/api/things")
public class ThingController {

    private ThingRepository thingRepository;
    private DozerMapperPlus objectMapper;

    public ThingController(final ThingRepository thingRepository, final DozerMapperPlus objectMapper) {
        this.thingRepository = thingRepository;
        this.objectMapper = objectMapper;
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
