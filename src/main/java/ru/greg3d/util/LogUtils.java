package ru.greg3d.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class LogUtils {
	private String capabilityName;
	private String folderName;
	private WebDriver driver;
	
	public LogUtils(WebDriver driver){
		this.driver = driver;
	}
	
	public void setCapabilityName(String capabilityName){
		this.capabilityName = capabilityName;
	}
	
	public void setFolderName(String folderName){
		this.folderName = folderName;
	} 
	
	public String getScreenshot(String fileName){
		StringBuilder sbPath = new StringBuilder();
		StringBuilder sbFile = new StringBuilder();
		if(this.folderName != null) sbPath.append(this.folderName);
		if(this.capabilityName != null) sbPath.append(this.capabilityName).append("/");
		sbFile.append(Calendar.getInstance().getTimeInMillis());
		//if(this.capabilityName != null) sb.append("_").append(this.capabilityName);
		sbFile.append("_").append(fileName);
		getScreenshot(this.driver, sbPath.append(sbFile).toString());
		
		return sbFile.toString();
	}
	
	public static void getScreenshot(WebDriver driver, String fileName){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File(fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getScreenshotWhithTimePreffix(WebDriver driver, String fileName){
		getScreenshot(driver, Calendar.getInstance().getTimeInMillis() + "_" + fileName);
	}	
}
