package com.lingua.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.model.Test;
import com.lingua.service.TestService;

@RestController
@RequestMapping(value = "/api/tests")
public class ApiTestController {
	@Autowired
	TestService testService;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<Test>> getTestovi(){
		List<Test> testovi;
		testovi = testService.findAll();
		if(testovi == null || testovi.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(testovi,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{id}")
	ResponseEntity<Test> getOne(@PathVariable Long id){
		Test t = testService.findOne(id);
		if(t==null){
			return new ResponseEntity<Test>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Test>(t,HttpStatus.OK);
	}
}
