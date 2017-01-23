package com.lingua.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.service.UcenikService;

@RestController
@RequestMapping(value = "/api/students")
public class ApiUcenikController {

	UcenikService ucenikServ;
	
}
