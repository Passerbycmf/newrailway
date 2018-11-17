package zjnu.newrailway.project.system.controller;


import net.sf.json.JSONObject;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import zjnu.newrailway.common.utils.FileUtil;
import zjnu.newrailway.common.utils.Result;
import zjnu.newrailway.framework.web.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuyuchao on 2018/5/18.
 */
@Controller
@RequestMapping("/file")
public class UploadAction extends BaseController {

    @RequestMapping("upload")
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
       //String basePath=request.getSession().getServletContext().getRealPath("images/");
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
        Files.copy(file.getInputStream(), Paths.get(path, newName), StandardCopyOption.REPLACE_EXISTING);
        //获取图片url地址
        String img="/pic/";
        String imgUrl = img + newName;
        System.out.println("imgUrl:" + imgUrl);

        Map map = new HashMap();
        map.put("code",0);
        map.put("imgUrl",imgUrl);
        JSONObject jsonObject = JSONObject.fromObject(map);
        return Result.createBySuccess(jsonObject);
    }

    @RequestMapping("view")
    public String view(HttpServletRequest request, HttpServletResponse response, String fileName) throws Exception {
        String upload="D://images/mcsz/";
        String inputFilePath = upload + "/" + fileName;
        File f = new File(inputFilePath);
        OutputStream out = response.getOutputStream();
        try {
            byte[] picture = FileUtil.getBytes(f);
            out.write(picture);
        } finally {
            out.flush();
            out.close();
        }
        return null;
    }
}
