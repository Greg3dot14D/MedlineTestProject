package ru.greg3d.util;
import java.io.IOException;

import org.json.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesLoader {

	public static DesiredCapabilities loadCapabilities(String fileName, String capabilitiesName) throws IOException{
		//String json = IOHelper.readFileToString(fileName, IOHelper.ENCODING_UTF8);
		String json = IOHelper.readFileToString18(fileName, IOHelper.ENCODING_UTF8);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		try{
		JSONObject obj = new JSONObject(json);
    	
		for(Object name : obj.getJSONObject(capabilitiesName).names()){
    		cap.setCapability(name.toString(), obj.getJSONObject(capabilitiesName).getString(name.toString()));
    		System.out.println("Cap ->" + name.toString() + "\nValue ->"+ obj.getJSONObject(capabilitiesName).getString(name.toString()));
    	}
		}catch(org.json.JSONException e){
			System.out.println(e.getMessage());
		}
		return cap;
	}
}
