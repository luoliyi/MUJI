package com.nf.impl;

import com.nf.entities.Sales;
import com.nf.interfaces.ISalesDao;
import com.nf.service.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Controller
@Service
public class ISalesImpl implements ISalesService {

    @Autowired
    ISalesDao salesDao;

    @Override
    public List<Sales> selectAllSalesVolume(Map<String, Object> objectMap) {
        return salesDao.selectAllSalesVolume(objectMap);
    }
}
