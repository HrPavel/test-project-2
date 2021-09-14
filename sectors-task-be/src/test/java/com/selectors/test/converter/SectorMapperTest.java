package com.selectors.test.converter;

import com.selectors.test.entity.Sector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.selectors.test.util.TestDataCreator.createDefaultSector;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
class SectorMapperTest {
    private final SectorMapper sectorMapper = new SectorMapperImpl();

    @Test
    public void convertToResponse() {
        Sector sector = createDefaultSector();

        var actual = sectorMapper.convertToResponse(sector);

        assertAll("Should contains appropriate fields",
                () -> assertEquals(actual.getId(), sector.getId()),
                () -> assertEquals(actual.getName(), sector.getName()),
                () -> assertEquals(actual.getParentId(), sector.getParentSector().getId()),
                () -> assertFalse(actual.getSectors().isEmpty()));
    }
}