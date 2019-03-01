package top.nju.iznauy.service.tool;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
public class ScoreExcelOperations {

    public static Map<String, Integer> getScores(String name, InputStream inputStream) throws IOException, InvalidFormatException {
        int pos = name.lastIndexOf('.');
        String postfix = name.substring(pos + 1);
        Workbook wb;
        switch (postfix) {
            case "xls":
                wb = new HSSFWorkbook(inputStream);
                break;
            case "xlsx":
                wb = new XSSFWorkbook(inputStream);
                break;
            default:
                System.out.println("错误的文件类型");
                return null;
        }

        Map<String, Integer> resultMap = new HashMap<>();


        Sheet sheet = wb.getSheetAt(0);
        int firstRowIndex = sheet.getFirstRowNum() + 1;
        int lastRowIndex = sheet.getLastRowNum();

        for (int rowIndex = firstRowIndex; rowIndex < lastRowIndex; rowIndex++) {
            System.out.println("rIndex: " + rowIndex);
            Row row = sheet.getRow(rowIndex);
            int firstCellIndex = row.getFirstCellNum();
            Cell studentEmailCell = row.getCell(firstCellIndex);
            Cell scoreCell = row.getCell(firstCellIndex + 1);
            System.out.println("第一个值：" + studentEmailCell.toString());
            System.out.println("第二个值：" + scoreCell.toString());
            if (studentEmailCell.toString().length() == 0)
                break;
            resultMap.put(studentEmailCell.toString(), (int) Math.ceil(Double.valueOf(scoreCell.toString())));
        }

        return resultMap;
    }

}
