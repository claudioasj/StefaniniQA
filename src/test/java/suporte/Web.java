package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    public static final String AUTOMATE_USERNAME = "claudioantonioju_WGosdI";
    public static final String AUTOMATE_ACCESS_KEY = "zax6ycvzTjh5oHvkTv2g";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        navegador.get("http://prova.stefanini-jgr.com.br/teste/qa/");

        return navegador;
    }

    public static WebDriver createBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "89.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name

        WebDriver navegador = null;

        try {
            navegador = new RemoteWebDriver(new URL(URL), caps);
            navegador.manage().window().maximize();
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            navegador.get("http://prova.stefanini-jgr.com.br/teste/qa/");
        }catch (MalformedURLException e){
            System.out.println("Erro ao acessar site"+e.getMessage() );
        }

        return navegador;

    }
}
