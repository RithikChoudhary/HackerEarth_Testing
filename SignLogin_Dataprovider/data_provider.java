package selenium.ReportSelenium;

import org.testng.annotations.DataProvider;

public class data_provider {
	@DataProvider(name="signin")
	public static Object[][] signin()
	{
		Object[][] a=new Object[1][4];
		
		a[0][0]="hacker";
		a[0][1]="earth";
		
		a[0][2]="earthhacked@gmail.com";
		a[0][3]="hacked_By_Devops";
				
		
		return a;
	}
	@DataProvider(name="login")
	public static Object[][] login()
	{
		Object[][] b = new Object[1][2];
		b[0][0] = "earthhacked@gmail.com";
		b[0][1] = "hacked_By_Devops";
		
		return b;
	}

}
