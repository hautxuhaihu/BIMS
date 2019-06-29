package tools;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class IOUtils {
    public String copySingleFile(File file, String fileName, String targetDir) {
        /*file是源文件,fileName代表上传的文件的名称,targetDir代表将要存在的目录*/
        String realPath=ServletActionContext.getServletContext().getRealPath(targetDir);
        File destFile=new File(realPath,fileName);
        try{
            FileUtils.copyFile(file,destFile);
            return "success";
        }catch (IOException e){
            e.printStackTrace();
            return "fail";
        }
    }

    public String copyManyFiles(File[] files, String[] fileNames, String targetDir){
        String realPath=ServletActionContext.getServletContext().getRealPath(targetDir);
        try{
            for(int i=0;i<files.length;i++){
                File destFile=new File(realPath,fileNames[i]);
                FileUtils.copyFile(files[i],destFile);
            }
            return "success";
        }catch (IOException e){
            e.printStackTrace();
            return "fail";
        }
    }
}
