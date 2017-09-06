package honoor.utils;
/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年8月17日 下午4:25:29 
 * 类说明 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.liusm.ClientConnectImpl;


/**
 * @author 作者 honoo
 * @version 创建时间：2017年8月14日 下午2:05:17 类说明
 * 向LED发送请求
 * 
 */
public class Sock1Utils {
	
	OutputStream os;
	InputStream is ;
	BufferedReader br;
	Socket socket;
	 InputStream stream;
	
	 Logger logger=Logger.getLogger(Sock1Utils .class); 
@SuppressWarnings("resource")
public int connect(String ip,int port)  {
	
	
	int status = 1;
	
	 try {
		socket = new Socket(ip, port);
		
		os = socket.getOutputStream();
		 stream= socket.getInputStream();
			 
			//os.write(TextUtils.disPlayData("[s000]华诺实创","05"));/*第一行*/
			//os.write(TextUtils.disPlayData("[s000]欢迎光临","06"));/*第二行*/
			
			/*设置默认显示*/
			os.write(TextUtils.disPlayData("[s000]等待识别","17"));/*第三行*/
		//	os.write(TextUtils.disPlayData("[s000]"+simple.format(new Date()),"18"));/*第四行*/
		//	os.write(VoiceUtils.all(00,02));
			os.flush();
			status=stream.read();
			
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		
		System.out.println("连接失败,正在重新连接!");
try {
	socket = new Socket(ip, port);

	os = socket.getOutputStream();
	 stream= socket.getInputStream();
		 
		//os.write(TextUtils.disPlayData("[s000]华诺实创","05"));/*第一行*/
		//os.write(TextUtils.disPlayData("[s000]欢迎光临","06"));/*第二行*/
		
		/*设置默认显示*/
		os.write(TextUtils.disPlayData("[s000]等待识别","17"));/*第三行*/
		//os.write(TextUtils.disPlayData("[s000]"+simple.format(new Date()),"18"));/*第四行*/
		//os.write(VoiceUtils.all(00,02));
		os.flush();
		status=stream.read();
} 
 catch (Exception e1) {
	// TODO Auto-generated catch block
		
		System.out.println("连接失败,正在重新连接!");
try {
	socket = new Socket(ip, port);

	os = socket.getOutputStream();
	 stream= socket.getInputStream();
		 
	//	os.write(TextUtils.disPlayData("[s000]华诺实创","05"));/*第一行*/
	//	os.write(TextUtils.disPlayData("[s000]欢迎光临","06"));/*第二行*/
		
		/*设置默认显示*/
		os.write(TextUtils.disPlayData("[s000]等待识别","17"));/*第三行*/
		//os.write(TextUtils.disPlayData("[s000]"+simple.format(new Date()),"18"));/*第四行*/
		//os.write(VoiceUtils.all(00,02));
		os.flush();
		status=stream.read();
} 
catch (Exception e11) {
	// TODO Auto-generated catch block
	System.out.println("连接失败,请检查LED是否连接正确!");
}
		
}
		
		
	}
	if(status !=1 && status !=0){
		
		return 1;
	}
	
	 
		return status; 
		
}
	
	
      /*发送文字和语音        str1显示的文本,hang显示的行数,n类型                            */
	public void sendTextAndSound(String str1,String hang,int n) {

		try {
		
      if(n==0){
         	/*发送文字*/
    	  
			os.write(TextUtils.disPlayData(str1,hang));
			
      }
      else if(n==1){
    	 /* 
    	  */
    	  /*播报欢迎观临*/
	     byte[] wel={(byte)0xA5 ,(byte)0xA5 ,(byte)0x02 ,(byte)0x04 ,(byte)0x07 ,(byte)0x01 ,(byte)0x01 ,(byte)0xF6 ,(byte)0xBE ,(byte)0xEF};
	
      	os.write(wel);
      	
          }
      
      else if(n==2){
    	  /*播报卡未注册*/
    	  
    	  byte[] wel={(byte)0xA5 ,(byte)0xA5 ,(byte)0x02 ,(byte)0x04 ,(byte)0x10 ,(byte)0x01 ,(byte)0x01 ,(byte)0xED ,(byte)0xBE ,(byte)0xEF };
    	 	os.write(wel);
    	 	
      }
       else if(n==3){
    	 /* 播报没有权限*/
    	  
    	   byte[] wel={(byte)0xA5 ,(byte)0xA5 ,(byte)0x02 ,(byte)0x04 ,(byte)0x0B ,(byte)0x01 ,(byte)0x01 ,(byte)0xF2 ,(byte)0xBE ,(byte)0xEF};
    	   os.write(wel);
    	   
      }
       
	        	os.flush();
	    // socket.shutdownOutput();
	        	
	     		//System.out.println(re.readLine());
	     		

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public void disconnect() throws IOException{

		socket.close();
		
		
		
	}
	

}
