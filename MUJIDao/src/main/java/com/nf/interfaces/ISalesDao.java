package com.nf.interfaces;

import com.nf.entities.Diary;
import com.nf.entities.Sales;

import java.util.List;
import java.util.Map;

public interface ISalesDao {
    List<Sales> selectAllSalesVolume(Map<String,Object>objectMap);
}
