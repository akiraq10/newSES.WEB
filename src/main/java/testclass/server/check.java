package testclass.server;

import com.clean.dataprovider.DataProvider;
import org.testng.annotations.Test;

public class check {
//    public static void main(String[] args) {
//        ReadConfigFile readConfigFile = ConfigFactory.create(ReadConfigFile.class);
////        String urlLocalhost=readConfigFile.Scheme()+ readConfigFile.domain()+":";
//        System.out.println(readConfigFile.Scheme());
//    }

    @Test(dataProvider="loginData",dataProviderClass = DataProvider.class)
    public void logintest(String userName,String Pwd){
        System.out.println("the username: "+ userName + " password: " + Pwd);
    }
    @Test(dataProvider="readProfileData",dataProviderClass = DataProvider.class)
    public void porifiletest(String profileName,String comment,String targetPlatform,String profileType){
        System.out.println("the profile name: "+ profileName
        + "| comment: " + comment +"| Platform: "+targetPlatform +"| type: "+profileType);

    }
}
