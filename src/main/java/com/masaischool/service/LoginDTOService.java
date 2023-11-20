package com.masaischool.service;

import com.masaischool.model.CurrentUserSession;
import com.masaischool.model.LoginDTO;

public interface LoginDTOService {
    
	
	 public CurrentUserSession loginInAccount(LoginDTO loginDto);
	 
	 public String logoutFromAccount(String uuid);
	 
	 
}
