package keywords;

import org.testng.Assert;

public class ValidationKeyWords extends GenericKeyWords {
	public void validateTitle(String expectedTitle)
	{
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
	
	

}
