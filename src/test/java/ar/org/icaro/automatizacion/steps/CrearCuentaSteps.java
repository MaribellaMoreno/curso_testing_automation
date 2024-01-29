package ar.org.icaro.automatizacion.steps;


import ar.org.icaro.automatizacion.pages.HomePage;
import ar.org.icaro.automatizacion.pages.RegisterPage;
import ar.org.icaro.automatizacion.steps.driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CrearCuentaSteps {

    private WebDriver driver;
    private RegisterPage registerPage;

    @Before
    public void setUp() {
        driver = DriverManager.driver;
    }
    private HomePage homePage;


    @Cuando("el usuario navega a la pagina de registro")
    public void elUsuarioNavegaALaPaginaDeRegistro() {
        registerPage.clickBotonMyAccount();
        registerPage = homePage.clickBotonRegisterMyAccount();
        registerPage = new RegisterPage(driver);
    }

    @Y("realiza el registro de datos en registrar cuenta")
    public void realizaElRegistroDeDatosEnRegistrarCuenta(String nombre, String apellido, String usuario, String telefono, String contrasenia) {
        registerPage.scrollHastaElFormulario();
        registerPage.realizarRegistroCon(nombre, apellido, usuario, telefono, contrasenia);
        registerPage.clickCheckboxPrivacy();
        registerPage.clickBotonContinue();
    }

    @Entonces("valido elementos de registro cuenta")
    public void validoElementosDeRegistroCuenta() {
        Assert.assertTrue(registerPage.isVisibleAccountCreated(), "No fue creada la cuenta");
    }

}
