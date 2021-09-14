package com.selectors.test.service;

import com.selectors.test.converter.SectorMapper;
import com.selectors.test.dto.SectorResponse;
import com.selectors.test.entity.Sector;
import com.selectors.test.handler.exception.ResourceNotFoundException;
import com.selectors.test.repository.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SectorService {
    private final SectorRepository sectorRepository;
    private final SectorMapper sectorMapper;

    public List<SectorResponse> getAll() {
        List<Sector> sectors = sectorRepository.findAllByParentSectorNull();
        return sectorMapper.convertToResponse(sectors);
    }

    public Sector getById(Long id) {
        return sectorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sector", id));
    }
}
