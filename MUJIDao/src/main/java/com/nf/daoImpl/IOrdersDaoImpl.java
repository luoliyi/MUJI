package com.nf.daoImpl;

import com.nf.commons.MyUtils.DBUtil;

import java.sql.ResultSet;

public class IOrdersDaoImpl {

    public int allOrdersCountMonitor(){
        int r=0;
        ResultSet resultSet= DBUtil.executeQuery("select count(*) from createorders");
        try {
            if (resultSet.next()){
                r=resultSet.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  r;
    }
}
