package com.lingua.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@RequestMapping(value="/student",produces="text/plain")
    public ResponseEntity<String> student() {
        return new ResponseEntity<>("/student/dashboard",HttpStatus.OK);
    }
	@RequestMapping(value="/professor",produces="text/plain")
    public ResponseEntity<String> professor() {
        return new ResponseEntity<>("/professor/dashboard",HttpStatus.OK);
    }
	@RequestMapping(value="/admin",produces="text/plain")
    public ResponseEntity<String> admin() {
        return new ResponseEntity<>("/admin",HttpStatus.OK);
    }
}
