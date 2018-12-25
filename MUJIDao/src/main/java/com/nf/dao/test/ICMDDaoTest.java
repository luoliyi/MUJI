package com.nf.dao.test;

import com.nf.commons.MyUtils.MD5Util;
import com.nf.entities.Administrator;
import com.nf.interfaces.IAdministratorDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class ICMDDaoTest {

   @Test
    public void testCMD(){
       try {
           Runtime.getRuntime().exec("C:\\Users\\one\\Desktop\\Win.bat\\onenteacherbat.bat");
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   @Test
    public void testDaaaa(){
       String sysdate= String.valueOf(System.currentTimeMillis());
       String cono=sysdate.substring(0,sysdate.length()-1);
       System.out.println(cono);
   }
}
