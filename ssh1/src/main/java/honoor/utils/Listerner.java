package honoor.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/** 
 * @author 作者 honoo 
 * @version 创建时间：2017年8月22日 上午11:18:21 
 * 类说明 
 */
public class Listerner implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		
		
		// TODO Auto-generated method stub
		System.out.println("tomcat开始");
		
		
		Timer timer=new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				Properties proper=new Properties();
			
			     try {
			    	/* File file=new File("");
			 		String str=file.getAbsolutePath();*/
			 		
					
					System.out.println( Listerner.class.getResourceAsStream("/config.properties")+"12");
					proper.load(Listerner.class.getResourceAsStream("/config.properties"));
					System.out.println(proper.get("kstart")+"start");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("文件异常");
				}
				// TODO Auto-generated method stub
				method1("http://"+proper.get("urlip")+":"+proper.get("urlport")+"/ssh1/first_submitData");
			}
		}, 3000);
		
		
		
		       
	}

	public static void method1(String url1) {

        try {
            
            URL url = new URL(url1);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type",
                    "application/json");
            connection.connect();
            OutputStreamWriter out=new OutputStreamWriter(connection.getOutputStream(),"utf-8" );
            out.flush();
            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");   
            reader.close();
            connection.disconnect();
     
          
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
       
    }
	
	
}
