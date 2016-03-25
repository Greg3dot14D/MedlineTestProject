package ru.greg3d.util;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.sound.midi.Patch;

public class IOHelper {

    public static final String ENCODING_WIN1251 = "windows-1251";
    public static final String ENCODING_UTF8 = "UTF-8";
    
	public static String readFileToString(String fileName, String encoding){
		
		StringBuilder sb = new StringBuilder("");
		try {
			BufferedReader br = new BufferedReader(
				      new InputStreamReader(
				          new FileInputStream(fileName),encoding));
			String line = "";
			try {
				while( (line = br.readLine()) != null){
					sb.append("\n" + line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			br.close();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String readFileToString18(String fileName, String encoding){
		
		String retValue = "";
		
		try {
			retValue = Files.lines(Paths.get(fileName.substring(1)), Charset.forName(encoding))
							.reduce((s1, s2)-> s1+"\n" + s2)
							.get();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retValue;
	}
}
