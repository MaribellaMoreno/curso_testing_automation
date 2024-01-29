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
        Assert.assertTrue(accountPage.isVisibleSeccionShoppingCart(), "No se visualiza seccion Shopping Cart");
        Assert.assertTrue(accountPage.isVisibleProductoSeleccionado(), "No coincide producto seleccionado");
    }
}
