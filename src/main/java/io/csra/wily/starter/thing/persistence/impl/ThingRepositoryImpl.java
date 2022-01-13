package io.csra.wily.starter.thing.persistence.impl;

import io.csra.wily.components.converter.DozerMapperPlus;
import io.csra.wily.starter.thing.persistence.ThingRepository;
import io.csra.wily.starter.thing.presentation.model.ThingDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// import org.jooq.DSLContext;
// import static io.csra.wily.starter.database.Tables.*;

@Transactional
@Repository
public class ThingRepositoryImpl implements ThingRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThingRepositoryImpl.class);

    private DozerMapperPlus objectMapper;
    // private DSLContext dslContext;

    public ThingRepositoryImpl(DozerMapperPlus objectMapper /*, DSLContext dslContext */) {
        this.objectMapper = objectMapper;
    }

    @Override
    public List<ThingDTO> getThings() {
        final List<ThingDTO> things = new ArrayList<>();
        final ThingDTO thing = ThingDTO.builder()
                .details("The Wily Starter Project")
                .createdBy("Nick DiMola")
                .createdTime(new Date())
                .modifiedBy("Nick DiMola")
                .modifiedTime(new Date())
                .build();
        things.add(thing);
        return things;
    }
}
