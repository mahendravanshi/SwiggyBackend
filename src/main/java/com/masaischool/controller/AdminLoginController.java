package com.masaischool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.model.CurrentUserSession;
import com.masaischool.model.LoginDTO;
import com.masaischool.service.LoginDTOService;


@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminLoginController {
	
	@Autowired
	private LoginDTOService loginDTOService;
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> adminLoginHandler(@RequestBody LoginDTO dto) {
		return new ResponseEntity<CurrentUserSession>(loginDTOService.loginInAccount(dto),HttpStatus.ACCEPTED);
	}
	
	
	
	@PostMapping("/logout")
	public ResponseEntity<String> adminLogoutHandler(@RequestParam String uuid){
		
		return new ResponseEntity<String>(loginDTOService.logoutFromAccount(uuid),HttpStatus.ACCEPTED);
	}
}

