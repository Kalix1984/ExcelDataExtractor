package hu.kalix.exceldemo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataExtractor {
    public static List<String> extract(String path)  {
        List<String> content = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(path)){
            XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
            XSSFRow row = sheet.getRow(1);

            Iterator<Cell> iterator = row.cellIterator();

            while (iterator.hasNext()) {
                Cell cell = iterator.next();

                switch (cell.getCellType()) {
                    case NUMERIC:
                        double number = cell.getNumericCellValue();
                        int wholeNumber = (int) number;
                        content.add(String.valueOf(wholeNumber));
                        break;

                    case STRING:
                        content.add(cell.getStringCellValue());
                        break;
                }
           }
        } catch (Exception e) {
            System.out.println(e);
        }
        return content;
    }

}
