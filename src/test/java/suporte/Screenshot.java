package suporte;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {

    public static void print(WebDriver navegador, String arquivo){
        File screenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenshot, new File(arquivo));
        } catch (Exception e){
            System.out.println("Erro ao salvar o arquivo" + e.getMessage());
        }
    }

    public static void salvaPrint(TestName metodoNome, WebDriver navegador){
        String screenshotArquivo = "D:\\Stefanini\\Imagens\\"+ Generator.dataHora()+metodoNome.getMethodName()+".png";
        Screenshot.print(navegador, screenshotArquivo);
    }
}
