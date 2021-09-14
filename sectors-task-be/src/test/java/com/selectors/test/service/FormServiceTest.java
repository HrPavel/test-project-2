package com.selectors.test.service;

import com.selectors.test.BaseIntegrationTest;
import com.selectors.test.dto.FormRequest;
import com.selectors.test.entity.Sector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Stream;

import static com.selectors.test.util.TestConstant.DEFAULT_SECTOR_ID;
import static com.selectors.test.util.TestConstant.FORM_NAME;
import static com.selectors.test.util.TestDataCreator.createForm;
import static com.selectors.test.util.TestDataCreator.createMainSector;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FormServiceTest extends BaseIntegrationTest {
    private static final String UPDATED_FORM_NAME = "ChangedName";
    private static final Long FORM_ID = 1L;
    private Sector sector;

    @Autowired
    private FormService formService;

    @BeforeEach
    public void init() {
        sector = sectorRepository.save(createMainSector());
    }

    @Test
    public void save() {
        FormRequest request = FormRequest.builder()
                .agreeToTerm(true)
                .sectorId(DEFAULT_SECTOR_ID)
                .username(FORM_NAME)
                .build();

        var actual = formService.save(request);

        assertNotNull(actual);
    }

    @Test
    public void saveWithNullSectorIdShouldThrowInvalidDataAccessApiUsageException() {
        FormRequest invalidRequest = FormRequest.builder()
                .agreeToTerm(true)
                .sectorId(null)
                .username(FORM_NAME)
                .build();

        assertThrows(InvalidDataAccessApiUsageException.class, () ->
                formService.save(invalidRequest));
    }

    @ParameterizedTest
    @MethodSource("provideNames")
    void saveWithEmptyFieldShouldThrowConstraintViolationException(String name, Class<ValidationException> clazz) {
        FormRequest invalidRequest = FormRequest.builder()
                .agreeToTerm(true)
                .sectorId(DEFAULT_SECTOR_ID)
                .username(name)
                .build();

        assertThrows(clazz, () ->
                formService.save(invalidRequest));
    }

    @Test
    public void update() {
        formRepository.save(createForm(sector));

        FormRequest request = FormRequest.builder()
                .agreeToTerm(true)
                .sectorId(DEFAULT_SECTOR_ID)
                .username(UPDATED_FORM_NAME)
                .build();

        var actual = formService.update(FORM_ID, request);

        assertAll("Should be not null and change value",
                () -> assertNotNull(actual),
                () -> assertEquals(actual.getUsername(), UPDATED_FORM_NAME));
    }

    private static Stream<Arguments> provideNames() {
        return Stream.of(
                Arguments.of(null, ConstraintViolationException.class),
                Arguments.of("", ConstraintViolationException.class));
    }
}