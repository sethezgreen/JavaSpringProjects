package com.codingdojo.hoppersReceipts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HoppersController {
	// class definition and imports here...
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "Seth Green";
        String itemName = "New GPU";
        double price = 650;
        String description = "A fast but afforable new graphics card.";
        String vendor = "NewEgg";
    
    	// Your code here! Add values to the view model to be rendered
        model.addAttribute("name", name);
        model.addAttribute("itemName", itemName);
        model.addAttribute("price", price);
        model.addAttribute("description", description);
        model.addAttribute("vendor", vendor);
        
    
        return "index.jsp";
    }
    //...
    

}
