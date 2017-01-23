package com.lingua.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.service.KorisnikService;

@RestController
@RequestMapping(value = "/api/users")
public class ApiKorisnikController {

	KorisnikService korisnikServ;
}
