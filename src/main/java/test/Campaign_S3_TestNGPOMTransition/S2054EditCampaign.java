
package test.Campaign_S3_TestNGPOMTransition;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import library.data.reader.ReadExcel;
import library.page.object.model.LoginPage;
import library.utility.Utility;

public class S2054EditCampaign extends Utility {

	public S2054EditCampaign(RemoteWebDriver driver) {
		this.driver = driver;
	}



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
		String campaign_Name = fn + ln + "_"+cn;
		String expectedRevenue = "$1,000,000";
		String budgetCost = "$100,000";
		
		
		new LoginPage(driver)
		.browser_Selection(browser, url)
		.login_UserName_Type(uid)										// Enter SF login username
		.login_Password_Type(pwd)										// Enter SF login password
		.login_Submit_Click()											// Click login button
		.verifyTitle("Home | Salesforce")	
		.clickToggle()												//2. Click on the toggle menu button from the left corner
		.viewAll()
		.appLauncher_Sales_Click()										// Click on Sales link
		.campaigns_Click()											//4. Click on the Campaigns tab 
		.campaigns_PickCampaignfromList_Click(campaign_Name)		//5. Click the Bootcamp link	
		.campaigns_Details_Click()									//6. Click on the Details tab
		.campaigns_Scroll()
		.campaigns_CampaignsDetails_EditEndDate_Click()				//7. Change the End Date as Today+4f
		.campaigns_Scroll()
		.campaigns_CampaignsDetails_EndDate_Click()
		.campaigns_CampaignsDetails_EndDate_CalenderClick(4)
		.campaigns_CampaignsDetails_EditRevenue_Type(expectedRevenue) 		//8. Update the Expected Revenue as 1000000
		.campaigns_CampaignsDetails_EditBudget_Type(budgetCost) 			//9. Update the Budget Cost in Campaign as 100000
		.campaigns_CampaignsDetails_EditSave_Click()						//10. Click on Save and verify the updated values
		.S2054EditCampaign_end_validation(expectedRevenue,budgetCost);
		
		}

	
	
	@DataProvider(name = "CreateCampaign")
	public Object[][] getdata() throws IOException
	{
		ReadExcel rexl = new ReadExcel();
		Object[][] data = rexl.readdata("CreateCampaign");
		return data;
		
	}
	
	
	
}

