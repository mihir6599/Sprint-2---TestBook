package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.login;

public class email_steps { 
	int email_validation;
	login elogin = new login();

	 @Given("^user is on testbook site$")
		 public void user_is_on_testbook_site() throws Throwable {
			elogin.openurl(); 
			Thread.sleep(3000);
		 }
	 @And("^user clicks on login button$")
	     public void user_clicks_on_login_button() throws Throwable {
	       elogin.click_login();
	     }

	 @When("^user enters valid (.+) valid (.+) clicks login$")
	     public void user_enters_valid_valid_clicks_login(String email, String password) throws Throwable {
	       elogin.enter_email(email);
	       Thread.sleep(1000);
	       
	       if (email.contains("@gmail.com")) {
	    	   elogin.email_validate(email);
	    	   System.out.println("1");
	    	   elogin.enter_password(password);
	    	   Thread.sleep(1000);
	    	   System.out.println("2");
  	       }
	       else {
	    	   elogin.email_validate(email);
	    	   //elogin.enter_password(password);
	       }   
	    
	     }

	 @Then("^user is  redirected to homepage$")
	     public void user_is_redirected_to_homepage() throws Throwable {
	        elogin.validate_dashboard();
	    
	     }

	 @And("^user clicks on live classes, selects a live class$")
	    public void user_clicks_on_live_classes_selects_a_live_class() throws Throwable {
	    	elogin.click_live_classes();
	    }


	 @Then("^user is  redirected to live videos page$")
	    public void user_is_redirected_to_live_videos_page() throws Throwable {
	    	//validation
		 	elogin.validate_live_class();
	    }


	 @And("^user clicks on get pass and selects a pass$")
	    public void user_clicks_on_get_pass_and_selects_a_pass() throws Throwable {
	        elogin.click_get_pass();
	    }
	 
	 @And("^selects card payment, enters card detail$")
	    public void selects_card_payment_enters_card_detail() throws Throwable {
	        elogin.card_payment();
	        elogin.cancel_payment();
	        elogin.logout();
	    }

}
