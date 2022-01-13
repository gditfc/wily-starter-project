package io.csra.wily.starter.thing.presentation.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class ThingDTO {

    private String details;
    private String createdBy;
    private Date createdTime;
    private String modifiedBy;
    private Date modifiedTime;

}
