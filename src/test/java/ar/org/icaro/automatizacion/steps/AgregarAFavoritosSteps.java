package ar.org.icaro.automatizacion.steps;

import ar.org.icaro.automatizacion.pages.HomePage;
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

    @Cuando("ingresa a seccion camaras y agrega favoritos")
    public void ingresaASeccionCamarasYAgregaFavoritos() {
        accountPage.clickBotonCamara();
        accountPage.clickBotonFavorito();
        accountPage.clickBotonWishList();
    }

    @Entonces("valida que existan productos en favoritos")
    public void validaQueExistanProductosEnFavoritos() {
        Assert.assertTrue(accountPage.isVisibleCantidadUno(), "No hay un producto en favoritos");
        Assert.assertTrue(accountPage.isVisibleProducto(), "No coincide producto seleccionado en favoritos");
    }
}
