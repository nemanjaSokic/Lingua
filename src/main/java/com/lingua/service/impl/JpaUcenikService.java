package com.lingua.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lingua.repository.UcenikRepository;
import com.lingua.service.UcenikService;

@Service
@Transactional
public class JpaUcenikService implements UcenikService{
	
	UcenikRepository ucenikRepo;
	
}
