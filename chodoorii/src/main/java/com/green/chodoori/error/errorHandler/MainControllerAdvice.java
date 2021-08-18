package com.green.chodoori.error.errorHandler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.chodoori.error.CompanayDetailNotFoundError;
import com.green.chodoori.error.PasswordIsNotSameError;
import com.green.chodoori.error.RequestedUserNotFound;
import com.green.chodoori.error.ResumeNotFoundError;

@ControllerAdvice
public class MainControllerAdvice {

	 @ExceptionHandler({PasswordIsNotSameError.class,RequestedUserNotFound.class})
	 public String PasswordNotSameException(HttpServletRequest req, Exception e, RedirectAttributes redir) {
		
		 System.out.println(e.getMessage());
		 System.out.println("핸들러 작동");
		 
		 Map<String, String> errors = new HashMap();
		 
		 String id = req.getParameter("id");
		 
		 
		 errors.put("id", id);
		 errors.put("error", e.getMessage());

		 redir.addFlashAttribute("errors", errors);
		 
		 return "redirect:/?error=on";
	 }
	 
	 @ExceptionHandler({CompanayDetailNotFoundError.class, ResumeNotFoundError.class, })
	 public String detailNotFoundHandler(HttpServletRequest req, Exception e, RedirectAttributes redir) {
		 return "/errors/404";
	 }
	 
	 
	 


}
