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

import com.lingua.model.Kurs;
import com.lingua.service.KursService;

@RestController
@RequestMapping(value = "/api/courses")
public class ApiKursController {
	
	@Autowired
	KursService kursServ;
	
	//-----------------GET------------------------
	
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<Kurs>> getAll(){
		List<Kurs> kursevi = kursServ.findAll();
		if(kursevi.isEmpty()){
			return new ResponseEntity<List<Kurs>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Kurs>>(kursevi,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value = "/{id}")
	ResponseEntity<Kurs> getOne(@PathVariable int id){
		Kurs k = kursServ.findOne(id);
		if(k==null){
			return new ResponseEntity<Kurs>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Kurs>(k,HttpStatus.OK);
	}
	//-----------------------------POST--------------------
	
	@RequestMapping(consumes="application/json",method=RequestMethod.POST)
	ResponseEntity<Kurs> add(@RequestBody Kurs newKurs){
		Kurs saved = kursServ.save(newKurs);
		return new ResponseEntity<Kurs>(saved,HttpStatus.CREATED);
	}
	
	//----------------------DELETE------------------------
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	ResponseEntity<Kurs> delete(@PathVariable int id){
		
		Kurs deleted = kursServ.delete(id);
		
		return new ResponseEntity<Kurs>(deleted,HttpStatus.NO_CONTENT);
	}
	
	//-----------------UPDATE------------------------------
	
	@RequestMapping(method=RequestMethod.PUT,value="/{id}",consumes="application/json")
	ResponseEntity<Kurs> edit(@PathVariable int id, @RequestBody Kurs kurs){
		if(id!=kurs.getIdKursa()){
			return new ResponseEntity<Kurs>(HttpStatus.BAD_REQUEST);
		}
		Kurs saved = kursServ.save(kurs);
		return new ResponseEntity<Kurs>(saved,HttpStatus.OK);
	}
	
	
	
	
	
}
