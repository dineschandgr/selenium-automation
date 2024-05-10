package testNG;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG3 {
	
	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("I will run before class");
	}
	
	@BeforeMethod
	public void beforeAllMethods() {
		System.out.println("I will run before all method in TestNG3");
	}
	
	@Test
	@Parameters({"testurl"})
	public void webLogin(String testurl) {
		System.out.println("web login TestNG3 "+testurl);
	}
	
	@Test(dependsOnMethods= {"webLogin"})
	public void mobileLogin() {
		System.out.println("mobile login TestNG3");
	}
	
	@Test(dependsOnMethods= {"mobileLogin"})
	public void mobileLogout() {
		System.out.println("mobile logout TestNG3");
	}
	
	@Test(enabled = false, groups = {"testGroup"}, timeOut = 4000)
	public void LoginAPICarLoan() {
		System.out.println("LoginAPICarLoan TestNG3");
	}	
	
	@AfterMethod
	public void afterAllMethods() {
		System.out.println("I will run after all method in TestNG3");
	}

	
}
