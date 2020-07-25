/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.common.base.CharMatcher;
import com.sun.org.apache.bcel.internal.generic.GOTO;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author User
 */
public class Playcontent {
    private WebDriver driver;
    private String baseurl;
    private JavascriptExecutor js;
    
    
    @Before
    public void setUp() {
        //chrome browser location
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Selenium Pre\\Chrome\\chromedriver.exe");
        //open browser
        driver=new ChromeDriver();
        js= (JavascriptExecutor)driver;
        baseurl="https://bongobd.com/";
        //goto bongo website
        driver.get(baseurl);
        //wait pageload time
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        //browser maximize
        driver.manage().window().maximize();
    }
    
    
    
    
    
    //content function
    @Test
    public void playscontent() throws InterruptedException {
    
    WebDriverWait wait1=new WebDriverWait(driver, 10);
    //browser scroll
     js.executeScript("window.scrollBy(0,2000)"); 
    WebElement selectcontent=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Pashan']")));
    //click on content
    System.out.println("select content");
    selectcontent.click();
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    Thread.sleep(11100);
    //switch to add/frame
    driver.switchTo().frame(0);{
        System.out.println("frame");
         TimeUnit.SECONDS.sleep(8);
    //checking skip button enable
    int size=driver.findElements(By.xpath("/html/body/div[1]/div[2]/div/div[2]/button")).size();
    System.out.println("skipbtnchk");
    if(size>0){
        WebElement skipbtn=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/button"));
        System.out.println("skipbtn");
        //click skip button when add skip button enable
        skipbtn.click();
    }
    }
    //switch to widnow
    driver.switchTo().defaultContent();
    TimeUnit.SECONDS.sleep(30);
System.out.println("playbtnchk");
        //checking play button enable
        int play=driver.findElements(By.xpath("//div[@class='vjs-control-bar']/button[@class='vjs-play-control vjs-control vjs-button vjs-paused']/span[@class='vjs-icon-placeholder']")).size();
        System.out.println("playbtnchk1");
        if(play>0){
            System.out.println("playbtn");
        WebElement clickplaybtn= driver.findElement(By.xpath("//div[@class='vjs-control-bar']/button[@class='vjs-play-control vjs-control vjs-button vjs-paused']"));
            System.out.println("click playbtn");
            //click play button
        clickplaybtn.click();
        System.out.println("clicked playbtn");
    }
       
    }
    
    
    
    @After
    public void tearDown() {
        //driver.close();
    }
    
}
