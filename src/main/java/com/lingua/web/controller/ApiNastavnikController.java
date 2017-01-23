package com.lingua.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.service.NastavnikService;

@RestController
@RequestMapping(value = "/api/professors")
public class ApiNastavnikController {

	NastavnikService nastavnikServ;
}
