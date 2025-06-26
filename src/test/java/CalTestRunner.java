import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalTestRunner extends Setup{

        @Test(priority = 1, description = "Sum of series number")
        public void doSeries() {
            CalScreen calcScreen = new CalScreen(driver);
            String series = calcScreen.doSeries("100/10*5-10+60");
            System.out.println(series);

            // Assertion: expected result is manually provided (example: 100)
            Assert.assertEquals(series, "100", "Calculation mismatch in doSeries()");
            Allure.description("Sum of Series Numbers");
        }

        @Test(priority = 2, description = "Read from CSV file then doing math")
        public void csvReadSeries() throws IOException {
            String path = "D:/SDET/App Automation/Cal_prac/src/data.csv";
            String line = "";

            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                // values[0] = expression, values[1] = expected result
                String expression = values[0];
                String expected = values[1];

                CalScreen calcScreen = new CalScreen(driver);
                String actualResult = calcScreen.CsvSeries(expression);

                System.out.println("Expression: " + expression + " => Result: " + actualResult);

                Assert.assertEquals(actualResult, expected, "Mismatch for expression: " + expression);
                Allure.description("Reading data from CSV file then doing sum of series numbers");
            }

            br.close();
        }

    @AfterMethod
    public void clearScreen(){
        CalScreen calcScreen=new CalScreen(driver);
        calcScreen.btnClear.click();
    }
}

