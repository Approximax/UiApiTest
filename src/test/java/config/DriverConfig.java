package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/driver.properties")
public interface DriverConfig extends Config {

    @Key("browser.name")
    @DefaultValue("chrome")
    String browserName();

    @Key("browser.version")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("browser.size")
    @DefaultValue("1920x1080")
    String browserSize();
}
