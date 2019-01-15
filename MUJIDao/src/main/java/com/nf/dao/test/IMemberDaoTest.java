package com.nf.dao.test;

import com.nf.commons.MyUtils.MD5Util;
import com.nf.entities.Goods;
import com.nf.entities.Member;
import com.nf.interfaces.IGoodsDao;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class IMemberDaoTest {

    @Autowired
    IMemberDao memberDao;

    @Test
    public void queryAllGoods() {
//        List<Member>members=memberDao.selectAllMember();
//        for (Member member:members){
//            System.out.println(member);
//        }
    }


    @Test
    public void delete() {
        int r = memberDao.delete("1");
        System.out.println("result:" + r);
    }

    @Test
    public void update() {
        Map<String, Object> map = new HashMap<>();
        map.put("mid", 1);
        map.put("mphone", "12345678901");
        map.put("msex", "女");
        map.put("mname", "大毛");
        int result = memberDao.update(map);
        System.out.println(result);
    }

    @Test
    public void selectOne() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("mphone", "13926901506");
        objectMap.put("mpassword", MD5Util.EncoderByMd5("luoliyi123"));
        Member member = memberDao.selectOne(objectMap);
        System.out.println(member);

    }
}
