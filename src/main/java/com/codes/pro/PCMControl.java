package com.codes.pro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class PCMControl {
	
	@GetMapping("/grade-json")
	@ResponseBody
	  public PCMBase displayResult() 
	  {       
		PCMBase result = new PCMBase();
		  
		result.setPhysics(70);
		result.setChemistry(85);
		result.setMath(60);
		result.setTotal();
		result.setGrade();
		  
		  
	    return result;
	
	 }
	  
	   @GetMapping("/grade-html")
	    public ModelAndView htmlView(Model model)
	  {    
		   PCMBase result = new PCMBase();
			  
		   result.setPhysics(80);
		   result.setChemistry(80);
		   result.setMath(80);
		   result.setTotal();
		   result.setGrade();
		   
	      
	        ModelAndView mav = new ModelAndView();
	        mav.addObject("result", result);
	        mav.setViewName("PCMFront");   
	        return mav;
	  }
}

