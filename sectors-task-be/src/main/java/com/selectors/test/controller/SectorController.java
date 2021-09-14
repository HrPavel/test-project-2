package com.selectors.test.controller;

import com.selectors.test.dto.SectorResponse;
import com.selectors.test.service.SectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Sector controller")
@RestController
@CrossOrigin
@RequestMapping("/api/sector")
@RequiredArgsConstructor
public class SectorController {
    private final SectorService sectorService;

    @GetMapping
    @Operation(summary = "Get selectors")
    public List<SectorResponse> getAll() {
        return sectorService.getAll();
    }
}
