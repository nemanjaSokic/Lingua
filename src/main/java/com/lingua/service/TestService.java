package com.lingua.service;

import java.util.List;

import com.lingua.model.Test;

public interface TestService {

	Test save(Test t);

	List<Test> findAll();

	Test findOne(Long id);
}
