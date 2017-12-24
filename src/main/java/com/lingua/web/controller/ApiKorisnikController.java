package com.lingua.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.exception.UserException;
import com.lingua.model.ErrorResponse;
import com.lingua.model.Korisnik;
import com.lingua.model.Kurs;
import com.lingua.model.Nastavnik;
import com.lingua.model.Ucenik;
import com.lingua.service.AuthenticationService;
import com.lingua.service.KorisnikService;
import com.lingua.service.KursService;
import com.lingua.service.NastavnikService;
import com.lingua.service.UcenikService;
import com.lingua.service.impl.EmailService;
import com.lingua.support.UcenikIdGenerator;

@RestController
@RequestMapping(value = "/api/users")
public class ApiKorisnikController {
	
	@Autowired
	KorisnikService korisnikServ;
	@Autowired
	AuthenticationService authService;
	@Autowired
	UcenikService ucenikServ;
	@Autowired
	NastavnikService nastavnikServ;
	@Autowired
	KursService kursServ;
	@Autowired
	EmailService email;
	@Autowired
	public SimpleMailMessage template;
	
	//------------------------GET---------------------------

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Korisnik>>  getAll(@RequestParam(value = "register", required = false) Boolean reg){
		//need to implement only to admin pass
		UserDetails userDetails =
				 (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userDetails.getUsername().equals("admin")){
			List<Korisnik> korisnici = new ArrayList<>();
			if(reg == false){
				korisnici = korisnikServ.getUnregistratedUsers();
				return new ResponseEntity<List<Korisnik>>(korisnici, HttpStatus.OK);
			}else{
				return new ResponseEntity<List<Korisnik>> (korisnikServ.getUsers(), HttpStatus.OK);
			}
		}else{
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}	
	}
	
	@RequestMapping(value="/u/{id}", method = RequestMethod.GET)
	public ResponseEntity<Korisnik>  login(@PathVariable(value = "id") String id) throws UserException{
		Korisnik k = korisnikServ.getUsers().stream().filter(korisnik -> korisnik.getKorisnickoIme().equals(id)).findFirst().orElse(null);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) { //Firstly, check is the user Anonymus
			//If NOT
			UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(userDetails.getUsername().equals("admin") || userDetails.getUsername().equals(k.getKorisnickoIme())){
				return new ResponseEntity<Korisnik>(k, HttpStatus.OK);
			}else{
				return new ResponseEntity<Korisnik>(HttpStatus.BAD_REQUEST);
			}
		}else{
			//If YES - this exception will never be done, because of httpBasic() which is responsible for 
			//handling SecurtyContextHolder and exceptions if username and pass is not correct
			throw new UserException("Invalid username requested");
		}
		
	}
	
	@RequestMapping("/u")
	public Principal isUserLogin(Principal user) {
		System.out.println(user);
		return user;
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public ResponseEntity<Boolean> isUsernameExist(@PathVariable(value="username") String un){
		boolean is = false;
		String username = korisnikServ.getUsername(un);
		if(username != null){
			is = true;
			return new ResponseEntity<Boolean>(is,HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(is,HttpStatus.OK);
	}
	
	//-----------------------EXCEPTION-----------------------
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(UserException ex){
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getErrorMessage());
		return new ResponseEntity<>(error, HttpStatus.valueOf(error.getErrorCode()));
	}
	
	//------------------------POST---------------------------
	@Transactional
	@RequestMapping(value="/prof", method = RequestMethod.POST, consumes = {"application/json"})
	public ResponseEntity<Korisnik>  save(@RequestBody Nastavnik nastavnik) throws Exception{
		if(nastavnik != null){
			korisnikServ.save(nastavnik);
			email.sendNotifyToAdmin();
			email.sendSimpleMessage(nastavnik.getEmail(), template.getSubject(),"Dear Professor " + nastavnik.getIme() +","+ template.getText());
		}else{
			return new ResponseEntity<Korisnik>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Korisnik> (HttpStatus.OK);
	}
	
	@Transactional
	@RequestMapping(value="/stud", method = RequestMethod.POST, consumes = {"application/json"})
	public ResponseEntity<Korisnik>  save(@RequestBody Ucenik ucenik) throws Exception{
		if(ucenik != null){
			ucenik.setIndeks(UcenikIdGenerator.generate(ucenik.getIme(), ucenik.getPrezime()));
			korisnikServ.save(ucenik);
			email.sendNotifyToAdmin();
			email.sendSimpleMessage(ucenik.getEmail(), template.getSubject(), "Dear " + ucenik.getIme() +","+ template.getText());
		}else{
			return new ResponseEntity<Korisnik>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Korisnik> (HttpStatus.OK);
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public ResponseEntity<Korisnik> logoutDo(HttpServletRequest request,HttpServletResponse response){
		HttpSession session= request.getSession(false);
		    SecurityContextHolder.clearContext();
		         session= request.getSession(false);
		        if(session != null) {
		            session.invalidate();
		        }
		        for(Cookie cookie : request.getCookies()) {
		            cookie.setMaxAge(0);
		        }

		    return new ResponseEntity<Korisnik>(HttpStatus.OK);
		}
}
