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
import com.lingua.model.Nastavnik;
import com.lingua.service.JezikService;
import com.lingua.service.NastavnikService;

@RestController
@RequestMapping(value = "/api/professors")
public class ApiNastavnikController {

	@Autowired
	NastavnikService nastavnikServ;
	@Autowired
	JezikService jezikServ;
	
	
	//-------------------------GET--------------------------
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<Nastavnik>> getAll(){
		List<Nastavnik> nastavnici = nastavnikServ.finadAll();
		if(nastavnici==null){
			return new ResponseEntity<List<Nastavnik>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Nastavnik>>(nastavnici,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	ResponseEntity<Nastavnik> getOne(@PathVariable int id){
		Nastavnik n = nastavnikServ.findOne(id);
		if(n==null){
			return new ResponseEntity<Nastavnik>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Nastavnik>(n,HttpStatus.OK);
	}
	@RequestMapping(value="/languages/{id}",method=RequestMethod.GET)
	ResponseEntity<List<Nastavnik>> getAllProfessorByLang(@PathVariable String id){
		List<Nastavnik> nastavnici = nastavnikServ.findByJezik(id);
		return new ResponseEntity<List<Nastavnik>>(nastavnici,HttpStatus.OK);
	}
	
	//--------------------POST----------------------------
	
	
	@RequestMapping(method=RequestMethod.POST,consumes="application/json")
	ResponseEntity<Nastavnik> add(@RequestBody Nastavnik newNastavnik){
		if(newNastavnik==null){
			return new ResponseEntity<Nastavnik>(HttpStatus.BAD_REQUEST);
		}
		Nastavnik presisted = nastavnikServ.save(newNastavnik);
		
		return new ResponseEntity<Nastavnik>(presisted,HttpStatus.CREATED);
	}
	
	//-------------------------------DELETE-------------------------------
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	ResponseEntity<Nastavnik> delete(@PathVariable int id){
		Nastavnik n = nastavnikServ.delete(id);
		if(n==null){
			return new ResponseEntity<Nastavnik>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Nastavnik>(HttpStatus.OK);
	}
	
	//---------------------------PUT--------------------------------
	
	@RequestMapping(method=RequestMethod.PUT,consumes="application/json",value="/{id}")
	ResponseEntity<Nastavnik> edit(@PathVariable int id, @RequestBody Nastavnik edited){
		if(id != edited.getId()){
			return new ResponseEntity<Nastavnik>(HttpStatus.BAD_REQUEST);
		}
		Nastavnik n = nastavnikServ.save(edited);
		if(n==null){
			return new ResponseEntity<Nastavnik>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Nastavnik>(n,HttpStatus.OK);
	}
	
	
	
}
