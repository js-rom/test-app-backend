package com.js_rom.test_app_backend.infrastructure.postgres.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.js_rom.test_app_backend.infrastructure.postgres.entities.OptionEntity;

public interface OptionRepository extends JpaRepository<OptionEntity, String> {

}
