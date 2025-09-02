package com.pransquare.dashboard.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pransquare.dashboard.entities.AttributeConfigEntity;

@Repository
public interface AttributeConfigRepository extends JpaRepository<AttributeConfigEntity, Integer> {

	Page<AttributeConfigEntity> findAll(Specification<AttributeConfigEntity> spec, Pageable pageable);

}
