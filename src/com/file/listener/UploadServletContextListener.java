package com.file.listener;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class UploadServletContextListener
 *
 */
@WebListener
public class UploadServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	Properties pp = new Properties();
		try {
			pp.load(
					UploadServletContextListener
					.class
					.getClassLoader().
					getResourceAsStream("com/file/conf/upload.properties"));
			System.out.println("监听器已启动-----" + pp.getProperty("uploadPath"));
			sce.getServletContext().
			setAttribute("uploadPath", pp.getProperty("uploadPath"));
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
