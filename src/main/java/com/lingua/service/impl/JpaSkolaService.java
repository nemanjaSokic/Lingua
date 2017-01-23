package com.lingua.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lingua.repository.SkolaRepository;
import com.lingua.service.SkolaService;

@Service
@Transactional
public class JpaSkolaService implements SkolaService{
	
	SkolaRepository skolaRepo;
	
}
