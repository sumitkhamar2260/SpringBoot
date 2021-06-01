package com.cts.rest.resources;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.rest.model.Customer;

@RestController
@RequestMapping("/cust")
public class CustomerController {
	
	static ArrayList <Customer>customerList =new ArrayList<>();
	static
	{
	Customer cust1= new Customer();
	cust1.setId(101);
	cust1.setName("Sumit");
	cust1.setBalance(50000);
	
	Customer cust2= new Customer();
	cust2.setId(102);
	cust2.setName("Deekshit");
	cust2.setBalance(60000);
	
	customerList.add(cust1);
	customerList.add(cust2);
	
	
	}
	@GetMapping
	public String getCustomer() {
		return "not yet ready";
	}
    
	
	@GetMapping
	@RequestMapping("/list")
	public ArrayList<Customer> getCustomers() {
		return customerList;
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public Customer getCustomerById(@RequestParam long id) {
		for(Customer cust: customerList) {
			if(cust.getId()==id)
				return cust;
			
		}
		return null;
          		
	}
	@GetMapping
	@RequestMapping("/custid/{id}")
	public Customer getCustomerById2(@PathVariable("id") long id) {
		for(Customer cust: customerList) {
			if(cust.getId()==id)
				return cust;
			
		}
		return null;
          		
	}
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer newCustomer) {
		customerList.add(newCustomer);
		return newCustomer;
		
	}
	
	@PutMapping
	  @RequestMapping("/update")
	  public Customer updateCustomer(@RequestBody Customer newCustomer) {
	    for (Customer cust : customerList) {
	      if (cust.getId() == newCustomer.getId()) {
	        cust.setBalance(newCustomer.getBalance());
	      }

	    }
	    return newCustomer;
	  }
	 @DeleteMapping
	  @RequestMapping("/delete/{id}")
	  public String deleteCustomer(@PathVariable("id") long id) {
	      int index=0;
		 for (Customer cust : customerList) {
	      if (cust.getId() == id) {
	    	  index=customerList.indexOf(cust);
	    	  System.out.println("index---->"+index);
	      }
	      customerList.remove(index);
	    }
	    return "delete";
	  }
	
}
