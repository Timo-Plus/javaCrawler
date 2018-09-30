package com.java.sl.core;


import com.java.sl.bean.Ershoufang;
import com.java.sl.bean.HouseData;
import us.codecraft.webmagic.Page;

import java.util.List;

/**
 * Author: zhangliujie
 * Time: 2018/9/30
 * Email: liujiezhangbupt@gmail.com
 * Description:
 */
public class PageParser {

    public HouseData process(Page page, String houseType){
        HouseData houseData = new HouseData();
        dealEr(page);
        return houseData;
    }

    public Ershoufang dealEr(Page page){
        Ershoufang houseInfo = new Ershoufang();
        String title = page.getHtml().xpath("/html/body/div[3]/div/div/div[1]/h1/text()").get(); // 标题
        System.out.println(title);

        String price = page.getHtml().xpath("/html/body/div[5]/div[2]/div[2]/span[1]/text()").get(); // 价格 单位：万
        System.out.println(price);

        String room = page.getHtml().xpath("/html/body/div[5]/div[2]/div[3]/div[1]/div[1]/text()").get(); // 2室1厅
        System.out.println(room);

        String floor = page.getHtml().xpath("/html/body/div[5]/div[2]/div[3]/div[1]/div[2]/text()").get(); // 中楼层/共21层
        System.out.println(floor);

        String toward = page.getHtml().xpath("/html/body/div[5]/div[2]/div[3]/div[2]/div[1]/text()").get(); // 南 北
        System.out.println(toward);

        String decorate = page.getHtml().xpath("/html/body/div[5]/div[2]/div[3]/div[2]/div[2]/text()").get(); // 平层/简装
        System.out.println(decorate);

        String area = page.getHtml().xpath("/html/body/div[5]/div[2]/div[3]/div[3]/div[1]/text()").get(); // 102.09平米
        System.out.println(area);

        String year = page.getHtml().xpath("/html/body/div[5]/div[2]/div[3]/div[3]/div[2]/text()").get(); // 2007年建/板塔结合
        System.out.println(year);

        String community = page.getHtml().xpath("/html/body/div[5]/div[2]/div[4]/div[1]/a[1]/text()").get(); //三环新城6号院
        System.out.println(community);

        String location = listToString(page.getHtml().xpath("/html/body/div[5]/div[2]/div[4]/div[2]/span[2]/allText()").all());
        System.out.println(location);
        // 获取房屋基本属性 todo

        // 获取房屋交易属性 todo

        return houseInfo;
    }

    // 把list转换为string，用空格分割
    public static String listToString(List<String> stringList) {
        if (stringList == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (String string : stringList) {
            if (flag) {
                result.append(" ");
            } else {
                flag = true;
            }
            result.append(string);
        }
        return result.toString().replace("&nbsp;", "");
    }
}