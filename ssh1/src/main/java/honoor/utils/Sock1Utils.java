package honoor.utils;
/** 
 * @author ���� ¬��  E-mail: 1914045211@qq.com
 * @version ����ʱ�䣺2017��8��17�� ����4:25:29 
 * ��˵�� 
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
 * @author ���� honoo
 * @version ����ʱ�䣺2017��8��14�� ����2:05:17 ��˵��
 * ��LED��������
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
			 
			//os.write(TextUtils.disPlayData("[s000]��ŵʵ��","05"));/*��һ��*/
			//os.write(TextUtils.disPlayData("[s000]��ӭ����","06"));/*�ڶ���*/
			
			/*����Ĭ����ʾ*/
			os.write(TextUtils.disPlayData("[s000]�ȴ�ʶ��","17"));/*������*/
		//	os.write(TextUtils.disPlayData("[s000]"+simple.format(new Date()),"18"));/*������*/
		//	os.write(VoiceUtils.all(00,02));
			os.flush();
			status=stream.read();
			
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		
		System.out.println("����ʧ��,������������!");
try {
	socket = new Socket(ip, port);

	os = socket.getOutputStream();
	 stream= socket.getInputStream();
		 
		//os.write(TextUtils.disPlayData("[s000]��ŵʵ��","05"));/*��һ��*/
		//os.write(TextUtils.disPlayData("[s000]��ӭ����","06"));/*�ڶ���*/
		
		/*����Ĭ����ʾ*/
		os.write(TextUtils.disPlayData("[s000]�ȴ�ʶ��","17"));/*������*/
		//os.write(TextUtils.disPlayData("[s000]"+simple.format(new Date()),"18"));/*������*/
		//os.write(VoiceUtils.all(00,02));
		os.flush();
		status=stream.read();
} 
 catch (Exception e1) {
	// TODO Auto-generated catch block
		
		System.out.println("����ʧ��,������������!");
try {
	socket = new Socket(ip, port);

	os = socket.getOutputStream();
	 stream= socket.getInputStream();
		 
	//	os.write(TextUtils.disPlayData("[s000]��ŵʵ��","05"));/*��һ��*/
	//	os.write(TextUtils.disPlayData("[s000]��ӭ����","06"));/*�ڶ���*/
		
		/*����Ĭ����ʾ*/
		os.write(TextUtils.disPlayData("[s000]�ȴ�ʶ��","17"));/*������*/
		//os.write(TextUtils.disPlayData("[s000]"+simple.format(new Date()),"18"));/*������*/
		//os.write(VoiceUtils.all(00,02));
		os.flush();
		status=stream.read();
} 
catch (Exception e11) {
	// TODO Auto-generated catch block
	System.out.println("����ʧ��,����LED�Ƿ�������ȷ!");
}
		
}
		
		
	}
	if(status !=1 && status !=0){
		
		return 1;
	}
	
	 
		return status; 
		
}
	
	
      /*�������ֺ�����        str1��ʾ���ı�,hang��ʾ������,n����                            */
	public void sendTextAndSound(String str1,String hang,int n) {

		try {
		
      if(n==0){
         	/*��������*/
    	  
			os.write(TextUtils.disPlayData(str1,hang));
			
      }
      else if(n==1){
    	 /* 
    	  */
    	  /*������ӭ����*/
	     byte[] wel={(byte)0xA5 ,(byte)0xA5 ,(byte)0x02 ,(byte)0x04 ,(byte)0x07 ,(byte)0x01 ,(byte)0x01 ,(byte)0xF6 ,(byte)0xBE ,(byte)0xEF};
	
      	os.write(wel);
      	
          }
      
      else if(n==2){
    	  /*������δע��*/
    	  
    	  byte[] wel={(byte)0xA5 ,(byte)0xA5 ,(byte)0x02 ,(byte)0x04 ,(byte)0x10 ,(byte)0x01 ,(byte)0x01 ,(byte)0xED ,(byte)0xBE ,(byte)0xEF };
    	 	os.write(wel);
    	 	
      }
       else if(n==3){
    	 /* ����û��Ȩ��*/
    	  
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
