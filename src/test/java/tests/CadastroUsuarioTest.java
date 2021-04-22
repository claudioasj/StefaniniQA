package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.CadastroUsuario;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "MassaDeDados.csv")
public class CadastroUsuarioTest {

    @Rule
    public TestName metodoNome = new TestName();

    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createBrowserStack();
    }

    @Test
    public void testeCadastarUsuarioCompeto(
            @Param(name="nome")String nome,
            @Param(name="email")String email,
            @Param(name="senha")String senha){
        String validaCadastro = new CadastroUsuario(navegador).cadastroCompleto(nome, email, senha).validaCadastroL1();

        Screenshot.salvaPrint(metodoNome, navegador);

        Assert.assertEquals("Claudio Junior", validaCadastro);
    }
    @Test
    public void testeNomeInvalido(
            @Param(name="nome")String nome,
            @Param(name="email")String email,
            @Param(name="senha")String senha){
        String validaNome = new CadastroUsuario(navegador).cadastroCompleto(nome, email, senha).nomeErro();

        Screenshot.salvaPrint(metodoNome, navegador);

        Assert.assertEquals("Por favor, insira um nome completo.",validaNome);
    }
    @Test
    public void testeSemNome(
            @Param(name="nome")String nome,
            @Param(name="email")String email,
            @Param(name="senha")String senha){
        String validaNome = new CadastroUsuario(navegador).cadastroCompleto(nome, email, senha).nomeErro();

        Screenshot.salvaPrint(metodoNome, navegador);

        Assert.assertEquals("O campo Nome é obrigatório.",validaNome);
    }

    @Test
    public void testeEmailInvalido(
            @Param(name="nome")String nome,
            @Param(name="email")String email,
            @Param(name="senha")String senha){
        String validaEmail = new CadastroUsuario(navegador).cadastroCompleto(nome, email, senha).emailErro();

        Screenshot.salvaPrint(metodoNome, navegador);

        Assert.assertEquals("Por favor, insira um e-mail válido.",validaEmail);
    }
    @Test
    public void testeSemEmail(
            @Param(name="nome")String nome,
            @Param(name="email")String email,
            @Param(name="senha")String senha){
        String validaEmail = new CadastroUsuario(navegador).cadastroCompleto(nome, email, senha).emailErro();

        Screenshot.salvaPrint(metodoNome, navegador);

        Assert.assertEquals("O campo E-mail é obrigatório.",validaEmail);
    }

    @Test
    public void testeSenhaInvalida(
            @Param(name="nome")String nome,
            @Param(name="email")String email,
            @Param(name="senha")String senha){
        String validaSenha = new CadastroUsuario(navegador).cadastroCompleto(nome, email, senha).senhaErro();

        Screenshot.salvaPrint(metodoNome, navegador);

        Assert.assertEquals("A senha deve conter ao menos 8 caracteres.",validaSenha);
    }
    @Test
    public void testeSemSenha(
            @Param(name="nome")String nome,
            @Param(name="email")String email,
            @Param(name="senha")String senha){
        String validaSenha = new CadastroUsuario(navegador).cadastroCompleto(nome, email, senha).senhaErro();

        Screenshot.salvaPrint(metodoNome, navegador);

        Assert.assertEquals("O campo Senha é obrigatório.",validaSenha);
    }

    @After
    public void tearDown(){
        navegador.quit();
    }
}
