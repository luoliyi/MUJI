package controller;
import com.nf.entities.Diary;
import com.nf.service.IDiaryService;
import com.nf.service.IGoodsService;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

/**
 * MySQL数据库备份
 *
 * @author GaoHuanjie
 */

@Controller
@RequestMapping(value = "admin/mySQLDatabaseBackup")
public class MySQLDatabaseBackup {

    @Autowired
    IDiaryService diaryService;

    /**
     * Java代码实现MySQL数据库导出
     *
     * @author GaoHuanjie
     * @param hostIP MySQL数据库所在服务器地址IP
     * @param userName 进入数据库所需要的用户名
     * @param userName 进入数据库所需要的用户名
     * @param password 进入数据库所需要的密码
     * @param savePath 数据库导出文件保存路径
     * @param fileName 数据库导出文件文件名
     * @param databaseName 要导出的数据库名
     * @return 返回true表示导出成功，否则返回false。
     */
    public boolean backup(String hostIP, String userName, String password, String savePath, String fileName, String databaseName) throws InterruptedException {
        File saveFile = new File(savePath);
        if (!saveFile.exists()) {// 如果目录不存在
            saveFile.mkdirs();// 创建文件夹
        }
        if(!savePath.endsWith(File.separator)){
            savePath = savePath + File.separator;
        }

        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));
            Process process = Runtime.getRuntime().exec(" mysqldump -h" + hostIP + " -u" + userName + " -p" + password + " --set-charset=UTF8 " + databaseName);
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while((line = bufferedReader.readLine())!= null){
                printWriter.println(line);
            }
            printWriter.flush();
            if(process.waitFor() == 0){//0 表示线程正常终止。
                return true;
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
     * 获取项目路径
     * */

    @RequestMapping(value = "/goToBackup",method = RequestMethod.POST)
    @ResponseBody
    public List<Object> goToBackup(HttpServletRequest request){

        System.out.println("1:"+request.getSession().getServletContext().getRealPath("DataSql"));

        /*
        * 获得路径
        * */
        String basurl=request.getSession().getServletContext().getRealPath("DataSql");

        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("daybftime",new Date().toLocaleString());
        objectMap.put("daypath",basurl);
        objectMap.put("dayhytime","");
        objectMap.put("daydesc","备份记录");

        List<Object> objects=new ArrayList<>();
        try {
            if (backup("127.0.0.1", "root", ".asamu.654", basurl, "mujisystem2.sql", "mujisystem")&&diaryService.insert(objectMap)>0) {
                objects.add("success");
                objects.add(basurl);
            } else {
                objects.add("error");
                objects.add(basurl);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return objects;
    }

    public static void main(String[] args){

       /* try {
            recover("C:\\Users\\one\\Desktop\\mujisystem2.sql");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    /*
    * 還原
    * */
    @RequestMapping(value = "/recover",method = RequestMethod.POST)
    public void recover(String path) throws IOException{
        Runtime runtime = Runtime.getRuntime();
        //-u后面是用户名，-p是密码-p后面最好不要有空格，-family是数据库的名字，--default-character-set=utf8，这句话一定的加
        //我就是因为这句话没加导致程序运行成功，但是数据库里面的内容还是以前的内容，最好写上完成的sql放到cmd中一运行才知道报错了
        //错误信息：
        //mysql: Character set 'utf-8' is not a compiled character set and is not specified in the '
        //C:\Program Files\MySQL\MySQL Server 5.5\share\charsets\Index.xml' file ERROR 2019 (HY000): Can't
        // initialize character set utf-8 (path: C:\Program Files\MySQL\MySQL Server 5.5\share\charsets\)，
        //又是讨人厌的编码问题，在恢复的时候设置一下默认的编码就可以了。
        Process process = runtime.exec("mysql -u root -p.asamu.654 --default-character-set=utf8 mujisystem");
        OutputStream outputStream = process.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String str = null;
        StringBuffer sb = new StringBuffer();
        while((str = br.readLine()) != null){
            sb.append(str+"\r\n");
        }
        str = sb.toString();
        System.out.println(str);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream,"utf-8");
        writer.write(str);
        writer.flush();
        outputStream.close();
        br.close();
        writer.close();
        System.out.println("还原成功！");
    }

    /*
     * 查询全部记录
     * */
    @RequestMapping(value = "/selectAllDiaryCount",method = RequestMethod.POST)
    @ResponseBody
    public int selectAllDiaryCount(@RequestBody List<Object> objectInit){

        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("pageno",0);
        objectMap.put("pagesize",99999);

        return diaryService.selectAllDiary(objectMap).size();
    }

    /*
    * 查询全部记录
    * */
    @RequestMapping(value = "/selectAllDiary",method = RequestMethod.POST)
    @ResponseBody
    public List<Diary>selectAllDiary(@RequestBody List<Object> objlist){

        int page= (int) objlist.get(0);
        int size= (int) objlist.get(1);
        int pageno=(page-1)*size;

        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("pageno",pageno);
        objectMap.put("pagesize",size);
        return diaryService.selectAllDiary(objectMap);
    }

    /*
    * 删除
    * */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public String delete(List<Object>objectList){
        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("dayid",objectList.get(0).toString());
        if(diaryService.delete(objectMap)>0){
            return "success";
        }
        return "error";
    }
}