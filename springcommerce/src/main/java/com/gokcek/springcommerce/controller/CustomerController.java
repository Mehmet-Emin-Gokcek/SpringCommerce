package com.gokcek.springcommerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gokcek.springcommerce.service.CustomerService;
import com.gokcek.springcommerce.model.Customer;


@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping("index")
	public String home() {
		return "index";
	}
	@RequestMapping("buy")
	public String buy() {
		return "buy";
	}
	
	@RequestMapping("sell")
	public String sell(Model model) {
		model.addAttribute("customer", new Customer());
		return "sell";
	}
	
	@RequestMapping("/records")
	public String records(Model model) {
		model.addAttribute("customers", customerService.findAll());
		return "records";
	}

	@PostMapping("/addCustomer")
	public String addcustomer(@Validated Customer customer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "sell";
		}
		customerService.saveCustomer(customer);
		model.addAttribute("customers", customerService.findAll());
		return "records";
	}

	@PostMapping("/deleteCustomer")
	public String deletecustomer(@RequestParam String id, Model model) {
		customerService.deleteById(Long.parseLong(id));

		model.addAttribute("customers", customerService.findAll());
		return "records";
	}

	@GetMapping("/editCustomer")
	public String showUpdateForm(@RequestParam String id, Model model) {
		Customer customer = customerService.findById(Long.parseLong(id))
				.orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));

		model.addAttribute("customer", customer);
		return "update";
	}

	@PostMapping("/updateCustomer")
	public String updatecustomer( @Validated Customer customer,  Model model) {

		customerService.updateCustomer(customer);
		model.addAttribute("customers", customerService.findAll());
		return "records";
	}

//  @GetMapping("/delete/{id}")
//	public String deletecustomer(@PathVariable("id")Long id, Model model) {
//	    customer customer = customerService.findById(id)
//	      .orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
//	    customerService.deleteById(id);
//	    model.addAttribute("customers", customerService.findAll());
//	    return "records";
//	}

//	   @GetMapping("/customersForm")
//	    public String customerForm(Model model) {
//	        model.addAttribute("customerForm", new customer());
//	        return "customersForm";
//	    }

//		@PostMapping("/customers-find")
//		public ModelAndView findcustomer(@ModelAttribute customer customer) 
//		{
//			customer thiscustomer = customerService.findById(customer.getId()).orElseThrow();   
//		    return new ModelAndView("result3","customerForm", thiscustomer);
//		}
//	

//		
//		
//		@PostMapping("/customers-save")
//		public String updatecustomer(@ModelAttribute customer customer) 
//		{
//			customerService.savecustomer(customer);   
//		    return ("redirect:/index");
//		}

//	@RequestMapping(value = "/fine", method = RequestMethod.GET)
//	public String viewcustomerDetails2(ModelMap model) {
//		System.out.println("-----------Came inside my controller ----------");
//	    model.addAttribute("greetingsFine", "I am doing Fine Excellent, THanks !!!!");
//	    return "fine";
//	}
//	
//	
//	@RequestMapping(value = "/customerslist", method = RequestMethod.GET)
//	public ModelAndView viewcustomerList() {
//		//System.out.println("-----------Came inside my controller for picking up customers list ----------");
//	    ArrayList<customer> customersList = customersList.getcustomersList();
//	    
//	    return new ModelAndView("customerslist","customersList", customersList);
//	}
//	
//	@RequestMapping(value = "/getcustomerdetails", method = RequestMethod.GET)
//	public ModelAndView getcustomerDetail(@RequestParam(name = "id") String customerId) {
//		System.out.println("---------Here is my ID from the form text box -------"+customerId);
//	    ArrayList<customer> customersList = customersList.getcustomersList();
//	    customer thiscustomer = null;
//	    for (customer customer:customersList) {
//	    	if (customer.getId() == Integer.parseInt(customerId)) {
//	    		thiscustomer = customer;
//	    	}
//	    }
//	    return new ModelAndView("getcustomerdetails","customerDetails",thiscustomer);
//	    
//	}
//	
//	@RequestMapping(value = "/addnewcustomer", method = {RequestMethod.GET,RequestMethod.POST})
//	public ModelAndView addNewcustomer(@RequestParam(name = "id") String customerId,
//			@RequestParam(name = "fname") String fName,
//			@RequestParam(name = "lname") String lName
//			) {
//		System.out.println("---------Here is all the info for adding this customer -------"+
//			customerId + "," + fName + "," + lName );
//		// Create a new customer and add the new customer to the list
//		customer customer = new customer(Integer.parseInt(customerId), fName, lName);
//
//		// get the latest customer list and set the model with the list
//		ArrayList<customer> customersList = customersList.addcustomer(customer);
//		
//	    return new ModelAndView("customerslist","customersList",customersList);
//	}

}