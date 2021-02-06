
package test.Campaign_S3_POMCucumberTransition;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import library.data.reader.ReadExcel;
import library.page.object.model.LoginPage;
import library.utility.Utility;

public class S2055DeleteOpportunity extends Utility {


	@Test(dataProvider = "CreateCampaign")
	public void mainflow(
			String url,
			String uid,
			String pwd,
			String browser,
			String cn, 
			String fn, 
			String ln, 
			String compo       ) throws AWTException  
	{
		cls = "S2054EditCampaign.class";	
		String opp_Name = "Salesforce Automation by Palanimohan";
		
		new LoginPage(driver)
		.browser_Selection(browser, url);
		
		new LoginPage(driver)
		.login_UserName_Type(uid)										// Enter SF login username
		.login_Password_Type(pwd)										// Enter SF login password
		.login_Submit_Click()											// Click login button
		.verifyTitle("Home | Salesforce")	
		.clickToggle()												//2. Click on the toggle menu button from the left corner
		.viewAll()
		.appLauncher_Sales_Click()										// Click on Sales link
		.opportunities_Click()											//4. Click on the Campaigns tab 
		.opportunity_DeletefromList_Click(opp_Name);
		
		}

	
	
	@DataProvider(name = "CreateCampaign")
	public Object[][] getdata() throws IOException
	{
		ReadExcel rexl = new ReadExcel();
		Object[][] data = rexl.readdata("CreateCampaign");
		return data;
		
	}
	
	
	
}

