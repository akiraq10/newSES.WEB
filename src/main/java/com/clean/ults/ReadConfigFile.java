package com.clean.ults;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:basicInfo.properties",
        "classpath:ConfigureInfo.properties",
        "classpath:AlertMessage.properties",
        "classpath:Browser.properties"

})
public interface ReadConfigFile extends Config {
    String urlSESWEB();
    String username();
    String password();
    String invalidPwd();
    String Scheme();
    String domain();
    String SESWEBPort();
    String IdPPort();
    String Subdirectory();
    String KFPath();
    String KFPwd();
    String ServeName();
    String DatabaseName();
    String SQLUserName();
    String SQLPwd();
    String ServerUrl();
    String SESWEBUrl();
    String ServerPublicUrL();
    String alertSuccess();
    String idpSESWEB();
    String idpUserName();
    String idPEmailUser();
    String chrome();
    String firefox();
    String edge();
    String seleniumGridHub();



}
