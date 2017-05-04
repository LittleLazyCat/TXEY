package com.credit.manage.filemanager.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Transactional(readOnly=true)
@Service("uploadFileService")
public class UploadFileService {
	
	public boolean uploadFile(String path, MultipartFile file, String filename) throws Exception {
         /*System.out.println("文件长度: " + file.getSize()); 
         System.out.println("文件类型: " + file.getContentType()); 
         System.out.println("文件名称: " + file.getName()); 
         System.out.println("文件原名: " + file.getOriginalFilename()); 
         System.out.println("========================================"); */
         try {   
             SaveFileFromInputStream(file.getInputStream(), path, filename);   
         } catch (IOException e) {   
        	 System.out.println(e.getMessage());   
             return false;   
         }   
        return true;
    }
	
	/**保存文件  
     * @param stream  
     * @param path  
     * @param filename  
     * @throws IOException  
   */ 
   private void SaveFileFromInputStream(InputStream stream,String path,String filename) 
         throws IOException {         
         FileOutputStream outputStream = new FileOutputStream( path + "/"+ filename);   
     int byteCount = 0;
     byte[] bytes = new byte[1024];
     while ((byteCount = stream.read(bytes)) != -1){
          outputStream.write(bytes, 0, byteCount);
     }
     outputStream.close();   
     stream.close();  
   } 

}
