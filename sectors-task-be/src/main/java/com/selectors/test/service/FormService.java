package com.selectors.test.service;

import com.selectors.test.converter.FormMapper;
import com.selectors.test.dto.FormRequest;
import com.selectors.test.dto.FormResponse;
import com.selectors.test.entity.Form;
import com.selectors.test.handler.exception.ResourceNotFoundException;
import com.selectors.test.repository.FormRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FormService {
    private final FormRepository formRepository;
    private final FormMapper formMapper;

    @Transactional
    public FormResponse save(FormRequest request) {
        Form convertedForm = formMapper.convertToEntity(request);

        return saveOrUpdateForm(convertedForm);
    }

    @Transactional
    public FormResponse update(Long id, FormRequest request) {
        Form existedForm = formRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Form", id));

        return saveOrUpdateForm(
                formMapper.updateEntityByRequest(existedForm, request));
    }

    private FormResponse saveOrUpdateForm(Form form) {
        Form savedForm = formRepository.save(form);
        return formMapper.convertToResponse(savedForm);
    }
}
