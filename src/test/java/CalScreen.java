import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalScreen {
    @FindBy(id="com.google.android.calculator:id/op_add")
    WebElement btnAdd;

    @FindBy(id="com.google.android.calculator:id/op_sub")
    WebElement btnMinus;

    @FindBy(id = "com.google.android.calculator:id/op_div")
    WebElement btnDiv;

    @FindBy(id = "com.google.android.calculator:id/op_mul")
    WebElement btnMul;

    @FindBy(id="com.google.android.calculator:id/eq")
    WebElement btnEqual;

    @FindBy(id="com.google.android.calculator:id/result_final")
    WebElement txtResult;

    @FindBy(id="com.google.android.calculator:id/clr")
    WebElement btnClear;

    @FindBy(id = "com.google.android.calculator:id/dec_point")
    WebElement btnPoint;

    @FindBy(id = "com.google.android.calculator:id/op_pow")
    WebElement btnPower;

    AndroidDriver driver;
    public CalScreen(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public String doSeries(String expression) {
        for (char ch : expression.toCharArray()) {
            switch (ch) {
                case '0' -> driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click();
                case '1' -> driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
                case '2' -> driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
                case '3' -> driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
                case '4' -> driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
                case '5' -> driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
                case '6' -> driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
                case '7' -> driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
                case '8' -> driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
                case '9' -> driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
                case '+' -> btnAdd.click();
                case '-' -> btnMinus.click();
                case '*' -> btnMul.click();
                case '/' -> btnDiv.click();
            }
        }

        btnEqual.click();
        return driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
    }

    public String CsvSeries(String expression) {
        for (char ch : expression.toCharArray()) {
            switch (ch) {
                case '0' -> driver.findElement(By.id("com.google.android.calculator:id/digit_0")).click();
                case '1' -> driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
                case '2' -> driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
                case '3' -> driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
                case '4' -> driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
                case '5' -> driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
                case '6' -> driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
                case '7' -> driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
                case '8' -> driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
                case '9' -> driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
                case '+' -> btnAdd.click();
                case '-' -> btnMinus.click();
                case '*' -> btnMul.click();
                case '/' -> btnDiv.click();
                case '.' -> btnPoint.click();
                case '^' -> btnPower.click();
            }
        }

        btnEqual.click();
        return driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
    }


}
