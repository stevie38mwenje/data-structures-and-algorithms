package arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;

public class Main {
//    public static final String INSERT_TO_SERVICES = "INSERT INTO billing.dbo.services ( biller_code, currency, service_name, biller_id, status) VALUES ( N'%s', N'KES', N'%s', 1 ,0);\n";
//    public static void main(String[] args) throws IOException {
//        File excelFile = new File("/home/mberhe/Downloads/Mhretaab-Mig-4-part-2.xlsx");
//        FileInputStream fis = new FileInputStream(excelFile);
//        // we create an XSSF Workbook object for our XLSX Excel File
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        // we get first sheet
//        XSSFSheet sheet = workbook.getSheetAt(0);
//        // we iterate on rows
//        Iterator<Row> rowIt = sheet.iterator();
//        List<Row> rowsList = new ArrayList<>();
//        rowIt.forEachRemaining(rowsList::add);
//        Set<String> sqlQueries = new LinkedHashSet<>();
//        for (int i = 1; i < rowsList.size(); ++i) {
//            Row row = rowsList.get(i);
//            Iterator<Cell> cellIterator = row.cellIterator();
//            List<Cell> cellsList = new ArrayList<>();
//            cellIterator.forEachRemaining(cellsList::add);
//            String sql = String.format(INSERT_TO_SERVICES, cellsList.get(4).toString().trim(), cellsList.get(2).toString().trim());
//            sqlQueries.add(sql);
//            System.out.println(sql);
//        }
//        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/mberhe/Downloads/mig_services.sql", true));
//        for (var sql : sqlQueries) {
//            writer.write(sql);
//        }
//        writer.close();
//        workbook.close();
//        fis.close();
   // }


//    Icecream icecream = new Icecream();



}