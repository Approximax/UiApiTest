package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/links.properties")
public interface LinksConfig extends Config {

    @Key("base.url")
    @DefaultValue("https://demoqa.com/")
    String baseUrl();

    @Key("selenoid.url")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String selenoidUrl();
}
