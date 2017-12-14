package com.lingua.support;

import java.util.Random;

import com.lingua.model.Ucenik;

public class UcenikIdGenerator {

	public static String generate(String ime, String prezime){
		Random num = new Random();
		int jmbg = num.hashCode();
		String temp = Integer.toString(jmbg);
		int len = temp.length();
		String last3 = temp.substring(len-3);
		String lastFirst = ime.substring(0, 1)+ prezime.substring(0, 1);
		return lastFirst.toUpperCase()+"-"+last3+num.nextInt();
	}

}
