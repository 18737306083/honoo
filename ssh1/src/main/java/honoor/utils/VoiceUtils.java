package honoor.utils;
/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年8月18日 上午9:34:32 
 * 类说明 
 */
public class VoiceUtils {
	
	
	
	public static byte ccd(){
	
		
		
		    byte	dataTotal = (byte) ((int) (Integer.valueOf("55", 16)));
			byte	dataTota2 = (byte) ((int) (Integer.valueOf("02", 16)));
			byte	dataTota3 = (byte) ((int) (Integer.valueOf("00", 16)));
			byte	dataTota4 = (byte) ((int) (Integer.valueOf("20", 16)));
			
			
		byte[] bytes2=new byte[4];
		bytes2[0]=dataTotal;
		bytes2[1]=dataTota2;
		bytes2[2]=dataTota3;
		bytes2[3]=dataTota4;
	return	calculateCheckSum(bytes2);
	}
	
	public static byte[] all(int pattern,int level){
		
		
		 byte	dataTota1 = (byte) ((int) (Integer.valueOf("A5", 16)));
			byte	dataTota2 = (byte) ((int) (Integer.valueOf("A5", 16)));
			byte	dataTota3 = (byte) ((int) (Integer.valueOf("01", 16)));
			byte	dataTota4 = (byte) ((int) (Integer.valueOf("05", 16)));

		    byte	dataTota5 = (byte) ((int) (Integer.valueOf("55", 16)));
			byte	dataTota6 = (byte) ((int) (Integer.valueOf("02", 16)));
			byte	dataTota7 = (byte) ((int) (Integer.valueOf(Integer.toHexString(pattern), 16)));
			byte	dataTota8 = (byte) ((int) (Integer.valueOf(Integer.toHexString(level), 16)));
			byte	dataTota9 = ccd();
			byte	dataTota10 = (byte) ((int) (Integer.valueOf("BE", 16)));
			byte	dataTota11 = (byte) ((int) (Integer.valueOf("EF", 16)));
			byte[] bytes=new byte[11];

			bytes[0]=dataTota1;
			bytes[1]=dataTota2;
			bytes[2]=dataTota3;
			bytes[3]=dataTota4;
			bytes[4]=dataTota5;
			bytes[5]=dataTota6;
			bytes[6]=dataTota7;
			bytes[7]=dataTota8;
			bytes[8]=dataTota9;
			bytes[9]=dataTota10;
			bytes[10]=dataTota11;
		/*	for (int i = 0; i < bytes.length; i++) {
				
						System.out.println(bytes[i]);A5 A5 02 04 0F 01 01 EE BE EF 
			}
	    	   byte[] wel1={(byte)0xA5 ,(byte)0xA5 ,(byte)0x01 ,(byte)0x05  ,(byte)0x55 ,(byte)0x02 ,(byte)0x00 ,(byte)0x20 ,(byte)0x88 ,(byte)0xBE ,(byte)0xEF};
	    	   for (int i = 0; i < wel1.length; i++) {
					
					System.out.println(wel1[i]+"pp");
		}*/
			return bytes;
	}
	
	/* 计算校验 */
	public static byte calculateCheckSum(byte[] bytes) {
		byte sum = 0;
		for (int i = 0; i < bytes.length; i++) {
			sum +=  bytes[i];

		}
		sum = (byte) ~sum;

		return sum;
	}

}
