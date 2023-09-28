package ru.yandex.praktikum;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class TestBase {

    public void optionBrowser(String browser) {
        if ("yandex".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            Configuration.browser = "chrome";
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage","--remote-allow-origins=*");
            options.setBinary("C:\\Users\\in00bertb\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            WebDriver webDriver = new ChromeDriver(options);
            setWebDriver(webDriver);
        }
        else{
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            Configuration.browser = "chrome";
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage","--remote-allow-origins=*");
            WebDriver webDriver = new ChromeDriver(options);
            setWebDriver(webDriver);
        }
    }
}