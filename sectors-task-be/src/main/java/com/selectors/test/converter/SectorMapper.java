package com.selectors.test.converter;

import com.selectors.test.dto.SectorResponse;
import com.selectors.test.entity.Sector;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectorMapper {

    @Mapping(target = "parentId", source = "parentSector.id")
    SectorResponse convertToResponse(Sector sector);

    List<SectorResponse> convertToResponse(List<Sector> sectors);
}
