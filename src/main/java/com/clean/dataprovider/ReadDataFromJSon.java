package com.clean.dataprovider;

import com.clean.dataprovider.getdata.LoginData;
import com.clean.dataprovider.getdata.CreateUserData;
import com.clean.dataprovider.getdata.ProfileData;
import org.testng.annotations.DataProvider;

public class ReadDataFromJSon {

    String fileLocation="/Data/";

    @DataProvider(name="loginValidData",parallel = true)
    public LoginData[] loginValidDataSet(){
        return DataObjectBuilder.buildDataObject(fileLocation+"LoginDataTest.json",LoginData[].class);

    }
    @DataProvider(name="loginInvalidData",parallel = true)
    public LoginData[] loginInvalidDataSet(){
        return DataObjectBuilder.buildDataObject(fileLocation+"LoginInvalidDataTest.json",LoginData[].class);

    }
    @DataProvider(name="CreateUserData",parallel = true)
    public CreateUserData[] userDataSet(){
        return DataObjectBuilder.buildDataObject(fileLocation+"UserData.json", CreateUserData[].class);

    }
    @DataProvider(name="ProfileData",parallel = true)
    public ProfileData[] profileDataSet(){
        return DataObjectBuilder.buildDataObject(fileLocation+"ProfileData.json", ProfileData[].class);

    }



}
