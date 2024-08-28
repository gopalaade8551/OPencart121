package utilities;




import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dataprovider {
	//String logindata[][];
	
	@DataProvider(name="Logindata")
	public String[][] getData() throws IOException   
	{
		String path=".\\testData\\Login_data.xlsx";
		
		excelutility xlutil=new excelutility(path);
		
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getcellcount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols];
		for(int i=1;i<totalrows;i++) //1  // read the data from xl and store into the two dimensional array
		{
			for(int j=0;j<totalcols;j++)//0   //i is row and j is col
			{
				
				logindata[i-1][j]=xlutil.GetCellData("sheet1", i, j);
			}
		}
		return logindata;
	}
}
		
		
	/*	
		@DataProvider(name = "Logindata")
	    public Object[][] getLoginData() {
	        return new Object[][] {
	            {"validEmail@example.com", "validPassword", "valid"},
	            {"invalidEmail@example.com", "invalidPassword", "invalid"}
	        };
	    }
		

	}
	*/


