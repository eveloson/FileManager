package com.file.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileTransferUtil {
	public static boolean inputStreanToOuputStream(InputStream is,OutputStream os) {
		boolean res = true;
		try {
			//复制文件
			byte[] b = new byte[1024*1024] ;
			int len = 0 ;
			while(-1!=(len = is.read(b, 0, b.length))){
				os.write(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
			res = false;
		}finally{
			//关闭流
			try {
				if(os!=null){
					os.flush();
					os.close();
				}
				if(is!=null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		return res;
	}
}
