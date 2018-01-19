package stepDefination;


import java.util.List;



import cucumber.api.DataTable;

import cucumber.api.java8.En;
import safetrip.tests.BaseTest;

public class ComparisonScreenStepDefination   implements En {
	
	public ComparisonScreenStepDefination(){
		Given("^application is launched$", () -> {
			
			System.out.println(" ComparisonScreen application is launched");
		  // StartDriver();
			
		});

		When("^Complete a checkOut for inbound purchase with the following data$", (DataTable data) -> {
			System.out.println("ComparisonScreen Complete a checkOut for inbound purchase with the following data");
			//data.asMap(Class<String> Class<String>);
			List<List<String>> raw = data.raw();
		//	raw.size();
			System.out.println(raw.size()+" && "+raw.get(0).size());
		});

		Then("^Verify Offered Package$", (DataTable data) -> {
System.out.println("ComparisonScreen Verify Offered Package");
		    // Write code here that turns the phrase above into concrete actions
		    // For automatic transformation, change DataTable to one of
		    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		   // throw new PendingException();
		});

		}
//	
	

}
