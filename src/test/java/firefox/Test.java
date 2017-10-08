package firefox;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Test {
    @org.junit.Test
    public void FirefoxHeadlessTest() {
        final String geckodriver = this.getClass().getResource("/geckodriver").getFile();
        new File(geckodriver).setExecutable(true);
        System.setProperty("webdriver.gecko.driver", geckodriver);

        final FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability("acceptInsecureCerts", true);
        capabilities.setCapability("disable-popup-blocking", true);

        final FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.http", "localhost");
        profile.setPreference("network.proxy.http_port", "8080");
        profile.setPreference("network.proxy.ssl", "localhost");
        profile.setPreference("network.proxy.ssl_port", "8080");
        profile.setPreference("network.proxy.no_proxies_on", "");

        final FirefoxOptions firefoxOptions = new FirefoxOptions(capabilities);
        firefoxOptions.setBinary(firefoxBinary);
        firefoxOptions.setProfile(profile);
        firefoxOptions.addPreference("network.proxy.http", "localhost");
        firefoxOptions.addPreference("network.proxy.http_port", "8080");
        firefoxOptions.addPreference("network.proxy.https", "localhost");
        firefoxOptions.addPreference("network.proxy.https_port", "8080");
        final FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        driver.quit();
    }
}
