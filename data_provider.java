package TrueCaller;

import org.testng.annotations.DataProvider;

public class data_provider {
	@DataProvider(name="loginsuccess")
	public static Object[][] login()
	{
		Object[][] a=new Object[2][2];
		
		a[0][0]="burnt776@gmail.com";
		a[0][1]="Bilupilu@1173";
		
//		a[1][0]="500069261@stu.upes.ac.in";
//		a[1][1]="bilupilu@@";
				
		
		return a;
	}

}
