package com.clean.ults;

import org.aeonbits.owner.Config;
@Config.Sources({"classpath:basicInfo.properties"})
public interface ReadConfigFile extends Config {
    String urlSESWEB();
    String username();
    String password();
    String invalidPwd();
}
