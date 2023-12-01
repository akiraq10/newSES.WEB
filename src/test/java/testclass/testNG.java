package testclass;

import org.testng.annotations.Test;

public class testNG {
    @Test(priority = 1)
    public void test1(){
        System.out.println("this is test1 method");
    }
    @Test(dependsOnMethods = "test1",priority = 1)
    public void test2(){
        System.out.println("this is test2 method");
    }@Test(priority = 3)
    public void test3(){
        System.out.println("this is test3 method");
    }

}
