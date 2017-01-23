package com.lingua.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.service.KursService;

@RestController
@RequestMapping(value = "/api/courses")
public class ApiKursController {

	KursService kursServ;
	
}
