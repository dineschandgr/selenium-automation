package testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG1 extends ParentClass{
	
	
	
	
	@Test(dependsOnMethods= {"webLogin2"})
	@Parameters({"testurl","testpwd"})
	public void webLogin1(String testurl, String password) {
		System.out.println("web login1 TestNG3 "+testurl + " password "+password);
	}
	

	@Test
	@Parameters({"testurl","testpwd"})
	public void webLogin2(String testurl, String password) {
		System.out.println("web login2 TestNG3 "+testurl + " password "+password);
		Assert.assertTrue(false);
	}
	
	
	@Test(groups = {"testGroup"})
	public void demo1() {
		System.out.println("demo1");
	}
	
	@Test(groups = {"testGroup"})
	public void second() {
		System.out.println("second");
		
	}
	
	@Test(dataProvider="getData")
	public void LoginAPICarLoan(String userName, String password) {
		System.out.println("LoginAPICarLoan "+userName +" password "+password);
	}
	
	
	@DataProvider
	public Object getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "firstsetusername";
		data[0][1] = "firstsetpassword";
		
		data[1][0] = "secondsetusername";
		data[1][1] = "secondsetpassword";
		
		data[2][0] = "thirdsetusername";
		data[2][1] = "thirdsetpassword";
		
		
		return data;
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
