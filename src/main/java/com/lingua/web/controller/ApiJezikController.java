package com.lingua.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.model.Jezik;
import com.lingua.service.JezikService;

@RestController
@RequestMapping(value = "/api/languages")
public class ApiJezikController {

	@Autowired
	private JezikService jezikService;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<Jezik>> getJezici(){
		List<Jezik> jezici;
		jezici = jezikService.findAll();
		if(jezici == null || jezici.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(jezici,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	ResponseEntity<Jezik> add(@RequestBody Jezik newJ){
		Jezik saved;
		saved = jezikService.save(newJ);
		return new ResponseEntity<Jezik>(saved, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{id}")
	ResponseEntity<Jezik> getOne(@PathVariable String id){
		Jezik j = jezikService.findOne(id);
		if(j==null){
			return new ResponseEntity<Jezik>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Jezik>(j,HttpStatus.OK);
	}
}
