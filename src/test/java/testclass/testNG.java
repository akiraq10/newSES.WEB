package testclass;

import com.clean.driver.DriverBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

@Feature("this is the @feature")
public class testNG {
    @Feature("this is the @feature")
    @Description("this is @Description_test1")
    @Story("this is @story_test1")
    @Test(priority = 3,groups = {"test1"})
    public void test1(){
        System.out.println("this is test1 method");
    }
    @Feature("this is the @feature")
    @Description("this is @Description_test2")
    @Story("this is @story_test2")
    @Test(dependsOnMethods = "test1",priority = 1,groups = {"test1"})
    public void test2(){
        System.out.println("this is test2 method");
        assertTrue(false,"test");
    }
    @Feature("this is the @feature_new")
    @Story("this is @story_test2")
    @Test()
    public void test3() {
        System.out.println(DriverBase.class.getName());
        assertEquals(false, true);

    }
    @Feature("this is the @feature_new3")
    @Epic("this is @epic_Test4")
    @Test(dependsOnMethods = {"test1","test3"})
    public void test4(){
        System.out.println("test4");
    }
    @Test(dependsOnMethods = "test4")
    public void test5(){
        System.out.println("test5");
    }


}
