package com.lingua.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.service.NivoService;

@RestController
@RequestMapping(value = "/api/levels")
public class ApiNivoController {

	NivoService nivoServ;
}
