package com.lingua.web.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lingua.exception.UserException;
import com.lingua.model.ErrorResponse;
import com.lingua.model.Korisnik;
import com.lingua.service.AuthenticationService;
import com.lingua.service.KorisnikService;

@RestController
@RequestMapping(value = "/api/users")
public class ApiKorisnikController {
	
	@Autowired
	KorisnikService korisnikServ;
	@Autowired
	AuthenticationService authService;
	
	//------------------------GET---------------------------
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Korisnik>>  listUser(){
		//need to implement only to admin pass
		UserDetails userDetails =
				 (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(userDetails.getUsername().equals("admin")){
			return new ResponseEntity<List<Korisnik>> (korisnikServ.getUsers(), HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}	
	}
	
	@RequestMapping(value="/u/{id}", method = RequestMethod.GET)
	public ResponseEntity<Korisnik>  listUser(@PathVariable(value = "id") String id) throws UserException{
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
	
	//-----------------------EXCEPTION-----------------------
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(UserException ex){
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getErrorMessage());
		return new ResponseEntity<>(error, HttpStatus.valueOf(error.getErrorCode()));
	}
	
	//------------------------POST---------------------------
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public ResponseEntity<Korisnik>  listUser(@RequestBody Korisnik user){
		return new ResponseEntity<Korisnik> (HttpStatus.OK);
	}
	
	@RequestMapping("/u")
	  public Principal user(Principal user) {
	    return user;
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
