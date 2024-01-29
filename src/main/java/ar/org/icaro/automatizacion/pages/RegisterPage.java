package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    private By myAccountBy = By.cssSelector("[title='My Account']");
    private By formularioBy = By.id("content");
    private By campofirstNamelBy = By.id("input-firstname");
    private By campolastNamelBy = By.id("input-lastname");
    private By campoEmailBy = By.id("input-email");
    private By campotelephoneBy = By.id("input-telephone");
    private By campoContraseniaBy = By.id("input-password");
    private By campoConfirmContraseniaBy = By.id("input-confirm");
    private By checkboxPrivacyBy = By.xpath("//input[@type='checkbox']");
    private By botonContinueBy = By.xpath("//input[@type='submit']");
    By textoAccountCreated = By.xpath("//p[contains(text(),'Congratulations! Your new account has been successfully created!')]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void clickBotonMyAccount() {
        myAccount().click();
    }

    public WebElement myAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountBy));
        return driver.findElement(myAccountBy);
    }

    public void scrollHastaElFormulario() {
        //Scrolleamos hasta el formulario para que los elementos esten a la vista
        WebElement formulario = getFormulario();
        scrollHasta(formulario);

    }

    private WebElement getFormulario() {
        wait.until(ExpectedConditions.presenceOfElementLocated(formularioBy));
        return driver.findElement(formularioBy);
    }


    public void realizarRegistroCon(String nombre, String apellido, String usuario, String telefono, String contrasenia) {
        ingresarNombre(nombre);
        ingresarApellido(apellido);
        ingresarEmail(usuario);
        ingresarTelefono(telefono);
        ingresarContrasenia(contrasenia);
        confirmarContrasenia(contrasenia);
    }

public void clickBotonContinue() {
    botonContinue().click();
    new HomePage(driver);
}

    public void ingresarNombre(String nombre) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campofirstNamelBy));
        driver.findElement(campofirstNamelBy).sendKeys(nombre);
    }

    public void ingresarApellido(String apellido) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campolastNamelBy));
        driver.findElement(campolastNamelBy).sendKeys(apellido);
    }

    public void ingresarEmail(String usuario) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoEmailBy));
        driver.findElement(campoEmailBy).sendKeys(usuario);
    }

    public void ingresarTelefono(String telefono) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campotelephoneBy));
        driver.findElement(campotelephoneBy).sendKeys(telefono);
    }

    public void ingresarContrasenia(String contrasenia) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoContraseniaBy));
        driver.findElement(campoContraseniaBy).sendKeys(contrasenia);
    }

    public void confirmarContrasenia(String contrasenia) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoConfirmContraseniaBy));
        driver.findElement(campoConfirmContraseniaBy).sendKeys(contrasenia);
    }

    public void clickCheckboxPrivacy() {
        checkboxPrivacy().click();
    }

    private WebElement checkboxPrivacy() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxPrivacyBy));
        return driver.findElement(checkboxPrivacyBy);
    }

    private WebElement botonContinue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(botonContinueBy));
        return driver.findElement(botonContinueBy);
    }

    public boolean isVisibleAccountCreated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textoAccountCreated));
        return isVisibleAccountCreated();
    }
}
