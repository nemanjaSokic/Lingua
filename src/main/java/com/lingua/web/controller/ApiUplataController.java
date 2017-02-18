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

import com.lingua.model.Uplata;
import com.lingua.service.UplataService;

@RestController
@RequestMapping(value = "/api/courses/{courseId}/students/{index}/payments")
public class ApiUplataController {
	
	@Autowired
	UplataService uplataServ;

	//--------------------------GET----------------------
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<Uplata>> getAll(@PathVariable int courseId, @PathVariable String index){
		List<Uplata> uplate = uplataServ.findByCourseAndStudent(courseId,index);
		if(uplate==null || uplate.isEmpty()){
			return new ResponseEntity<List<Uplata>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Uplata>>(uplate,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{br}")
	ResponseEntity<Uplata> getOne(
			@PathVariable int courseId,
			@PathVariable String index,
			@PathVariable int br){
		Uplata u = uplataServ.findByCourseAndStudentAndPayment(courseId,index,br);
		if(u==null){
			return new ResponseEntity<Uplata>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
	
	//---------------------POST------------------------
	
	@RequestMapping(method=RequestMethod.POST,consumes="application/json")
	ResponseEntity<Uplata> add(@RequestBody Uplata newUplata){
		Uplata presisted = uplataServ.save(newUplata);
		if(presisted==null){
			return new ResponseEntity<Uplata>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Uplata>(presisted,HttpStatus.OK);
	}
	
	
}
