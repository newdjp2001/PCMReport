package com.codes.pro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class PCMControl {
	public int Total(int p,int c,int m)
	{ return (p+c+m);}
	
	public char grade(int t ) {
		if (t/3>=80) {return 'A';}
		else if(t/3>=50&t/3<80) {return 'B'; }
		else { return 'C';}
		
	}
	
	@GetMapping("/Grade.json")
	@ResponseBody
	  public PCMBase displayResult(@RequestParam(name="Physics",required=false,defaultValue="70") int Physics,
			  @RequestParam(name="Chemistry",required=false,defaultValue="85") int Chemistry,
			  @RequestParam(name="Math",required=false,defaultValue="60") int Math ) 
	  {       
		PCMBase result = new PCMBase();
		jsonErrorResponse exe = new jsonErrorResponse();
		 try { 
		result.setPhysics(Physics);
		result.setChemistry(Chemistry);
		result.setMath(Math);
		result.setTotal(Total(Physics,Chemistry,Math));
		if(result.getTotal()/3>=80) 
		{result.setGrade('A');}
		else if (result.getTotal()/3>=50) {result.setGrade('B');}
		else {result.setGrade('C');
		}
		}catch(Exception e) { 
			exe.setMessage("Exception:Number Format Exception");
		    exe.setDetails(""+e);
			System.out.println("Exception Here:"+e);}
		  
		  
	    return result;
	
	 }
	@PostMapping(value="/Grade.json",consumes="application/json",produces="application/json")
	 @ResponseBody
	public PCMBase acceptResult(@RequestBody PCMBase result){
		
		return result;
		}
		
		
	   @GetMapping("/Grade")
	   @ResponseBody
	    public ModelAndView htmlView(Model model,@RequestParam(name="Physics",required=false,defaultValue="80") int Physics,
				  @RequestParam(name="Chemistry",required=false,defaultValue="80") int Chemistry,
				  @RequestParam(name="Math",required=false,defaultValue="80") int Math )
	  {    
		   
		   PCMBase result = new PCMBase();
		    
		   result.setPhysics(Physics);
		   result.setChemistry(Chemistry);
		   result.setMath(Math);
		   result.setTotal(Total( Physics,Chemistry,Math));
		   result.setGrade(grade(result.getTotal() ));
		   
	      
	        ModelAndView mav = new ModelAndView();
	        mav.addObject("result", result);
	        mav.setViewName("PCMFront");   
	        return mav;
	  }
  }

