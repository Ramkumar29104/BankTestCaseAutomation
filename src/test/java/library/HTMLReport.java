package library;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class HTMLReport {
	
	public static ExtentSparkReporter html;
	public static ExtentReports extent;
	public ExtentTest test,node;
	public String author,category;
	
	
	public void startReport() {
		html = new ExtentSparkReporter("./report/UIBank.html");
		extent = new ExtentReports();
		extent.attachReporter(html);
	}
	
	public void endReport() {
		extent.flush();
	}
	
	public ExtentTest startTestCase(String testCaseName, String testDescription) {
		test=extent.createTest(testCaseName,testDescription);
		test.assignAuthor(author);
		test.assignCategory(category);
		return test;
	}
	
	public ExtentTest startTestCase(String module) {
		node = test.createNode(module);
		return node;
	}
	
	public void reportStep(String desc, String status) {
		try {
			if(status.equalsIgnoreCase("pass")) {
				System.out.println("This testcase is passed");
				  node.pass(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
				 
			}else if(status.equalsIgnoreCase("fail")) {
				node.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
			} else {
				node.info(desc);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public abstract String takeScreenshot();
	

}
