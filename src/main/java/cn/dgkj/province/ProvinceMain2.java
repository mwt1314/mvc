package cn.dgkj.province;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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
public class ProvinceMain2 {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = (XSSFWorkbook) readExcel("C:\\Users\\mawt\\Downloads\\xzq_201907.xlsx");
        XSSFSheet sheet = workbook.getSheetAt(0);
        StringBuilder sb = new StringBuilder();
        int id = 0;
        for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {//获取总行数
            Row row = sheet.getRow(j); // 取出第i行 getRow(index) 获取第(j)行

            String name1 = getCellFormatValue(row.getCell(1));
            String id1 = getCellFormatValue(row.getCell(0));

            String name2 = getCellFormatValue(row.getCell(3));
            String id2 = getCellFormatValue(row.getCell(2));

            String name3 = getCellFormatValue(row.getCell(5));
            String id3 = getCellFormatValue(row.getCell(4));


            String sql = "INSERT INTO `china` VALUES (" + (++id) + ",'" + id3 + "', '" + name3 + "', '" + id2 + "','" + name2 + "','" + id1 + "','" + name1 + "');";
            sb.append(sql);
        }
        IOUtils.write(sb.toString(), new FileOutputStream("C:\\Users\\mawt\\Downloads\\china.sql"), "UTF-8");
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
