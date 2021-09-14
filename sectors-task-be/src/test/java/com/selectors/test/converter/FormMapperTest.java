package com.selectors.test.converter;

import com.selectors.test.dto.FormRequest;
import com.selectors.test.entity.Form;
import com.selectors.test.service.SectorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.selectors.test.util.TestConstant.DEFAULT_FORM_ID;
import static com.selectors.test.util.TestConstant.DEFAULT_SECTOR_ID;
import static com.selectors.test.util.TestConstant.FORM_NAME;
import static com.selectors.test.util.TestDataCreator.createDefaultSector;
import static com.selectors.test.util.TestDataCreator.createForm;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FormMapperTest {

    private SectorService sectorService;
    private FormMapper formMapper;

    @BeforeEach
    public void init() {
        sectorService = Mockito.mock(SectorService.class);
        formMapper = new FormMapperImpl(sectorService);
    }

    @Test
    public void convertToEntity() {
        FormRequest request = FormRequest.builder()
                .username(FORM_NAME)
                .agreeToTerm(true)
                .sectorId(DEFAULT_SECTOR_ID)
                .build();

        when(sectorService.getById(request.getSectorId())).thenReturn(createDefaultSector());

        var actual = formMapper.convertToEntity(request);

        assertAll("Should contains appropriate fields",
                () -> assertEquals(actual.getUsername(), request.getUsername()),
                () -> assertEquals(actual.getAgreeToTerm(), request.getAgreeToTerm()),
                () -> assertEquals(actual.getSector().getId(), request.getSectorId())
        );
    }

    @Test
    public void convertToResponse() {
        Form form = createForm(createDefaultSector());
        form.setId(DEFAULT_FORM_ID);

        var actual = formMapper.convertToResponse(form);

        assertAll("Should contains appropriate fields",
                () -> assertEquals(actual.getId(), form.getId()),
                () -> assertEquals(actual.getUsername(), form.getUsername()),
                () -> assertEquals(actual.getSectorId(), form.getSector().getId()),
                () -> assertEquals(actual.getAgreeToTerm(), form.getAgreeToTerm())
        );
    }

    @Test
    public void updateEntityByRequest() {
        FormRequest request = FormRequest.builder()
                .username(FORM_NAME)
                .agreeToTerm(true)
                .sectorId(DEFAULT_SECTOR_ID)
                .build();

        when(sectorService.getById(request.getSectorId())).thenReturn(createDefaultSector());

        var actual = formMapper.updateEntityByRequest(createForm(createDefaultSector()), request);

        assertAll("Should contains appropriate fields",
                () -> assertEquals(actual.getUsername(), request.getUsername()),
                () -> assertEquals(actual.getAgreeToTerm(), request.getAgreeToTerm()),
                () -> assertEquals(actual.getSector().getId(), request.getSectorId())
        );
    }
}