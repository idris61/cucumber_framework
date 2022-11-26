package stepDefinitions.DBSteps;

import org.junit.Test;
import utilities.DBUtils;

public class DBTest {

    @Test
    public void test01(){

        DBUtils.createConnection();

        String query = "select * from physician";

        // Physician tablosundaki kolon(sütun) isimlerini verir.
        System.out.println(DBUtils.getColumnNames(query) + "\n");

        // Physician tablosundaki first_name sütunundaki dataları verir
        System.out.println(DBUtils.getColumnData(query, "first_name") + "\n");

        // Physician tablosundaki 100. satır, 16. hücredeki datayı verir
        System.out.println(DBUtils.getCellValuewithRowsAndCells(query, 100, 16) + "\n");

        String query1 = "select * from physician where id = 147333";
        // 147333 id li datanın bilgilerini List olarak verir
        System.out.println("147333 id'li data: " + DBUtils.getRowList(query1) + "\n");

        // 147333 id li datanın ilk hücresindeki datayı verir
        System.out.println("First Cell: " + DBUtils.getCellValue(query1) + "\n");

        // 147333 id li datanın ikinci hücresindeki datayı verir
        System.out.println("Second Cell : " +DBUtils.getSecondCellValue(query1) + "\n");

        // 147333 id li datanın bilgilerini map olarak verir
        System.out.println(DBUtils.getRowMap(query1) + "\n");

        System.out.println(DBUtils.getQueryResultList(query1) + "\n");

        System.out.println(DBUtils.getQueryResultMap(query1) + "\n");

        DBUtils.closeConnection();

    }

}
