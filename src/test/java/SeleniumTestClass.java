import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SeleniumTestClass {

    static WebDriver driver;
    private static String TYPE_DRIVER = "webdriver.chrome.driver";
    private static String PATH_DRIVER = "C:\\WebDriver\\chromedriver.exe";
    private String BASE_URL = "https://portalclientes-tst0.gruposancorseguros.com/";


    @BeforeClass
    public static void setUp() {
        System.setProperty(TYPE_DRIVER, PATH_DRIVER);
        driver = new ChromeDriver();





    }

    @Test
    public void test1() {
        String user = "testtt31@yopmail.com";
        driver.get(BASE_URL);
        driver.manage().window().maximize();

        WebElement btnIngresar = driver.findElement(By.xpath("//button[contains(text(),'Ingresar')]"));


        WebDriverWait espera = new WebDriverWait(driver,Duration.ofSeconds(5));
        espera.until(ExpectedConditions.elementToBeClickable(btnIngresar));

        btnIngresar.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement txtEmail = driver.findElement(By.id("1-email"));
        WebElement txtClave = driver.findElement(By.name("password"));
        WebElement btnIniciarSesion = driver.findElement(By.name("submit"));


        WebDriverWait espera2 = new WebDriverWait(driver,Duration.ofSeconds(5));
        espera2.until(ExpectedConditions.elementToBeClickable(btnIniciarSesion));

        txtEmail.sendKeys(user);
        txtClave.sendKeys("123456");
        btnIniciarSesion.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement txtInicio = driver.findElement(By.xpath("//strong[contains(text(),'Inicio')]"));

        WebDriverWait espera3 = new WebDriverWait(driver,Duration.ofSeconds(5));
        espera2.until(ExpectedConditions.visibilityOf(txtInicio));


        System.out.println(txtInicio.getText());

        Assert.assertEquals("Inicio de sesión",txtInicio.getText());


    }

    @AfterClass
    public static void tearDown() {

        driver.quit();
    }



}
