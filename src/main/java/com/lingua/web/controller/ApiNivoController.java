package com.lingua.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.model.Nivo;
import com.lingua.service.NivoService;
import com.mysql.fabric.Response;

@RestController
@RequestMapping(value = "/api/levels")
public class ApiNivoController {

	NivoService nivoServ;
	
	
	//-----------------GET---------------------
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	ResponseEntity<Nivo> getLevel(@PathVariable int id){
		Nivo n = nivoServ.findOne(id);
		if(n==null){
			return new ResponseEntity<Nivo>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Nivo>(n,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<Nivo>> getAll(){
		List<Nivo> nivoi = nivoServ.findAll();
		return new ResponseEntity<List<Nivo>>(nivoi,HttpStatus.OK);
	}
	
	//-------------------POST------------------
	
	@RequestMapping(consumes="application/json",method=RequestMethod.POST)
	ResponseEntity<Nivo> addLevel(Nivo n){
		List<Nivo> nivoi = nivoServ.findAll();
		for(Nivo itr : nivoi){
			if(n.getIdNivo() == itr.getIdNivo()){
				return new ResponseEntity<Nivo>(HttpStatus.BAD_REQUEST);
			}
		}
		Nivo presisted = nivoServ.save(n);
		return new ResponseEntity<Nivo>(presisted,HttpStatus.CREATED);
	}
	
	//-----------------DELETE-------------------
	
	ResponseEntity<Nivo> remove(@PathVariable int id){
		Nivo d = nivoServ.findOne(id);
		if(d == null){
			return new ResponseEntity<Nivo>(HttpStatus.BAD_REQUEST);
		}
		nivoServ.delete(id);
		return new ResponseEntity<Nivo>(d,HttpStatus.OK);
	}
}
