package com.pransquare.dashboard.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pransquare.dashboard.entities.AttributeConfigEntity;
import com.pransquare.dashboard.exceptions.ResourceNotFoundException;
import com.pransquare.dashboard.models.AttributeModel;
import com.pransquare.dashboard.models.AttributeSearchModel;
import com.pransquare.dashboard.services.AttributeConfigService;

@RestController
@RequestMapping(value = "/Pransquare/MasterConfiguration/attributes")
public class AttributeConfigController {

	private static final Logger logger = LogManager.getLogger(AttributeConfigController.class);

	private AttributeConfigService attributeConfigService;

	public AttributeConfigController(AttributeConfigService attributeConfigService) {
		this.attributeConfigService = attributeConfigService;
	}

	@PostMapping("/saveOrUpdateAttributes")
	public ResponseEntity<String> saveOrUpdateAttributes(@RequestBody AttributeModel attributeModel) {
		return attributeConfigService.saveOrUpdateAttributes(attributeModel);
	}

	@PostMapping("/searchAttributes")
	public ResponseEntity<Page<AttributeConfigEntity>> searchAttributes(
			@RequestBody AttributeSearchModel attributeSearchModel) {
		Page<AttributeConfigEntity> result = null;
		result = attributeConfigService.searchAttributes(attributeSearchModel);
		if (result == null) {
			throw new ResourceNotFoundException("No Attributes found");
		} else {
			return ResponseEntity.ok(result);
		}
	}

	@GetMapping("/getActiveAttributes")
	public ResponseEntity<List<String>> getActiveAttributes() {
		AttributeSearchModel attributeSearchModel = new AttributeSearchModel();
		attributeSearchModel.setStatus("Active");
		attributeSearchModel.setSize(100);
		attributeSearchModel.setAttributeName(null);
		List<String> response = new ArrayList<>();
		Page<AttributeConfigEntity> result = null;
		result = attributeConfigService.searchAttributes(attributeSearchModel);
		logger.info(result.toList());
		if (result.isEmpty()) {
			throw new ResourceNotFoundException("No Attributes found");
		} else {
			response = result.toList().stream().map(m -> m.getAttributeName()).toList();
			return ResponseEntity.ok(response);
		}
	}
}
