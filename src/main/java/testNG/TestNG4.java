package testNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestNG4 {
	
	
	@Test
	public void webLoginHomeLoan() {
		System.out.println("web login");
	}
	
	@Test
	public void mobileLoginHomeLoan() {
		System.out.println("mobile login");
	}
	
	@Test(groups = {"testGroup"})
	public void LoginAPIHomeLoan() {
		System.out.println("LoginAPICarLoan");
	}
	
	@AfterTest
	public void testExit() {
		System.out.println("Exit test case");
	}

}
