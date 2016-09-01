package com.pursuit.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MavenRemove {
	static List<String> filelist = new ArrayList<String>();
	
	public static void main(String[] args) {
		removeNojar("D:/repository/maven/repo");
	
	}
	public static void removeNojar(String  mavenpath){
		//1.获取文件夹下所有备选删除的文件
		getFile(new File(mavenpath));
		
		//2.删除文件夹
		removefilelist();
	}
	private static void removefilelist() {
		for (int i = 0; i < filelist.size(); i++) {
			String path = filelist.get(i);
			System.out.println("删除："+path+"   ");
			System.out.println(deleteDir(new File(path)));
		}
		
	}
	public static void getFile(File file){
		if(file.isDirectory()){
			if(isSecondLeafFlag(file)){
				if(removeFlag(file)){
					filelist.add(file.getAbsolutePath());
				}
			}else{
				File[] bigFiles = file.listFiles();
				for (int i = 0; i < bigFiles.length; i++) {
					getFile(bigFiles[i]);
				}
			}
			return;
		}
		System.out.println("====遍历到单元素:"+file.getAbsolutePath());
		return;
	}
    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * 删除文件夹，要先删除其子元素
     * true：删除成功
     * false：删除失败
     */
    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        System.out.println(dir);
        return dir.delete();
    }
	/**
	 * 判断是否是二级节点
	 * @param files
	 * @return
	 */
	public static boolean isSecondLeafFlag(File files){
		boolean flag =true;
		File[] children = files.listFiles();
		if(children.length==0){
			flag=false;
		}
		for (int i = 0; i < children.length; i++) {
			File file = children[i];
			if(file.isDirectory()){
				flag =false;
				break;
			}
		}
		return flag;
	}
	/**
	 * @param files
	 * @return
	 * true删除该文件
	 * false不删除
	 */
	public static boolean removeFlag(File files){
		boolean flag =true;
		if(files.getName().startsWith(".")){
			return false;
		}
		
		File[] children = files.listFiles();
		
		for (int i = 0; i < children.length; i++) {
			File file = children[i];
			
			if(file.isDirectory())System.out.println("算法出现问题");
			
			if(file.getName().endsWith(".jar")){
				flag =false;
				break;
			}
		}
		return flag;
	}
}
