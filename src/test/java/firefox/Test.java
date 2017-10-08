package firefox;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class Test {
    @org.junit.Test
    public void FirefoxHeadlessTest() {
        final String geckodriver = this.getClass().getResource("/geckodriver").getFile();
        new File(geckodriver).setExecutable(true);
        System.setProperty("webdriver.gecko.driver", geckodriver);

        final FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        final FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        final FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        driver.quit();
    }
}
