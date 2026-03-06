package Utilities;

import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.Map;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        List<Map<String, String>> data = ExcelReader.readExcelData("src/test/resources/LoginData.csv", "LoginData");
        Object[][] testData = new Object[data.size()][3];
        for (int i = 0; i < data.size(); i++) {
            Map<String, String> row = data.get(i);
            testData[i][0] = row.get("Email");
            testData[i][1] = row.get("Password");
            testData[i][2] = row.get("ExpectedMessage");
        }
        return testData;
    }

    @DataProvider(name = "inventoryData")
    public static Object[][] getInventoryData() {
        List<Map<String, String>> data = ExcelReader.readExcelData("src/test/resources/InventoryData.csv", "InventoryData");
        Object[][] testData = new Object[data.size()][11];
        for (int i = 0; i < data.size(); i++) {
            Map<String, String> row = data.get(i);
            testData[i][0] = row.get("Email");
            testData[i][1] = row.get("Password");
            testData[i][2] = row.get("ExpectedMessage");
            testData[i][3] = row.get("DeviceType");
            testData[i][4] = row.get("Brand");
            testData[i][5] = row.get("UnitPrice");
            testData[i][6] = row.get("Color");
            testData[i][7] = row.get("ColorValue");
            testData[i][8] = row.get("Quantity");
            testData[i][9] = row.get("Subtotal");
            testData[i][10] = row.get("Address");
        }
        return testData;
    }

    @DataProvider(name = "validLoginData")
    public static Object[][] getValidLoginData() {
        List<Map<String, String>> data = ExcelReader.readExcelData("src/test/resources/LoginData.csv", "LoginData");
        // Return only the first row (valid credentials)
        Object[][] testData = new Object[1][3];
        Map<String, String> firstRow = data.get(0);
        testData[0][0] = firstRow.get("Email");
        testData[0][1] = firstRow.get("Password");
        testData[0][2] = firstRow.get("ExpectedMessage");
        return testData;
    }
}
