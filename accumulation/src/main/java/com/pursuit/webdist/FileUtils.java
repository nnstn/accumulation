package com.pursuit.webdist;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class FileUtils {

	/**
	 * 得到路径下对应所有的文件及文件夹
	 * 
	 * @param path
	 * @return
	 */
	public static File[] fileList(String path) {
		File file = new File(path);
		return file.listFiles();
	}

	/**
	 * 得到路径下符合条件的文件及文件夹
	 * 
	 * @param path
	 * @param cond
	 * @return
	 */
	public static File[] fileList(String path, final String cond) {
		File file = new File(path);
		return file.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.indexOf(cond) >= 0;
			}

		});
	}

	/**
	 * 读取文件
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String readFile(String path) throws IOException {
		File file = new File(path);
		StringBuffer strBuffer = new StringBuffer();
		Reader reader = null;
		BufferedReader breader = null;
		try {
			reader = new FileReader(file);
			breader = new BufferedReader(reader);
			String strline = null;
			while ((strline = breader.readLine()) != null) {
				strBuffer.append(strline + "\n");
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("文件不能被发现！");
		} catch (IOException e) {
			throw new IOException("文件读取中出现了异常！");
		} finally {
			if (breader != null)
				breader.close();
			if (reader != null)
				reader.close();
		}
		return strBuffer.toString();
	}
	
	
	/**
	 * @param file
	 * @param code
	 * @return
	 * @throws IOException
	 */
	public static String readFile(String path,String code) throws IOException{
		FileInputStream fInputStream = new FileInputStream(path);  
		//code为上面方法里返回的编码方式  
		InputStreamReader inputStreamReader = new InputStreamReader(fInputStream, code);  
		BufferedReader in = new BufferedReader(inputStreamReader);  
		StringBuilder sBuffer=  new StringBuilder();
		String strTmp = "";  
		//按行读取  
		while (( strTmp = in.readLine()) != null) {  
		    sBuffer.append(strTmp + "/n");  
		}  
		return sBuffer.toString();  
	}
	/**
	 * 写文件
	 * @param path
	 * @param content
	 * @throws IOException
	 */
    public static void writeFile(String path , String content) throws IOException{
	    File file = new File(path);
	    Writer writer = null;
	    BufferedWriter bwriter = null;
	    PrintWriter out = null;
	    try {
			writer = new FileWriter(file , true);
			bwriter = new BufferedWriter(writer);
			out = new PrintWriter(bwriter);
			out.println(content);
		} catch (IOException e) {
			throw new IOException("写文件出现了异常！");
		} finally {
			if(out != null) out.close();
			if(bwriter != null) bwriter.close();
			if(writer != null) writer.close();
		}
	}
	/**
	 * 创建文件
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static boolean createFile(String path) throws IOException{
		File file = new File(path);
		try {
			return file.createNewFile();
		} catch (IOException e) {
			throw new IOException("文件创建失败！");
		}
	}
	/**
	 * 创建多个文件夹
	 * @param path
	 * @return
	 */
	public static boolean mkdirs(String path){
		File file = new File(path);
	    return file.mkdirs();
	}
	
	/**
	 * 更换名称
	 * @param oldpath 
	 * @param newfname
	 * @return
	 */
	public static boolean renameFile(String oldpath , String newfname){
		File oldfile = new File(oldpath);
		File newfile = new File(oldpath.substring(0, oldpath.indexOf("\\") + 1) + newfname);
		return oldfile.renameTo(newfile);
	}
	
	/**
	 * 删除文件及文件夹
	 * @param path
	 * @return
	 */
	public static boolean delete(String path){
		File file = new File(path);
	    return file.delete();
	}
	
	
	/** 
	 * 判断文件的编码格式 
	 * @return 文件编码格式 
	 * @throws Exception 
	 */  
	public static String codeString(File fileName) throws Exception{  
	    BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));  
	    int p = (bin.read() << 8) + bin.read();  
	    System.out.println(p);
	    String code = null;  
	    switch (p) {  
	        case 0xefbb:  
	            code = "UTF-8";  
	            break;  
	        case 0xfffe:  
	            code = "Unicode";  
	            break;  
	        case 0xfeff:  
	            code = "UTF-16BE";  
	            break;  
	        default:  
	            code = "GBK";  
	    }  
	    return code;  
	}
	
}
