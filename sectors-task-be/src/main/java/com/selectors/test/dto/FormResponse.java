package com.selectors.test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormResponse {
    private Long id;
    private String username;
    private Long sectorId;
    private Boolean agreeToTerm;
}
