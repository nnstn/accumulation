package com.pursuit.checkcode;

import java.awt.Font;  
import java.awt.Graphics2D;  
import java.awt.image.BufferedImage;  
import java.io.IOException;  

import javax.imageio.ImageIO;  
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
public class CheckCode extends HttpServlet{  
    
	private static final long serialVersionUID = 1L;
	
	HttpServletResponse response;
	HttpServletRequest request;
	
    public void checkcode(){  
        //设置不缓存图片  
        response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "No-cache");  
        response.setDateHeader("Expires", 0) ;  
        //将图形写给浏览器  
        response.setContentType("image/jpeg") ;  
        
        IdentifyingCode idCode = new IdentifyingCode();  
        BufferedImage image =new BufferedImage(idCode.getWidth() , idCode.getHeight() , BufferedImage.TYPE_INT_BGR) ;  
        Graphics2D g = image.createGraphics() ;  
        //定义字体样式  
        Font myFont = new Font("宋体" , Font.BOLD , 20) ;  
        //设置字体  
        g.setFont(myFont) ;  
        g.setColor(idCode.getRandomColor(200 , 250)) ;  
        //绘制背景  
        g.fillRect(0, 0, idCode.getWidth() , idCode.getHeight()) ;  
        g.setColor(idCode.getRandomColor(180, 200)) ;  
        //画干扰线
        idCode.drawRandomLines(g, 160) ;  
        String checkcode = idCode.drawRandomString(4, g); 
        request.getSession().setAttribute("checkcode", checkcode);
        g.dispose() ;  
        try {
			ImageIO.write(image, "JPEG", response.getOutputStream()) ;
		} catch (IOException e) {
			e.printStackTrace();
		}  
    }
}  