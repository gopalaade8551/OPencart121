package utilities;

import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DataSourceResolver;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	
	public void OnStart(ITestContext testcontext)
	{
		/*
		      SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		      Date dt=new Date();
		     String currentdatetimestamp=df.format(dt);
		     */
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//Time stamp
		repName="Test-Report- "+timestamp+".html";
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);//spacify the location of the report
		
		sparkReporter.config().setDocumentTitle("Opencart Automation Report");//Title of the Report
		sparkReporter.config().setReportName("Opencart functional Testing");//Name of the Report
		sparkReporter.config().setTheme(Theme.DARK);
		
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "OpenCart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customer");
		extent.setSystemInfo("Username", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		
		String os=testcontext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		
		String browser=testcontext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includegroups=testcontext.getCurrentXmlTest().getIncludedGroups();
		if(!includegroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includegroups.toString());
		}
	}
	
	public void onTestSuccess(ITestResult result)
	{
	    test=extent.createTest(result.getTestClass().getName());
	    test.assignCategory(result.getMethod().getGroups());//to display groups in report
	    test.log(Status.PASS, result.getName()+"got successfully passed");
	}
	
	
	public void onTestFail(ITestResult result) 
	{
		
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+"test failed");
		
		test.log(Status.INFO, result.getThrowable().getMessage());
		String imgpath=new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgpath);
		
	}
	public void OnTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skiped");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
	}
	
	public void Onfinish(ITestContext testContext) 
	{
		extent.flush();
		String pathofextentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport=new File(pathofextentReport);
		
		try
		{
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		//try {
		
			/*
	      URL url=new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
	      
	      
	      //Create the email message
	      ImageHtmlEmail email=new ImageHtmlEmail();
	      email.setDataSourceResolver(new DataSourceUrlResolver(url));
	      email.setHostName("smtp.googlemail.com");
	      email.setSmtpPort(465);
	      email.setAuthenticator(new DefaultAuthenticator("gopalade8551@gmail.com","Gopal789#"));
	      email.setSSLOnConnect(true);
	      email.setFrom("gopalade8551@gmail.com");//sender
	      email.setSubject("Test Results");
	      email.setMsg("Please Find Attached Report");
	      email.addTo("gopalade681@gmail.com");//Receiver
	      email.attach(url,"extent Report","Please check report....");
	      email.send();//send the email
		}
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
	      */
	}
}
	      
		
	 
	


