package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/user.properties"
})
public interface UserConfig extends Config {

    @Key("username")
    String getUserName();

    @Key("password")
    String getPassword();
}
