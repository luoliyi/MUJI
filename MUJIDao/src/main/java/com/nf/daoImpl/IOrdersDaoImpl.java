package com.nf.daoImpl;

import com.nf.commons.MyUtils.DBUtil;
import sun.security.pkcs11.Secmod;

import java.sql.ResultSet;


public class IOrdersDaoImpl {

    public int allOrdersCountMonitor() {
        int r = 0;
        ResultSet resultSet = DBUtil.executeQuery("select count(*) from createorders");
        try {
            if (resultSet.next()) {
                r = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DBUtil.close();
        return r;
    }
}
