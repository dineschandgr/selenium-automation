package Advanced.testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG1 {
	
	
	@BeforeSuite
	public void prerequisite() {
		System.out.println("execute first");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("runs before every test");
	}
	

	@Test
	@Parameters({"testurl"})
	public void webLogin(String testurl) {
		System.out.println("web login TestNG3 "+testurl);
	}
	
	public void demo1() {
		System.out.println("demo1");
	}
	
	@Test
	public void second() {
		System.out.println("demo2");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("runs after every test");
	}
	
	@AfterTest
	public void last() {
		System.out.println("after all test");
	}

}
