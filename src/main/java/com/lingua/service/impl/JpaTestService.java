package com.lingua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingua.model.Test;
import com.lingua.repository.TestRepository;
import com.lingua.service.TestService;

@Service
@Transactional
public class JpaTestService implements TestService{

	@Autowired
	TestRepository tr;

	@Override
	public Test save(Test t) {
		return tr.save(t);
	}

	@Override
	public List<Test> findAll() {
		return tr.findAll();
	}

	@Override
	public Test findOne(Long id) {
		return tr.findOne(id);
	}
	
	
}
