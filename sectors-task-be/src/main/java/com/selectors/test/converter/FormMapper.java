package com.selectors.test.converter;

import com.selectors.test.dto.FormRequest;
import com.selectors.test.dto.FormResponse;
import com.selectors.test.entity.Form;
import com.selectors.test.service.SectorService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = "spring", uses = {SectorService.class})
public interface FormMapper {

    @Mapping(target = "sector", source = "request.sectorId")
    @Mapping(target = "agreeToTerm", source = "request.agreeToTerm")
    Form convertToEntity(FormRequest request);

    @Mapping(target = "sector", source = "request.sectorId")
    Form updateEntityByRequest(@MappingTarget Form existedForm, FormRequest request);

    @Mapping(target = "sectorId", source = "sector.id")
    FormResponse convertToResponse(Form form);
}
