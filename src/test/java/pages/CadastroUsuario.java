package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroUsuario extends BasePage{

    public CadastroUsuario(WebDriver navegador) {
        super(navegador);
    }

    public CadastroUsuario escreveNome(String nome){
        navegador.findElement(By.id("name")).sendKeys(nome);
        return this;
    }

    public CadastroUsuario escreveEmail(String email){
        navegador.findElement(By.id("email")).sendKeys(email);
        return this;
    }

    public CadastroUsuario escreveSenha(String senha){
        navegador.findElement(By.id("password")).sendKeys(senha);
        return this;
    }

    public CadastroUsuario clickCadastro(){
        navegador.findElement(By.id("register")).click();
        return this;
    }

    public String validaCadastroL1(){
        return navegador.findElement(By.id("tdUserName1")).getText();

    }

    public String nomeErro(){
        return navegador.findElement(By.xpath("//input[@id=\"name\"]/following-sibling::p")).getText();
    }

    public String emailErro(){
        return navegador.findElement(By.xpath("//input[@id=\"email\"]/following-sibling::p")).getText();
    }

    public String senhaErro(){
        return navegador.findElement(By.xpath("//input[@id=\"password\"]/following-sibling::p")).getText();
    }

    public CadastroUsuario cadastroCompleto(String nome, String email, String senha){
        escreveNome(nome);
        escreveEmail(email);
        escreveSenha(senha);
        clickCadastro();
        return this;
    }
}
