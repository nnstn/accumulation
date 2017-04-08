package com.pursuit.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class FileCharsetConverter {
 
    public static void main(String[] args) throws Exception {
        convert("E:/研磨设计模式/designpattern","UTF-8", new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                    	//System.out.println(dir.getAbsolutePath()+"//"+name);
                        return name.endsWith("java")||new File(dir.getAbsolutePath()+"//"+name).isDirectory();
                    }
                });
        //convert("E:/研磨设计模式/designpattern/src/cn/javass/dp/abstractfactory/example2", "UTF-8");
    	//convert("E:/研磨设计模式/file1.txt", "UTF-8");
    	//System.out.println(codeString(new File("E:/研磨设计模式/file1.txt")));
    }
 
    /**
     * 把指定文件或目录转换成指定的编码
     * 
     * @param  要转换的文件
     * @param  源文件的编码
     * @param  要转换的编码
     * @throws Exception
     */
    public static void convert(String fileName,String toCharsetName) throws Exception {
        convert(new File(fileName), toCharsetName, null);
    }
 
    /**
     * 把指定文件或目录转换成指定的编码
     * 
     * @param file
     *            要转换的文件或目录
     * @param fromCharsetName
     *            源文件的编码
     * @param toCharsetName
     *            要转换的编码
     * @throws Exception
     */
    public static void convert(File file, String toCharsetName) throws Exception {
        convert(file, toCharsetName, null);
    }
 
    /**
     * 把指定文件或目录转换成指定的编码
     * 
     * @param 要转换的文件或目录
     * @param 源文件的编码
     * @param 要转换的编码
     * @param 文件名过滤器
     * @throws Exception
     */
    public static void convert(String fileName,String toCharsetName, FilenameFilter filter) throws Exception {
        convert(new File(fileName), toCharsetName, filter);
    }
 
    /**
     * 把指定文件或目录转换成指定的编码
     * 
     * @param 要转换的文件或目录
     * @param 源文件的编码
     * @param 要转换的编码
     * @param 文件名过滤器
     * @throws Exception
     */
    public static void convert(File file, String toCharsetName, FilenameFilter filter) throws Exception {
    	if (file.isDirectory()) {
            File[] fileList = null;
            if (filter == null) {
                fileList = file.listFiles();
            } else {
                fileList = file.listFiles(filter);
            }
            for (File f : fileList) {
                convert(f, toCharsetName, filter);
            }
        } else {
            if (filter == null|| filter.accept(file.getParentFile(), file.getName())) {
            	String fromCharsetName =codeString(file);
            	System.out.println(fromCharsetName+file);
                String fileContent = getFileContentFromCharset(file,fromCharsetName);
                saveFile2Charset(file, toCharsetName, fileContent);
            }
        }
    }
	/** 
	 * 判断文件的编码格式 
	 * @return 文件编码格式 
	 * @throws Exception 
	 */  
	public static String codeString(File fileName) throws Exception{
		System.out.println(fileName);
	    BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));  
	    byte[] b = new byte[3];
	    int read = bin.read(b);
	   // bin.close();  
	    if (b[0] == -17 && b[1] == -69 && b[2] == -65)  
	        System.out.println(fileName.getName() + "：编码为UTF-8");  
	    else  
	        System.out.println(fileName.getName() + "：可能是GBK，也可能是其他编码");  
	    
	    System.out.println(read);
	    int p = (bin.read() << 8) + bin.read();  
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
 
    /**
     * 以指定编码方式读取文件，返回文件内容
     *
     * @param 要转换的文件
     * @param 源文件的编码
     * @throws Exception
     */
    public static String getFileContentFromCharset(File file,
            String fromCharsetName) throws Exception {
        if (!Charset.isSupported(fromCharsetName)) {
            throw new UnsupportedCharsetException(fromCharsetName);
        }
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream,fromCharsetName);
        char[] chs = new char[(int) file.length()];
        reader.read(chs);
        String str = new String(chs).trim();
        reader.close();
        return str;
    }
 
    /**
     * 以指定编码方式写文本文件，存在会覆盖
     * 
     * @param 要写入的文件
     * @param 要转换的编码
     * @param 文件内容
     * @throws Exception
     */
    public static void saveFile2Charset(File file, String toCharsetName,
            String content) throws Exception {
        if (!Charset.isSupported(toCharsetName)) {
            throw new UnsupportedCharsetException(toCharsetName);
        }
        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter outWrite = new OutputStreamWriter(outputStream,toCharsetName);
        outWrite.write(content);
        outWrite.close();
    }
}