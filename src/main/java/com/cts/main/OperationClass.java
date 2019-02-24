package com.cts.main;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;


public class OperationClass {
	
	
	public String executeCommand(String fileLocation, String xsdLocation) {
		
	
		StringBuffer sb=new StringBuffer();
		
		String cmd="ls -lrt";
		try {
			Process process=Runtime.getRuntime().exec(cmd);
			
			List<String> result=IOUtils.readLines(process.getInputStream());
			for(String line:result) {
				sb.append(line);
				sb.append("\n");
			}
			System.out.println(sb.toString());
			return sb.toString();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error occured while validation";
		}catch(NullPointerException exp) {
			exp.printStackTrace();
			return "Error occured while validation";
		}catch(Exception ex) {
			ex.printStackTrace();
			return "Error occured while validation";
		}
		
		
		
	}

}
