package zjnu.newrailway.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import java.io.*;

public class FileUtil {

    /**
     * @author Jason 2011-10-27
     * Purpose 输出文件
     * */
    public static void writeToBytes(byte bytes[],String fileName){
        FileOutputStream fos=null;
        try{
            fos=new FileOutputStream(fileName,true);
            fos.write(bytes);
            fos.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                fos.close();
            }catch(IOException iex){}
        }
    }

    /*******************
     * 获取文件的后缀名
     * @param fileName
     * @return
     */
    public static String getExt(String fileName){
        String[] array=fileName.split("[.]");
        if(array.length>1){
            return array[array.length-1];
        }
        return null;
    }

    /************************8
     * 自动创建目录
     * @param dir
     * @return
     */
    public static boolean creatDirs(String dir) {
        boolean res = false;
        File file = new File(dir);
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            res = true;
        } catch (Exception ex) {

        }
        return res;
    }
    public static void copyFile_bak(File srcFile,String targetPath) throws Exception{
        FileInputStream fileIn = new FileInputStream(srcFile);
        FileOutputStream outStream =new FileOutputStream(targetPath);
        byte[] buffer = new byte[(int) srcFile.length()];
        int len = 0;
        len = fileIn.read(buffer);
        outStream.write(buffer);
        outStream.close();
        outStream.close();
    }

    public static void copyFile(File srcFile,String targetPath) throws Exception{
        BufferedOutputStream outbuf = null;
        BufferedInputStream inbuf = null;
        FileInputStream fileIn = null;
        FileOutputStream outStream = null;
        try{
            fileIn = new FileInputStream(srcFile);
            inbuf = new BufferedInputStream(fileIn);
            outStream =new FileOutputStream(targetPath);
            outbuf = new BufferedOutputStream(outStream);
            byte[] buffer = new byte[2048];
            int b = 0;
            while((b = inbuf.read(buffer))!=-1){
                outbuf.write(buffer);
            }
            outbuf.flush();
            outbuf.close();
            inbuf.close();
        }catch (Exception e) {
            throw e;
        }finally{
            if(outbuf!=null){
                outbuf.close();
                outbuf = null;
            }
            if(inbuf!=null){
                inbuf.close();
                inbuf = null;
            }
        }
    }

    public  static byte[] getBytes(File f) throws Exception {

        byte[] buffer = new byte[(int) f.length()];
        int len = 0;
        FileInputStream fileIn = new FileInputStream(f);
        len = fileIn.read(buffer);
        fileIn.close();
        return buffer;
    }
    public  static String getContent(InputStream inStream,String encoder) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(inStream, encoder));
        StringBuffer buf=new StringBuffer();
        while(true){
            String line = in.readLine();
            if(line==null){
                break;
            }
            buf.append(line);
        }
        return buf.toString();
    }
    public static String getConetnFromFile(String fileRoot,String encoder)throws Exception{
        File f=new File(fileRoot);
        byte[] buffer = getBytes(f);
        return new String(buffer,encoder);
    }
    public static void deleteFile(String url)throws FileNotFoundException,IOException{
        try{
            File fileName = new File(url);
            if(fileName.exists()){
                if(!fileName.isDirectory()){
                    fileName.delete();
                }else{
                    String[] filelist = fileName.list();
                    for(int i=0;i<filelist.length;i++){
                        File delfile = new File(url+"/"+filelist[i]);
                        if(!delfile.isDirectory()){
                            delfile.delete();
                        }else{
                            deleteFile(url+"/"+filelist[i]);
                        }
                    }
                    fileName.delete();
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void writeFile(String path,String content)throws Exception{
        FileOutputStream outStream =new FileOutputStream(path);
        byte[] buffer = content.getBytes();
        int len = 0;
        outStream.write(buffer);
        outStream.close();
        outStream.close();
    }
    public static byte[] getBytesBASE64(String s) {
        Base64 base64 = new Base64();
        return base64.decode(s.getBytes());
    }

    /**
     * 将文件转换为byte形式
     * @param
     * @return
     */
    public static byte[] getByteByFile(File file)throws Exception{
        if(file==null || !file.exists()){
            return null;
        }
        ByteArrayOutputStream out = null;
        FileInputStream fis=null;
        try{
            out = new ByteArrayOutputStream();
            fis=new FileInputStream(file);
            byte[] bytes=new byte[1024];
            int num=0;
            while ((num=fis.read(bytes))>0) {
                out.write(bytes, 0, num);
            }
            byte[] datas=out.toByteArray();
            return datas;
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(out!=null) out.close();
            if(fis!=null) fis.close();
        }
        return null;
    }
    /**解析文件类型*/
    public static String getFileType(String fileName){
        if(fileName==null || "".equals(fileName.trim())){
            return "5";
        }
        String name = StringUtils.lowerCase(fileName.trim());
        if(name.matches("[\\w\\W]*((\\.jpeg)|(\\.gif)|(\\.jpg)|(\\.png)|(\\.bmp)$)")){//图片
            return "1";
        }else if(name.matches("[\\w\\W]*((\\.doc)|(\\.docx)|(\\.xls)|(\\.xlsx)|(\\.ppt)|(\\.pptx)|(\\.txt)|(\\.pdf)$)")){//文档
            return "2";
        }else if(name.matches("[\\w\\W]*((\\.rar)|(\\.zip)$)")){//压缩包文档
            return "3";
        }else if(name.matches("[\\w\\W]*((\\.avi)|(\\.mpg)|(\\.mpeg)|(\\.mpe)|(\\.m1v)|(\\.m2v)|(\\.mpv2)|(\\.mp2v)|(\\.dat)|(\\.ts)|(\\.tp)$)")){//媒体
            return "4";
        }else if(name.matches("[\\w\\W]*((\\.tpr)|(\\.pva)|(\\.pss)|(\\.mp4)|(\\.m4v)|(\\.m4p)|(\\.m4b)|(\\.3gp)|(\\.3gpp)|(\\.3g2)|(\\.3gp2)|(\\.ogg)|(\\.mov)|(\\.qt)|(\\.amr)|(\\.rm)|(\\.ram)$)")){
            return "4";
        }else if(name.matches("[\\w\\W]*((\\.rmvb)|(\\.rpm)|(\\.wmv)|(\\.flv)|(\\.3gp)|(\\.swf)|(\\.asf)|(\\.divx)|(\\.xvid)|(\\.flv1)|(\\.mpeg1)|(\\.mpeg2)|(\\.mpeg3)|(\\.mpeg4)|(\\.h264)$)")){
            return "4";
        }
        return "5";
    }
}
