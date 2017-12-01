package com.lingua.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lingua.model.Korisnik;
import com.lingua.support.dao.KorisnikDAO;

@Service
public class AuthenticationService implements UserDetailsService {
	@Autowired
	private KorisnikService korisnikServ;
	//private KorisnikDAO korDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik userInfo = korisnikServ.getOne(username);
		System.out.println(userInfo);
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.toString());
		UserDetails userDetails = (UserDetails)new User(userInfo.getKorisnickoIme(), 
				userInfo.getSifraKorisnika(), userInfo.getRegistrovan(), true, true, true, Arrays.asList(authority));
		return userDetails;
	}
} 