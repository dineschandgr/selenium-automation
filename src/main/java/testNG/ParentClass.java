package testNG;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class ParentClass {
	
	@BeforeSuite
	public void prerequisite() {
		System.out.println("execute first");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("runs before every test");
	}

}
