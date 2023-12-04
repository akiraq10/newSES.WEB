package testclass;

import com.clean.driver.DriverBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class testNG {
    @Test(priority = 1)
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
    @Test
    public void givenLoggerWithFailoverConfig_whenLog_thanOK()
            throws Exception {
        Logger logger = LogManager.getLogger(DriverBase.class.getName());
        Exception e = new RuntimeException("This is only a test!");

        logger.trace("This is a syslog message at TRACE level.");
        logger.debug("This is a syslog message at DEBUG level.");
        logger.info("This is a syslog message at INFO level. ");
        logger.warn("This is a syslog message at WARN level.");
        logger.error("This is a syslog message at ERROR level.", e);
        logger.fatal("This is a syslog message at FATAL level.");
        System.out.println(DriverBase.class.getName());
    }

}
