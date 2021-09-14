package com.selectors.test.util;

import com.selectors.test.entity.Form;
import com.selectors.test.entity.Sector;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.selectors.test.util.TestConstant.DEFAULT_SECTOR_ID;
import static com.selectors.test.util.TestConstant.DEFAULT_SECTOR_NAME;
import static com.selectors.test.util.TestConstant.FORM_NAME;
import static com.selectors.test.util.TestConstant.MAIN_SECTOR_NAME;
import static com.selectors.test.util.TestConstant.SUB_SECTOR_NAME;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestDataCreator {

    public static Sector createMainSector() {
        return new Sector()
                .setName(MAIN_SECTOR_NAME)
                .setParentSector(null)
                .setSectors(new ArrayList<>());
    }

    public static Sector createSubSector(Sector sector) {
        return new Sector()
                .setName(SUB_SECTOR_NAME)
                .setParentSector(sector)
                .setSectors(new ArrayList<>());
    }

    public static Sector createDefaultSector() {
        return new Sector()
                .setId(DEFAULT_SECTOR_ID)
                .setName(DEFAULT_SECTOR_NAME)
                .setParentSector(
                        new Sector().setId(2L))
                .setSectors(List.of(createMainSector()));
    }

    public static Form createForm(Sector sector) {
        return new Form()
                .setAgreeToTerm(true)
                .setSector(sector)
                .setUsername(FORM_NAME);
    }
}
