package TrueCaller;

import org.testng.annotations.DataProvider;

public class data_provider {
	@DataProvider(name="loginsuccess")
	public static Object[][] login()
	{
		Object[][] a=new Object[2][2];
		
		a[0][0]="Email@gmail.com";
		a[0][1]="Password";
		
				
		
		return a;
	}

}
