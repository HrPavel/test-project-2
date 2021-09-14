package com.selectors.test.util;

import com.selectors.test.repository.FormRepository;
import com.selectors.test.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class IntegrationTestRepoHelper {
    @Autowired
    protected SectorRepository sectorRepository;
    @Autowired
    protected FormRepository formRepository;
}
