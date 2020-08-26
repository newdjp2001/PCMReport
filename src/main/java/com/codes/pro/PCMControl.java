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
	public int total(int p,int c,int m)
	{ return (p+c+m);}
	
	public char Grade(int t ) {
		if (t/3>=80) {return 'A';}
		else if(t/3>50&t/3<80) {return 'B'; }
		else { return 'C';}
		
	}
	
	@GetMapping("/grade-json")
	@ResponseBody
	  public PCMBase displayResult(@RequestParam(name="physics",required=false,defaultValue="70") int physics,
			  @RequestParam(name="chemistry",required=false,defaultValue="85") int chemistry,
			  @RequestParam(name="math",required=false,defaultValue="60") int math ) 
	  {       
		PCMBase result = new PCMBase();
		jsonErrorResponse exe = new jsonErrorResponse();
		 try { 
		result.setPhysics(physics);
		result.setChemistry(chemistry);
		result.setMath(math);
		result.setTotal(total( physics,chemistry,math));
		if(result.getTotal()/3>80) 
		{result.setGrade('A');}
		else if (result.getTotal()/3>50) {result.setGrade('B');}
		else if (result.getTotal()/3<50) {result.setGrade('C');
		}
		}catch(Exception e) { 
			exe.setMessage("Exception:Number Format Exception");
		    exe.setDetails(""+e);
			System.out.println("Exception Here:"+e);}
		  
		  
	    return result;
	
	 }
	@PostMapping(value="/grade-json",consumes="application/json",produces="application/json")
	 @ResponseBody
	public PCMBase acceptResult(@RequestBody PCMBase result){
		
		return result;
		}
		
 
	   @GetMapping("/grade-html")
	   @ResponseBody
	    public ModelAndView htmlView(Model model,@RequestParam(name="physics",required=false,defaultValue="70") int physics,
				  @RequestParam(name="chemistry",required=false,defaultValue="85") int chemistry,
				  @RequestParam(name="math",required=false,defaultValue="60") int math )
	  {    
		   PCMBase result = new PCMBase();
			  
		   result.setPhysics(physics);
		   result.setChemistry(chemistry);
		   result.setMath(math);
		   result.setTotal(total( physics,chemistry,math));
		   result.setGrade(Grade(result.getTotal() ));
		   
	      
	        ModelAndView mav = new ModelAndView();
	        mav.addObject("result", result);
	        mav.setViewName("PCMFront");   
	        return mav;
	  }
	  
}

