package stepDefination;

import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java8.En;

public class HomePageStepDefination implements En{

	
	public HomePageStepDefination() {
		Given("^application is launched1$", () -> {
			
			System.out.println("Insidde HomePage Applications is launched1");
		    // Write code here that turns the phrase above into concrete actions
		    //throw new PendingException();
		});

		When("^Complete a checkOut for inbound purchase with the following data1$", (DataTable arg1) -> {
			
			System.out.println("Inside Homepage Complete a checkOut for inbound purchase with the following data$");
		    // Write code here that turns the phrase above into concrete actions
		    // For automatic transformation, change DataTable to one of
		    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		    //throw new PendingException();
			Assert.assertTrue(false);
		});

		Then("c", (DataTable arg1) -> {
			
		
		    // Write code here that turns the phrase above into concrete actions
		    // For automatic transformation, change DataTable to one of
		    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		    //throw new PendingException();
		});
		Then("^Verify Offered Package(\\d+)$", (Integer arg1, DataTable arg2) -> {
			System.out.println("Inside Homepage ^Verify Offered Package1$ ");
		    // Write code here that turns the phrase above into concrete actions
		    // For automatic transformation, change DataTable to one of
		    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		   // throw new PendingException();
		});

	}
}
