package controller;

import com.nf.commons.MyUtils.Standard;
import com.nf.entities.Goods;
import com.nf.entities.PictureList;
import com.nf.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "admin/pictureListController")
public class PictureListController {

    @Autowired
    IPictureService pictureService;


    @RequestMapping(value = "/selectAllGoods", method = RequestMethod.POST)
    @ResponseBody
    public List<Goods> selectAllGoods() {
        return pictureService.selectAllGoods();
    }

    @RequestMapping(value = "/selectAllPicByGid", method = RequestMethod.POST)
    @ResponseBody
    public List<PictureList> selectAllPicByGid(@RequestBody List<Object> objectList) {

        return pictureService.selectAllPicture((String) objectList.get(0));
    }

    @RequestMapping(value = "/selectOnePicture", method = RequestMethod.POST)
    @ResponseBody
    public PictureList selectOnePicture(@RequestBody List<Object> objectList) {
        return pictureService.selectOnePicture(objectList.get(0).toString());
    }

    /*
     * 修改
     * */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody List<Object> objectList) {

        System.out.println(objectList);
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("picpath", objectList.get(0).toString());
        objectMap.put("picdesc", objectList.get(1).toString());
        objectMap.put("picid", objectList.get(2).toString());

        if (pictureService.update(objectMap) > 0) {
            return "success";
        }
        return "error";
    }

    /*
     * 删除
     * */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestBody List<Object> objectList) {

        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("picid", objectList.get(0).toString());

        if (pictureService.delete(objectMap) > 0) {
            return "success";
        }
        return "error";
    }


    /*
     * 添加
     * */
    @RequestMapping(value = "/insertPic", method = RequestMethod.POST)
    @ResponseBody
    public List<PictureList> insertPic(@RequestBody List<Object> objectList) {

        System.out.println(objectList);
        List<String> stringList = (List<String>) objectList.get(1);
        System.out.println("stringList.size=:" + stringList.size());
        for (int i = 0; i < stringList.size(); i++) {
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("gid", objectList.get(0).toString());
            objectMap.put("picpath", stringList.get(i));
            objectMap.put("picdesc", "");
            pictureService.insert(objectMap);
        }
        return pictureService.selectAllPicture((String) objectList.get(0));
    }

    /*
     * 批量文件上传
     *
     * */
    @RequestMapping(value = "/file3Save", method = RequestMethod.POST)
    @ResponseBody
    public Standard file3Save(MultipartFile file, HttpServletRequest request) throws Exception {
        //文件存放的位置
        String path = request.getSession().getServletContext().getRealPath("/admin/img/PictureList");
        System.out.println("path:" + path);
        File fi = new File(path);
        if (!fi.exists()) {
            fi.mkdir();
        }
        File tempFile = new File(path, file.getOriginalFilename());
        file.transferTo(tempFile);
        System.out.println("tempFile:" + tempFile.getName());
        Standard standard = new Standard();
        standard.put("msg", "上传成功!");
        standard.put("data", tempFile.getName());

        return standard;
    }

}
