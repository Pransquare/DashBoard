package com.pransquare.dashboard.services;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pransquare.dashboard.entities.AttributeConfigEntity;
import com.pransquare.dashboard.models.AttributeModel;
import com.pransquare.dashboard.models.AttributeSearchModel;
import com.pransquare.dashboard.repositories.AttributeConfigRepository;

@Service
public class AttributeConfigService {
	
	private AttributeConfigRepository attributeConfigRepository;
	
	

	public AttributeConfigService(AttributeConfigRepository attributeConfigRepository) {
		this.attributeConfigRepository = attributeConfigRepository;
	}



	public ResponseEntity<String> saveOrUpdateAttributes(AttributeModel attributeModel) {
	    AttributeConfigEntity attributeConfigEntity;

	    if (attributeModel.getAttributeConfigId() != null && attributeConfigRepository.existsById(attributeModel.getAttributeConfigId())) {
	        // Update existing record
	        attributeConfigEntity = attributeConfigRepository.findById(attributeModel.getAttributeConfigId()).get();
	        attributeConfigEntity.setAttributeName(attributeModel.getAttributeName());
	        attributeConfigEntity.setStatus(attributeModel.getStatus());
	        attributeConfigEntity.setModifiedBy(attributeModel.getCreatedBy());
	        attributeConfigEntity.setModifiedDate(LocalDateTime.now());
	    } else {
	        // Create new record
	        attributeConfigEntity = new AttributeConfigEntity();
	        attributeConfigEntity.setAttributeName(attributeModel.getAttributeName());
	        attributeConfigEntity.setStatus(attributeModel.getStatus());
	        attributeConfigEntity.setCreatedBy(attributeModel.getCreatedBy());
	        attributeConfigEntity.setCreatedDate(LocalDateTime.now());
	        attributeConfigEntity.setModifiedBy(attributeModel.getCreatedBy());
	        attributeConfigEntity.setModifiedDate(LocalDateTime.now());
	    }

	    attributeConfigRepository.save(attributeConfigEntity);
	    return ResponseEntity.ok("Saved or Updated Successfully");
	}
	
	public Page<AttributeConfigEntity> searchAttributes(AttributeSearchModel searchModel) {
	    Pageable pageable = PageRequest.of(searchModel.getPage(), searchModel.getSize(), Sort.by(Sort.Direction.ASC, "modifiedDate"));

	    Specification<AttributeConfigEntity> spec = Specification.where(null);

	    if (searchModel.getAttributeName() != null && !searchModel.getAttributeName().isEmpty()) {
	        spec = spec.and(AttributeSpecification.hasAttributeName(searchModel.getAttributeName()));
	    }

	    if (searchModel.getStatus() != null && !searchModel.getStatus().isEmpty()) {
	        spec = spec.and(AttributeSpecification.hasStatus(searchModel.getStatus()));
	    }

	   

	    return attributeConfigRepository.findAll(spec, pageable);
	}


	public class AttributeSpecification {

	    public static Specification<AttributeConfigEntity> hasAttributeName(String name) {
	        return (root, query, cb) -> cb.like(cb.lower(root.get("attributeName")), "%" + name.toLowerCase() + "%");
	    }

	    public static Specification<AttributeConfigEntity> hasStatus(String status) {
	        return (root, query, cb) -> cb.equal(root.get("status"), status);
	    }

	 
	}
	
	

}
