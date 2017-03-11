package com.lingua.support;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.lingua.model.Ucenik;

public class UcenikIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor arg0, Object obj)
			throws HibernateException {
		Random num = new Random();
		int jmbg = ((Ucenik)obj).getJmbg();
		String temp = Integer.toString(jmbg);
		int len = temp.length();
		String last3 = temp.substring(len-3);
		String lastFirst = ((Ucenik)obj).getIme().substring(0, 1)+((Ucenik)obj).getPrezime().substring(0, 1);
		return lastFirst.toUpperCase()+"-"+last3+num.nextInt();
	}

}
