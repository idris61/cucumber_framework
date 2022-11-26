package stepDefinitions.DBSteps;

import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtils;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;

import static utilities.DBUtils.getColumnData;

public class DBTest02 {

    @Test
    public void test01() {

        //DATABASE iLE BAGLANTI KUR
        DBUtils.createConnection();

        String query = "select * from physician";
        System.out.println(DBUtils.getColumnNames(query) + "\n");

        //SUTUN iSiMLERi
        //[id, first_name, last_name, birth_date, phone, gender, blood_group, adress, description, created_date, user_id, country_id, cstate_id, created_by, last_modified_by, last_modified_date, speciality, exam_fee, image, image_content_type]

        //ID'LERE ULASMA VE KAYDETME
        System.out.println("=====================ID LIST==================");
        List<Object> idList = getColumnData(query, "id");
        System.out.println(idList + "\n");
        String fileName1 = "src/test/resources/testdata/DoktorID.txt";
        WriteToTxt.savePhysicianIds(fileName1, idList);


        //ID'LERi DOGRULAMA
        List<Object> actualPhysicianIDs = ReadTxt.returnPhysicianIDsList(fileName1);
        List<Object> expectedPhysicianIDs = new ArrayList<>();
        expectedPhysicianIDs.add(147333);
        expectedPhysicianIDs.add(154273);

        Assert.assertTrue("IDLER UYUSMUYOR", actualPhysicianIDs.containsAll(expectedPhysicianIDs));



        //DOKTOR isimlerine ULASMA VE KAYDETME
        System.out.println("=====================PHYSiCiAN LIST==================");
        List<Object> nameList = getColumnData(query, "first_name");
        System.out.println(nameList + "\n");
        String fileName2 = "src/test/resources/testdata/DoktorName.txt";
        WriteToTxt.savePhysicianFirstName(fileName2, nameList);


        //isimleri DOGRULAMA
        List<String > actualPhysicianNames = ReadTxt.returnPhysicianFirstName(fileName2);
        List<String > expectedPhysicianNames = new ArrayList<>();
        expectedPhysicianNames.add("Yusuf");

        Assert.assertTrue("iSiMLER UYUSMUYOR", actualPhysicianNames.containsAll(expectedPhysicianNames));
    }
}