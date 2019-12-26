package cn.dgkj.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mawt
 * @description 省市区解析
 * @date 2019/11/15
 */
public class ChinaProvinceUtil {

    public static void main(String[] args) throws Exception{
    //    parse();
    }

    private static void parse() throws IOException {
        String data = IOUtils.toString(new FileInputStream("F:\\idea-workspace\\mvc\\src\\main\\resources\\province.json"));
        ProvinceResp provinceResp = JSONObject.parseObject(data, ProvinceResp.class);
        System.out.println(provinceResp);
        ProvinceResp.Province[] provinces = provinceResp.getData();
        ArrayList<String> list = new ArrayList<>();
        detail(provinces, "0", list);
        list.forEach(System.out::println);
        StringBuffer sb = new StringBuffer();
        for (String s : list) {
            sb.append(s);
        }
        IOUtils.write(sb.toString(), new FileOutputStream("F:\\idea-workspace\\mvc\\src\\main\\resources\\province.sql"), "UTF-8");
    }

    private static void detail(ProvinceResp.Province[] provinces, String parent, List<String> list) {
        if (provinces != null && provinces.length > 0) {
            for (ProvinceResp.Province province : provinces) {
                String value = province.getValue();
                String label = fillLabel(province.getLabel());

                list.add("INSERT INTO `china` VALUES ('" + label + "', '" + value + "', '" + parent + "');");

                ProvinceResp.Province[] children = province.getChildren();
                detail(children, label,  list);
            }
        }
    }

    private static String fillLabel(String label) {
        while (label.length() != 6) {
            label += "0";
        }
        return label;
    }

}
