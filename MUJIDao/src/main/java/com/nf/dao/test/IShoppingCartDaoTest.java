package com.nf.dao.test;

import com.nf.commons.MyUtils.MD5Util;
import com.nf.entities.Administrator;
import com.nf.entities.ShoppingCart;
import com.nf.interfaces.IAdministratorDao;
import com.nf.interfaces.IShoppingCartDao;
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
public class IShoppingCartDaoTest {

    @Autowired
    IShoppingCartDao shoppingCartDao;

    @Test
    public void selectAllCartByMphone(){
        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("mphone","13926901506");
        List<ShoppingCart> shoppingCarts=shoppingCartDao.selectAllCartByMphone(objectMap);
        System.out.println(shoppingCarts);
    }
}
