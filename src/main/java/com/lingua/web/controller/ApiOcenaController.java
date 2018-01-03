package com.lingua.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.model.Ocena;
import com.lingua.service.OcenaService;

@RestController
@RequestMapping(value = "/api/marks")
public class ApiOcenaController {
	@Autowired
	OcenaService ocenaService;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<Ocena>> getTestovi(){
		List<Ocena> ocene;
		ocene = ocenaService.findAll();
		if(ocene == null || ocene.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(ocene,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{id}")
	ResponseEntity<Ocena> getOne(@PathVariable Long id){
		Ocena t = ocenaService.findOne(id);
		if(t==null){
			return new ResponseEntity<Ocena>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Ocena>(t,HttpStatus.OK);
	}
}
