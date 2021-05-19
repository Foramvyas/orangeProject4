package project4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OrangeProject {

    WebDriver driver;

    @Before

    public void setUp() {

        String baseUrl = "https://opensource-demo.orangehrmlive.com";

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
    @Test
            public void verifyUserShouldLoginandLogoutSuccessfully(){

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();


        String text1 = "Welcome Paul";
        String text2 = driver.findElement(By.xpath("//a[@id='welcome']")).getText();
        if (text1.equals(text2)) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }


        driver.findElement(By.xpath("//div[@id='branding']/a[2]")).click();


        driver.findElement(By.linkText("Logout")).click();
        String expectedText= "LOGIN Panel";
        WebElement text=driver.findElement(By.xpath("//div[@id='logInPanelHeading']"));
        String actualText= text.getText();
        Assert.assertEquals("LOGIN Panel message not displayed",expectedText,actualText);

    }
    @After
    public void tearDown(){

        driver.quit();
    }

}
