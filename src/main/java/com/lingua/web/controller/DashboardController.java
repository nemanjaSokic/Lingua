package com.lingua.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@RequestMapping(value="/student/{username}",produces="text/plain")
    public ResponseEntity<String> student(@PathVariable String username) {
        return new ResponseEntity<>("/student/"+ username +"/home",HttpStatus.OK);
    }
	@RequestMapping(value="/professor/{username}",produces="text/plain")
    public ResponseEntity<String> professor(@PathVariable String username) {
        return new ResponseEntity<>("/professor/"+ username +"/home",HttpStatus.OK);
    }
	@RequestMapping(value="/admin",produces="text/plain")
    public ResponseEntity<String> admin(@PathVariable String username) {
        return new ResponseEntity<>("/admin",HttpStatus.OK);
    }
}
