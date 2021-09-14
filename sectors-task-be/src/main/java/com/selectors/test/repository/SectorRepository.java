package com.selectors.test.repository;

import com.selectors.test.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectorRepository extends JpaRepository<Sector, Long> {
    List<Sector> findAllByParentSectorNull();
}
