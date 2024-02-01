package ar.org.icaro.automatizacion.steps;

import ar.org.icaro.automatizacion.pages.HomePage;
import ar.org.icaro.automatizacion.pages.LoginPage;
import ar.org.icaro.automatizacion.pages.RegisterPage;
import ar.org.icaro.automatizacion.pages.AccountPage;
import ar.org.icaro.automatizacion.steps.driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AgregarAFavoritosSteps {

    private WebDriver driver;
    private RegisterPage registerPage;

    private AccountPage accountPage;

    @Before
    public void setUp() {
        driver = DriverManager.driver;
    }
    private HomePage homePage;
    private LoginPage loginPage;

    @Cuando("ingresa a seccion camaras y agrega favoritos")
    public void ingresaASeccionCamarasYAgregaFavoritos() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage.clickBotonCamara();
        accountPage.clickBotonFavorito();
        accountPage.clickBotonWishList();
    }

    @Entonces("valida que existan productos en favoritos")
    public void validaQueExistanProductosEnFavoritos() {
        String expectedTextProducto = "(1)";
        Assert.assertTrue(accountPage.isVisibleCantidadUno().contains(expectedTextProducto), "No hay un producto en favoritos");
        String expectedTextFavorito = "Canon EOS 5D";
        Assert.assertTrue(accountPage.isVisibleProducto().contains(expectedTextFavorito), "No coincide producto seleccionado en favoritos");
    }
}
