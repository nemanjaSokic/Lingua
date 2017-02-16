package com.lingua.support;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.lingua.model.Jezik;

public class JezikIdGenerator implements IdentifierGenerator{

	
@Override
public Serializable generate(SessionImplementor session, Object object)
        throws HibernateException {
	
	String name = ((Jezik) object).getNaziv();
   

    return name.substring(0,3);
}}