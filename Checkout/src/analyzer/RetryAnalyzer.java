package analyzer;

import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	public static WebDriver webDriver;
	int count = 0;
	int limit = 1000;
	
	public boolean retry(ITestResult result){
		
		
		

	if(count<limit){
		
		
		count++;
	return true;
	}
	return false;
	
	

	}
}
