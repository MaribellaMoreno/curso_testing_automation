package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {
    By myAccountTextBy = By.xpath("//h2[text()='My Account']");
    By botonCamaratBy = By.xpath("//a[text()='Cameras']");
    By botonFavoritoBy = By.xpath("//button//i[@Class='fa fa-heart']");
    By botonWishListBy = By.xpath("//span[contains(text(),'Wish List')]");
    By textCantidad = By.xpath("//span[contains(text(),'(1)')]");
    By titleProducto = By.xpath("//a[contains(text(),'Canon EOS 5D')]");
    By nombreProducto = By.xpath("//h4//a[contains(text(),'Canon EOS 5D')]");
    By selectColor = By.xpath("//select[@class='form-control']");
    By selectOptionColor = By.xpath("//select[@class='form-control']//option[contains(text(),'Red')]");
    By buttonAddToCart = By.xpath("//button[contains(text(),'Add to Cart')]");
    By buttonCarrito = By.xpath("//button//span[@id='cart-total']");
    By buttonViewCart = By.xpath("//p//strong[contains(text(),' View Cart')]");
    By titleShoppingCart = By.xpath("//a[contains(text(), 'Shopping Cart')]");
    By titleProductoSeleccionado = By.xpath("//div[@class='table-responsive']//td//a[contains(text(),'Canon EOS 5D')]");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getMyAccountSubtitulo() {
        return myAccountSubtitulo().getText();
    }

    private WebElement myAccountSubtitulo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountTextBy));
        return driver.findElement(myAccountTextBy);
    }

    public void clickBotonCamara() {
        botonCamara().click();
    }

    private WebElement botonCamara() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(botonCamaratBy));
        return driver.findElement(botonCamaratBy);
    }

    public void clickBotonFavorito() {
        botonFavorito().click();
    }

    private WebElement botonFavorito() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(botonFavoritoBy));
        return driver.findElement(botonFavoritoBy);
    }

    public void clickBotonWishList() {
        botonWishList().click();
    }

    private WebElement botonWishList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(botonWishListBy));
        return driver.findElement(botonWishListBy);
    }

    public String isVisibleCantidadUno() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textCantidad));
        WebElement cantidadUno = driver.findElement(textCantidad);
        return cantidadUno.getText();
    }

    public String isVisibleProducto() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleProducto));
        WebElement producto = driver.findElement(titleProducto);
        return producto.getText();
    }

    public String isVisibleNombreProducto() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nombreProducto));
        WebElement nameProducto = driver.findElement(nombreProducto);
        return nameProducto.getText();
    }

    public void clickBotonSelect() {
        selectColor().click();
    }

    private WebElement selectColor() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectColor));
        return driver.findElement(selectColor);
    }

    public LoginPage clickSelectOptionColor() {
        selectOptionColor().click();
        return new LoginPage(driver);
    }

    private WebElement selectOptionColor() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectOptionColor));
        return driver.findElement(selectOptionColor);
    }

    public AccountPage clickBotonAddToCart() {
        botonAddToCart().click();
        return new AccountPage(driver);
    }

    private WebElement botonAddToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddToCart));
        return driver.findElement(buttonAddToCart);
    }

    public AccountPage clickBotonCarrito() {
        botonCarrito().click();
        return new AccountPage(driver);
    }

    private WebElement botonCarrito() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonCarrito));
        return driver.findElement(buttonCarrito);
    }

    public AccountPage clickBotonViewCart() {
        botonViewCart().click();
        return new AccountPage(driver);
    }

    private WebElement botonViewCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonViewCart));
        return driver.findElement(buttonViewCart);
    }

    public String isVisibleSeccionShoppingCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleShoppingCart));
        WebElement seccionShoppingCart = driver.findElement(titleShoppingCart);
        return seccionShoppingCart.getText();
    }

    public String isVisibleProductoSeleccionado() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleProductoSeleccionado));
        WebElement productoSeleccionado = driver.findElement(titleProductoSeleccionado);
        return productoSeleccionado.getText();
    }
}
