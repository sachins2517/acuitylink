package test.java;

public class Run{

	public static void main(String[] args) throws Exception {
	
		HIsignup hi = new HIsignup();
		hi.setUp();
		hi.testSignupHI();
		hi.tearDown();
		
		SignupASP asp = new SignupASP();
		asp.setUp();
		asp.testSignupASP();
		asp.tearDown();
		
		Approval a = new Approval();
		a.setUp();
		a.testApproval();
		a.tearDown();
		
		Thread.sleep(2000);
		
		HIScenario his = new HIScenario();
		his.setUp();
		his.testHIScenario();
		//his.tearDown();
		
		ASPScenario asps = new ASPScenario();
		asps.setUp();
		asps.testASPScenario();
		asps.tearDown();
	}
}
