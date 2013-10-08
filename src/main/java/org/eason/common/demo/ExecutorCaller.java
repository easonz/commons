package org.eason.common.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExecutorCaller {
	private static Logger logger = LoggerFactory.getLogger(ExecutorCaller.class);
	
	private static String exePath = "";
	private static String exeName = "target.exe";
	private static Process process = null;

	public ExecutorCaller() {
		exePath = "" + exeName;
	}

	public void execute(){
		File file = null;
		
		try {
			file = new File(exePath + "/" + exeName);
			if (!file.exists()) {
				logger.error("executor {} not found!");
				return;
			}
			
			String[] cmdarray = { exePath };
			
			logger.info(StringUtils.join(cmdarray, "\r\n"));
			
			process = Runtime.getRuntime().exec(cmdarray);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				logger.info("read from app: " + line);
			}
			process.waitFor();
			
		} catch (Throwable e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		} finally {
			if (process != null) {
				process.destroy();
			}
		}
		logger.info("executer executed.");
	}
}
