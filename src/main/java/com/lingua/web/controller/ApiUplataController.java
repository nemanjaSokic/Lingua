package com.lingua.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.service.UplataService;

@RestController
@RequestMapping(value = "/api/payments")
public class ApiUplataController {

	UplataService uplataServ;
	
}
