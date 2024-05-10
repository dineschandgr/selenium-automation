package testNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG2 {

	@Test(groups = { "testGroup" })
	@Parameters({ "URL", "testpwd" })
	public void webLogin(String urlname, String testPwd) {
		System.out.println("web login " + urlname);
		System.out.println("web testPwd " + testPwd);
	}

	@Test
	public void mobileLogin() {
		System.out.println("mobile login TestNG2");
	}

	@Test
	public void mobileLogout() {
		System.out.println("mobile logout");
		Assert.assertTrue(false);
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

}
