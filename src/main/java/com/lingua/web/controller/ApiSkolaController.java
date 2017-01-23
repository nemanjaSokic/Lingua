package com.lingua.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.service.SkolaService;

@RestController
@RequestMapping(value = "/api/school")
public class ApiSkolaController {
	
	SkolaService skolaServ;
}
