package com.radiofrance.pageObjects;

import com.radiofrance.config.Configuration;
import com.radiofrance.config.Properties;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Page {

    @FindBy(id = "didomi-notice-disagree-button")
    private WebElement cookieFrame;

    @FindBy(xpath = "/html/body")
    private WebElement page_content;

    private String message = "";

    private String access = "";
    /***
     *
     */
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected Actions action;
    /***
     * waiter
     */
    protected WebDriverWait wait;
    protected WebDriverWait shortWait;
    protected WebDriverWait middleWait;
    protected WebDriverWait longWait;

    protected Configuration config = Properties.Config;

    Page(){
        // Init
        driver = Properties.DriverManager.getDriver();
        PageFactory.initElements(driver, this);

        js = (JavascriptExecutor) driver;
        action = new Actions(driver);

        //Waiter
        wait        = new WebDriverWait(driver, Duration.ofSeconds(4));
        shortWait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        middleWait  = new WebDriverWait(driver, Duration.ofSeconds(20));
        longWait    = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    protected <V>boolean waitUntil(Function<? super WebDriver, V> isTrue){
        try{
            wait.until(isTrue);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    protected <V>boolean shortUntil(Function<? super WebDriver, V> isTrue){
        try{
            shortWait.until(isTrue);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    /***
     *
     * @param isTrue
     * @param <V>
     * @return
     */
    protected <V>boolean middleUntil(Function<? super WebDriver, V> isTrue){
        try{
            middleWait.until(isTrue);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /***
     *
     * @param isTrue
     * @param <V>
     * @return
     */
    protected <V>boolean longUntil(Function<? super WebDriver, V> isTrue){
        try{
            longWait.until(isTrue);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    /***
     *
     */
    protected void waitForLoadingPage( ){
        if(!longUntil(driver->js.executeScript("return document.readyState").equals("complete") || js.executeScript("return document.readyState").equals("interactive") )){
            throw new RuntimeException(driver.getCurrentUrl()+" not loaded");
        }
    }
    /***
     *
     * @param url
     */
    protected void get(String url){
        driver.get(url);
        waitForLoadingPage();
    }
    public void handleCookie(){
        if(shortUntil(visibilityOf(cookieFrame))) clickOn(cookieFrame);
    }

    public void handleFrame() {
        handleCookie();
        scroll(15);
    }

    protected void clickOn(WebElement element){

        if( !shortUntil(visibilityOf(element)) ){
            // Logger
            throw new RuntimeException("Element not visible after click");
        }

        if( !shortUntil(elementToBeClickable(element))){
            // Logger
            throw new RuntimeException("Element not clickable");
        }
        element.click();
    }

    protected void scroll(int height){
        js.executeScript("window.scrollBy(0,"+height+")");
    }

    public int checkErrorpage(WebElement linked) {
        int verification = 0;
        scroll((linked.getLocation().getY()-200));
        String link = linked.getAttribute("href");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // establish and open connection with URL
        try {
            HttpURLConnection c = (HttpURLConnection) new URL(link).openConnection();
            // set the HEAD request with setRequestMethod
            c.setRequestMethod("HEAD");
            // connection started and get response code
            c.connect();

            int r = c.getResponseCode();

            String answ = r + "";
            access = answ;

            if (answ.startsWith("4")) {
                message = "FAIL";
            } else {
                message = "PASS";
            }

        } catch (Exception e){

            message = "FAIL";

        }
        try{
            driver.navigate().to(link);
            if (!access.startsWith("4") && message.equals("PASS")) {

                try {
                    link = driver.getCurrentUrl();
                    if(driver.getTitle().contains("not found")||driver.getTitle().contains("erreur")||driver.getTitle().contains("404")||driver.getTitle().contains("introuvable")){
                        message = "FAIL";
                    }else{
                        access = page_content.getText();
                        if(access.contains("The website encountered an unexpected error")){
                            message = "FAIL";
                        }else{
                            message = "PASS";
                        }
                    }

                }catch(Exception e){
                    System.out.println(e);
                }

            }

        }catch (Exception e){

            System.out.println("No for this");

        }

        try{
            if ((link.contains("https"))&&(message.equals("PASS"))) {
                verification++;
            }
        }catch (Exception e){
            System.out.println(e);

        }

        try{
            driver.navigate().back();
        }catch (Exception e){
            System.out.println(e);

        }

        System.out.println("\nurl de page "+link
                + "\naccess au contenu de la page : "+message);

        return verification;

    }

    @Attachment(value = "screenshot", type = "image/png")
    public static void saveScreenShotPNG(){
        Allure.addAttachment("screenshot", new ByteArrayInputStream(((TakesScreenshot) Properties.DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
