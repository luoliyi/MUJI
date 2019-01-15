package controller;

import com.nf.commons.MyUtils.PrintPdf;
import com.nf.entities.*;
import com.nf.service.ICreateOrdersService;
import com.nf.service.IOrdersService;
import com.nf.service.ISalesService;
import com.nf.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "admin/salesController")
public class SalesController {

    @Autowired
    ISalesService salesService;

    @RequestMapping(value = "/getAllSalesByMonth", method = RequestMethod.POST)
    @ResponseBody
    public List<Sales> getAllSalesByMonth(@RequestBody List<Object> objects) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("yourMonth", objects.get(0).toString());
        List<Sales> salesList = salesService.selectAllSalesVolume(objectMap);
        for (int i = 1; i <= 12 - salesList.size(); i++) {
            if (salesList.size() != 12) {
                salesList.add(new Sales(i, 0));
            }
        }
        //按月份正序排序
        Collections.sort(salesList, new Comparator<Sales>() {
            @Override
            public int compare(Sales o1, Sales o2) {
                if (o1.getSaleMonth() > o2.getSaleMonth()) {
                    return 1;
                }
                return -1;
            }
        });
        return salesList;
    }

    /*
     * 查询每日清单情况
     * */
    @RequestMapping(value = "/selectOneDaySalesVolume", method = RequestMethod.POST)
    @ResponseBody
    public List<DaySales> selectOneDaySalesVolume(@RequestBody List<Object> objects) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("myday", objects.get(0).toString());
        return salesService.selectOneDaySalesVolume(objectMap);
    }
}
