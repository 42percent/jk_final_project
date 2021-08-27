package bit.your.prj.util;

import java.util.Date;

public class PdsUtil {

	public static String getNewFileName(String f) {
		String filename = "";
		String fpost = "";
		
		if(f.indexOf('.') >= 0) {	// 확장자명이 있음			
			fpost = f.substring( f.indexOf('.') );		//	abc.txt -> .txt
			filename = "1"+ new Date().getTime() + fpost;	//  32342342.txt
		}else {
			filename = new Date().getTime() + ".back";
		}
		
		return filename;
	}
	
	public static String getNewFileName2(String f) {
		String filename = "";
		String fpost = "";
		
		if(f.indexOf('.') >= 0) {	// 확장자명이 있음			
			fpost = f.substring( f.indexOf('.') );		//	abc.txt -> .txt
			filename = "1"+new Date().getTime() + fpost;	//  32342342.txt
		}else {
			filename = new Date().getTime() + ".back";
		}
		
		return filename;
	}
	
	public static String getNewFileNamea(String f) {
		String filenamea = "";
		String fposta = "";
		
		if(f.indexOf('.') >= 0) {	// 확장자명이 있음			
			fposta = f.substring( f.indexOf('.') );		//	abc.txt -> .txt
			filenamea = "2"+ new Date().getTime() + fposta;	//  32342342.txt
		}else {
			filenamea = new Date().getTime() + ".back";
		}
		
		return filenamea;
	}
	public static String getNewFileNameb(String f) {
		String filenameb = "";
		String fpostb = "";
		
		if(f.indexOf('.') >= 0) {	// 확장자명이 있음			
			fpostb = f.substring( f.indexOf('.') );		//	abc.txt -> .txt
			filenameb = "3"+new Date().getTime() + fpostb;	//  32342342.txt
		}else {
			filenameb = new Date().getTime() + ".back";
		}
		
		return filenameb;
	}
	public static String getNewFileNamec(String f) {
		String filenamec = "";
		String fpostc = "";
		
		if(f.indexOf('.') >= 0) {	// 확장자명이 있음			
			fpostc = f.substring( f.indexOf('.') );		//	abc.txt -> .txt
			filenamec = "4"+new Date().getTime() + fpostc;	//  32342342.txt
		}else {
			filenamec = new Date().getTime() + ".back";
		}
		
		return filenamec;
	}
	public static String getNewFileNamed(String f) {
		String filenamed = "";
		String fpostd = "";
		
		if(f.indexOf('.') >= 0) {	// 확장자명이 있음			
			fpostd = f.substring( f.indexOf('.') );		//	abc.txt -> .txt
			filenamed = "5"+new Date().getTime() + fpostd;	//  32342342.txt
		}else {
			filenamed = new Date().getTime() + ".back";
		}
		
		return filenamed;
	}
	public static String getNewFileNamee(String f) {
		String filenamee = "";
		String fposte = "";
		
		if(f.indexOf('.') >= 0) {	// 확장자명이 있음			
			fposte = f.substring( f.indexOf('.') );		//	abc.txt -> .txt
			filenamee = "6"+new Date().getTime() + fposte;	//  32342342.txt
		}else {
			filenamee = new Date().getTime() + ".back";
		}
		
		return filenamee;
	}
	public static String getNewFileNamef(String f) {
		String filenamef = "";
		String fpostf = "";
		
		if(f.indexOf('.') >= 0) {	// 확장자명이 있음			
			fpostf = f.substring( f.indexOf('.') );		//	abc.txt -> .txt
			filenamef = "7"+new Date().getTime() + fpostf;	//  32342342.txt
		}else {
			filenamef = new Date().getTime() + ".back";
		}
		
		return filenamef;
	}
}




