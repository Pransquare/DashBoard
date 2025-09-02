package com.pransquare.dashboard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pransquare.dashboard.entities.PerformanceParametersEntity;
import com.pransquare.dashboard.response.ParamResponse;
import com.pransquare.dashboard.services.PerformanceParamService;

@RestController
@RequestMapping("/Pransquare/MasterConfiguration/parameters")
public class PerformanceParameterController {
	@Autowired
	PerformanceParamService performanceParamService;

	@PostMapping("/addParam")
	public ResponseEntity<ParamResponse> addParams(@RequestBody PerformanceParametersEntity param) {
		ParamResponse res = new ParamResponse();
		PerformanceParametersEntity obj = performanceParamService.addParam(param);
		res.setRes(obj);
		res.setMessage("Success");
		return new ResponseEntity<ParamResponse>(res, HttpStatus.OK);

	}

	@GetMapping("/getParams")
	public ResponseEntity<ParamResponse> getParams() {
		ParamResponse res = new ParamResponse();
		List<PerformanceParametersEntity> obj = performanceParamService.getAllParams();
		res.setRes(obj);
		res.setMessage("Success");
		return new ResponseEntity<ParamResponse>(res, HttpStatus.OK);

	}

	@DeleteMapping("/deleteParam/{paramId}")
	public ResponseEntity<ParamResponse> deleteParam(@PathVariable("paramId") Long PramId) {
		ParamResponse res = new ParamResponse();
		try {
			performanceParamService.deleteParam(PramId);
			List<PerformanceParametersEntity> obj = performanceParamService.getAllParams();
			res.setRes(obj);
			res.setMessage("Successfully deleted group");
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			res.setMessage("Error Occured while deleting the Param");
			return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
		}
	}
}
