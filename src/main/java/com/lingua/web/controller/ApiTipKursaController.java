package com.lingua.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.model.TipKursa;
import com.lingua.service.TipKursaService;

@RestController
@RequestMapping(value = "/api/courseTypes")
public class ApiTipKursaController {

	@Autowired
	TipKursaService tipKursaServ;
	//----------GET----------------
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TipKursa>>  getAll(){
		List<TipKursa> allTypes = tipKursaServ.getAll();
		return new ResponseEntity<List<TipKursa>>(allTypes, HttpStatus.OK);	
	}
}
