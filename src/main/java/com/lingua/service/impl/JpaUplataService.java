package com.lingua.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lingua.repository.UplataRepository;
import com.lingua.service.UplataService;

@Service
@Transactional
public class JpaUplataService implements UplataService{

	UplataRepository uplataRepo;
	
}
