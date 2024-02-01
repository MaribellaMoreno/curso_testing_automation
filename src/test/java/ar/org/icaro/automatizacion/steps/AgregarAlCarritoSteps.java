package ar.org.icaro.automatizacion.steps;

import ar.org.icaro.automatizacion.pages.AccountPage;
import ar.org.icaro.automatizacion.pages.HomePage;
import ar.org.icaro.automatizacion.pages.LoginPage;
import ar.org.icaro.automatizacion.steps.driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AgregarAlCarritoSteps {

    private WebDriver driver;
    @Before
    public void setUp() {
        driver = DriverManager.driver;
    }
    private HomePage homePage;
    private LoginPage loginPage;

    private AccountPage accountPage;

    @Cuando("ingresa a seccion camaras y selecciono producto canon")
    public void ingresaASeccionCamarasYSeleccionoProductoCanon() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage.clickBotonCamara();
        accountPage.isVisibleNombreProducto();
    }

    @Y("selecciono color y agrego producto al carrito")
    public void seleccionoColorYAgregoProductoAlCarrito() {
        accountPage.clickBotonSelect();
        accountPage.clickSelectOptionColor();
        accountPage.clickBotonAddToCart();
        accountPage.clickBotonCarrito();
        accountPage.clickBotonViewCart();
    }

    @Entonces("valido producto en carrito")
    public void validoProductoEnCarrito() {
        String expectedTextSeccion = "(1)";
        Assert.assertTrue(accountPage.isVisibleSeccionShoppingCart().contains(expectedTextSeccion), "No se visualiza seccion Shopping Cart");
        String expectedTextSeleccionado = "Canon EOS 5D";
        Assert.assertTrue(accountPage.isVisibleProductoSeleccionado().contains(expectedTextSeleccionado), "No coincide producto seleccionado");
    }
}
