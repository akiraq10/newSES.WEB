package testclass;

import com.clean.driver.DriverBase;
import org.testng.annotations.Test;

import static com.clean.driver.DriverBase.readConfigFile;
import static com.clean.pages.login.LoginPage.loginPage;


public class testNG {
    @Test(priority = 3)
    public void test1(){
        System.out.println("this is test1 method");
    }
    @Test(dependsOnMethods = "test1",priority = 1)
    public void test2(){
        System.out.println("this is test2 method");
    }
    @Test(priority = 3)
    public void test3() {
        System.out.println(DriverBase.class.getName());

    }
    @Test(dependsOnMethods = {"test1","test3"})
    public void test4(){
        System.out.println("test4");
    }
    @Test(dependsOnMethods = "test4")
    public void test5(){
        System.out.println("test5");
    }


}
