package in.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {
	
	@GetMapping("/balance")
	public String balance() {
		// Logic to check balance 
		return "Your Balance :: 7898.90 INR";
	}
	
	@GetMapping("/transfer")
	public String amountTransfer() {
		// Logic to transfer balance  
		return "Your Amount Tranfer Successfull";
	}
	
	@GetMapping("/login")
	public String login() {
		//logic for login
		return "Your Login Success";
	}
	
	@GetMapping("/contact")
	public String getContactInfo() {
		return "Contact Us : : abc@gmail.com";
	}
	

}
