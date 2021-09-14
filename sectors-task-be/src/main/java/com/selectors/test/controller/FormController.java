package com.selectors.test.controller;

import com.selectors.test.dto.FormRequest;
import com.selectors.test.dto.FormResponse;
import com.selectors.test.service.FormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "Form controller")
@RestController
@CrossOrigin
@RequestMapping("/api/form")
@RequiredArgsConstructor
public class FormController {
    private final FormService formService;

    @PostMapping
    @Operation(summary = "Save new form")
    public FormResponse save(
            @Parameter(description = "Request for update form", required = true) @RequestBody @Valid FormRequest request) {
        return formService.save(request);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update form by id")
    public FormResponse update(
            @Parameter(description = "Id of the existing form", example = "1") @PathVariable Long id,
            @Parameter(description = "Request for update form", required = true) @RequestBody @Valid FormRequest request) {
        return formService.update(id, request);
    }
}
