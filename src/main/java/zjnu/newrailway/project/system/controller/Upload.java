package zjnu.newrailway.project.system.controller;

import net.sf.json.JSONObject;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import zjnu.newrailway.common.utils.Result;
import zjnu.newrailway.framework.web.BaseController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2018/11/12 13:19
 * @version: 1.0
 **/
@Controller
@RequestMapping("system/repairProjects/file")
public class Upload extends BaseController {
    @RequestMapping("/upload") //requestParam要写才知道是前台的那个数组
    @ResponseBody
    public Result filesUpload(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) {
        List<String> list = new ArrayList<String>();
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                // 保存文件
                list = saveFile(request, file, list);
            }
        }
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i==(list.size()-1)){
                stringBuffer.append(list.get(i));
            }else {
                stringBuffer.append(list.get(i)).append(";");
            }
        }
        System.out.println(stringBuffer.toString());
        return Result.createBySuccess(stringBuffer.toString());
    }

    private List<String> saveFile(HttpServletRequest request, MultipartFile file, List<String> list) {
        String basePath="D://images/mcsz/";
        String path = basePath + File.separator;
        File targetFile = new File(path);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String newName = new DateTime().toString("yyyyMMddHHmmss") + suffixName;
        try {
            Files.copy(file.getInputStream(), Paths.get(path, newName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取图片url地址
        String img="/pic/";
        String imgUrl = img + newName;
        System.out.println("imgUrl:" + imgUrl);
        list.add(imgUrl);
        return list;
    }
}