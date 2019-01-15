package com.nf.commons.MyUtils;

import com.nf.entities.Goods;
import com.nf.entities.Orders;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Calendar;

public class PrintPdf implements Printable {

    private ArrayList<Orders> ordersArrayList;
    private Font font;

    public ArrayList<Orders> getOrdersArrayList() {
        return ordersArrayList;
    }

    public void setOrdersArrayList(ArrayList<Orders> ordersArrayList) {
        this.ordersArrayList = ordersArrayList;
    }

    public PrintPdf(ArrayList<Orders> ordersArrayList) {
        this.ordersArrayList = ordersArrayList;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        Component c = null;
        // 转换成Graphics2D 拿到画笔
        Graphics2D g2 = (Graphics2D) graphics;
        // 设置打印颜色为黑色
        g2.setColor(Color.black);

        // 打印起点坐标
        double x = pageFormat.getImageableX();
        double y = pageFormat.getImageableY();

        // 虚线
        float[] dash1 = {4.0f};
        // width - 此 BasicStroke 的宽度。此宽度必须大于或等于 0.0f。如果将宽度设置为
        // 0.0f，则将笔划呈现为可用于目标设备和抗锯齿提示设置的最细线条。
        // cap - BasicStroke 端点的装饰
        // join - 应用在路径线段交汇处的装饰
        // miterlimit - 斜接处的剪裁限制。miterlimit 必须大于或等于 1.0f。
        // dash - 表示虚线模式的数组
        // dash_phase - 开始虚线模式的偏移量

        // 设置画虚线
        g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 4.0f, dash1, 0.0f));

        // 设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
        font = new Font("微软雅黑", Font.PLAIN, 11);
        g2.setFont(font);// 设置字体
        float heigth = font.getSize2D();// 字体高度
        float line = 3 * heigth;
        // 标题
        g2.drawString("MUJI无印良品----欢迎光临珠海扬名广场2期", (float) x + 180, (float) y + heigth);
        line += heigth;
        line += heigth;

        font = new Font("微软雅黑", Font.PLAIN, 8);
        g2.setFont(font);// 设置字体
        heigth = font.getSize2D();// 字体高度

        // 显示电话号码和单号
        // g2.drawString("电话号码：" + ordersArrayList.get(0).getMphone(), (float) x+50, (float) y + line);
        g2.drawString("发票时间：" + Calendar.getInstance().getTime().toLocaleString(), (float) x + 50, (float) y + line);
        // 显示订单号
        g2.drawString("订单号：" + ordersArrayList.get(0).getCono(), (float) x + 230, (float) y + line);
        line += heigth;
        line += heigth;

        // 显示收银员和POS机
        g2.drawString("收银员：Jack", (float) x + 50, (float) y + line);
        // 显示订单号
        g2.drawString("POS机：75602", (float) x + 230, (float) y + line);
        line += heigth;
        line += heigth;

        // 显示标题
        g2.drawString("名称", (float) x + 50, (float) y + line);
        g2.drawString("单价", (float) x + 230, (float) y + line);
        g2.drawString("数量", (float) x + 280, (float) y + line);
        g2.drawString("总额", (float) x + 330, (float) y + line);
        line += heigth;
        g2.drawLine((int) x, (int) (y + line), (int) x + 800, (int) (y + line));

        // 第4行
        line += heigth;
        line += heigth;

        float sumPrice = 0;
        int sumCount = 0;

        // 显示内容
        for (int i = 0; i < ordersArrayList.size(); i++) {
            Orders order = ordersArrayList.get(i);
            Goods goods = ordersArrayList.get(i).getGoods();
            g2.drawString(goods.getGname(), (float) x + 50, (float) y + line);
            g2.drawString(String.valueOf(goods.getGnowprice()), (float) x + 230, (float) y + line);
            g2.drawString(String.valueOf(order.getOcount()), (float) x + 280, (float) y + line);
            g2.drawString(String.valueOf(order.getOsumprice()), (float) x + 330, (float) y + line);
            sumPrice += order.getOsumprice();
            sumCount += order.getOcount();
            line += heigth;
        }
        line += heigth;

        /*
         * drawLine：画横线
         * */
        g2.drawLine((int) x, (int) (y + line), (int) x + 800, (int) (y + line));
        line += heigth;
        line += heigth;

        g2.drawString("售出商品件数：" + sumCount + "件", (float) x + 50, (float) y + line);
        g2.drawString("合计：" + sumPrice + "元", (float) x + 230, (float) y + line);
        line += heigth;
        line += heigth;
        g2.drawString("实收：" + sumPrice + "元", (float) x + 50, (float) y + line);
        // g2.drawString("找零:" + changes + "元", (float) x + 70, (float) y + line);
        line += heigth;
        line += heigth;

        line += heigth;
        line += heigth;

        line += heigth;
        line += heigth;
        line += heigth;
        g2.drawString("谢谢惠顾！", (float) x + 50, (float) y + line);

        line += heigth;
        line += heigth;
        g2.drawString("请仔细核对收银票据、找零以及商品，离柜概不负责。", (float) x + 50, (float) y + line);
        line += heigth;
        line += heigth;
        g2.drawString("地址：广东省珠海市香洲区凤凰南路1066号扬名广场2期1层", (float) x + 50, (float) y + line);
        line += heigth;
        line += heigth;
        g2.drawString("网络商城：www.muji.com.cn", (float) x + 50, (float) y + line);
        switch (pageIndex) {
            case 0:
                return PAGE_EXISTS;
            default:
                return NO_SUCH_PAGE;
        }
    }
}
