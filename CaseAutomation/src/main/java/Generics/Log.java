package Generics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;

public class Log {
	
	private SimpleDateFormat dateFormat;
	private SimpleDateFormat dateFormatFile;
	private SimpleDateFormat dateFormatFileLog;
	Charset charset;
	private WebDriver driver;
	private File file;
	private String path;
	
	public Log(WebDriver driver) {
		this.driver = driver;
		dateFormat = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
		dateFormatFile = new SimpleDateFormat("'Date'_d-MM-yyyy_'Time'_HH.mm.ss");
		dateFormatFileLog = new SimpleDateFormat("'Date'_d-MM-yyyy");
		charset = Charset.forName("UTF-8");
		path = "Log/ID_"+dateFormatFile.format(Calendar.getInstance().getTime())+"/";
		file = new File(path + dateFormatFileLog.format(Calendar.getInstance().getTime())  + ".log");
	}
	
	public void setNewLog(String tag, String desciption){
		String logMenssage = dateFormat.format(Calendar.getInstance().getTime()) + " - [" + tag + "]: " + desciption;
		System.out.println(logMenssage);
		try {

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(logMenssage+"\n");
			bw.close();
			System.out.println("[Log.setNewLog] Export Log Sucess");	

		} catch (Exception e) {
			System.out.println("[Log.setNewLog] Error Export Log");			
		}
		
	}

	public void screenshot(){	
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String nameFile = dateFormatFile.format(Calendar.getInstance().getTime());
		try {
			FileUtils.copyFile(scrFile, new File(path + nameFile +".png"));
			//setNewLog("Log.screenshot", "Sucess screenshot");
		} catch (IOException e) {
			//setNewLog("Log.screenshot", "Error screenshot");
		}
	
	}
	
}