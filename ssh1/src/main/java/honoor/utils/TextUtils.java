package honoor.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年8月17日 下午4:55:11 
 * 类说明 
 */
public class TextUtils {
	
	/*发送的文本格式*/
	//data=head+type+packlen+fun+dataLen+data+accd+end
	
	public static  byte[] total(int dataAndNameLength, List<String> nameList,String dataName,String hang) {
		byte[] date3 ;
		
		date3 = new byte[dataAndNameLength + 2];
		date3[0] = (byte) ((int) (Integer.valueOf(hang, 16)));
		date3[1] = (byte) ((int) (Integer.valueOf(dataName, 16)));

		for (int i = 0; i < nameList.size(); i++) {
			date3[i + 2] = (byte) ((int) (Integer.valueOf(nameList.get(i), 16)));

		     }

		return date3;
	}

	//字符串到16进制
	public static  List<String> stringToHex(String name) throws UnsupportedEncodingException{
		byte[] names;
		List<String> nameList;
		int dataAndNameLength;
		
		
		/* 获取十六进制 */
		 names = name.getBytes("gbk");
		 nameList = new ArrayList<String>();
				 
		 for (byte b : names) {
			nameList.add(Integer.toHexString((b & 0xff)).toUpperCase());

		}
		
		return nameList;
	}
	
	

	public static  String dateLength(int dataAndNameLength){
		
		String dataName = Integer.toHexString(dataAndNameLength).toUpperCase();
		return dataName;
	}
	
	//packLen
	public static  byte packLength(int dataAndNameLength){
		int packAndNameLenth;

		packAndNameLenth = dataAndNameLength + 3;
		byte packNameLength = (byte) ((int) (Integer.valueOf(Integer.toHexString(packAndNameLenth).toUpperCase(), 16)));

		return packNameLength;
	}
	
	
	//拼接所有数据
	public static  byte[] totalAll(byte ccd,int dataAndNameLength,byte[] date3 ){
		byte[] dataTotal;

		dataTotal = new byte[date3.length + 7];
		
		dataTotal[0] = (byte) ((int) (Integer.valueOf("A5", 16)));
		dataTotal[1] = (byte) ((int) (Integer.valueOf("A5", 16)));
		dataTotal[2] = (byte) ((int) (Integer.valueOf("01", 16)));
		dataTotal[3] = packLength(dataAndNameLength);

		for (int i = 0; i < date3.length; i++) {
			dataTotal[i + 4] = date3[i];

		}
		dataTotal[dataTotal.length - 3] = ccd;
		dataTotal[dataTotal.length - 2] = (byte) ((int) (Integer.valueOf("BE",16)));
		dataTotal[dataTotal.length - 1] = (byte) ((int) (Integer.valueOf("EF",16)));
		return dataTotal;
		
	}
	
	
	//显示数据
	public static  byte[] disPlayData(String name,String hang) throws UnsupportedEncodingException {
		byte[] names;
		List<String> nameList;
		int dataAndNameLength;
		byte[] date3;
		byte ccd ;
		
		nameList=stringToHex(name);
		dataAndNameLength = nameList.size();
		date3 = total(dataAndNameLength, nameList, dateLength(dataAndNameLength),hang);
	    ccd = calculateCheckSum(date3);
		
		return totalAll(ccd, dataAndNameLength, date3);

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
