package com.lingua.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.model.Skola;
import com.lingua.service.SkolaService;

@RestController
@RequestMapping(value = "/api/school")
public class ApiSkolaController {
	
	@Autowired
	SkolaService skolaServ;
	
	@RequestMapping(method=RequestMethod.GET,value="/{pib}")
	ResponseEntity<Skola> getOne(@PathVariable int pib){
		Skola skola = skolaServ.findOne(pib);
		return new ResponseEntity<Skola>(skola,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<Skola>> getAll(){
		List<Skola> skole = skolaServ.findAll();
		return new ResponseEntity<List<Skola>>(skole,HttpStatus.OK);
	}
	
}
