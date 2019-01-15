package com.nf.dao.test;

import com.nf.commons.MyUtils.MD5Util;
import com.nf.entities.Administrator;
import com.nf.entities.CreateOrders;
import com.nf.entities.Sales;
import com.nf.interfaces.IAdministratorDao;
import com.nf.interfaces.ICreateOrdersDao;
import com.nf.interfaces.ISalesDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class ICreateOrdersDaoTest {

    @Autowired
    ICreateOrdersDao createOrdersDao;

    @Autowired
    ISalesDao salesDao;

    @Test
    public void selectAllOrderByMphoneAndStateAndLimit() {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("mphone", "13926901506");
        objectMap.put("ostate", 0);
        List<CreateOrders> createOrders = createOrdersDao.selectAllOrderByMphoneAndStateAndLimit(objectMap);
        System.out.println(createOrders);
    }

    @Test
    public void selectAllSalesVolume() {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("yourMonth", "2018");
        List<Sales> salesList = salesDao.selectAllSalesVolume(objectMap);
        for (int i = 1; i <= 12; i++) {
            if (salesList.size() != 12) {
                salesList.add(new Sales(i, 0));
            }
        }
        /*排序*/
        Collections.sort(salesList, new Comparator<Sales>() {
            @Override
            public int compare(Sales o1, Sales o2) {
                if (o1.getSaleMonth() > o2.getSaleMonth()) {
                    return 1;
                }
                return -1;
            }
        });
        for (Sales sales : salesList) {
            System.out.println(sales);
        }
    }
}
