package cn.dgkj.province;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author mawt
 * @description
 * @date 2019/11/20
 */
public class ProvinceMain {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = (XSSFWorkbook) readExcel("C:\\Users\\mawt\\Downloads\\xzq_201907.xlsx");
        XSSFSheet sheet = workbook.getSheetAt(0);
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        Map<String, String> map3 = new HashMap<>();
        for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {//获取总行数
            Row row = sheet.getRow(j); // 取出第i行 getRow(index) 获取第(j)行

            String name1 = getCellFormatValue(row.getCell(1));
            String id1 = getCellFormatValue(row.getCell(0));
            map1.put(id1, name1 + "," + 0);

            String name2 = getCellFormatValue(row.getCell(3));
            String id2 = getCellFormatValue(row.getCell(2));
            String pid1 = id1;
            map2.put(id2, name2 + "," + pid1);

            String name3 = getCellFormatValue(row.getCell(5));
            String id3 = getCellFormatValue(row.getCell(4));
            String pid2 = id2;
            map3.put(id3, name3 + "," + pid2);

            for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) { // getPhysicalNumberOfCells() 获取当前行的总列数
                String value1 = getCellFormatValue(row.getCell(k));//取出第j行第k列的值
            //    System.out.print(value1 + "\t\t\t");
            }
        //    System.out.println();
        }
        Map<String, String> map = new HashMap<>();
        map.putAll(map1);
        map.putAll(map2);
        map.putAll(map3);

        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : list) {
            String id = entry.getKey();
            String name = entry.getValue().split(",")[0];
            String pid = entry.getValue().split(",")[1];
            sb.append(sql(id,name,pid));
        //    System.out.println(sql(id,name,pid));
        }
        IOUtils.write(sb.toString(), new FileOutputStream("C:\\Users\\mawt\\Downloads\\xzq_201907.sql"), "UTF-8");
        workbook.close();
    }

    private static String sql(String id, String name, String pid) {
        return "INSERT INTO `china` VALUES ('" + id + "', '" + name + "', '" + pid + "');";
    }

    //读取excel
    public static Workbook readExcel(String filePath) {
        Workbook wb = null;
        if (filePath == null) {
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if (".xls".equals(extString)) {
                return wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(extString)) {
                return wb = new XSSFWorkbook(is);
            } else {
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    public static String getCellFormatValue(Cell cell) {
        String cellValue = "";
        if (cell != null) {
            // 判断cell类型
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: {
                //    cellValue = String.valueOf(cell.getNumericCellValue());

                    DecimalFormat decimalFormat = new DecimalFormat("###################");
                    cellValue = decimalFormat.format(cell.getNumericCellValue());	//1
                    break;
                }
                case Cell.CELL_TYPE_STRING: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }
        return cellValue;
    }

}
