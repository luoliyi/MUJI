package com.nf.dao.test;

import com.nf.commons.MyUtils.MD5Util;
import com.nf.entities.Administrator;
import com.nf.entities.Member;
import com.nf.interfaces.IAdministratorDao;
import com.nf.interfaces.IMemberDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class IAdministratorDaoTest {

    @Autowired
    IAdministratorDao administratorDao;

    @Test
    public void queryAllGoods() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("aname","bigone");
        objectMap.put("aphone","13926901501");
        objectMap.put("apassword",MD5Util.EncoderByMd5(".asamu.654"));
        objectMap.put("pageno",0);
        objectMap.put("pagesize",9999);
        List<Administrator> administrators=administratorDao.selectAllAdministrator(objectMap);
        for (Administrator administrator:administrators){
            System.out.println(administrator);
        }
    }

    @Test
    public void delete(){
        int r=administratorDao.delete("1");
        System.out.println("result:"+r);
    }

    @Test
    public void update(){
        Map<String,Object> map=new HashMap<>();
        map.put("mid",1);
        map.put("mphone","12345678901");
        map.put("msex","女");
        map.put("mname","大毛");
        int result=administratorDao.update(map);
        System.out.println(result);
    }

    @Test
    public void selectOne() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Map<String,Object> objectMap=new HashMap<>();
        objectMap.put("aphone","13926901501");
        objectMap.put("apassword",MD5Util.EncoderByMd5(".asamu.654"));
        Administrator administrator=administratorDao.selectOne(objectMap);
        System.out.println(administrator);
    }
}
