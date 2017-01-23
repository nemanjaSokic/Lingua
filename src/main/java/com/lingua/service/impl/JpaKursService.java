package com.lingua.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lingua.repository.KursRepository;
import com.lingua.service.KursService;

@Service
@Transactional
public class JpaKursService implements KursService{

	KursRepository kursRepo;
}
