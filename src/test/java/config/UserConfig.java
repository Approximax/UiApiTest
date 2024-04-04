package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/user.properties")
public interface UserConfig extends Config {

    @Key("username")
    @DefaultValue("example")
    String getUserName();

    @Key("password")
    @DefaultValue("1234")
    String getPassword();
}
