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

import com.lingua.model.Nivo;
import com.lingua.service.NivoService;

@RestController
@RequestMapping(value = "/api/levels")
public class ApiNivoController {
	
	@Autowired
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
		if(nivoi==null){
			return new ResponseEntity<List<Nivo>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Nivo>>(nivoi,HttpStatus.OK);
	}
	
	//-------------------POST------------------
	
	@RequestMapping(consumes="application/json",method=RequestMethod.POST)
	ResponseEntity<Nivo> addLevel(@RequestBody Nivo n){
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
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	ResponseEntity<Nivo> remove(@PathVariable int id){
		Nivo d = nivoServ.findOne(id);
		if(d == null){
			return new ResponseEntity<Nivo>(HttpStatus.BAD_REQUEST);
		}
		nivoServ.delete(id);
		return new ResponseEntity<Nivo>(d,HttpStatus.OK);
	}
	
	//------------------------UPDATE----------------------

	@RequestMapping(consumes="application/json",value="/{id}",method=RequestMethod.PUT)
	ResponseEntity<Nivo> edit(@PathVariable int id,@RequestBody Nivo nivo){
		
		if(nivo.getIdNivo()!=id){
			return new ResponseEntity<Nivo>(HttpStatus.BAD_REQUEST);
		}
		Nivo presis = nivoServ.save(nivo);
		return new ResponseEntity<Nivo>(presis,HttpStatus.OK);
	}
	
	
}
