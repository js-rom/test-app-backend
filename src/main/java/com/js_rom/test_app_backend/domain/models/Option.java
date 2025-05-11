package com.js_rom.test_app_backend.domain.models;

import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Option {

    @EqualsAndHashCode.Include
    private String id;
    private String description;
}
